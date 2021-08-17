package jdk.model;

import java.time.LocalDate;

public class Person {
    String personalId;
    String name;
    LocalDate dateOfBirth;
    
    public Person () {}
    
    public Person(String name, String personalId) {
        this.name = name;
        this.personalId = personalId;
    }
    
    public String getPersonalId() {
        return personalId;
    }
    
    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
