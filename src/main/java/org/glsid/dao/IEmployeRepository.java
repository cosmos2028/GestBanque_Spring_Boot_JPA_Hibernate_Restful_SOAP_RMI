package org.glsid.dao;

import org.glsid.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeRepository extends JpaRepository<Employe, Long> 
{

}
