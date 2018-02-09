package com.lzx.Config;

/**
 * Created by Ronin on 2018/2/5.
 *
 * 定义一个统一的返回页面数据格式
 */
public class BaseAPI {

    public APIResult setResult(ResultCode code, Object data) {
        APIResult result = new APIResult(code, code.msg(),data);
        return result;
    }
}
