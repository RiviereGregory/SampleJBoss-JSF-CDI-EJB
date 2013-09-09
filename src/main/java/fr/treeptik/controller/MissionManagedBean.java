package fr.treeptik.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import fr.treeptik.model.Employe;
import fr.treeptik.model.Mission;
import fr.treeptik.service.MissionService;

@ManagedBean(name = "missionMB")
public class MissionManagedBean {

	@Inject
	private FacesContext facesContext;

	@Inject
	private MissionService missionService;

	private Mission mission;

	private ListDataModel<Mission> missions = new ListDataModel<>();

	@PostConstruct
	public void init() {
		setMission(new Mission());
		mission.setEmploye(new Employe());
	}

	public String register() throws Exception {
		try {
			missionService.register(getMission());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!",
					"Registration successful");
			facesContext.addMessage(null, m);
			init();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(),
					"Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
		return "list";
	}

	public void remove() throws Exception {
		try {
			mission = missions.getRowData();
			missionService.removeById(mission.getId());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Removed!",
					"Remove successful");
			facesContext.addMessage(null, m);
			init();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(),
					"Remove unsuccessful");
			facesContext.addMessage(null, m);
		}
	}

	public ListDataModel<Mission> findAll() throws Exception {
		missions = new ListDataModel<>();

		try {
			missions.setWrappedData(missionService.findAll());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "FindAll!",
					"FindAll successful");
			facesContext.addMessage(null, m);
			init();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(),
					"FindAll unsuccessful");
			facesContext.addMessage(null, m);
		}

		return missions;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public ListDataModel<Mission> getMissions() {
		return missions;
	}

	public void setMissions(ListDataModel<Mission> missions) {
		this.missions = missions;
	}

}
