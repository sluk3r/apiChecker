package lang;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class LongDivideToFloat {
    
    @Test
    public void longDividedResultToFloat() throws InterruptedException {
        long start = System.currentTimeMillis();
    
        TimeUnit.MILLISECONDS.sleep(345);
        
        long end = System.currentTimeMillis();
        
        long duration = end - start;
    
        System.out.println("duration: " + duration);
        
        // 这样加了强类型转换后， 最终结果中才能是小数
        float durationInFloat = (float)duration / 1000;
        
        System.out.println("durationInFloat: " + durationInFloat);
    }
}
