package com.Construclick.construclik.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Construclick.construclik.exceptions.EmailNotFoundException;
import com.Construclick.construclik.model.ContratarServicio;

import com.Construclick.construclik.repository.ContractarServiciosRepository;


@Service
public class ContractarServicioService {
	// Mando a llamar UserRepository
			private ContractarServiciosRepository contractarServiciosRepository;
			
			// Inyección de dependencias en el constructor
			@Autowired
			public ContractarServicioService(ContractarServiciosRepository contractarServiciosRepository) {
				this.contractarServiciosRepository = contractarServiciosRepository;
			}
			
			// Método para obtener todos los usuarios
			public List<ContratarServicio> getAll() {
				return contractarServiciosRepository.findAll();
			}
			
			// Método para crear un nuevo usuario
			public ContratarServicio createContratarServicio(ContratarServicio newContratarServicio) {
				return contractarServiciosRepository.save(newContratarServicio);
			}
			public void deleteContratarServicio(Long id) {
				if(contractarServiciosRepository.existsById(id)) {
					contractarServiciosRepository.deleteById(id);
				}else {
					throw new EmailNotFoundException(id);
				
				}
				
			
			}
			// Método para recuperar usuarios por Id (validar si existe)
			public ContratarServicio getById(Long id) {
				return contractarServiciosRepository.findById(id)
						.orElseThrow(() -> new EmailNotFoundException(id));
			}
			
			// Método para recuperar usuario por Id (sin excepción, de tipo Optional)
			/*
			public Optional<User> getById(Long id) {
				return userRepository.findById(id);
			}
			*/
			
			// Método para recuperar usuarios por email (con excepciones y de tipo User)
			public ContratarServicio getByEmail(String email) {
				return contractarServiciosRepository.findByEmail(email);
			}

			
			
			
			
			public ContratarServicio updateUser(ContratarServicio contratarServicio, Long id) {
				return contractarServiciosRepository.findById(id)
						.map(contratarServicioMap -> {
							contratarServicioMap.setPassword(contratarServicio.getPassword());
							return contractarServiciosRepository.save(contratarServicioMap);
						})
						.orElseThrow(() -> new EmailNotFoundException(id));
			}
			
			
			
			
			
}
