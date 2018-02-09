package com.lzx.Config;

/**
 * Created by Ronin on 2018/2/5.
 *
 * 统一返回的字段
 *
 */
public class APIResult {

    private String code;
    private String message;
    private Object data;

    public APIResult() {

    }

    public APIResult(ResultCode code, String message, Object data) {
        this.setCode(code);
        this.setMessage(code.msg());
        this.data = data;
    }




    public APIResult(ResultCode code, Object data) {
        this.setCode(code);
        this.setMessage(code.msg());
        this.data = data;
    }



    public String getCode() {

        return code;
    }

    public void setCode(ResultCode code) {

        this.code = code.val();
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public Object getData() {

        return data;
    }

    public void setData(Object data) {

        this.data = data;
    }
}
