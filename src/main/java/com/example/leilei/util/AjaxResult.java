package com.example.leilei.util;

public class AjaxResult {
    private boolean success = true;

    private String message = "操作成功!";

    //在实际开发中，还有两个属性
    //private Object data;
    //private int code;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //成功
    public AjaxResult(){}

    //失败
    public AjaxResult(String message){
        this.success = false;
        this.message = message;
    }
}
