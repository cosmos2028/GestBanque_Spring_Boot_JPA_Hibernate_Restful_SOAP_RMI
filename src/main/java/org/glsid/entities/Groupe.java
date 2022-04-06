package org.glsid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Groupe implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeGroup;
	private String nomGroup;
	@ManyToMany(mappedBy = "groupes")
	private List<Employe> employes;
	
	public Groupe() {
		super();
	}
	public Groupe(String nomGroup) {
		super();
		this.nomGroup = nomGroup;
	}
	public Long getCodeGroup() {
		return codeGroup;
	}
	public void setCodeGroup(Long codeGroup) {
		this.codeGroup = codeGroup;
	}
	public String getNomGroup() {
		return nomGroup;
	}
	public void setNomGroup(String nomGroup) {
		this.nomGroup = nomGroup;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	

}
