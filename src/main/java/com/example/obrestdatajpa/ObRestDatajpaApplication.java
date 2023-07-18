package com.example.obrestdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObRestDatajpaApplication.class, args);

		/*ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepositoryImpl repository = context.getBean(BookRepositoryImpl.class);*/

	}

}
