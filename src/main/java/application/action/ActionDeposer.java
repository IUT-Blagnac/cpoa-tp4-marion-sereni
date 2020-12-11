package application.action;

import java.util.Locale;
import java.util.Scanner;

import applicationBanqueAction.ApplicationAgenceBancaire;
import applicationBanqueAction.banque.AgenceBancaire;

public class ActionDeposer implements Action {
	String message;
	String code;
	
	public ActionDeposer (String m, String c) {
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
		System.out.println("montant ?");
		montant = lect.nextDouble();
	
		ApplicationAgenceBancaire.deposerSurUnCompte(ag,num,montant);
		
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