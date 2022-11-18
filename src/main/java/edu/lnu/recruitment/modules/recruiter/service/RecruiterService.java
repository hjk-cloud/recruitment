package edu.lnu.recruitment.modules.recruiter.service;

import edu.lnu.recruitment.modules.recruiter.entity.Recruiter;

public interface RecruiterService {

    void register(Recruiter recruiter);

    Byte getStatus(Long id);

}
