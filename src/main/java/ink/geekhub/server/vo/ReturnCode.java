package ink.geekhub.server.vo;

import lombok.Getter;

/**
 * 返回状态码
 * @author linghua
 */
@Getter
public enum ReturnCode {

    SUCCESS(200, "操作成功"),
    FAILURE(500, "操作失败"),
    VALIDATE_FAILED(404, "参数校验失败"),
    UNAUTHORIZED(401, "未登录或登录过期"),
    FORBIDDEN(403, "没有操作权限");

    private final int code;

    private final String msg;

    ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
