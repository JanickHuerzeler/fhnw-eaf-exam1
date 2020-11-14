package ch.fhnw.eaf.exam1.exam1.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MODULE")
public class Module {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String teacher;

    protected Module() {
    }

    public Module(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    // Inverse side
    @ManyToMany(mappedBy = "modules")
    private List<Student> students = new LinkedList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
