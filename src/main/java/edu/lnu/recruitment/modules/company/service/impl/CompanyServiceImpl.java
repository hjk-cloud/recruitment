package edu.lnu.recruitment.modules.company.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.lnu.recruitment.modules.company.entity.Company;
import edu.lnu.recruitment.modules.company.mapper.CompanyMapper;
import edu.lnu.recruitment.modules.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Package: edu.lnu.recruitment.modules.company.service.impl
 * @ClassName: CompanyServiceImpl
 * @Author: huangjk
 * @CreateTime: 2022/10/17 19:28
 * @Description:
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public boolean save(Company company) {
        company.setId(new Snowflake(0, 1).nextId());
        return companyMapper.insert(company) == 1;
    }

    @Override
    public Company queryById(long id) {
        return companyMapper.selectById(id);
    }


    @Override
    public List<Company> queryPageByConditions(Map<String, Object> params) {
        QueryWrapper wrapper = new QueryWrapper();

        int pageNum = (int) params.get("page");
        int size = (int) params.get("size");

        //TODO 增加条件信息

        Page<Company> page = new Page<>(pageNum, size);
        companyMapper.selectPage(page, wrapper);
        return page.getRecords();
    }
}
