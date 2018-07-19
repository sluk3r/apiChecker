package invokeJavaStaticMethod;

import model.Product;
import org.drools.StatefulSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.maciejwalkowiak.drools.DroolsJUnitRunner;
import pl.maciejwalkowiak.drools.annotations.DroolsFiles;
import pl.maciejwalkowiak.drools.annotations.DroolsSession;
import readDroolsReturnedValue.DroolsResultContainer;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by wangxichun on 2018/7/19.
 */

@RunWith(DroolsJUnitRunner.class)
@DroolsFiles(value = "drools_simple_invoke_static_method.drl", location = "/test-rules/invokeStaticMethod/")
public class invokeJavaStaticMethodSimply {
    @DroolsSession
    StatefulSession kieSession;


    @Test
    public void invoke_java_static_method_simple() {
        kieSession.fireAllRules();
    }

}
