package com.lzx.Config;

/**
 * Created by Ronin on 2018/2/5.
 *
 * 枚举类，定义会可能出现的异常
 *
 * */
public enum ResultCode {

    /** 成功 */
    SUCCESS("200", "成功"),

    /** 没有登录 */
    NOT_LOGIN("400", "没有登录"),

    /** 发生异常 */
    EXCEPTION("401", "用户没有权限"),

    /** 系统错误 */
    SYS_ERROR("402", "系统错误"),

    /** 参数错误 */
    PARAMS_ERROR("403", "参数错误 "),

    /** 不支持或已经废弃 */
    NOT_SUPPORTED("410", "不支持或已经废弃"),

    /** AuthCode错误 */
    INVALID_AUTHCODE("444", "无效的AuthCode"),

    /** 太频繁的调用 */
    TOO_FREQUENT("445", "太频繁的调用"),

    /** 未知的错误 */
    UNKNOWN_ERROR("499", "未知错误"),

    /** 需要的参数丢失 */
    NO_PARAM("-100", "需要的参数丢失"),

    /** token为空 */
    TOKEN_IS_NULL("001", "token为空"),

    /** 数据为空 */
    DATA_IS_NULL("002", "数据为空"),

    /** 操作失败 */
    ERROR("003", "操作失败"),
    /** 数据重复 */
    DATA_REPEAT("004", "数据重复");

    private ResultCode(String value, String msg) {
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;

}
