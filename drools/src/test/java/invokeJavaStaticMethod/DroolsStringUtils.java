package invokeJavaStaticMethod;

/**
 * Created by wangxichun on 2018/7/19.
 */
public class DroolsStringUtils {
    public static boolean isEmpty(String param) {
        if (param == null || "".equals(param)) {
            return true;
        }
        return false;
    }
}
