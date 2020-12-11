package application.action;

import java.util.Locale;
import java.util.Scanner;

import applicationBanqueAction.banque.AgenceBancaire;
import applicationBanqueAction.banque.Compte;

public class ActionVoirCompteNumero implements Action{
	String message;
	String code;
	
	public ActionVoirCompteNumero (String m, String c) {
		this.message=m;
		this.code=c;
		
	}
	
	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		Compte c;
		String num;
		Scanner lect;
		System.out.println("Numéro du compte ?");
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		
		num = lect.next();
		c = ag.getCompte(num);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			c.afficher();
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
