package edu.lnu.recruitment.modules.candidate.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.candidate.entity.Candidate;
import edu.lnu.recruitment.modules.candidate.service.CandidateService;
import edu.lnu.recruitment.modules.company.entity.Company;
import edu.lnu.recruitment.modules.position.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : CandidateController
 * @Description : 候选人注册接口
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/25  17:01
 */
@RestController
@RequestMapping("/app/candidate")
@CrossOrigin
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping("/register")
    public R register(@RequestBody Candidate candidate){
        try{
           return candidateService.register(candidate);
        }catch (Exception e){
            return R.error(e.getMessage());
        }

    }
    /**
     * 展示用户信息
     */
    @GetMapping("/show")
    public R show( Long id) {

        Candidate candidate = candidateService.queryById(id);
        return R.ok().put("candidate", candidate);
    }
    /**
     * 更新用户信息
     */
    @RequestMapping("/updateInfo")
    public R updateInfo(@RequestBody Candidate candidate) {

        boolean flag = candidateService.update(candidate);
        return flag ? R.ok() : R.error("更新失败");

    }
}
