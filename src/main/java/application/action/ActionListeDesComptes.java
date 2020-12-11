package application.action;

import applicationBanqueAction.banque.AgenceBancaire;

public class ActionListeDesComptes implements Action {
	String message;
	String code;
	
	public ActionListeDesComptes (String m, String c) {
		this.message=m;
		this.code=c;
		
	}
	
	public void execute (AgenceBancaire ag) {
		ag.afficher();
		
	}

	@Override
	public String actionMessage() {
		
		return this.message;
	}

	@Override
	public String actionCode() {
	
		return this.code;
	}
}
