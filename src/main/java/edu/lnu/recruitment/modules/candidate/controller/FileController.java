package edu.lnu.recruitment.modules.candidate.controller;

import edu.lnu.recruitment.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
    //定义日期格式，返回指定时间格式输入
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");


    @RequestMapping("/upload")
    public R fileUpload(MultipartFile file, HttpServletRequest request){
        //获得文件原始名字
        String originalFilename = file.getOriginalFilename();
        if(!originalFilename.endsWith(".pdf")){
            return R.error("只能上传pdf类型文件");
        }else if(file.getSize() > File_SIZE){
            return R.error("请上传小于5MB文件");
        }
        String dataformat = sdf.format(new Date());
        String realpath = request.getServletContext().getRealPath("/") + dataformat;
        File folder = new File("C:\\Users\\lenovo\\Desktop\\简历文件夹");
        if(!folder.exists()){
            folder.mkdirs();
        }
        String newName = UUID.randomUUID().toString() + ".pdf";
        try {
            file.transferTo(new File(folder, newName));
            String url = request.getScheme() + "://" +  request.getServerName() + ":" + request.getServerPort() + dataformat + newName;
            R result = new R();
            result.put("status", "简历成功上传");
            result.put("预览地址", url);
            return result;
        } catch (IOException e) {
            return R.error(e.getMessage());
        }

    }





}
