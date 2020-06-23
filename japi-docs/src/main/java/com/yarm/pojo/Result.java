package com.yarm.pojo;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private boolean status;
    private String msg;
    private T data;
}
