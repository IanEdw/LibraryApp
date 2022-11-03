package ru.ianedw.springcource.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int personId;

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100")
    private String fullName;

    @Min(value = 1, message = "Cannot be 0")
    private int yearOfBirth;

    public Person() {}
    public Person(int person_Id, String fullName, int yearOfBirth) {
        this.personId = person_Id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
