package com.yarm.response;

import lombok.Data;

@Data
public class Result<T> {
    public Result(){
        this.status = true;
    }
    private boolean status;
    private int code;
    private T data;
}
