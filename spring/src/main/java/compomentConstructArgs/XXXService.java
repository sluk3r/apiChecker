package compomentConstructArgs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wangxichun on 2017/8/6 0006.
 */
@Component
public class XXXService {
    String name;
    @Autowired
    public XXXService(@Value("${compomentConstructArgs.name}") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
