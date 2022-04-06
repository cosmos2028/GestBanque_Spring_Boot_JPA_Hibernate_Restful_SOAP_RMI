package org.glsid.dao;

import org.glsid.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOperationRepository extends JpaRepository<Operation, Long> 
{

	@Query("select o from Operation o where o.compte.IdCompte=:x")
	Page<Operation> findByCompteCodeCompte(@Param("x") String codeCompte,Pageable pageable);
	
	/*
	 * la methode d'en haut ou celle d'en bas mais on va utiliser celle du haut
	 
	public Page<Operation> findByCompte(Compte compte,Pageable pageable);

	*/
}
