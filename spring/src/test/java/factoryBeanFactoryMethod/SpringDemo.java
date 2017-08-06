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

        /**
         * 过程中的两个问题：
         * 1. spring-context jar没能自动引入， spring-core引入后spring-context也不能自动引入？这些spring jar之间的关联关系怎样？
         * 2. 用@ContextConfiguration({"classpath:factoryBeanFactoryMethod/spring-config.xml"})行， 但用@ContextConfiguration({"classpath:factoryBeanFactoryMethod/spring-*.xml"})不行。 这里的通配符不起作用。具体什么情况下， 才起作用？
         */
    }


}
