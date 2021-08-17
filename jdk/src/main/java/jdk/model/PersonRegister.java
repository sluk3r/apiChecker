package jdk.model;

import com.google.common.collect.Maps;

import java.util.Map;

public class PersonRegister {
    Map<String, Person> register = Maps.newHashMap();
    
    public void registerPersonWithName(String name, Person person) {
        register.put(name, person);
    }
    
    public Person fetchPersonWithName(String name) {
        return register.get(name);
    }
}
