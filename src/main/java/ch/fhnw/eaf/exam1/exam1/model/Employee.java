package ch.fhnw.eaf.exam1.exam1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class Employee {
    public enum Type { FULL, PART_TIME };

    protected Employee() {
    }

    public Employee(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "EMP_TYPE", nullable = false)
    Type type;

    @Lob
    byte[] picture;

    String name;
}