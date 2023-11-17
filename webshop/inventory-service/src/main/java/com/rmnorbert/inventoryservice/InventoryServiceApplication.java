package com.rmnorbert.inventoryservice;

import com.rmnorbert.inventoryservice.model.Inventory;
import com.rmnorbert.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = Inventory.builder()
					.skuCode("Super_Light_Sugar")
					.quantity(100)
					.build();
			Inventory inventory1 = Inventory.builder()
					.skuCode("Super_Fat_Sugar")
					.quantity(0)
					.build();
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
