package util;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.fail;

public class CollectionsTest {

    @Test
    public void test_collection_max_of_empty_list() {
        List emptyList = Collections.EMPTY_LIST;

        try {
            Object o = Collections.max(emptyList);
            fail("NoSuchElementException be thrown");
        } catch (NoSuchElementException e) {
            //ignore
        }
    }
}
