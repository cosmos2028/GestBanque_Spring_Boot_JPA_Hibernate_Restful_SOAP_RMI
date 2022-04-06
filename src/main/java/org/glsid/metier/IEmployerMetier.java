package org.glsid.metier;

import java.util.List;

import org.glsid.entities.Employe;

public interface IEmployerMetier 
{
	public Employe saveEmploye(Employe e);
	public List<Employe> listEmploye();

}
