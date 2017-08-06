package clazz;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by wangxichun on 2017/8/6 0006.
 */
public class ClazzDemo {

    @Test
    public void className() {
        Class thisClass = this.getClass();

        assertEquals("clazz.ClazzDemo", thisClass.getName());
        assertEquals("ClazzDemo", thisClass.getSimpleName());
        assertTrue(thisClass.getCanonicalName().equals(thisClass.getName()));
    }

}
