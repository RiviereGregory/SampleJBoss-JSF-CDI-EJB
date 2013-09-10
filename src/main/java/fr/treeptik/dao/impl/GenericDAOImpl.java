package fr.treeptik.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import fr.treeptik.dao.GenericDAO;
import fr.treeptik.exception.DAOException;

public class GenericDAOImpl<T, PK> implements GenericDAO<T, PK> {

	@Inject
	protected EntityManager em;

	@Inject
	protected Logger log;

	private Class<T> type;

	public GenericDAOImpl(Class<T> type) {
		this.type = type;
	}

	@Override
	public T register(T entite) throws DAOException {
		try {
			entite = em.merge(entite);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return entite;
	}

	@Override
	public void remove(T entite) throws DAOException {
		try {
			em.remove(entite);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public T findById(PK id) throws DAOException {
		try {
			return em.find(type, id);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<T> findAll() throws DAOException {
		try {
			return em.createQuery("SELECT o FROM " + type.getSimpleName() + " o", type)
					.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void removeById(PK id) throws DAOException {
		try {
			Query query = em.createQuery("DELETE FROM " + type.getSimpleName()
					+ "  o WHERE o.id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

}
