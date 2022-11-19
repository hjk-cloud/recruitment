package edu.lnu.recruitment.modules.candidate.service;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.candidate.entity.Candidate;
import edu.lnu.recruitment.modules.candidate.entity.CandidateFile;
import edu.lnu.recruitment.modules.company.entity.Company;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CandidateService {
    //注册接口
    void register(Candidate candidate);
    //上传简历
    R upload(MultipartFile file);
    //简历下载
    CandidateFile download(String candidateId);
    //查询用户的所有简历
    R findAllFiles(String candidateId);
    //查询用户的所有简历
    R deleteFile(String fileId);
}
