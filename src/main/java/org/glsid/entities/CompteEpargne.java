package org.glsid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double taux;
	
	public CompteEpargne()
	{
		super();
	}
	
	public CompteEpargne(String idCompte, double solde, Date dateCreation,double taux) 
	{
		super(idCompte, solde, dateCreation);
		this.taux=taux;
	}

	public Double getTaux() {
		return taux;
	}
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	

}
