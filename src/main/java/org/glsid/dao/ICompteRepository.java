package org.glsid.dao;

import org.glsid.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteRepository extends JpaRepository<Compte, String>
{

}
