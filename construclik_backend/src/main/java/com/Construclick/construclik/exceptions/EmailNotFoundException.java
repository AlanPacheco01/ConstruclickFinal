package com.Construclick.construclik.exceptions;

public class EmailNotFoundException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	// Método constructor con un mensaje en super
	public EmailNotFoundException(Long id) {
		super("El usuario con el id " + id + " no existe.");
	}
	public EmailNotFoundException(String email) {
		super("El usuario con el email " + email + " no existe.");
	}
}
