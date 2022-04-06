package org.glsid.metier;


public interface IOperationMetier 
{
	public boolean verser(String codeCompte,double montant,Long codeEmp);
	public boolean retirer(String codeCompte,double montant,Long codeEmp);
	public boolean virement(String CodeCpte1,String CodeCpte2,double montant,Long codeEmp);
	public PageOperation getOperations(String codeCompte,int pageActuelle,int nombreOperations);
	

}
