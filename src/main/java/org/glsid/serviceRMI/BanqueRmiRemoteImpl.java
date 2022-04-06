package org.glsid.serviceRMI;

import java.rmi.RemoteException;

import org.glsid.entities.Compte;
import org.glsid.metier.ICompteMetier;
import org.glsid.metier.IOperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myRmiService")
public class BanqueRmiRemoteImpl implements BanqueRmiRemote
{
	@Autowired
	ICompteMetier  compteMetier;
	@Autowired
	IOperationMetier operationMetier;

	@Override
	public Compte saveCompte(Compte compte) throws RemoteException {
		return compteMetier.saveCompte(compte);
	}

	@Override
	public Compte getCompte(String codeCompte) throws RemoteException {
		return compteMetier.getCompte(codeCompte);
	}

	@Override
	public boolean verser(String codeCompte, double montant, Long codeEmp) throws RemoteException {
		
		return operationMetier.verser(codeCompte, montant, codeEmp);
	}

	@Override
	public boolean retirer(String codeCompte, double montant, Long codeEmp) throws RemoteException {
		return operationMetier.retirer(codeCompte, montant, codeEmp);
	}

	@Override
	public boolean virement(String CodeCpte1, String CodeCpte2, double montant, Long codeEmp) throws RemoteException {
		return operationMetier.virement(CodeCpte1, CodeCpte2, montant, codeEmp);
	}
	

}
