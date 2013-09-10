package fr.treeptik.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.treeptik.dao.MissionDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Mission;
import fr.treeptik.service.MissionService;

@Stateless
public class MissionServiceImpl implements MissionService {

	@Inject
	private Logger log;

	@Inject
	private MissionDAO dao;

	@Override
	public Mission register(Mission mission) throws ServiceException {
		log.info("Registering " + mission.getNom());
		try {
			mission = dao.register(mission);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return mission;
	}

	@Override
	public void remove(Mission mission) throws ServiceException {
		log.info("Removing " + mission.getNom());
		try {
			dao.remove(mission);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

	}

	@Override
	public void removeById(Integer id) throws ServiceException {
		log.info("Removing mission id : " + id);
		try {
			dao.removeById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

	}

	@Override
	public List<Mission> findAll() throws ServiceException {
		try {
			return dao.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public Mission findById(Integer id) throws ServiceException {
		try {
			return dao.findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

}
