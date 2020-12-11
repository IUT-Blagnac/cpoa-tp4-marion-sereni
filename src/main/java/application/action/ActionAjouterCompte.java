package application.action;

import java.util.Locale;
import java.util.Scanner;

import applicationBanqueAction.ApplicationAgenceBancaire;
import applicationBanqueAction.banque.AgenceBancaire;
import applicationBanqueAction.banque.Compte;
import applicationBanqueAction.banque.exception.ABCompteDejaExistantException;
import applicationBanqueAction.banque.exception.ABCompteNullException;

public class ActionAjouterCompte implements Action {
	String message;
	String code;
	
	public ActionAjouterCompte (String m, String c) {
		this.message=m;
		this.code=c;
		
	}
	
	public void execute (AgenceBancaire ag) {
		String num;
		String prop;
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		System.out.println("Numéro du compte ?");
		num = lect.next();
		System.out.println("proprietaire du compte ?");
		prop = lect.next();
	
		Compte c = new Compte(num,prop);
		try {
			ag.addCompte(c);
		} catch (ABCompteNullException e) {
	
			e.printStackTrace();
		} catch (ABCompteDejaExistantException e) {

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