package edu.lnu.recruitment.modules.company.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.company.entity.Company;
import edu.lnu.recruitment.modules.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: edu.lnu.recruitment.modules.company.controller
 * @ClassName: CompanyController
 * @Author: huangjk
 * @CreateTime: 2022/10/17 19:26
 * @Description:
 */
@RestController
@RequestMapping("/app/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/save")
    public R save(@RequestBody Company company) {
        boolean isSuccess = companyService.save(company);
        return R.ok("status:" + isSuccess);
    }

}