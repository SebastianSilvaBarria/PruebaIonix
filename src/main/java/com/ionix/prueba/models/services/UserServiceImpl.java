package com.ionix.prueba.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ionix.prueba.models.entity.User;
import com.ionix.prueba.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public User save(User user) {		
		return repository.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByMail(String mail) {		
		return repository.findByMail(mail);
	}



	
}
