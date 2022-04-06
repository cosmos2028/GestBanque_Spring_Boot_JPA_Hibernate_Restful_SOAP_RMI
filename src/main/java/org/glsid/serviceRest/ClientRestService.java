package org.glsid.serviceRest;

import java.util.List;

import org.glsid.entities.Client;
import org.glsid.metier.IClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RequestBody permet d'indiquer à Spring de recuperer le contenu dans le corps
 * de la requete et aussi que c'est au format json pour désérialization
 * 
 * @ResponseBody permet de retourner la reponse au client la reponse au format
 * JSON en effectuant une serialization mais pas oblige de le preciser car il est implicite
 * 
 * 
 * @Autowired permet d'injecter l'implementation de l'interface désignée
 */
@RestController
public class ClientRestService 
{
	

	@Autowired
	private IClientMetier clientMetier;
	@RequestMapping(value="/clients",method = RequestMethod.POST)
	public Client saveClient(@RequestBody Client c)
	{
		return clientMetier.saveClient(c);
	}
	@RequestMapping(value="/clients",method = RequestMethod.GET)
	public List<Client> listClient()
	{
		return clientMetier.listClient();
	}
	
}
