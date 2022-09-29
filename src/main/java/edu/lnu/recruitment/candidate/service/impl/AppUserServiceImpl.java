package edu.lnu.recruitment.candidate.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;

import edu.lnu.recruitment.candidate.service.AppUserService;
import edu.lnu.recruitment.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: edu.lnu.recruitment.candidate.service.impl
 * @ClassName: AppUserServiceImpl
 * @Author: huangjk
 * @CreateTime: 2022/9/29 16:23
 * @Description:
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public String sendSmsCode(String phone) {
        String code = RandomUtil.randomNumbers(6);
        String codeKey = "code_" + phone;
        String s = redisUtils.get(codeKey);
        if (ObjectUtil.isNotNull(s)) {
            return s;
        }
        redisUtils.set(codeKey, code, 60 * 5);
        return code;
    }
}
