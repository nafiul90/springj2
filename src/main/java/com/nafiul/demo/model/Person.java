package com.nafiul.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue
    private int PersonId;

    @Embedded
    private Name name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phoneNumber;

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Phone> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<Phone> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
