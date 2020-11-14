package ch.fhnw.eaf.exam1.exam1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import java.util.Collection;

import javax.persistence.CascadeType;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue
    private int id;

    // This is the inverse side of the relationship
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Collection<Order> orders;

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}
