package application.actionlist;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import application.action.Action;
import applicationBanqueAction.ApplicationAgenceBancaire;
import applicationBanqueAction.banque.AgenceBancaire;

public class ActionListGestion implements ActionList{
	String message;
	String code;
	String titre;
	ArrayList <Action> listeDesActions ;
	
	public ActionListGestion(String m, String c, String t, ArrayList <Action> listActions){
		this.message=m;
		this.code=c;
		this.titre=t;
		this.listeDesActions=listActions;
	}
	
	
	public String actionMessage() {
		return this.message;
	}

	@Override
	public String actionCode() {
		return this.code;
	}

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		String choix;

		boolean continuer ;
		AgenceBancaire monAg ;
		continuer = true;
		while (continuer) {
			System.out.println("--");
			System.out.println("  Agence " + ag.getNomAgence() + " de " + ag.getLocAgence());
			System.out.println("  "+this.titre);
			System.out.println("--");
			System.out.println("  Choisir :");
			for(int i =0;i<this.listeDesActions.size();i++) {
				System.out.println(	"	"+this.listeDesActions.get(i).actionCode()+" - "+this.listeDesActions.get(i).actionMessage());
			}
			System.out.println("");
			System.out.println("	0 - Pour quitter ce menu");
			System.out.print("Votre choix ? ");
			choix = lect.next();
			switch (choix) {
				case "0" :
					continuer = false;
					break;
				case "1" :
					this.listeDesActions.get(0).execute(ag);
					break;
				case "2" :
				try {
					this.listeDesActions.get(1).execute(ag);
				} catch (Exception e) {
					e.printStackTrace();
				}
					break;
				default :
					System.out.println("Erreur de saisie ...");
					ApplicationAgenceBancaire.tempo();
					break;
			}
		}
	}

	@Override
	public String listTitle() {
		
		return this.titre;
	}

	@Override
	public int size() {
		
		return this.listeDesActions.size();
	}

	@Override
	public boolean addAction(Action ac) {
		if(this.listeDesActions.contains(ac)) {
			return false;
		}else {
			this.listeDesActions.add(ac);
			return true;
		}
		
		
	}

}