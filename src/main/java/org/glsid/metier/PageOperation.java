package org.glsid.metier;

import java.io.Serializable;
import java.util.List;

import org.glsid.entities.Operation;

public class PageOperation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Operation> listOperations;
	
	private int pageActuelle;
	
	private int nombreOperations;
	
	private Long totalOperations;
	
	private int totalPages;

	public List<Operation> getListOperations() {
		return listOperations;
	}

	public void setListOperations(List<Operation> listOperations) {
		this.listOperations = listOperations;
	}

	public int getPage() {
		return pageActuelle;
	}

	public void setPage(int page) {
		this.pageActuelle = page;
	}

	public int getNombreOperations() {
		return nombreOperations;
	}

	public void setNombreOperations(int nombreOperations) {
		this.nombreOperations = nombreOperations;
	}

	public Long getTotalOperations() {
		return totalOperations;
	}

	public void setTotalOperations(long l) {
		this.totalOperations = l;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	

}
