package edu.lnu.recruitment.modules.admin.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.admin.service.AdminService;
import edu.lnu.recruitment.modules.company.entity.Company;
import edu.lnu.recruitment.modules.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;
    /**
     * 管理员查看全部未审核信息
     */
    @GetMapping("/showAll")
    public R show(){

        List<Company> company = adminService.queryAllUnchecked();
        return R.ok().put("company", company);
    }

}
