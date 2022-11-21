package edu.lnu.recruitment.modules.recruiter.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.recruiter.entity.Recruiter;
import edu.lnu.recruitment.modules.recruiter.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public R register(@RequestBody Map<String, Object> map){
        try{
            recruiterService.register(map);
            return R.ok("注册成功");
        }catch (Exception e){
            return R.error(e.getMessage());
        }

    }

    /**
     * 展示招聘者信息
     */
    @GetMapping("/show")
    public R show( Long id) {

        Recruiter recruiter = recruiterService.queryById(id);
        return R.ok().put("recruiter", recruiter);
    }

    /**
     * 更新招聘者信息
     */
    @RequestMapping("/updateInfo")
    public R updateInfo(@RequestBody Recruiter recruiter) {

        boolean flag = recruiterService.update(recruiter);
        return flag ? R.ok() : R.error("更新失败");

    }
}
