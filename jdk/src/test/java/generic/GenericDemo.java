package generic;

import com.google.common.collect.Maps;
import jdk.model.Person;
import jdk.model.PersonRegister;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class GenericDemo {
    
    @Test
    public void withoutGenericClass() {
        Map<String, Person> register = Maps.newHashMap();
        
        register.put("zhangsan", new Person("zhangsan", "132336201309231242"));
        register.put("lisi", new Person("lisi", "13233620130923124X"));
        
        assertNotNull(register.get("lisi"));
        
        // 这个是业务上容易出现问题的地方，
        assertNull(register.get(3L));
    }
    
    @Test
    public void withGenericClass() {
        PersonRegister personRegister = new PersonRegister();
    
        personRegister.registerPersonWithName("zhangsan", new Person("zhangsan", "132336201309231242"));
        personRegister.registerPersonWithName("lisi", new Person("lisi", "13233620130923124X"));
        
        assertNotNull(personRegister.fetchPersonWithName("lisi"));
        
        // 这样的封装， 避免了上面的因错误类型导致异常。
        // PersonRegister专人负责，业务知识聚焦，由于更理解业务，才能通过封装的方式隔离变化，同时又提供业务易读的API。
        //      jdk.model.PersonRegister#fetchPersonWithName vs  java.util.Map#get
        // assertNull(personRegister.fetchPersonWithName(3L));
    }
}
