package ch.fhnw.eaf.exam1.exam1.model.CLI;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

import ch.fhnw.eaf.exam1.exam1.model.Address;
import ch.fhnw.eaf.exam1.exam1.model.Person;

@SpringBootApplication
@EntityScan(basePackageClasses = Person.class)
public class Exam1CLI implements CommandLineRunner {
    @PersistenceUnit
    EntityManagerFactory emf;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Exam1CLI.class).run(args);
    }

    @Override
    public void run(String... args) {
        EntityManager em = emf.createEntityManager();

        // Aufgabe 2.b)
        em.getTransaction().begin();
        Person p1 = new Person("P1");
        Person p2 = new Person("P2");
        Address a1 = new Address("A01");
        Address a2 = new Address("A02");
        Address a3 = new Address("A03");

        p1.setAddress(a2);
        p2.setAddress(a1);
        a1.setPerson(p1);
        a2.setPerson(p2);

        Address a = em.merge(a1); // stores p2.setAddress(a1)
        em.persist(a3);// persist a3 (event with no p at the moment)

        // a.person.name += "X";
        a.getPerson().setName(a.getPerson().getName() + "X");
        // p1.name += "Y"
        System.out.println("p1 == a.getPerson(): " + (p1 == a.getPerson()));
        
        p1.setName(p1.getName() + "Y");

        // a.person.address = a3
        a.getPerson().setAddress(a3);

        em.getTransaction().commit();
    }
}
