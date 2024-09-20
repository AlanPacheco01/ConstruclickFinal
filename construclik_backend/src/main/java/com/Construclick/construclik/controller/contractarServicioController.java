package com.Construclick.construclik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Construclick.construclik.model.ContratarServicio;
import com.Construclick.construclik.service.ContractarServicioService;
import com.Construclick.construclik.exceptions.EmailNotFoundException;




@RestController
@RequestMapping("/contractarServicio/r2") 
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST})
public class contractarServicioController {
private ContractarServicioService contractarServicioService;
@Autowired
public contractarServicioController(ContractarServicioService contractarServicioService) {
	this.contractarServicioService = contractarServicioService;
}
//mapear metodos
@GetMapping("/construclick")
public List<ContratarServicio> getMappingAll(){
	return contractarServicioService.getAll();	
}

@PostMapping
public ContratarServicio newContratarServicio(@RequestBody ContratarServicio contractarServico) {
	return contractarServicioService.createContratarServicio(contractarServico);
}

@DeleteMapping("/construclick/{id}")
public void deleteContratarServicio(@PathVariable(name="id") Long id) {
	contractarServicioService.deleteContratarServicio(id);
}
// Mapear método get by Id que apunte a un Id específico


//Mapear método get By Email aplicando la Query (JPQL) y la excepción
	// --- ResponseEntity<Entity> clase de Spring que me permite representar respuestas HTTP personalizables 
	// --- @RequestParam(parametro) permite recibir parámetros y valores
	// Creamos clase EmailNotFoundException y su clase controller EmailNotFoundController
	@GetMapping("/construclick2/email")
	public ResponseEntity<ContratarServicio> getByEmail(@RequestParam(name = "construemail") String email) {
		ContratarServicio contratarServicioByEmail = contractarServicioService.getByEmail(email);
		if (contratarServicioByEmail == null) {
			throw new EmailNotFoundException(email);
		}
		return new ResponseEntity<ContratarServicio>(contratarServicioByEmail, HttpStatus.OK);
	}


//Mapear método update User utilizando Put. Necesitamos acceder al user mediante Id (findById) y definir el nuevo valor
	@PutMapping("/construclick/{id}")
	public ContratarServicio updateUser(@RequestBody ContratarServicio contratarServicio, @PathVariable(name = "id") Long id) {
		return contractarServicioService.updateUser(contratarServicio, id);
	}




}
