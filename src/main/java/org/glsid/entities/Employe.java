package org.glsid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

/*
 * @JsonIgnore permet de charger ou envoyer l'objet Employe sans le groupe
 * et le supérieur hierachique.
 * 
 * @JsonSetter permet de prendre en compte l'objet qui a ete mis en JSONIgnore 
 * mais uniquement au moment de la reception.
 */
@Entity
public class Employe implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmp;
	
	private String nomEmp;
	private String prenomEmp;
	
	@ManyToOne
	@JoinColumn(name="code_emp_sup")
	private Employe employeSupHierachiq;
	
	@ManyToMany
	@JoinTable(name="EMP_GROUP")
	private List<Groupe> groupes;
	
	
	public Employe() 
	{
		super();
	}
	
	public Employe(String nomEmp) {
		super();
		this.nomEmp = nomEmp;
	}
	public Long getCodeEmp() {
		return codeEmp;
	}
	public void setCodeEmp(Long codeEmp) {
		this.codeEmp = codeEmp;
	}
	public String getNomEmp() {
		return nomEmp;
	}
	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}
	public String getPrenomEmp() {
		return prenomEmp;
	}
	public void setPrenomEmp(String prenomEmp) {
		this.prenomEmp = prenomEmp;
	}
	@JsonIgnore
	public Employe getEmployeSupHierachiq() {
		return employeSupHierachiq;
	}
	@JsonSetter
	public void setEmployeSupHierachiq(Employe employeSupHierachiq) {
		this.employeSupHierachiq = employeSupHierachiq;
	}
	@JsonIgnore
	public List<Groupe> getGroupes() {
		return groupes;
	}
	@JsonSetter
	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	

}
