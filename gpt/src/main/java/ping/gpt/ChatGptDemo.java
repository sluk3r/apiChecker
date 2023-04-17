package ping.gpt;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taoxi
 * @version 1.0
 * @description:
 * @date 2023/4/8 8:54 上午
 */
public class ChatGptDemo {

    public static void main(String[] args) {
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type","application/json;charset=UTF-8");

        JSONObject json = new JSONObject();
        //选择模型
        json.set("model","text-davinci-003");
        //添加我们需要输入的内容
        json.set("prompt","在中国一个25岁的男生应该有多少存款？");
        json.set("temperature",0.9);
        json.set("max_tokens",2048);
        json.set("top_p",1);
        json.set("frequency_penalty",0.0);
        json.set("presence_penalty",0.6);

        String privateToken = "XXXX";


//        HttpResponse response = HttpRequest.post("https://api.openai.com/v1/completions")

        HttpResponse response = HttpRequest.post("https://service-0ctbjjhm-1317703753.hk.apigw.tencentcs.com/v1/completions")
                .headerMap(headers, false)
                .bearerAuth(privateToken)
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute();


        String body = response.body();
        System.out.println("========================GPT返回的原始报文=============================================");
        System.out.println("GPT body: " + body);

        Map result = JSON.parseObject(body, Map.class);
        List choices = (List) result.get("choices");
        Map o = (Map) choices.get(0);
        Object text = o.get("text");

        System.out.println("============================================================================");
        System.out.println("GPT text: " + text);
    }
}
