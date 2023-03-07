package ink.geekhub.server.exception;

import lombok.Getter;

/**
 * 接口错误异常
 * @author linghua
 */
@Getter
public class ApiException extends RuntimeException{

    private final int code;

    private final String msg;

    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiException(String msg) {
        this(400, msg);
    }

    public ApiException() {
        this(400, "接口异常");
    }
}
