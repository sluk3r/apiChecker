package readDroolsReturnedValue;

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
@DroolsFiles(value = "test-rules.drl", location = "/test-rules/")
public class JavaReadDroolsReturnedValueTest {
    @DroolsSession
    StatefulSession kieSession;

    /**
     * 通过全局变量的方式， 读取返回值。
     */
    @Test
    public void read() {
        // Java - prior to fireAllRules
        DroolsResultContainer resultContainer = new DroolsResultContainer();
        kieSession.setGlobal("resultContainer", resultContainer);

        Product product = new Product();

        kieSession.insert(product);
        kieSession.fireAllRules();

        assertEquals(150000, product.getDiscount());
        assertTrue(resultContainer.size()>1);
//        assertTrue(product == resultContainer.getValueByKey("k1"));
//        assertTrue(resultContainer.getValueByKey("k1") instanceof Date);
    }
}
