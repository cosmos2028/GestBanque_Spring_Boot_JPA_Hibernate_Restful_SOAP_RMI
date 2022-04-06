package org.glsid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type"
		)
@JsonSubTypes
	({
			@Type(name = "V",value = Versement.class),
			@Type(name = "R",value = Retrait.class)
	})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)
public class Operation implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long numOp;
	private double montantOp;
	private Date dateOp;
	
	@ManyToOne
	@JoinColumn(name="IdCompte")
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name="codeEmp")
	private Employe employe;
	public Operation() {
		super();
	}
	public Operation(double montantOp, Date dateOp) {
		super();
		this.montantOp = montantOp;
		this.dateOp = dateOp;
	}
	public Long getNumOp() {
		return numOp;
	}
	public void setNumOp(Long numOp) {
		this.numOp = numOp;
	}
	public double getMontantOp() {
		return montantOp;
	}
	public void setMontantOp(double montantOp) {
		this.montantOp = montantOp;
	}
	public Date getDateOp() {
		return dateOp;
	}
	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}
	@JsonIgnore
	public Compte getCompte() {
		return compte;
	}
	@JsonSetter
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	@JsonIgnore
	public Employe getEmploye() {
		return employe;
	}
	@JsonSetter
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
	

}
