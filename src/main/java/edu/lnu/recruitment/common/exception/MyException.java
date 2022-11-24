package edu.lnu.recruitment.common.exception;

/**
 * @Package: edu.lnu.recruitment.common.exception
 * @ClassName: MyException
 * @Author: huangjk
 * @CreateTime: 2022/11/20 21:56
 * @Description:
 */
public class MyException extends RuntimeException {
    private int code = 500;
    private String msg = "服务器异常";

    public MyException(MyExceptionCodeMsg myCodeMsg) {
        this.code = myCodeMsg.getCode();
        this.msg = myCodeMsg.getMsg();
    }

    public MyException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
