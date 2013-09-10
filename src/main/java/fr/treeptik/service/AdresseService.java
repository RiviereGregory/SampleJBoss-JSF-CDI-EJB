package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Adresse;

public interface AdresseService {

	Adresse register(Adresse adresse) throws ServiceException;

	void remove(Adresse adresse) throws ServiceException;

	void removeById(Integer id) throws ServiceException;

	List<Adresse> findAll() throws ServiceException;

	Adresse findById(Integer id) throws ServiceException;

}