package edu.lnu.recruitment.modules.company.service;

import edu.lnu.recruitment.modules.company.entity.Company;

import java.util.List;
import java.util.Map;

/**
 * @Package: edu.lnu.recruitment.modules.company.service
 * @ClassName: CompanyService
 * @Author: huangjk
 * @CreateTime: 2022/10/17 19:28
 * @Description:
 */
public interface CompanyService {
    boolean save(Company company);

    Company queryById(long id);

    List<Company> queryPageByConditions(Map<String, Object> params);

    boolean check(Long id,Byte status);

    List<Company> queryAllUnchecked(int page, int size);

    Byte getStatus(String recruiterId);
}
