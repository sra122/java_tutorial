package com.sravan.jpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sravan.jpa.Entity.LoginRequest;
import com.sravan.jpa.Entity.User;
import com.sravan.jpa.Repository.UsersRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User userEntity = usersRepository.findByEmail(user.getEmail());
		
		if (userEntity == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			try {
				return new ResponseEntity<>(usersRepository.save(user), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
		
	}
	
	@GetMapping("/fetch/{id}")
	public User getUser(@PathVariable String id) {
		return usersRepository.findById(Integer.parseInt(id)).get();
		//return id;
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
		User userEntity = usersRepository.findByEmail(loginRequest.getEmail());
		
		if (userEntity != null) {
			if (passwordEncoder.matches(loginRequest.getPassword(), userEntity.getPassword())) {
				return new ResponseEntity<>(userEntity, HttpStatus.OK);
			}
			
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
