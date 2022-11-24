package edu.lnu.recruitment.common.exception;

import edu.lnu.recruitment.common.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: edu.lnu.recruitment.common.exception
 * @ClassName: GlobalExceptionHandler
 * @Author: huangjk
 * @CreateTime: 2022/11/22 21:56
 * @Description:
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public R exceptionHandler(Exception e) {
        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return R.error(myException.getCode(), myException.getMsg());
        }
        return R.error(500, "服务器异常");
    }
}
