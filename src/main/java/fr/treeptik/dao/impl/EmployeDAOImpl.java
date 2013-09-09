package fr.treeptik.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Employe;

@Stateless
public class EmployeDAOImpl implements EmployeDAO {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Override
	public void register(Employe employe) throws DAOException {
		log.info("Registering " + employe.getNom());
		em.persist(employe);
	}

	@Override
	public void remove(Employe employe) throws DAOException {
		log.info("Removing " + employe.getNom());
		em.remove(employe);
	}

	@Override
	public List<Employe> findAll() throws DAOException {
		try {
			return em.createQuery("SELECT emp FROM Employe emp", Employe.class).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void removeById(Integer id) throws DAOException {
		try {
			Query query = em.createQuery("DELETE FROM Employe emp WHERE emp.id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

	}

}
