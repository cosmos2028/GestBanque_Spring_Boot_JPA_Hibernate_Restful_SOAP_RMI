package org.glsid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="client")
public class Client implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCli;
	@Column(name="nomCli")
	private String nomCli;
	@Column(name="prenomCli")
	private String prenomCli;
	@Column(name="adresseCli")
	private String adresseCli;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Compte> comptes ;
	
	public Client() {}

	public Client(Long codeCli, String nomCli) {
		super();
		this.codeCli = codeCli;
		this.nomCli = nomCli;
	}

	public Long getCodeCli() {
		return codeCli;
	}

	public void setCodeCli(Long codeCli) {
		this.codeCli = codeCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getPrenomCli() {
		return prenomCli;
	}

	public void setPrenomCli(String prenomCli) {
		this.prenomCli = prenomCli;
	}

	public String getAdresseCli() {
		return adresseCli;
	}

	public void setAdresseCli(String adresseCli) {
		this.adresseCli = adresseCli;
	}

	@JsonIgnore
	public List<Compte> getComptes() {
		return comptes;
	}

	@JsonSetter
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	

}
