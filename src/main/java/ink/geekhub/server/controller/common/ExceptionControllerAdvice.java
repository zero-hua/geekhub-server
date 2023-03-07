package ink.geekhub.server.controller.common;

import ink.geekhub.server.anno.ExceptionCode;
import ink.geekhub.server.exception.ApiException;
import ink.geekhub.server.vo.ResultVO;
import ink.geekhub.server.vo.ReturnCode;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;

/**
 * 全局异常处理类
 * @author linghua
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 处理参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) throws NoSuchFieldException {
        //从异常对象中拿到错误信息
        String defaultMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        //参数的Class对象， 等下通过字段名字获取Field对象
        Class parameterType = e.getParameter().getParameterType();
        //拿到错误的字段名称
        String fieldName = e.getBindingResult().getFieldError().getField();
        Field field = parameterType.getDeclaredField(fieldName);
        //获取Field对象上的自定义注解
        ExceptionCode exceptionCode = field.getAnnotation(ExceptionCode.class);

        //被自定义注解的话就返回注解的响应信息
        if (exceptionCode == null) {
            return new ResultVO<>(exceptionCode.value(), exceptionCode.msg(), defaultMessage);
        }
        //没有就返回默认的统一的错误信息
        return new ResultVO<>(ReturnCode.FAILURE, defaultMessage);
    }

    /**
     * api异常
     */
    @ExceptionHandler(ApiException.class)
    public ResultVO<String> apiExceptionHandler(ApiException e) {
        return new ResultVO<>(ReturnCode.VALIDATE_FAILED, e.getMsg());
    }
}
