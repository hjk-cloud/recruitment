package edu.lnu.recruitment.security.loginandauthority.login.mapper;


import edu.lnu.recruitment.security.loginandauthority.login.entity.Role;
import edu.lnu.recruitment.security.loginandauthority.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    //1.登录接口
    User findUser(@Param("username") String username);
    //2.查询用户角色信息
    List<Role> findRole(Integer userid);
}
