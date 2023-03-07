package ink.geekhub.server.utils;

import org.elasticsearch.action.get.GetRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author linghua
 */
public class HttpContextUtil {

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static HttpSession getSession() {
        HttpServletRequest request = getRequest();
        return request.getSession();
    }

    public static void setAttributeToSession(String name, Object data) {
        getSession().setAttribute(name, data);
    }

    public static Object getAttributeFromInSession(String name) {
        return getSession().getAttribute(name);
    }

}
