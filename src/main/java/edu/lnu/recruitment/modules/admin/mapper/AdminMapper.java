package edu.lnu.recruitment.modules.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.modules.admin.entity.Admin;
import edu.lnu.recruitment.modules.company.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper extends BaseMapper<Admin> {


}
