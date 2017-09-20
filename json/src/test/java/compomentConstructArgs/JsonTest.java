package compomentConstructArgs;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxichun on 2017/9/20 0020.
 */
public class JsonTest {

    @Test
    public void test() {
        Map<String, Date> downOrderInfo = new HashMap<>();
        downOrderInfo.put("now", new Date());

        SerializeConfig mapping = new SerializeConfig();
        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        String json = JSONObject.toJSONString(downOrderInfo,mapping, SerializerFeature.WriteDateUseDateFormat);//{"now":"2017-09-20 21:53:47"}
//        String json = JSONObject.toJSONString(downOrderInfo); //{"now":1505915484713}


        System.out.println(json);
    }

}
