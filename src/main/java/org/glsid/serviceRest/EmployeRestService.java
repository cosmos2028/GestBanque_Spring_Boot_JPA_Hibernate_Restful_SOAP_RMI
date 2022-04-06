package org.glsid.serviceRest;

import java.util.List;

import org.glsid.entities.Employe;
import org.glsid.metier.IEmployerMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeRestService implements IEmployerMetier
{
	@Autowired
	private IEmployerMetier employerMetier;

	@Override
	@RequestMapping(value = "/employes",method = RequestMethod.POST)
	public Employe saveEmploye( @RequestBody Employe e) {
		return employerMetier.saveEmploye(e);
	}

	@Override
	@RequestMapping(value = "/employes",method = RequestMethod.GET)
	public List<Employe> listEmploye() {
		return employerMetier.listEmploye();
	}

}
