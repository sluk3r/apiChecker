package lang3;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.Range;
import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class RangeTest{

    @Test
    public void test_range_between() {
        Range r1 = Range.between(201, 4999);

        //自然值
        assertTrue(r1.contains(300));

        //边界值
        assertTrue(r1.contains(201));
        assertTrue(r1.contains(4999));

        //不可能包含的值
        assertFalse(r1.contains(5000));
        assertFalse(r1.contains(200));
    }
    
    
    @Test
    public void test_range_map() {
        Range r0 = Range.between(Integer.MIN_VALUE, 200);
        Range r1 = Range.between(201, 4999);
        Range r2 = Range.between(5000, Integer.MAX_VALUE);

        Map<Range, Integer> rangeMap = ImmutableMap.of(r0, 0, r1, 1, r2, 2);


        int userSroce = 10;

        Integer sendpayFlag = null;

        for(Map.Entry<Range, Integer> me: rangeMap.entrySet()) {
            if (me.getKey().contains(userSroce)) {
                sendpayFlag = me.getValue();
                break;
            }
        }

        assertEquals(Integer.valueOf(0), sendpayFlag);
    }

}
