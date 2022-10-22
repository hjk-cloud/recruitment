package edu.lnu.recruitment.common.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.lnu.recruitment.common.security.exception.KaptchaNotMatchException;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName : LoginFilter
 * @Description : springsecurity相当于一个过滤器链，默认配置是通过UserNamePasswordAuthenticationFilter来处理登录的，
 *                而且是通过attemptAuthentication来实现的，由于他它使用的是requests.getParams()来获取的表单数据，
 *                面对前后端分离就不成立了，所以我们自定义前后端分离Filter，通过重写让attemptAuthentication，来实现自定义
 *                最后让springsecurity加载我们自定义的filter
 * @Author : 今晚月亮复活了
 * @Date: 2022/9/29  17:51
 */


@Data
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    public static final String FORM_KAPTCHA_KEY = "kaptcha";

    private String kaptchaParameter = FORM_KAPTCHA_KEY;



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //1.判断是否是post方式请求，如果不是post
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        //2.判断前端发来的是否为json格式的请求类型
        if(request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)){
            //3.从json中获取用户输入的用户名和密码进行认证{"username":"","password":""}
            try {
                Map<String, String> userInfo = new ObjectMapper().readValue(request.getInputStream(), Map.class);
                //这里调用getUsernameParameter是为了灵活使用,比如前端是name=username,则默认即可,否则可通过set进行设置取值,具体可看源码
                //2.获取 session 中验证码
                String kaptcha = userInfo.get(getKaptchaParameter());//用来获取数据中验证码
                String sessionVerifyCode = (String) request.getSession().getAttribute("kaptcha");
                if (!ObjectUtils.isEmpty(kaptcha) && !ObjectUtils.isEmpty(sessionVerifyCode) &&
                        kaptcha.equalsIgnoreCase(sessionVerifyCode)) {
                    //getUsernameParameter()已在springsecurityconfig进行设置
                    String username = userInfo.get(getUsernameParameter());
                    String password = userInfo.get(getPasswordParameter());
                    //当在页面中输入用户名和密码之后首先会进入到UsernamePasswordAuthenticationToken验证(Authentication)
                    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
                    setDetails(request, authRequest);
                    return this.getAuthenticationManager().authenticate(authRequest);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new KaptchaNotMatchException("验证码不匹配!");
        }
        //4.如果自定义filter的条件都不满足，那我们默认回调父类，相当与走默认流程
        return super.attemptAuthentication(request, response);
    }
}
