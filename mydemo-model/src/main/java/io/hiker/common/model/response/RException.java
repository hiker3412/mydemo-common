package io.hiker.common.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RException extends RuntimeException {
    private String code;

    public RException(String message) {
        super(message);
        this.code = REnum.FAIL.code();
    }

    public RException(REnum rEnum) {
        super(rEnum.msg());
        this.code = rEnum.code();
    }

    public RException(REnum rEnum, String message) {
        super(message);
        this.code = rEnum.code();
    }

    public R<Void> toR() {
        return new R<Void>().setCode(this.code).setMsg(getMessage());
    }
}
