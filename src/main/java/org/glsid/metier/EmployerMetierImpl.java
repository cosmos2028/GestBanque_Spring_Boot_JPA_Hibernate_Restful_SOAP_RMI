package org.glsid.metier;

import java.util.List;

import org.glsid.dao.IEmployeRepository;
import org.glsid.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerMetierImpl implements IEmployerMetier
{

	@Autowired
	private IEmployeRepository employeRepository;
	@Override
	public Employe saveEmploye(Employe e) {
		return employeRepository.save(e);
	}

	@Override
	public List<Employe> listEmploye() {
		return employeRepository.findAll();
	}
	

}
