package org.glsid.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/*
 * @Inheritance et @DiscriminatorColumn permettre le mapping 
 * ou la serialization d'une class avec héritage en de bdd
 * 
 * 
 * @JsonTypeInfo et @JsonSubTypes permettre le mapping ou la serialization
 * d'une class avec héritage en JSON
 * 
 * ERROR :
 * ids for this class must be manually assigned before calling save()
 * 
 * Comme IdCompte n'est pas autoIncrement il faut rajouter ceci comme annotation
 * sur ID :
 *  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    
  *
  *@JsonProperty("IdCompte") renomer ou spécifier à json s'il a
  *du mal trouver l'attribut pour effectuer le mapping sinon on aura une erreur:
  *ids for this class must be manually assigned before calling save()
  *
 */


@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type"
		)
@JsonSubTypes
	({
			@Type(name = "CC",value = CompteCourant.class),
			@Type(name = "CE",value = CompteEpargne.class)
	})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE", 
discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Compte implements Serializable 
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String IdCompte ;
	
	private double solde;
	
	private Date dateCreation;
	
	@ManyToOne
	@JoinColumn(name="codeCli")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="codeEmp")
	private Employe employe;
	
	@OneToMany(mappedBy = "compte")
	List<Operation> operations;
	
	public Compte() {}
	
	public Compte(String idCompte) 
	{
		super();
		IdCompte = idCompte;
	}
	
	public Compte(String idCompte, double solde, Date dateCreation) 
	{
		super();
		IdCompte = idCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
	}
	 @JsonProperty("IdCompte")
	public String getIdCompte() {
		return IdCompte;
	}
	public void setIdCompte(String idCompte) {
		IdCompte = idCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
	

}
