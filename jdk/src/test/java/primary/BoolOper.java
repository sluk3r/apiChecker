package primary;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by wangxichun on 2017/10/2 0002.
 */
public class BoolOper {

    @Test
    public void boolOr() {
        assertTrue(false | true);
        assertFalse(false & true);
        assertTrue(true | true);
    }

}
