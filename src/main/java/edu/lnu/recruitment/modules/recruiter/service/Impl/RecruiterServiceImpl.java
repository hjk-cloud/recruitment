package edu.lnu.recruitment.modules.recruiter.service.Impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.User;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.UserRole;
import edu.lnu.recruitment.common.security.loginandauthority.login.mapper.UserDao;
import edu.lnu.recruitment.common.security.loginandauthority.login.mapper.UserRoleDao;
import edu.lnu.recruitment.modules.company.entity.Company;
import edu.lnu.recruitment.modules.company.mapper.CompanyMapper;
import edu.lnu.recruitment.modules.recruiter.entity.Recruiter;
import edu.lnu.recruitment.modules.recruiter.mapper.RecruiterMapper;
import edu.lnu.recruitment.modules.recruiter.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

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

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(Map<String, Object> map) {

        //设置两表的共同Id
        long commonId = new Snowflake(0, 1).nextId();
        //设置招聘者和公司的共同Id
        long recCompanyId = new Snowflake(0, 1).nextId();
        //设置求职者绑定的公司id
        long recComId;


        /**
         * 该部分为注册公共用户表
         */
        User user = new User(commonId, map.get("recruiterName").toString(), passwordEncoder.encode(map.get("recruiterPassword").toString()));
        //查询用户是否已被注册
        QueryWrapper<User> userQueryWrapper = new QueryWrapper();
        userQueryWrapper.eq("user_name", map.get("recruiterName").toString());
        User ifUserExist = userDao.selectOne(userQueryWrapper);
        if(ifUserExist != null){
            throw new RuntimeException("该用户名已存在");
        }else{
            //未注册的用户才可以注册
            userDao.insert(user);
        }

        /**
         * 查询公司是否被注册
         */
        QueryWrapper<Company> companyWrapper = new QueryWrapper();
        companyWrapper.eq("credit_code", map.get("creditCode").toString());
        Company ifCompanyExist = companyMapper.selectOne(companyWrapper);
        if(ifCompanyExist == null){
            recComId = recCompanyId;
        }else{
            recComId = ifCompanyExist.getId();
        }

        /**
         * 该部分为注册求职者表
         */
        //查询用户是否已被注册
        QueryWrapper<Recruiter> recruiterQueryWrapper = new QueryWrapper();
        recruiterQueryWrapper.eq("recruiter_name", map.get("recruiterName").toString());
        Recruiter ifCandidateExist = recruiterMapper.selectOne(recruiterQueryWrapper);
        if(ifCandidateExist != null){
            throw new RuntimeException("该用户名已存在");
        }else{
            //对用户id采用雪花算法
            Recruiter recruiter = new Recruiter();
            recruiter.setId(commonId).setCompanyId(recComId)
                    .setRecruiterName(map.get("recruiterName").toString()).setSex((int) map.get("sex"))
                    .setJobTitle(map.get("jobTitle").toString());
            //未注册的用户才可以注册
            recruiterMapper.insert(recruiter);
        }

        /**
         * 更新公司表
         */

        if(ifCompanyExist == null){
            Company company = new Company();
            company.setId(recCompanyId).setCompanyName(map.get("companyName").toString())
                    .setCategory(map.get("category").toString()).setNumberScale(map.get("numberScale").toString())
                    .setAddress(map.get("address").toString()).setAddress(map.get("website").toString())
                    .setCompanyProfile(map.get("companyProfile").toString()).setFullName(map.get("fullName").toString())
                    .setCreditCode(map.get("creditCode").toString()).setEstablishDate( LocalDate.parse(map.get("establishDate").toString() , DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .setRegisteredCapital(map.get("registeredCapital").toString()).setVerification((byte) 0);
            companyMapper.insert(company);
        }
        //如果公司存在不做处理


        /**
         * 更新用户和角色中间表
         */
        UserRole userRole = new UserRole().setId(new Snowflake(0, 1).nextId()).setUserId(commonId).setRoleId(3L);
        userRoleDao.insert(userRole);
        return true;
    }

    @Override
    public Recruiter queryById(long id) {
        return recruiterMapper.selectById(id);
    }

    @Override
    public boolean update(Recruiter recruiter) {
        boolean isSuccess = recruiterMapper.updateById(recruiter) > 0;
        return isSuccess;
    }

}
