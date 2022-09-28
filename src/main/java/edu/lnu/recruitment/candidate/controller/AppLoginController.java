package edu.lnu.recruitment.candidate.controller;

import edu.lnu.recruitment.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: edu.lnu.recruitment.candidate.controller
 * @ClassName: AppLoginController
 * @Author: huangjk
 * @CreateTime: 2022/9/28 18:35
 * @Description:
 */
@RestController
@RequestMapping("/app/user")
public class AppLoginController {

    @RequestMapping("/sendSmsCode")
    public R sendSmsCode(String phone) {
        System.out.println(phone);
        return R.ok();
    }
}
