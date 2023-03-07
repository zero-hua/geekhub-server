package ink.geekhub.server.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义参数校验错误码和错误信息注解
 * @author linghua
 */
@Retention(RetentionPolicy.RUNTIME)//运行时可以通过反射访问
@Target({ElementType.FIELD})//作用于域上
public @interface ExceptionCode {

    int value() default 400;

    String msg() default "服务出现异常";
}
