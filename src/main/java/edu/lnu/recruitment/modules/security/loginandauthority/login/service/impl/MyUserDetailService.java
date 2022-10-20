package edu.lnu.recruitment.modules.security.loginandauthority.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import edu.lnu.recruitment.modules.security.loginandauthority.login.entity.Role;
import edu.lnu.recruitment.modules.security.loginandauthority.login.entity.User;
import edu.lnu.recruitment.modules.security.loginandauthority.login.mapper.RoleDao;
import edu.lnu.recruitment.modules.security.loginandauthority.login.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName : LoginServiceImpl
 * @Description : 登录接口
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/12  10:44
 */
@Service
/**
 UserDetailService 是顶层父接口，接口中 loadUserByUserName 方法是用来在认证时进行用户名认证方法，
 默认实现使用是内存实现，如果想要修改数据库实现我们只需要自定义 UserDetailService 实现，最终返回 UserDetails 实例即可。
*/
public class MyUserDetailService implements UserDetailsService {


    @Autowired
    private UserDao userDao;




    //1.springsecurity内置登录方法
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_name",username);
        User user = userDao.selectOne(wrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("该用户不存在，请检查账号");
        }
        //查询用户对应的权限信息,连表查询
        List<Role> roles = userDao.findUserRoles(user.getUserid());
        user.setRoles(roles);
        //将返回结果以UserDetails返回
        return user;
    }




}
