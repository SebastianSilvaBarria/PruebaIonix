package com.ionix.prueba.models.services;

import com.ionix.prueba.models.entity.User;

public interface UserService {

	public Iterable<User> findAll();
	
	public User save(User user);

	public User findByMail(String mail);
}
