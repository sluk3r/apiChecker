package droolsInvokeSpringBean;

import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created by wangxichun on 2018/7/19.
 */
public class SpringContextContainer {
    public static  ApplicationContext contextStaticHolder;

    public static void setContext(ApplicationContext context) {
        contextStaticHolder = context;
    }


    public static void invokeSpringBeanWithoutResult(String beanId, String methodName, Map<String,Object> input) {

    }

}
