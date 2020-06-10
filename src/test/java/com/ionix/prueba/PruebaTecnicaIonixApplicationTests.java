package com.ionix.prueba;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ionix.prueba.models.entity.User;
import com.ionix.prueba.repository.UserRepository;

@SpringBootTest
class PruebaTecnicaIonixApplicationTests {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	void contextLoads() {
		
		User user = userRepository.findByMail("msilva@gmail.com");
		System.out.println(user.getName() +" - "+  user.getUserName() +" - "+ user.getMail() +" - "+ user.getPhone());
	}

	@Test
	void testListar() {
		Iterable<User> listar = userRepository.findAll();
		for (User user : listar) {
			System.out.println(user.getName() +" - "+  user.getUserName() +" - "+ user.getMail() +" - "+ user.getPhone());
		}
	}
	

}
