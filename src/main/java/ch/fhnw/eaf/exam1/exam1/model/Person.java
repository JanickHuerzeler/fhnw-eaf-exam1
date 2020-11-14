package ch.fhnw.eaf.exam1.exam1.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, optional = false)
    private Address address;

    protected Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("%-10s [%d], %s", name, id, address);
    }
}
