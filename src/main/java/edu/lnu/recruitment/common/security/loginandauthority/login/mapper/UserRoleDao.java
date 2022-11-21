package edu.lnu.recruitment.common.security.loginandauthority.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRoleDao extends BaseMapper<UserRole> {
}
