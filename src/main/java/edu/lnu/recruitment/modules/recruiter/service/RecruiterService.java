package edu.lnu.recruitment.modules.recruiter.service;

import edu.lnu.recruitment.modules.recruiter.entity.Recruiter;

import java.util.Map;

public interface RecruiterService {


    boolean register(Map<String, Object> map);

    Recruiter queryById(long id);

    boolean update(Recruiter recruiter);


}
