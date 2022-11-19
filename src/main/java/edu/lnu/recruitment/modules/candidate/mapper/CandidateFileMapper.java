package edu.lnu.recruitment.modules.candidate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.modules.candidate.entity.CandidateFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CandidateFileMapper extends BaseMapper<CandidateFile> {
}
