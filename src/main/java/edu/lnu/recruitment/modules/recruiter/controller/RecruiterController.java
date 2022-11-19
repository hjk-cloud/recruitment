package edu.lnu.recruitment.modules.recruiter.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.recruiter.entity.Recruiter;
import edu.lnu.recruitment.modules.recruiter.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : RecruiterController
 * @Description :
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/25  18:22
 */
@RestController
@RequestMapping("/app/recruiter")
@CrossOrigin
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @RequestMapping("/register")
    public R register(@RequestBody Recruiter recruiter){
        try{
            recruiterService.register(recruiter);
            return R.ok("注册成功");
        }catch (Exception e){
            return R.error(e.getMessage());
        }

    }
}
