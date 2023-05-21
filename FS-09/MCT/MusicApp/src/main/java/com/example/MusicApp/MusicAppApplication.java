package com.example.MusicApp;

import com.example.MusicApp.Model.User;
import com.example.MusicApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MusicAppApplication.class, args);
	}

	@Autowired
	private UserRepository user_repo;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setFirstName("Dilsha");
		user.setLastName("Udayan");
		user.setRole("Admin");
		user.setUserName("Dilu");
		user.setPassword("Dilsha@123");
		user_repo.save(user);

		User user_1 = new User();
		user_1.setFirstName("Dilesh");
		user_1.setLastName("Udayan");
		user_1.setRole("User");
		user_1.setUserName("Dilus");
		user_1.setPassword("Dilesh@123");
		user_repo.save(user_1);
	}
}
