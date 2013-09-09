package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Employe;

public interface EmployeService {

	void register(Employe employe) throws ServiceException;

	void remove(Employe employe) throws ServiceException;

	void removeById(Integer id) throws ServiceException;

	List<Employe> findAll() throws ServiceException;

}