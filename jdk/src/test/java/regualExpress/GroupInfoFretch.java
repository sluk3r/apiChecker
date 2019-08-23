package regualExpress;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupInfoFretch {



    @Test
    public void extractInfo() {
        String content = "<p><a href=\"http://ump.jd.com/performanceReport/initPage.action?queryMap.appName=coi&amp;queryMap.appId=3218&amp;queryMap.accessKey=BullsCOI.OrderChannelWebServiceImpl.sendNewPaymentOrderInfo&amp;queryMap.analysisFrequency=1&amp;queryMap.departCode=6773&amp;queryMap.groupId=\" class=\"external-link\" rel=\"nofollow\">先款接单</a></p>";


        String regu = "queryMap.appName=(.*)&amp;.*queryMap.appId=(.*?)&amp;.*accessKey=(.*?)&amp;";


        Pattern pattern = Pattern.compile(regu);

        Matcher matcher =  pattern.matcher(content);

        if (matcher.find())
        {
            // we're only looking for one group, so get it
            String appName = matcher.group(1);
            String appId = matcher.group(2);
            String key = matcher.group(3);

            System.out.println("appName: " + appName + ",appId: " + appId + ", key: " + key);
        }


    }
}

