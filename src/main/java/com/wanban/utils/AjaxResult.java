package com.wanban.utils;

import java.util.List;

/**
 * Created by 赖红 on 2018/1/17.
 */
public class AjaxResult<T> {
    private boolean success;
    private String msg;
    private boolean hasError;
    private String error;

    public AjaxResult(boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public boolean isHasError() {
        return hasError;
    }
    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

}
