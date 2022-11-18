package edu.lnu.recruitment.modules.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.lnu.recruitment.modules.admin.entity.Admin;
import edu.lnu.recruitment.modules.admin.mapper.AdminMapper;
import edu.lnu.recruitment.modules.admin.service.AdminService;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService  {
}
