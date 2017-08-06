package compomentConstructArgs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by wangxichun on 2017/8/6 0006.
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:compomentConstructArgs/spring-config.xml"})
public class XXXServiceTest {
    @Autowired
    XXXService xxxService;

    @Test
    public void nameEquals() {
        assertEquals("jd.ofw", xxxService.getName());
    }
}
