package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Mission;

public interface MissionService {

	void register(Mission mission) throws ServiceException;

	void remove(Mission mission) throws ServiceException;

	void removeById(Integer id) throws ServiceException;

	List<Mission> findAll() throws ServiceException;

	Mission findById(Integer id) throws ServiceException;

}