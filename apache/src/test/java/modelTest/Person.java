package modelTest;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
    String name;
    List<Person> brothers;
    
    public Person () {}
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Person> getBrothers() {
        return brothers;
    }
    
    public void setBrothers(List<Person> brothers) {
        this.brothers = brothers;
    }
}