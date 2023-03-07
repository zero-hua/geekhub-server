package ink.geekhub.server.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author linghua
 */
@Getter
@ToString
@Setter
public class ResultVO<T> {

    /**
     * 错误码
     * 0 请求成功
     * 1 请求不成功
     * 2 服务器问题
     */
    private final Integer code;

    private final String msg;

    private final T data;

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(ReturnCode code, T data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public ResultVO(T data) {
        this(ReturnCode.SUCCESS, data);
    }

    public static ResultVO<Object> success(Object data) {
        return new ResultVO<Object>(0, "请求成功", data);
    }
}
