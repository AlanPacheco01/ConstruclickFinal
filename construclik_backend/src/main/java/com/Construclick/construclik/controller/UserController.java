package com.Construclick.construclik.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Construclick.construclik.exceptions.EmailNotFoundException;

import com.Construclick.construclik.model.User;
import com.Construclick.construclik.service.UserService;

//tega que iniia rel springboot
//definimos el endpoint que apunta a este controlador  mediante la anotacion y el endpoint que nosotros definamos 

@RestController
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/registro/r1")   //localhost:8080/api/v1
public class UserController {
	// instanciar una variable de tipo UserService
   private  UserService UserService;
   //realizar inyeccion de dependncias en el constructor con la anotacion @Autowired
@Autowired
	public UserController(UserService UserService) {
		this.UserService = UserService;
	}
//mapear metodos
	@GetMapping("/construclick")
	public List<User> getMappingAll(){
		return UserService.getAll();	
	}
	
	@PostMapping
	public User newUser(@RequestBody User user) {
		return UserService.createUser(user);
	}
	@GetMapping("/construclick2/email")
	public ResponseEntity<User> getByEmail(@RequestParam(name = "construemail") String email) {
		User userByEmail = UserService.getByEmail(email);
		if (userByEmail == null) {
			throw new EmailNotFoundException(email);
		}
		return new ResponseEntity<User>(userByEmail, HttpStatus.OK);
	}
}
