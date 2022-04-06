package org.glsid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double decouvert;
	
	public CompteCourant(){super();}
	
	public CompteCourant(String idCompte, double solde, Date dateCreation,double decouvert) {
		super(idCompte, solde, dateCreation);
		this.decouvert = decouvert;
	}

	public Double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(Double decouvert) 
	{
		this.decouvert = decouvert;
	}

}
