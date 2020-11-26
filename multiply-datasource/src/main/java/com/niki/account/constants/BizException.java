package com.niki.account.constants;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description :业务异常
 * @Author : yarm.yang
 * @Date : 2020/5/6 9:36
*/
@Data
@AllArgsConstructor
public class BizException extends Exception {

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorMsg;

    public BizException(ErrorCode error) {
        super(error.getMsg());
        this.errorCode = String.valueOf(error.getCode());
        this.errorMsg = error.getMsg();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
