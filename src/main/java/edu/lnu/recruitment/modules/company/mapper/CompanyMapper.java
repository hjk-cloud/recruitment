package edu.lnu.recruitment.modules.company.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.modules.company.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Package: edu.lnu.recruitment.modules.company.mapper
 * @ClassName: CompanyMapper
 * @Author: huangjk
 * @CreateTime: 2022/10/17 19:48
 * @Description:
 */
@Mapper
@Repository
public interface CompanyMapper extends BaseMapper<Company> {
    boolean updateStatus(Long id, byte verification);

    Byte getCompanyStatusByRecruiterId(Long companyId);
}
