package jsonPath;

import com.alibaba.fastjson.JSON;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class JsonPathDemo {
    @Test
    public void extract() {
        String content = "[\n" +
                "  {\n" +
                "    \"statementId\": \"com.jd.orderpackage.pack\",\n" +
                "    \"msgObj\": {\n" +
                "      \"waybillCode\": \"JDVB02278596342\",\n" +
                "      \"mode\": 1,\n" +
                "      \"packList\": [\n" +
                "        {\n" +
                "          \"operatorName\": \"bjzzc\",\n" +
                "          \"packWeight\": \"0.0\",\n" +
                "          \"packVolume\": \"0.0\",\n" +
                "          \"packCode\": \"JDVB02278596342-1-1-\",\n" +
                "          \"operatorTime\": 1577352776000,\n" +
                "          \"shipNo\": \"JDVB02278596342\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"orgNo\": \"724\",\n" +
                "      \"distributeNo\": \"6\",\n" +
                "      \"warehouseNo\": \"63\",\n" +
                "      \"uuid\": \"OB66319122600000159-JDVB02278596342-1-1--91104624\",\n" +
                "      \"orderId\": \"108443875755\",\n" +
                "      \"goodNumber\": 1\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"statementId\": \"com.jd.orderpackage.pack\",\n" +
                "    \"msgObj\": {\n" +
                "      \"waybillCode\": \"JDVC02395045650\",\n" +
                "      \"mode\": 1,\n" +
                "      \"packList\": [\n" +
                "        {\n" +
                "          \"operatorName\": \"obCheck\",\n" +
                "          \"packWeight\": \"0.0\",\n" +
                "          \"packVolume\": \"0.0\",\n" +
                "          \"packCode\": \"JDVC02395045650-2-2-\",\n" +
                "          \"operatorTime\": 1577352697000,\n" +
                "          \"shipNo\": \"JDVC02395045650\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"orgNo\": \"645\",\n" +
                "      \"distributeNo\": \"630\",\n" +
                "      \"warehouseNo\": \"1\",\n" +
                "      \"uuid\": \"OB630119122600000630-JDVC02395045650-2-2--30423850\",\n" +
                "      \"orderId\": \"108387913996\",\n" +
                "      \"goodNumber\": 2\n" +
                "    }\n" +
                "  }\n" +
                "]";
        
        String express = "$[*]['msgObj']['waybillCode','orderId']";
    
        DocumentContext documentContext = JsonPath.parse(content);
        List<Map<String,String>> extractedInfo = documentContext.read(express);
        
        Map<String, String> map = extractedInfo.get(0);
        assertTrue(map.get("waybillCode").equals("JDVB02278596342"));
        assertTrue(map.get("orderId").equals("108443875755"));
    
    
    
        Map<String, String> m2 = extractedInfo.get(1);
        assertTrue(m2.get("waybillCode").equals("JDVC02395045650"));
        assertTrue(m2.get("orderId").equals("108387913996"));
        
    }
}
