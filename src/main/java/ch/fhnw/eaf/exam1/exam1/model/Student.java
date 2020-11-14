package ch.fhnw.eaf.exam1.exam1.model;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue
    private int id;

    private String name, prename;

    // Student = owner
    @JoinTable(name = "ENROLLMENTS", joinColumns = @JoinColumn(name = "student"), inverseJoinColumns = @JoinColumn(name = "module"))
    @ManyToMany
    private List<Module> modules = new LinkedList<>();

    protected Student() {
    }

    public Student(String name, String prename) {
        this.name = name;
        this.prename = prename;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
