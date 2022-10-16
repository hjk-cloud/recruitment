package edu.lnu.recruitment.security.loginandauthority.login.controller;

import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName : testController
 * @Description : test
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/15  18:24
 */
@RestController
public class VerifyCodeController {

    private final Producer producer;

    @Autowired
    public VerifyCodeController(Producer producer) {
        this.producer = producer;
    }

    //因为前后端分离是不能用流进行数据返回的，这里通过返回一串base64供前端解析
    public String getVerifyBase64Code;

    @GetMapping("/verifycode.jpg")
    public String getVerifyBase64Code(HttpSession httpSession) throws IOException {
        //1.生成验证码
        String text = producer.createText();
        //2.放入 session redis 实现
        httpSession.setAttribute("kaptcha", text);
        //3.生成图片
        BufferedImage bi = producer.createImage(text);
        FastByteArrayOutputStream fos = new FastByteArrayOutputStream();
        ImageIO.write(bi, "jpg", fos);
        //4.返回 base64
        return Base64.encodeBase64String(fos.toByteArray());
    }
}
