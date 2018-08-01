package defaultCtx;

import model.Product;
import org.drools.StatefulSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.maciejwalkowiak.drools.DroolsJUnitRunner;
import pl.maciejwalkowiak.drools.annotations.DroolsFiles;
import pl.maciejwalkowiak.drools.annotations.DroolsSession;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


/**
 * Created by wangxichun on 2018/7/17.
 */
@RunWith(DroolsJUnitRunner.class)
@DroolsFiles(value = "defaultCtx.drl", location = "/test-rules/defaultCtx")
public class JavaReadDroolsReturnedValueTest {
    @DroolsSession
    StatefulSession kieSession;

    /**
     * 通过全局变量的方式， 读取返回值。
     */
    @Test
    public void read() {
        // Java - prior to fireAllRules
        DroolsResultContainer resultContainer_defined_in_java = new DroolsResultContainer();
        kieSession.setGlobal("resultContainer_defined_in_drl", resultContainer_defined_in_java);  //

        Product product = new Product();

        kieSession.insert(product);
        kieSession.fireAllRules();

        assertEquals(150000, product.getDiscount());
        assertTrue(resultContainer_defined_in_java.size()>1);
        assertTrue(product == resultContainer_defined_in_java.getValueByKey("k1"));
        assertTrue(resultContainer_defined_in_java.getValueByKey("k2") instanceof Date);
    }
}
