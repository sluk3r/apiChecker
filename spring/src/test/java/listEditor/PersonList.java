package listEditor;

import org.springframework.stereotype.Component;
import prototype.Person;

import javax.annotation.Resource;
import java.util.List;


@Component
public class PersonList {
    @Resource
    List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
