package prototype;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:prototype/spring-config.xml" })
public class ProtoTypeTest {
    @Resource(name = "l1")
    List<Person> l1;

    @Resource(name = "l2")
    List<Person> l2;

    @Test
    public void protoTypeCheck () {
        Person pInL1 = l1.get(0);
        String instance1MemAddress = pInL1.toString();

        Person pInL2 = l2.get(0);
        String instance2MemAddress = pInL2.toString();

        assertFalse("实例是两个", instance1MemAddress.equals(instance2MemAddress));
    }

}
