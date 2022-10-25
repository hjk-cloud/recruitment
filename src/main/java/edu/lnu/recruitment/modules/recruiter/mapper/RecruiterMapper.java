package edu.lnu.recruitment.modules.recruiter.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.User;
import edu.lnu.recruitment.modules.candidate.entity.Candidate;
import edu.lnu.recruitment.modules.recruiter.entity.Recruiter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RecruiterMapper extends BaseMapper<Recruiter> {

}
