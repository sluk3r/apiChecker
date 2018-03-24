package lang;

import org.junit.Test;

import static java.lang.String.format;

public class StringformatDemo {

    @Test
    public void test_format() {

        String bizId = format("%s_%s", 1, 2);

        System.out.println(bizId);
    }
    
    
    @Test
    public void test_value_of_null() {
        Object null_value = null;
        System.out.println(String.valueOf(null_value));


    }

}
