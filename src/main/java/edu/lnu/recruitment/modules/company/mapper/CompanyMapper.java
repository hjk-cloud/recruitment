package edu.lnu.recruitment.modules.company.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.modules.company.entity.Company;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Package: edu.lnu.recruitment.modules.company.mapper
 * @ClassName: CompanyMapper
 * @Author: huangjk
 * @CreateTime: 2022/10/17 19:48
 * @Description:
 */
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
}
