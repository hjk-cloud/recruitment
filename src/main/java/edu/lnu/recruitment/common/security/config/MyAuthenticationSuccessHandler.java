package edu.lnu.recruitment.common.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : MyAuthenticationSuccessHandler
 * @Description : 自定义登陆成功AuthenticationSuccessHandler接口
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/15  9:17
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("msg", "登录成功");
        result.put("用户信息", authentication.getPrincipal());
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpStatus.OK.value());
        String s = new ObjectMapper().writeValueAsString(result);
        response.getWriter().println(s);

    }
}
