package org.glsid.metier;

import java.util.List;

import org.glsid.entities.Compte;

public interface ICompteMetier 
{

	public Compte saveCompte(Compte c);
	public Compte getCompte(String codeCompte);
	public List<Compte> listCompte();
}
