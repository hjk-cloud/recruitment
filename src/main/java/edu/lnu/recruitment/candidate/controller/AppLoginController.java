package edu.lnu.recruitment.candidate.controller;

import edu.lnu.recruitment.candidate.service.AppUserService;
import edu.lnu.recruitment.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: edu.lnu.recruitment.candidate.controller
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
