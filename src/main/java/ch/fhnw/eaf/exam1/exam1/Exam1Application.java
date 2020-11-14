package ch.fhnw.eaf.exam1.exam1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ch.fhnw.eaf.xyz")

public class Exam1Application {

	public static void main(String[] args) {
		SpringApplication.run(Exam1Application.class, args);
	}

}
