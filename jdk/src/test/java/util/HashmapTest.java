package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wangxichun on 2017/9/28 0028.
 */
public class HashmapTest {


    @Test
    public void putGet() {
        HashMap map = new HashMap();


        map.put("k1", "v1");
        map.put("k1", "v2");

        assertEquals("v2", map.get("k1"));
    }

}
