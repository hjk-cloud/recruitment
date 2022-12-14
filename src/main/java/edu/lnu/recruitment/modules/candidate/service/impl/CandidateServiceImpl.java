package edu.lnu.recruitment.modules.candidate.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.User;
import edu.lnu.recruitment.common.security.loginandauthority.login.entity.UserRole;
import edu.lnu.recruitment.common.security.loginandauthority.login.mapper.UserDao;
import edu.lnu.recruitment.common.security.loginandauthority.login.mapper.UserRoleDao;
import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.candidate.entity.Candidate;
import edu.lnu.recruitment.modules.candidate.entity.CandidateFile;
import edu.lnu.recruitment.modules.candidate.mapper.CandidateFileMapper;
import edu.lnu.recruitment.modules.candidate.mapper.CandidateMapper;
import edu.lnu.recruitment.modules.candidate.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : CandidateServiceImpl
 * @Description :
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/25  17:38
 */
@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private CandidateFileMapper candidateFileMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(Candidate candidate) {

        //设置两表的共同Id
        long commonId = new Snowflake(0, 1).nextId();

        /**
         * 该部分为注册公共用户表
         */
        User user = new User(commonId, candidate.getCandidateName(), passwordEncoder.encode(candidate.getCandidatePassword()));
        //查询用户是否已被注册
        QueryWrapper<User> userQueryWrapper = new QueryWrapper();
        userQueryWrapper.eq("user_name", candidate.getCandidateName());
        User ifUserExist = userDao.selectOne(userQueryWrapper);
        if(ifUserExist != null){
            throw new RuntimeException("该用户名已存在");
        }else{
            //未注册的用户才可以注册
            userDao.insert(user);
        }

        /**
         * 该部分为注册求职者表
         */
        //查询用户是否已被注册
        QueryWrapper<Candidate> candidateQueryWrapper = new QueryWrapper();
        candidateQueryWrapper.eq("candidate_name", candidate.getCandidateName());
        Candidate ifCandidateExist = candidateMapper.selectOne(candidateQueryWrapper);
        if(ifCandidateExist != null){
            throw new RuntimeException("该用户名已存在");
        }else{
            //对用户id采用雪花算法
            candidate.setId(commonId);
            //未注册的用户才可以注册
            candidateMapper.insert(candidate);
        }

        /**
         * 更新用户和角色中间表
         */
        UserRole userRole = new UserRole().setId(new Snowflake(0, 1).nextId()).setUserId(commonId).setRoleId(2L);
        userRoleDao.insert(userRole);
        return true;

    }

    /**
     * 上传简历
     * @param file
     */
    @Override
    public boolean upload(MultipartFile file, String candidateId) {
        //定义日期格式，返回指定时间格式输入
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String dataformat = sdf.format(new Date());
        String realpath = "C:/Users/lenovo/Desktop/简历文件夹/files" + dataformat;
        File folder = new File(realpath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        long timeId = new Snowflake(0, 1).nextId();
        String newName = timeId + ".pdf";
        try {
            file.transferTo(new File(folder, newName));
            //数据库里存入简历信息
            //ToDo
            //确少用户id
            candidateFileMapper.insert(new CandidateFile().setId(timeId).setFileName(file.getOriginalFilename()).setPath(realpath).setUploadTime(new Date()).setCandidateId(Long.valueOf(candidateId)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 简历下载
     * @param candidateId
     * @return
     */
    @Override
    public CandidateFile download(String candidateId) {
        CandidateFile candidateFile = candidateFileMapper.selectById(candidateId);
        return candidateFile;
    }

    @Override
    public Map<String, Object> findAllFiles(String candidateId) {
        QueryWrapper<CandidateFile> candidateFileQueryWrapper = new QueryWrapper();
        candidateFileQueryWrapper.eq("candidate_id", candidateId);
        List<CandidateFile> candidateFiles = candidateFileMapper.selectList(candidateFileQueryWrapper);
        Map<String, Object> map = new HashMap<>();
        for(CandidateFile file : candidateFiles){
            map.put(file.getId().toString(),file.getFileName());
        }
        return map;
    }

    @Override
    public boolean deleteFile(String fileId) {
        try{
            CandidateFile candidateFile = candidateFileMapper.selectById(fileId);
            File file = new File(candidateFile.getPath(), candidateFile.getId() + ".pdf");
            if(file.exists())file.delete();
            candidateFileMapper.deleteById(fileId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Candidate queryById(long id) {
        return candidateMapper.selectById(id);
    }

    @Override
    public boolean update(Candidate candidate) {
        boolean isSuccess = candidateMapper.updateById(candidate) > 0;
        return isSuccess;
    }
}


