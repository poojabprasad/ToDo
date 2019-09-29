package com.example.demo;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {

		ApplicationContext applicationContext =
				SpringApplication.run(DemoApplication.class, args);

		for (String names : applicationContext.getBeanDefinitionNames()) {
			System.out.println("=======bean name ios " + names);
		}
	}

	@Bean
	public CommandLineRunner setup(ToDoRepository toDoRepository) {
		return (args) -> {
			toDoRepository.save(new ToDo("Write the code", true));
			toDoRepository.save(new ToDo("test the code", false));
			toDoRepository.save(new ToDo("compile the code", true));
			toDoRepository.save(new ToDo("run the code", false));
			logger.info("Stored data in h2 database");
		};
	}
}

