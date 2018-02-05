package com.sanshao90.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/5
 */
@Data
@AllArgsConstructor
public class Result<T> {

    public static final int OK = 0;
    public static final int ERROR = -1;

    public static final String OK_MSG = "OK";
    public static final String ERROR_MSG = "ERROR";

    public static final String[] NOOP = {};

    private int code;
    private String msg;
    private String url;
    private T data;

    public static <T> Result<T> ok(int code, String msg, String url, T data) {
        return new Result<T>(code, msg, url, data);
    }

    public static <T> Result<T> ok(int code, String msg, T data) {
        return ok(code, msg, null, data);
    }

    public static <T> Result<T> ok(String msg, T data) {
        return ok(OK, msg, null, data);
    }

    public static <T> Result<T> ok(T data) {
        return ok(OK, OK_MSG, null,data);
    }

    public static Result<String[]> ok(String msg) {
        return ok(OK, OK_MSG, msg, NOOP);
    }

    public static <T> Result<T> error(int code, String msg, String url, T data) {
        return new Result<T>(code, msg, url, data);
    }

    public static <T> Result<T> error(int code, String msg, T data) {
        return ok(code, msg, null, data);
    }

    public static <T> Result<T> error(String msg, T data) {
        return ok(ERROR, msg, null, data);
    }

    public static <T> Result<T> error(T data) {
        return ok(ERROR, ERROR_MSG, null,data);
    }

    public static Result<String[]> error(String msg) {
        return ok(ERROR, ERROR_MSG, msg, NOOP);
    }
}

