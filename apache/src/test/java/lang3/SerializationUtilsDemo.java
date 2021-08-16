package lang3;

import com.google.common.collect.Lists;
import modelTest.Person;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class SerializationUtilsDemo {
    @Test
    public void deepClone() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Person laoDa = new Person("zhangDa");
        Person laoEr = new Person("zhangEr");
        Person laoSan = new Person("zhangSan");
        Person laoSi = new Person("zhangSi");
        laoSi.setBrothers(Lists.newArrayList(laoDa, laoEr, laoSan));
        
        Person laoSiCloneShallow = (Person) BeanUtils.cloneBean(laoSi);
        Person laoDaFromShallowCloned = laoSiCloneShallow.getBrothers().get(0);
        assertSame("", laoDa, laoDaFromShallowCloned);
    
        Person laoSiCloneDeep = SerializationUtils.clone(laoSi);
        Person laoDaFromDeepCloned = laoSiCloneDeep.getBrothers().get(0);
        assertNotSame(laoDa, laoDaFromDeepCloned);
    }
}

