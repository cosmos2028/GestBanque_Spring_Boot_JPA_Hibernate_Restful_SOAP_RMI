package org.glsid.metier;

import java.util.Date;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.glsid.dao.ICompteRepository;
import org.glsid.dao.IEmployeRepository;
import org.glsid.dao.IOperationRepository;
import org.glsid.entities.Compte;
import org.glsid.entities.Employe;
import org.glsid.entities.Operation;
import org.glsid.entities.Retrait;
import org.glsid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements IOperationMetier 
{
	private final org.apache.logging.log4j.Logger log = LogManager.getLogger(OperationMetierImpl.class.getName());


	@Autowired
	private IOperationRepository operationRepository;
	@Autowired
	private ICompteRepository compteRepository;
	@Autowired
	private IEmployeRepository employeRepository;
	
	@Transactional
	@Override
	public boolean verser(String codeCompte, double montant, Long codeEmp) 
	{

		Optional<Compte> optionalCompte = compteRepository.findById(codeCompte);
		Optional<Employe> optionEmp = employeRepository.findById(codeEmp);
		
		if(optionalCompte.isPresent()&&	 optionEmp.isPresent())
		{
			Compte compte = optionalCompte.get();
			Employe employe = optionEmp.get();
			Operation operation = new Versement();
			compte.setSolde(compte.getSolde()+ montant);
			
			operation.setCompte(compte);
			operation.setDateOp(new Date());
			operation.setEmploye(employe);
			operation.setMontantOp(montant);
			
			operationRepository.save(operation);
			
			log.info("\n\n\n");
			log.info("Operation du versement est un success");
			log.info("--------------------------------");
			return true;
		}else
		{
			log.info("\n\n\n");
			log.error("objet compte ou employe  n'existe pas avec codeCompte ou CodeEmp : "+codeCompte+ " ou "+codeEmp);
			 throw new NullPointerException("\n\"objet compte ou employe  n'existe pas avec codeCompte ou CodeEmp : \"+codeCompte+ \" ou \"+codeEmp");
		}
		
	}

	@Transactional
	@Override
	public boolean retirer(String codeCompte, double montant, Long codeEmp) 
	{

		Optional<Compte> optionalCompte = compteRepository.findById(codeCompte);
		Optional<Employe> optionEmp = employeRepository.findById(codeEmp);
		
		if(optionalCompte.isPresent()&&optionEmp.isPresent())
		{
			Compte compte = optionalCompte.get();
			Employe employe = optionEmp.get();
			Operation operation = new Retrait();
			
			if(compte.getSolde()<montant) throw new RuntimeException("Solde insuffissant ");
			
			compte.setSolde(compte.getSolde()-montant);
			
			operation.setCompte(compte);
			operation.setDateOp(new Date());
			operation.setEmploye(employe);
			operation.setMontantOp(montant);
			
			operationRepository.save(operation);
			
			log.info("\n\n\n");
			log.info("Operation du Retrait est un success");
			log.info("--------------------------------");
			return true;
		}else
		{
			log.info("\n\n\n");
			log.error("objet compte ou employe  n'existe pas avec codeCompte ou CodeEmp : "+codeCompte+ " ou "+codeEmp);
			 throw new NullPointerException("\n\"objet compte ou employe  n'existe pas avec codeCompte ou CodeEmp : \"+codeCompte+ \" ou \"+codeEmp");
		}

	}

	@Transactional
	@Override
	public boolean virement( String CodeCpte1, String CodeCpte2,double montant, Long codeEmp)
	{
		
		 retirer(CodeCpte1,montant,codeEmp);
		 verser(CodeCpte2,montant,codeEmp);
		 log.info("\n\n\n");
		 log.info("Virement effectué avec success");
		return true;
	}

	@Override
	public PageOperation getOperations(String codeCompte, int pageActuelle, int nombreOperations) 
	{
        Pageable page = PageRequest.of(pageActuelle, nombreOperations, Sort.by("montantOp"));

	  Page<Operation>	_dataPageOperations1 = operationRepository.findByCompteCodeCompte(codeCompte,page);
	  
	  PageOperation _VpageOperation = new PageOperation();
	  
	  _VpageOperation.setListOperations(_dataPageOperations1.getContent());
	  _VpageOperation.setNombreOperations(_dataPageOperations1.getNumberOfElements());
	  _VpageOperation.setTotalOperations(_dataPageOperations1.getTotalElements());
	  _VpageOperation.setPage(_dataPageOperations1.getNumber());
	  _VpageOperation.setTotalPages(_dataPageOperations1.getTotalPages());
		return _VpageOperation;
		
		
		/*
		 * utilisation de l'autre methode
		 * 
		 * qui n'est pas une bonne methode car on a fait une requete a la bdd pour
		 * obtenir l'objet Compte
		 * et le resultat est redonné à une autre requete findByCompte qui va encore faire une 
		 * dans la BDD (ce n'est pas une bonne pratique surtout en terme de performance)		
		 
		
		Optional<Compte> optionalComptePage = compteRepository.findById(codeCompte);

		if(optionalComptePage.isPresent())
		{
			Compte compte = optionalComptePage.get();
		
			  Page<Operation>	pageOperations2 = operationRepository.findByCompte(compte,page);

			log.info("\n\n\n");
			log.info("Compte trouve avec  success");
			log.info("--------------------------------");
		}else
		{
			log.info("\n\n\n");
			log.error("objet compte   n'existe pas avec codeCompte : "+codeCompte+ " ou ");
			 throw new NullPointerException("\n\"objet compte n'existe pas avec codeCompte : \"+codeCompte+ \"");
		}
		*/

		
	}

	
	
	

}
