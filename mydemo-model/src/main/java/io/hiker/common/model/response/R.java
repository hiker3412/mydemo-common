package io.hiker.common.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class R<T> {
    private String code;
    private String msg;
    private T data;

    public R(REnum rEnum) {
        this.code = rEnum.code();
        this.msg = rEnum.msg();
    }

    public R(REnum rEnum, T data) {
        this.code = rEnum.code();
        this.msg = rEnum.msg();
        this.data = data;
    }

    public static <T> R<T> success() {
        return new R<T>(REnum.SUCCESS);
    }

    public static <T> R<T> success(T data) {
        return new R<T>(REnum.SUCCESS,data);
    }

    public static <T> R<T> fail() {
        return new R<T>(REnum.FAIL);
    }

    public static <T> R<T> fail(String msg) {
        return new R<T>(REnum.FAIL).setMsg(msg);
    }

    public static <T> R<T> clientFail() {
        return new R<T>(REnum.CLIENT_FAIL);
    }

    public static <T> R<T> clientFail(String msg) {
        return new R<T>(REnum.CLIENT_FAIL).setMsg(msg);
    }

}
