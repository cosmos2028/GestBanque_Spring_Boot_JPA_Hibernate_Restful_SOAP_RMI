package org.glsid.serviceRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.glsid.entities.Compte;

public interface BanqueRmiRemote extends Remote 
{
	public Compte saveCompte(Compte compte) throws RemoteException;
	public Compte getCompte(String codeCompte)throws RemoteException;
	public boolean verser(String codeCompte,double montant,Long codeEmp)throws RemoteException;
	public boolean retirer(String codeCompte,double montant,Long codeEmp)throws RemoteException;
	public boolean virement(String CodeCpte1,String CodeCpte2,double montant,Long codeEmp)throws RemoteException;
	

}
