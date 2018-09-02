package com.nafiul.demo.model;

import lombok.ToString;

import javax.persistence.Entity;
import java.util.List;


@ToString
@Entity
public class Student extends Person {

    private float cgpa;
    private String department;

    public Student() {
        super();
    }

    public Student(int PersonId, Name name, List<Address> address, List<Phone> phoneNumber, float cgpa, String department) {
        super(PersonId, name, address, phoneNumber);
        this.cgpa = cgpa;
        this.department = department;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
