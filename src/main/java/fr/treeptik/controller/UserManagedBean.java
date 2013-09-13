package fr.treeptik.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "userMB")
@SessionScoped
public class UserManagedBean {

	public String logout() throws Exception {
		// FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		// return "/index?faces-redirect=true";

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();

		System.out.println("Login : " + request.getUserPrincipal().getName());

		if (session != null) {
			session.invalidate();
		}
		// FacesContext
		// .getCurrentInstance()
		// .getApplication()
		// .getNavigationHandler()
		// .handleNavigation(FacesContext.getCurrentInstance(), null,
		// "/index.jsf?faces-redirect=true");
		return "logout";
	}

}
