package com.ionix.prueba.controllers;


import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ionix.prueba.models.entity.JsonApiExterna;
import com.ionix.prueba.models.entity.User;
import com.ionix.prueba.models.services.UserService;
import com.ionix.prueba.utils.Utils;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody User user){
		return ResponseEntity.ok(service.save(user));
	}
	
	@GetMapping("/search/{mail}")
	public ResponseEntity<?> findByMail(@PathVariable String mail){
		return ResponseEntity.ok(service.findByMail(mail));
	}
	
	@PostMapping("/consultaExterna/{param}")
	public ResponseEntity<?> consultaExterna(@PathVariable String param) throws NoSuchAlgorithmException, NoSuchPaddingException{
		
		String rutEncriptado = Utils.encoder(param);
		JsonApiExterna apiExterna = new JsonApiExterna();
		RestTemplate restTemplate = new RestTemplate();
		long start = System.currentTimeMillis();
		@SuppressWarnings("unchecked")
		HashMap<String, Object> object = (HashMap<String, Object>) restTemplate.getForObject("https://sandbox.ionix.cl/test-tecnico/search?rut="+param , Object.class);
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;

		for ( Entry<String, Object> item : object.entrySet()) {
			
			if(item.getKey().equals("responseCode")) {
				apiExterna.setResponseCode((int) item.getValue());
			}else if(item.getKey().equals("description")) {
				apiExterna.setDescription((String) item.getValue());
			}else if(item.getKey().equals("result")) {
				@SuppressWarnings("unchecked")
				Map<Object, Object> map = (Map<Object, Object>) item.getValue();
				apiExterna.setResult(map);
			}
				
		}
		
		apiExterna.setElapsedTime((int) elapsedTime);
		return ResponseEntity.ok(apiExterna);
	}
}