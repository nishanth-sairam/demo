package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(CustomerRepo customerRepo) {
		return args -> {
			customerRepo.save(new Customer(null, "joy", new Profile(null, "user", "user")));
			customerRepo.findAll().forEach(System.out::println);
		};
	}

}

@Table("customer_profile")
record Profile(@Id Integer id, String username, String password) {
}
@Table("customer")
record Customer(@Id Integer id, String name, Profile profile) {
}

interface CustomerRepo extends ListCrudRepository<Customer, Integer> {
}
