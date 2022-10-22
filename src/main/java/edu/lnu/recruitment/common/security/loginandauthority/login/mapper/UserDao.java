package edu.lnu.recruitment.common.security.loginandauthority.login.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.Role;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao extends BaseMapper<User> {
    //处理mybaitsplus无法处理的连表查询
    List<Role> findUserRoles(Long userid);

}
