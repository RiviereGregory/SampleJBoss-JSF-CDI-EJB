package fr.treeptik.dao.impl;

import java.io.Serializable;

import javax.ejb.Stateless;

import fr.treeptik.dao.AdresseDAO;
import fr.treeptik.model.Adresse;

@Stateless
public class AdresseDAOImpl extends GenericDAOImpl<Adresse, Integer> implements AdresseDAO,
		Serializable {

	private static final long serialVersionUID = 1L;

	public AdresseDAOImpl() {
		super(Adresse.class);
	}

}
