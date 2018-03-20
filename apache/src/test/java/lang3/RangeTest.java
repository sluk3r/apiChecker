package lang3;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.Range;
import org.junit.Test;

import java.util.*;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.apache.commons.lang3.Range.between;
import static org.junit.Assert.assertFalse;

public class RangeTest{

    @Test
    public void test_range_between() {
        Range r1 = between(201, 4999);

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
        Range r0 = between(MIN_VALUE, 200);
        Range r1 = between(201, 4999);
        Range r2 = between(5000, MAX_VALUE);

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
    
    
    @Test
    public void test_range_Overlap_demo() {
        Range r0 = between(MIN_VALUE, 200);
        Range r1 = between(201, 4999);
        Range r2 = between(5000, MAX_VALUE);


        List<Range> rangeList = new ArrayList();
        rangeList.add(r0);
        rangeList.add(r1);
        rangeList.add(r2);

        for (int i=0;i<rangeList.size();i++) {
            Range r = rangeList.get(i);
            for (int j=i+1;j<rangeList.size();j++) {
                Range rInner = rangeList.get(j);

                if (rInner.isOverlappedBy(r)) {
                    fail(String.format("range[%s] and range[%s] overlop", JSON.toJSONString(r), JSON.toJSONString(rInner)));
                }
            }
        }


    }


}
