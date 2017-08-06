package aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by wangxichun on 2017/8/6 0006.
 */
@Component
public class JsfInterfaceImpl  implements JsfInterface {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public Map<String, List<Result<Long>>> doService(Map params) throws Exception {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw  new NullPointerException();
        }

        logger.info("JsfInterfaceImpl's doService method invoked");

        List<Result<Long>> resultList = new ArrayList<Result<Long>>();

        resultList.add(new Result<Long>(true, 102, "process ok", 43153L));

        Map<String, List<Result<Long>>> map = new HashMap<String, List<Result<Long>>>();
        map.put("43153L", resultList);

        return map;
    }
}
