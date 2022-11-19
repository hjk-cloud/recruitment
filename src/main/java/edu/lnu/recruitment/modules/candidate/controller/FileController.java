package edu.lnu.recruitment.modules.candidate.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.candidate.entity.CandidateFile;
import edu.lnu.recruitment.modules.candidate.service.CandidateService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;


/**
 * @ClassName : FileController
 * @Description : 处理用户简历上传
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/28  16:40
 */
@RestController
@RequestMapping("/app/candidate")
public class FileController {

    //定义简历最大大小
    private static final long File_SIZE = 5 * 1024 * 1024L;

    @Autowired
    private CandidateService candidateService;

    @RequestMapping("/upload")
    public R fileUpload(MultipartFile file) {
        //获得文件原始名字
        String originalFilename = file.getOriginalFilename();
        if (!originalFilename.endsWith(".pdf")) {
            return R.error("只能上传pdf类型文件");
        } else if (file.getSize() > File_SIZE) {
            return R.error("请上传小于5MB文件");
        }
        return candidateService.upload(file);
    }


    @RequestMapping("/download")
    public void fileDownload(String openStyle , String fileId, HttpServletResponse response) throws IOException {
        //todo
        //在线预览乱码
        //获取打开方式
        openStyle = openStyle == null ? "attachment" : "inline";
        //获取文件信息
       CandidateFile file = candidateService.download(fileId);
        //获取文件输入流
        FileInputStream is = new FileInputStream(new File(file.getPath(), file.getId() + ".pdf"));
        //附件下载
        response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(file.getFileName(), "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //文件拷贝
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }

    @RequestMapping("/findallfiles")
    public R findAllFiles(String candidateId) {
        //获取求职者所有简历
        return candidateService.findAllFiles(candidateId);
    }

    @RequestMapping("/deletefiles")
    public R deleteFiles(String fileId) {
        //删除求职者简历
        return candidateService.deleteFile(fileId);
    }


}
