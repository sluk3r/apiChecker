package droolsInvokeSpringBean;

import org.drools.StatefulSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.maciejwalkowiak.drools.DroolsJUnitRunner;
import pl.maciejwalkowiak.drools.annotations.DroolsFiles;
import pl.maciejwalkowiak.drools.annotations.DroolsSession;

/**
 * Created by wangxichun on 2018/7/19.
 */

@RunWith(DroolsJUnitRunner.class)
@DroolsFiles(value = "drools_simple_invoke_spring_service_via_static_method.drl", location = "/test-rules/invokeSpringBean/")
public class InvokeSpringBeanService {
    @DroolsSession
    StatefulSession kieSession;


    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        SpringContextContainer.setContext(context);
    }


    @Test
    public void invoke_spring_bean() {
        kieSession.fireAllRules();
    }

}
