package com.niki.account.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/26
 */
@Data
public class Result<T> {
    @ApiModelProperty(
            value = "状态码",
            required = true
    )
    private Integer code = 0;
    @ApiModelProperty("提示信息")
    private String message = "";
    @ApiModelProperty("封装对象")
    private T model;

    public static <T> Result failResult(Integer code, String msg, T model) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setModel(model);
        return result;
    }

    public static Result customFaillbackResult(String code, String msg) {
        Result result = new Result();
        result.setCode(ResultState.FAILED.getCode());
        result.setModel(code);
        result.setMessage(msg);
        return result;
    }

}
