package com.Construclick.construclik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Construclick.construclik.model.User;
import com.Construclick.construclik.repository.UserRepository;

@Service
public class UserService {
	// Mando a llamar UserRepository
		private UserRepository userRepository;
		
		// Inyección de dependencias en el constructor
		@Autowired
		public UserService(UserRepository userRepository) {
			this.userRepository = userRepository;
		}
		
		// Método para obtener todos los usuarios
		public List<User> getAll() {
			return userRepository.findAll();
		}
		
		// Método para crear un nuevo usuario
		public User createUser(User newUser) {
			return userRepository.save(newUser);
		}
		// Método para recuperar usuarios por email (con excepciones y de tipo User)
		public User getByEmail(String email) {
			return userRepository.findByEmail(email);
		}

}
