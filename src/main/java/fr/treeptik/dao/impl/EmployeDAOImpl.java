package fr.treeptik.dao.impl;

import java.io.Serializable;

import javax.ejb.Stateless;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.model.Employe;

@Stateless
public class EmployeDAOImpl extends GenericDAOImpl<Employe, Integer> implements EmployeDAO,
		Serializable {

	private static final long serialVersionUID = 1L;

	public EmployeDAOImpl() {
		super(Employe.class);
	}

	// @Inject
	// private Logger log;
	//
	// @Inject
	// private EntityManager em;

	// @Override
	// public void register(Employe employe) throws DAOException {
	// log.info("Registering " + employe.getNom());
	// // em.persist(employe);
	// em.merge(employe);
	// }
	//
	// @Override
	// public void remove(Employe employe) throws DAOException {
	// log.info("Removing " + employe.getNom());
	// em.remove(employe);
	// }
	//
	// @Override
	// public List<Employe> findAll() throws DAOException {
	// try {
	// return em.createQuery("SELECT emp FROM Employe emp", Employe.class).getResultList();
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	// }
	//
	// @Override
	// public void removeById(Integer id) throws DAOException {
	// try {
	// Query query = em.createQuery("DELETE FROM Employe emp WHERE emp.id = :id");
	// query.setParameter("id", id);
	// query.executeUpdate();
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	//
	// }
	//
	// @Override
	// public Employe findById(Integer id) throws DAOException {
	// try {
	// return em.find(Employe.class, id);
	// } catch (PersistenceException e) {
	// throw new DAOException(e.getMessage(), e.getCause());
	// }
	// }

}
