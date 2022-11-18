package edu.lnu.recruitment.modules.recruiter.service.Impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.User;
import edu.lnu.recruitment.common.security.loginandauthority.login.mapper.UserDao;
import edu.lnu.recruitment.modules.recruiter.entity.Recruiter;
import edu.lnu.recruitment.modules.recruiter.mapper.RecruiterMapper;
import edu.lnu.recruitment.modules.recruiter.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName : RecruiterServiceImpl
 * @Description :
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/25  18:26
 */
@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RecruiterMapper recruiterMapper;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(Recruiter recruiter) {

        //设置两表的共同Id
        long commonId = new Snowflake(0, 1).nextId();

        /**
         * 该部分为注册公共用户表
         */
        User user = new User(commonId, recruiter.getRecruiterName(), passwordEncoder.encode(recruiter.getRecruiterPassword()));
        //查询用户是否已被注册
        QueryWrapper<User> userQueryWrapper = new QueryWrapper();
        userQueryWrapper.eq("user_name", recruiter.getRecruiterName());
        User ifUserExist = userDao.selectOne(userQueryWrapper);
        if(ifUserExist != null){
            throw new RuntimeException("该用户名已存在");
        }else{
            //未注册的用户才可以注册
            userDao.insert(user);
        }

        /**
         * 该部分为注册求职者表
         */
        //查询用户是否已被注册
        QueryWrapper<Recruiter> recruiterQueryWrapper = new QueryWrapper();
        recruiterQueryWrapper.eq("recruiter_name", recruiter.getRecruiterName());
        Recruiter ifCandidateExist = recruiterMapper.selectOne(recruiterQueryWrapper);
        if(ifCandidateExist != null){
            throw new RuntimeException("该用户名已存在");
        }else{
            //对用户id采用雪花算法
            recruiter.setId(commonId);
            //ToDo 处理用户简历
            //未注册的用户才可以注册
            recruiterMapper.insert(recruiter);
        }

        /**
         * 更新用户和角色中间表
         */
        userDao.insertUserRole(commonId, 3, new Snowflake(0, 1).nextId());

    }


}
