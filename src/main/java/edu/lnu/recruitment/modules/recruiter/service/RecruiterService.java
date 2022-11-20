package edu.lnu.recruitment.modules.recruiter.service;

import edu.lnu.recruitment.modules.candidate.entity.Candidate;
import edu.lnu.recruitment.modules.recruiter.entity.Recruiter;

public interface RecruiterService {

    void register(Recruiter recruiter);

    Recruiter queryById(long id);

    boolean update(Recruiter recruiter);

}
