package com.niki.account.constants;

/**
 * Description: 模块错误信息
 *
 * @author : xudong.shen
 * @version V1.0
 * @since : 2019年10月21日 3:43 PM
 */
public enum ErrorCode {
    /**
     * 处理Throw出来的异常
     */
    UNKNOWN_ERROR(-5020000,"未知错误,稍后再试"),
    ;

    private int code;

    private String msg;

    ErrorCode(int code, String desc){
        this.code = code;
        this.msg = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
