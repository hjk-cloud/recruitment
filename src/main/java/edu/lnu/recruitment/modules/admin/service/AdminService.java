package edu.lnu.recruitment.modules.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.lnu.recruitment.modules.admin.entity.Admin;
import edu.lnu.recruitment.modules.company.entity.Company;

import java.util.List;
import java.util.Map;

public interface AdminService extends IService<Admin> {
    List<Company> queryAllUnchecked();
}
