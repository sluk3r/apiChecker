package primary;

import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ArrayOfNull {
    
    @Test
    public void test_put_null_into_array_should_not_throw_exception() {
        try {
            String[] stringArray = new String[] {null};
        } catch (Throwable t) {
            fail("数组里放一个null时不应该抛出异常");
        }

    }

    @Test
    public void test_array_of_null_length() {
        String[] stringArray = new String[] {null};
        assertTrue(stringArray.length == 1);
    }

    @Test
    public void test_array_of_null_should_iterate() {
        String[] stringArray = new String[] {null};
        for(String s: stringArray) {
            assertNull(s);
        }
    }
    
}
