package com.example.FoodApp;

import com.example.FoodApp.Model.Role;
import com.example.FoodApp.Model.UserRole;
import com.example.FoodApp.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class FoodAppApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(FoodAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Project Started");

		Role role1 = new Role();
		Role role2 = new Role();
		Role role3 = new Role();
		Role role4 = new Role();
		role1.setRoleId(1);
		role1.setRoleName("ADMIN");
		role2.setRoleId(2);
		role2.setRoleName("CUSTOMER");
		role3.setRoleId(3);
		role3.setRoleName("RESTAURANT");
		role4.setRoleId(4);
		role4.setRoleName("DELIVERY");

		roleRepository.save(role1);
		roleRepository.save(role2);
		roleRepository.save(role3);
		roleRepository.save(role4);
	}
}
