package edu.lnu.recruitment.common.security.loginandauthority.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleDao extends BaseMapper<Role> {
}
