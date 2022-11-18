package edu.lnu.recruitment.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.lnu.recruitment.modules.admin.entity.Admin;
import edu.lnu.recruitment.modules.admin.mapper.AdminMapper;
import edu.lnu.recruitment.modules.admin.service.AdminService;
import edu.lnu.recruitment.modules.company.entity.Company;
import edu.lnu.recruitment.modules.company.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService  {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public List<Company> queryAllUnchecked() {

        return companyMapper.queryAllUnchecked();
    }
}
