package edu.lnu.recruitment.modules.company.service;

import edu.lnu.recruitment.modules.company.entity.Company;

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


}
