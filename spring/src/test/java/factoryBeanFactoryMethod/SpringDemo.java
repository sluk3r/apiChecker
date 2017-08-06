package factoryBeanFactoryMethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by wangxichun on 2017/8/6 0006.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:factoryBeanFactoryMethod/spring-config.xml"})
public class SpringDemo {

    @Autowired
    UserService userService;


    @Autowired
    LoginService loginService;


    @Test
    public void demo() {
        assertNotNull(userService);
        assertNotNull(loginService);
    }


}
