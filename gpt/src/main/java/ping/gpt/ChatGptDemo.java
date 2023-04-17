package ping.gpt;


import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ChatGptDemo {

    private static final String URL = "https://service-0ctbjjhm-1317703753.hk.apigw.tencentcs.com/v1/completions";
    private static final String PRIVATE_TOKEN = "XXXX";

    public static void main(String[] args) {
        ChatGpt chatGpt = new ChatGpt();
        String responseText = chatGpt.getResponseText("在中国一个25岁的男生应该有多少存款？");
        System.out.println("GPT text: " + responseText);
    }

    private static class ChatGpt {
        private final Map<String, String> headers;
        private final JSONObject json;

        public ChatGpt() {
            headers = new HashMap<>();
            headers.put("Content-Type", "application/json;charset=UTF-8");

            json = new JSONObject();
            // 选择模型
            json.set("model", "text-davinci-003");
            json.set("temperature", 0.9);
            json.set("max_tokens", 2048);
            json.set("top_p", 1);
            json.set("frequency_penalty", 0.0);
            json.set("presence_penalty", 0.6);
        }

        public String getResponseText(String prompt) {
            // 添加我们需要输入的内容
            json.set("prompt", prompt);

            HttpResponse response = HttpRequest.post(URL)
                    .headerMap(headers, false)
                    .bearerAuth(PRIVATE_TOKEN)
                    .body(String.valueOf(json))
                    .timeout(5 * 60 * 1000)
                    .execute();

            String body = response.body();
            System.out.println("========================GPT返回的原始报文=============================================");
            System.out.println("GPT body: " + body);

            Map<String, Object> result = JSON.parseObject(body, Map.class);
            List<Map<String, Object>> choices = (List<Map<String, Object>>) result.get("choices");
            Map<String, Object> o = choices.get(0);
            return (String) o.get("text");
        }
    }
}
