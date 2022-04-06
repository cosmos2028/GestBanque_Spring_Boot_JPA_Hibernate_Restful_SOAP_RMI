package org.glsid.servicesoap;
/*
 * fonctionne en utilisant le JDK1.8
 * 
 * 

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.glsid.entities.Compte;
import org.glsid.metier.ICompteMetier;
import org.glsid.metier.IOperationMetier;
import org.glsid.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@WebService(serviceName = "BanqueWS")
@Service
public class CompteOperationSOAP
{
	@Autowired
	ICompteMetier compteMetier;
	@Autowired
	IOperationMetier operationMetier;

	@WebMethod
	public Compte getCompte(@WebParam(name="codeCompte") String codeCompte) 
	{
		return compteMetier.getCompte(codeCompte);
	}
	@WebMethod
	public boolean verser(
			@WebParam(name="codeCompte") String codeCompte,
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmp") Long codeEmp) 
	{
		return operationMetier.verser(codeCompte, montant, codeEmp);
	}
	@WebMethod
	public boolean retirer(
			@WebParam(name="codeCompte") String codeCompte, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.retirer(codeCompte, montant, codeEmp);
	}
	@WebMethod
	public boolean virement(
			@WebParam(name="CodeCpte1") String CodeCpte1, 
			@WebParam(name="CodeCpte2") String CodeCpte2, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.virement(CodeCpte1, CodeCpte2, montant, codeEmp);
	}
	@WebMethod
	public PageOperation getOperations(
			@WebParam(name="codeCompte") String codeCompte, 
			@WebParam(name="pageActuelle") int pageActuelle, 
			@WebParam(name="nombreOperations")int nombreOperations) 
	{
		return operationMetier.getOperations(codeCompte, pageActuelle, nombreOperations);
	}

}
 */
