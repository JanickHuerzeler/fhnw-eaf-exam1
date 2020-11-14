package ch.fhnw.eaf.exam1.exam1.CLI;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

import ch.fhnw.eaf.exam1.exam1.model.Address;
import ch.fhnw.eaf.exam1.exam1.model.Customer;
import ch.fhnw.eaf.exam1.exam1.model.Order;
import ch.fhnw.eaf.exam1.exam1.model.Person;
import ch.fhnw.eaf.exam1.exam1.model.Module;
import ch.fhnw.eaf.exam1.exam1.model.Student;

@SpringBootApplication
@EntityScan(basePackageClasses = Person.class)
public class CLI implements CommandLineRunner {

    @PersistenceUnit
    EntityManagerFactory emf;

    public static void main(String[] args) {
        new SpringApplicationBuilder(CLI.class).run(args);
    }

    @Override
    public void run(String... args) {
        // ex1();
        // ex2();
        // ex3();
        ex4();
    }

    void ex1() {
        EntityManager em = emf.createEntityManager();

        // OneToOne bidirectional
        em.getTransaction().begin();

        Person p = new Person("Dominik");
        Address a = new Address("Bahnhofstrasse6", 5210, "Windisch");
        p.setAddress(a);
        em.persist(p);

        em.refresh(a); // Solution to not fail 3rd print
        // em.refresh(p); // needs CascadeType.REFRESH on Person

        int pId = p.getId();
        // em.clear();
        // p = em.find(Person.class, pId);
        System.out.println(p);
        System.out.println(p.getAddress().getStreet());
        System.out.println(p.getAddress().getPerson().getName());

        em.getTransaction().commit();
    }

    void ex2() {
        EntityManager em = emf.createEntityManager();

        // OneToOne bidirectional
        em.getTransaction().begin();

        Person p = new Person("Dominik");
        Address a1 = new Address("Bahnhofstrasse 6", 5210, "Windisch");
        Address a2 = new Address("Steinackerstrasse 5", 5210, "Windisch");

        p.setAddress(a1);
        a2.setPerson(p);

        em.persist(p);
        em.persist(a2);

        em.getTransaction().commit();
    }

    void ex3() {
        EntityManager em = emf.createEntityManager();

        // OneToMany bidirectional
        em.getTransaction().begin();

        Customer c = new Customer();
        Order o1 = new Order();
        Order o2 = new Order();

        c.setOrders(List.of(o1, o2));
        o1.setCustomer(c);
        o2.setCustomer(c);

        em.persist(c);

        em.getTransaction().commit();
    }

    void ex4() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Module m1 = new Module("webfr", "Luthiger");
        Module m2 = new Module("conpr", "Kröni");
        Student s1 = new Student("Meier", "Max");
        Student s2 = new Student("Müller", "Moritz");
        em.persist(m1); // all entities persisted
        em.persist(m2);
        em.persist(s1);
        em.persist(s2);

        m1.setStudents(List.of(s1, s2));
        s1.setModules(List.of(m1, m2));
        m2.setStudents(List.of(s2));

        em.getTransaction().commit();
    }
}
