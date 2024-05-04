package io.hiker.common.model.response;

public enum REnum {
    //1000 重复提交
    PROCESSING("1000","正在操作中"),

    //2000 处理成功
    SUCCESS("2000","success"),

    //4000 客户端参数错误
    CLIENT_FAIL("4000","客户端异常"),

    //服务器发生异常
    FAIL("5000","系统异常");

    REnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    String code;
    String msg;

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
