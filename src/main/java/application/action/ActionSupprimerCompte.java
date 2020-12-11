package application.action;

import java.util.Locale;
import java.util.Scanner;

import applicationBanqueAction.ApplicationAgenceBancaire;
import applicationBanqueAction.banque.AgenceBancaire;
import applicationBanqueAction.banque.exception.ABCompteInexistantException;

public class ActionSupprimerCompte implements Action {
	String message;
	String code;
	
	public ActionSupprimerCompte (String m, String c) {
		this.message=m;
		this.code=c;
		
	}
	
	public void execute (AgenceBancaire ag) {
		String num;
		double montant;
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		System.out.println("Numéro du compte ?");
		num = lect.next();
	
		try {
			ag.removeCompte(num);
		} catch (ABCompteInexistantException e) {
			e.printStackTrace();
		}
		
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