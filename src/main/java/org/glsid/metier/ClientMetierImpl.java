package org.glsid.metier;

import java.util.List;

import org.glsid.dao.IClientRepository;
import org.glsid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @Service ou @Component permet de signaler au conteneur Spring qu'on va
 * utiliser les composants de Spring et toujours utilise dans la couche metier
 * 
 * permet de considerer la class comme un Bean Spring
 * 
 *  
 *  @autowire  est une annotation Spring qui permet d'injecter
 * une instance d'objet ou implementation de l'interface dans la varaible indique
 */
@Service
public class ClientMetierImpl implements IClientMetier 
{

	/*
	 * @Autowired
	 * permet d'inject une implementation de cette interface
	 */
	@Autowired
	IClientRepository clientRepository;
	
	@Override
	public Client saveClient(Client c) 
	{
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClient() 
	{
		return clientRepository.findAll();
	}

}
