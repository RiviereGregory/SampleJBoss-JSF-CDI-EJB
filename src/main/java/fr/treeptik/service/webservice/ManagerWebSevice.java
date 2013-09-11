package fr.treeptik.service.webservice;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;

@Stateless
@WebService
public class ManagerWebSevice {

	@Inject
	EmployeService employeService;

	public Employe register(Employe employe) throws ServiceException {
		return employeService.register(employe);

	}

}
