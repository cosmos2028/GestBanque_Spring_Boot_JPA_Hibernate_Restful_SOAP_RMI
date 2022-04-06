package org.glsid.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.glsid.dao.ICompteRepository;
import org.glsid.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements ICompteMetier 
{
	private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(CompteMetierImpl.class.getName());

	@Autowired
	private ICompteRepository compteMetier;
	@Override
	public Compte saveCompte(Compte c) 
	{
		c.setDateCreation(new Date());
		return compteMetier.save(c);
	}

	@Override
	public List<Compte> listCompte() 
	{
		return compteMetier.findAll();
	}

	@Override
	public Compte getCompte(String codeCompte) 
	{
		/*
		 * la nouvelle version de finOne utilise OPTIONAL 
		 * et c'est pourquoi on utilise : 
		 * .orElseThrow(() -> new RuntimeException("Compte Introuvable")
		 * pour gerer gerer si l'objet n'existe pas au lieu de retourn null
		 * et generer une exception NullPointrException
		*/
		Optional<Compte>optionalCompte = compteMetier.findById(codeCompte);
		Compte compte=null;

		if(optionalCompte.isPresent())
		{

			compte = optionalCompte.get();
			log.info("\n\n\n");
			log.info("Compte found with findById(: "+codeCompte+" )");
			log.info("--------------------------------");
			log.info(codeCompte.toString());
			log.info("\n");
			return  compte;
		}else
		{
			log.info("\n\n\n");
			log.error("objet n'existe pas avec idCompte : "+codeCompte);
			 throw new NullPointerException("\n\nmessage runtimeException :l'objet n'existe pas avec idCompte : "+codeCompte+"\n\n");
		}
		
		
	}

}
