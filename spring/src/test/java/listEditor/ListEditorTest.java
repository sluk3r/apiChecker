package listEditor;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prototype.Person;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:personList/spring-config.xml" })
public class ListEditorTest {
    @Resource
    PersonList personList;

    @Test
    public void protoTypeCheck () {
        assertNotNull(personList);
        assertNotNull(personList.getPersonList());
        assertFalse(personList.getPersonList().isEmpty());
    }

}
