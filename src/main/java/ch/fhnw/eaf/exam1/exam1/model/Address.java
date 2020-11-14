package ch.fhnw.eaf.exam1.exam1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private int id;

    private String street, city;
    private int zip;
    @OneToOne(mappedBy = "address")
    private Person person;

    protected Address() {
    }

    public Address(String street, int zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getStreet(){
        return street;
    }

    @Override
    public String toString(){
        return String.format("%s, %d %s", street, zip, city);
    }
}
