package org.glsid.dao;

import org.glsid.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long>
{

}
