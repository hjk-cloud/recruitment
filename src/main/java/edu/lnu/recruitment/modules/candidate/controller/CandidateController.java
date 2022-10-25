package edu.lnu.recruitment.modules.candidate.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.candidate.entity.Candidate;
import edu.lnu.recruitment.modules.candidate.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            candidateService.register(candidate);
        }catch (Exception e){
            return R.error(e.getMessage());
        }
        return R.ok("注册成功");
    }
}
