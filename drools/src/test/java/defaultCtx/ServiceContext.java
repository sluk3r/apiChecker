package defaultCtx;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxichun on 2018/7/17.
 */


public class ServiceContext {
    Map<String,Object> container = new HashMap<String, Object>();
    Map<String,Object> systemContext = new HashMap<String, Object>();


    public void putValueByKeyIntoContainer(String key, Object value) {
        container.put(key, value);
    }

    public Object getValueByKey(String key) {
        return container.get(key);
    }


    public int size() {
        return container.size();
    }


    public void putValueByKeyIntoSystemContext(String key, Object value) {
        systemContext.put(key, value);
    }

    public Object getValueByKeyFromSystemContext(String key) {
        return systemContext.get(key);
    }


}
