package ink.geekhub.server.utils;

/**
 * 提供随机验证码
 * @author linghua
 */
public class RandomCodeService {

    public static String getRandomCode() {
        long l1 = System.currentTimeMillis();
        long l2 = l1 % 1000000;
        String s = String .valueOf(l2);
        if (s.length() == 5) {
            s += "0";
        }
        return s;
    }
}
