package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Employe;

public interface EmployeDAO {

	void register(Employe employe) throws DAOException;

	void remove(Employe employe) throws DAOException;

	void removeById(Integer id) throws DAOException;

	List<Employe> findAll() throws DAOException;

}