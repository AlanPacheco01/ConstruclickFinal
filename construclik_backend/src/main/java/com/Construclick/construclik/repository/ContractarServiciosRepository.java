package com.Construclick.construclik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.Construclick.construclik.model.ContratarServicio;



public interface ContractarServiciosRepository  extends JpaRepository<ContratarServicio,Long> {
	@Query("SELECT u FROM ContratarServicio u WHERE u.email = ?1 ")
	ContratarServicio findByEmail(String email);
}
