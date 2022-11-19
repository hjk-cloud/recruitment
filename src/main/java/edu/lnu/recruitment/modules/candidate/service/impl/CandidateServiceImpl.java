package edu.lnu.recruitment.modules.candidate.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.User;
import edu.lnu.recruitment.common.security.loginandauthority.login.mapper.UserDao;
import edu.lnu.recruitment.modules.candidate.entity.Candidate;
import edu.lnu.recruitment.modules.candidate.mapper.CandidateMapper;
import edu.lnu.recruitment.modules.candidate.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName : CandidateServiceImpl
 * @Description :
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/25  17:38
 */
@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(Candidate candidate) {

        //设置两表的共同Id
        long commonId = new Snowflake(0, 1).nextId();

        /**
         * 该部分为注册公共用户表
         */
        User user = new User(commonId, candidate.getCandidateName(), passwordEncoder.encode(candidate.getCandidatePassword()));
        //查询用户是否已被注册
        QueryWrapper<User> userQueryWrapper = new QueryWrapper();
        userQueryWrapper.eq("user_name", candidate.getCandidateName());
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
        QueryWrapper<Candidate> candidateQueryWrapper = new QueryWrapper();
        candidateQueryWrapper.eq("candidate_name", candidate.getCandidateName());
        Candidate ifCandidateExist = candidateMapper.selectOne(candidateQueryWrapper);
        if(ifCandidateExist != null){
            throw new RuntimeException("该用户名已存在");
        }else{
            //对用户id采用雪花算法
            candidate.setId(commonId);
            //ToDo 处理用户简历
            //未注册的用户才可以注册
            candidateMapper.insert(candidate);
        }

        /**
         * 更新用户和角色中间表
         */
        userDao.insertUserRole(commonId, 2, new Snowflake(0, 1).nextId());


    }

}
