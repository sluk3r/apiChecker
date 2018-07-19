package invokeJavaStaticMethod;

/**
 * Created by wangxichun on 2018/7/19.
 */
public class JavaStaticMethodContainer {

    public static String appendix = "JavaStaticMethodContainer";

    public static String append(String source) {
        return source + "_" + appendix;
    }
}
