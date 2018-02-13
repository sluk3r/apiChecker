package log4j2Withslf4J;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by wangxichun on 2018/2/13 0013.
 */
public class Log4j2WithSlf4jTest {
    
    @Test
    public void test_demo() {
        Logger logger = getLogger(Log4j2WithSlf4jTest.class);

        String loggerImplClassName = logger.getClass().getSimpleName();
        assertTrue(loggerImplClassName.equals("SLF4JLogger"));
    }
    
}
