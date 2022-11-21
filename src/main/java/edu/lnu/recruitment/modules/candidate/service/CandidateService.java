package edu.lnu.recruitment.modules.candidate.service;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.candidate.entity.Candidate;
import edu.lnu.recruitment.modules.candidate.entity.CandidateFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


public interface CandidateService {
    //注册接口
    boolean register(Candidate candidate);
    //上传简历
    boolean upload(MultipartFile file, String candidateId);
    //简历下载
    CandidateFile download(String candidateId);
    //查询用户的所有简历
    Map<String, Object> findAllFiles(String candidateId);
    //查询用户的所有简历
    boolean deleteFile(String fileId);

    Candidate queryById(long id);

    boolean update(Candidate candidate);

}
