package org.glsid.serviceRest;

import org.glsid.metier.IOperationMetier;
import org.glsid.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpeationRestService 
{

	@Autowired
	private IOperationMetier operationMetier;



	@PutMapping("/versement")
	public boolean verser(
			
			@RequestParam String codeCompte, 
			@RequestParam  double montant, 
			@RequestParam  Long codeEmp) {
		return operationMetier.verser(codeCompte, montant, codeEmp);
	}

	@PutMapping("/retrait")
	public boolean retirer(
			@RequestParam String codeCompte, 
			@RequestParam  double montant, 
			@RequestParam  Long codeEmp) 
	{
		return operationMetier.retirer(codeCompte, montant, codeEmp);
	}

	@PutMapping("/virement")
	public boolean virement(
			@RequestParam String CodeCpte1, 
			@RequestParam String CodeCpte2, 
			@RequestParam double montant, 
			@RequestParam Long codeEmp) {
		return operationMetier.virement(CodeCpte1, CodeCpte2, montant, codeEmp);
	}
	
	@GetMapping("/operation")
	public PageOperation getOperations(
			@RequestParam String codeCompte,
			@RequestParam  int pageActuelle, 
			@RequestParam  int nombreOperations) {
		return operationMetier.getOperations(codeCompte, pageActuelle, nombreOperations);
	}
	
}
