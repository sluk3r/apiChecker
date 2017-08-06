package aop;

import aop.service.JsfInterface;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.sun.istack.internal.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxichun on 2017/8/6 0006.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class AopDemo {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Configuration
    @ComponentScan(basePackages = {"aop"})
    static class ContextConfiguration {}

    @Autowired @NotNull
    JsfInterface jsfInterface;

    @Test
    public void aopDemoRun(){
        Map params = ImmutableMap.of("key1", "values");
        try {
            Map<String,List<JsfInterface.Result<Long>>>   result  = jsfInterface.doService(params);


            logger.info(JSON.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


