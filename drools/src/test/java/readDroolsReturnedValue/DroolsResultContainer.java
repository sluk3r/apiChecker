package readDroolsReturnedValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxichun on 2018/7/17.
 */


public class DroolsResultContainer {
    Map<String,Object> container = new HashMap<String, Object>();


    public void putValueByKey(String key, Object value) {
        container.put(key, value);
    }

    public Object getValueByKey(String key) {
        return container.get(key);
    }

    public int size() {
        return container.size();
    }
}
