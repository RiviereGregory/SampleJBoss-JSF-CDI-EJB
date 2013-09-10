package fr.treeptik.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Adresse;
import fr.treeptik.model.Employe;
import fr.treeptik.service.AdresseService;

@ManagedBean(name = "adresseMB")
@SessionScoped
public class AdresseManagedBean {

	@Inject
	private FacesContext facesContext;

	@Inject
	private AdresseService adresseService;

	private Adresse adresse;

	private ListDataModel<Adresse> adresses = new ListDataModel<>();

	private List<SelectItem> selectAdresse = new ArrayList<>();

	@PostConstruct
	public void init() {
		System.out.println("INIT");
		setAdresse(new Adresse());
		adresse.setEmploye(new Employe());
	}

	public String register() throws Exception {
		try {
			adresseService.register(adresse);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!",
					"Registration successful");
			facesContext.addMessage(null, m);
			init();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(),
					"Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
		return initListAdresse();
	}

	// Permet d'initialiser la liste qui sera utiliser dans les datatables de primefaces
	public String initListAdresse() throws Exception {
		adresses = new ListDataModel<Adresse>();
		adresses.setWrappedData(adresseService.findAll());
		return "/adresse/list";
	}

	public String initAdresse() throws Exception {
		init();
		return "/adresse/create";
	}

	public void remove() throws Exception {
		try {
			adresse = adresses.getRowData();
			adresseService.removeById(adresse.getId());
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(),
					"Remove unsuccessful");
			facesContext.addMessage(null, m);
		}
	}

	public String modify() throws ServiceException {

		adresse = adresses.getRowData();
		System.out.println("Id Adresse " + adresse.getId());
		adresseService.findById(adresse.getId());
		System.out.println("Ville Adresse " + adresse.getVille());

		return "create";
	}

	public ListDataModel<Adresse> findAll() throws Exception {

		return adresses;
	}

	public ListDataModel<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(ListDataModel<Adresse> adresses) {
		this.adresses = adresses;
	}

	public List<SelectItem> getSelectAdresse() throws ServiceException {

		List<Adresse> allAdresse = adresseService.findAll();
		selectAdresse.clear();
		for (Adresse adresse : allAdresse) {

			selectAdresse.add(new SelectItem(adresse.getId(), adresse.getVille() + " - "
					+ adresse.getRue()));
		}

		return selectAdresse;
	}

	public void setSelectAdresse(List<SelectItem> selectAdresse) {
		this.selectAdresse = selectAdresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
