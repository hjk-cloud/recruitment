package edu.lnu.recruitment.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : MyLogoutSuccessHandler
 * @Description : 自定义注销成功处理接口
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/16  10:04
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("msg", "注销成功");
        result.put("用户信息", authentication.getPrincipal());
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpStatus.OK.value());
        String s = new ObjectMapper().writeValueAsString(result);
        response.getWriter().println(s);
    }
}
