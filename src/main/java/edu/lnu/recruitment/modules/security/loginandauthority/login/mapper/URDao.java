package edu.lnu.recruitment.modules.security.loginandauthority.login.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import edu.lnu.recruitment.modules.security.loginandauthority.login.entity.RUId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface URDao extends BaseMapper<RUId> {

}
