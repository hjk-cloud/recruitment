package edu.lnu.recruitment.modules.candidate.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.candidate.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: edu.lnu.recruitment.modules.candidate.controller
 * @ClassName: AppLoginController
 * @Author: huangjk
 * @CreateTime: 2022/9/28 18:35
 * @Description:
 */
@RestController
@RequestMapping("/app/user")
@CrossOrigin
public class AppLoginController {
    @Autowired
    private AppUserService appUserService;

    @RequestMapping("/sendSmsCode")
    public R sendSmsCode(@RequestBody String phone) {

        String code = appUserService.sendSmsCode(phone);
        return R.ok(code);
    }
}
