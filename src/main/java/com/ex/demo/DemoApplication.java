package com.ex.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService service){
		return args -> {
//			List<Customer> customers = service.findCustomers();
//			customers.forEach(customer -> {
//				System.out.println(customer.getFisrtname());
//				System.out.println(customer.getLastname());
//				System.out.println(customer.getAddress());
//			});

			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			AtomicInteger n= new AtomicInteger(10);
			List.of("Alain","Albert","Mila","Ameena").forEach(s -> {
				n.getAndIncrement();
				for (int i = 0; i < 100000; i++) {

					Customer customer = Customer.builder()
							.address("Akwa" + i)
							.age(generateRandomNumber(1, 100))
							.id("C"+ n.get()+i)
							.fisrtname(s)
							.lastname(s+i)
							.city("Douala " + i)
							.build();
					service.save(customer);
					System.out.println("ligne : "+i);
				}
				System.out.println("Donnée de : "+s);
			});
		};
	}

	public static int generateRandomNumber(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than Min");
		}

		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	public static void binarySearch(int tab[], int min, int max, int val) {
		int milieu = (min + max) / 2;
		while (min <= max) {
			if (tab[milieu] < val) {
				min = milieu + 1;
			} else if (tab[milieu] == val) {
				System.out.println("L'élément se trouve à l'index: " + milieu);
				break;
			} else {
				max = milieu - 1;
			}
			milieu = (min + max) / 2;
		}
		if (min > max) {
			System.out.println("L'élément n'existe pas!");
		}
	}

}
