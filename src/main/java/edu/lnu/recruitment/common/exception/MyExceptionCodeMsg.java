package edu.lnu.recruitment.common.exception;

/**
 * @Package: edu.lnu.recruitment.common.exception
 * @ClassName: MyExceptionCodeMsg
 * @Author: huangjk
 * @CreateTime: 2022/11/22 21:53
 * @Description:
 */
public enum MyExceptionCodeMsg {


    INVALID_ID(1001, "无效ID"),
    BAD_FORMAT(1002, "数据格式错误"),
    PAGE_LIMIT(1003, "页数超出限制"),
    PARAM_IS_NULL(1004, "缺少必填参数"),
    PARAM_LIMIT(1005, "参数长度超出限制"),
    PARAM_TYPE_ERROR(1006, "参数类型错误");

    private int code;
    private String msg;

    MyExceptionCodeMsg(int code, String msg) {
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
