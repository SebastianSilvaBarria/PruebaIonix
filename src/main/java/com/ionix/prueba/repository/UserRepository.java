package com.ionix.prueba.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ionix.prueba.models.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query(value = "SELECT id, name, user_name, phone, mail FROM usuarios u WHERE u.mail = ?1", nativeQuery = true)
	User findByMail(String mail);
}
