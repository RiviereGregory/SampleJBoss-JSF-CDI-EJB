package fr.treeptik.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.treeptik.dao.AdresseDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Adresse;
import fr.treeptik.service.AdresseService;

@Stateless
public class AdresseServiceImpl implements AdresseService {

	@Inject
	private Logger log;

	@Inject
	private AdresseDAO dao;

	@Override
	public Adresse register(Adresse adresse) throws ServiceException {
		log.info("Registering " + adresse.getVille());
		try {
			adresse = dao.register(adresse);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return adresse;
	}

	@Override
	public void remove(Adresse adresse) throws ServiceException {
		log.info("Removing " + adresse.getVille());
		try {
			dao.remove(adresse);
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
	public List<Adresse> findAll() throws ServiceException {
		try {
			return dao.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public Adresse findById(Integer id) throws ServiceException {
		try {
			return dao.findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

}
