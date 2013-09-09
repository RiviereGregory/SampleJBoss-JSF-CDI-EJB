package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Mission;

public interface MissionDAO {

	void register(Mission mission) throws DAOException;

	void remove(Mission mission) throws DAOException;

	void removeById(Integer id) throws DAOException;

	List<Mission> findAll() throws DAOException;

}