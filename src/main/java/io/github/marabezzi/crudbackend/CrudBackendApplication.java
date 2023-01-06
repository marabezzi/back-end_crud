package io.github.marabezzi.crudbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.marabezzi.crudbackend.model.Course;
import io.github.marabezzi.crudbackend.repository.CourseRepository;

@SpringBootApplication
public class CrudBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudBackendApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
			
			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("Front-end");
			
			courseRepository.save(c);
		};
	}

}
