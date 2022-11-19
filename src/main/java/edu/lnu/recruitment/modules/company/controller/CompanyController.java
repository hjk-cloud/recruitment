package edu.lnu.recruitment.modules.company.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.company.entity.Company;
import edu.lnu.recruitment.modules.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/queryById")
    public R queryById(long companyId) {
        return R.ok().put("company", companyService.queryById(companyId));
    }

    @RequestMapping("/queryByConditions")
    public R queryByConditions(@RequestBody Map<String, Object> params) {
        List<Company> list = companyService.queryPageByConditions(params);
        return R.ok().put("pageNum:", params.get("page")).put("list", list);
    }
    /**
     * 展示公司注册信息
     */
    @GetMapping("/show/{id}")
    public R show(@RequestBody Long id) {

        Company company = companyService.queryById(id);
        return R.ok().put("company", company);
    }

    /**
     * 审批公司信息
     */
    @GetMapping("/check")
    public R check(Long id, Byte verification) {
        boolean isSuccess = companyService.check(id, verification);
        return R.ok("审批完成" + isSuccess);
    }

    /**
     * 管理员查看全部未审核信息
     */
    @GetMapping("/admin/showAll")
    public R show(int page, int size){

        List<Company> company = companyService.queryAllUnchecked(page, size);
        return R.ok().put("company", company);
    }

    /**
     * 显示审核状态
     */
    @RequestMapping("/recruiter/showStatus")
    public R showStatus(String recruiterId){
        Byte status = companyService.getStatus(recruiterId);
        return R.ok().put("status", status);
    }
}
