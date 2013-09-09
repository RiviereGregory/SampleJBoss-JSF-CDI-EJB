package fr.treeptik.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;

@Stateless
public class EmployeServiceImpl implements EmployeService {

	@Inject
	private Logger log;

	@Inject
	private EmployeDAO dao;

	@Override
	public void register(Employe employe) throws ServiceException {
		log.info("Registering " + employe.getNom());
		try {
			dao.register(employe);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void remove(Employe employe) throws ServiceException {
		log.info("Removing " + employe.getNom());
		try {
			dao.remove(employe);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

	}

	@Override
	public void removeById(Integer id) throws ServiceException {
		log.info("Removing employe id : " + id);
		try {
			dao.removeById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

	}

	@Override
	public List<Employe> findAll() throws ServiceException {
		try {
			return dao.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

}
