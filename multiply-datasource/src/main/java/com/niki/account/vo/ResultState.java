package com.niki.account.vo;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/26
 */
public class ResultState {
    public static final ResultState SUCCESS = new ResultState(0, "Success");
    public static final ResultState FALLBACK = new ResultState(-1, "Fallback");
    public static final ResultState FAILED = new ResultState(-2, "Failed");
    public static final ResultState PARAM_ERROR = new ResultState(-3, "Param Error");
    private Integer code = 0;
    private String message = "";

    public ResultState(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
