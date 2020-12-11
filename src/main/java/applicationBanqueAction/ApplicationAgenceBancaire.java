package applicationBanqueAction;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import application.action.Action;
import application.action.ActionAjouterCompte;
import application.action.ActionDeposer;
import application.action.ActionListeDesComptes;
import application.action.ActionRetirer;
import application.action.ActionSupprimerCompte;
import application.action.ActionVoirCompteNumero;
import application.actionlist.ActionListAgenceBancaire;
import application.actionlist.ActionListOperations;
import applicationBanqueAction.application.AccesAgenceBancaire;
import applicationBanqueAction.banque.AgenceBancaire;
import applicationBanqueAction.banque.Compte;
import applicationBanqueAction.banque.exception.CompteException;

public class ApplicationAgenceBancaire {
	
	/**
	 * Affichage du menu de l'application
	 * @param ag	AgenceBancaire pour r�cup�rer le nom et la localisation
	 */
	public static void afficherMenu(AgenceBancaire ag) {
		System.out.println("--");
		System.out.println("  Agence " + ag.getNomAgence() + " de " + ag.getLocAgence());
		System.out.println("  Menu Général");
		System.out.println("--");
		System.out.println("  Choisir :");
		System.out.println("	1 - Liste des comptes de l'agence");
		System.out.println("	2 - Voir un compte (par son num�ro)");
		System.out.println("	3 - Menu opérations sur comptes");
		System.out.println("	4 - Menu gestion des comptes");
		System.out.println("");
		System.out.println("	0 - Pour quitter ce menu");
		System.out.print("Votre choix ? ");
	}
	
	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
	 */
	public static void tempo () {
		Scanner lect ;
		
		lect = new Scanner (System.in );
		
		System.out.print("Tapper un caractère + return pour continuer ... ");
		lect.next(); 
	}
	public static void main(String argv[]) {
	
		String choix;

		boolean continuer ;
		Scanner lect;
		AgenceBancaire monAg ;
		
		String nom, numero;		
		Compte c;
		double montant;
		
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		
		monAg = AccesAgenceBancaire.getAgenceBancaire();
		
		ActionListeDesComptes listeCompte = new ActionListeDesComptes("Liste des comptes de l'agence","1");
		ActionVoirCompteNumero compteNum = new ActionVoirCompteNumero("Voir un compte (par son numéro)","2");
			ArrayList<Action> listChoixOp =new ArrayList<Action>();
			ActionDeposer depot = new ActionDeposer("Déposer de l'argent sur un compte","1");
			ActionRetirer retrait = new ActionRetirer("Retirer de l'argent sur un compte","2");
			listChoixOp.add(depot);
			listChoixOp.add(retrait);
		ActionListOperations menuOp = new ActionListOperations("Menu opérations sur comptes","3","Menu opérations sur comptes",listChoixOp);
		ArrayList<Action> listChoixGestion =new ArrayList<Action>();
			ActionAjouterCompte ajout = new ActionAjouterCompte("Ajouter un compte","1");
			ActionSupprimerCompte supprime = new ActionSupprimerCompte("Supprimer un compte","2");
			listChoixGestion.add(ajout);
			listChoixGestion.add(supprime);
		ActionListOperations menuGestion = new ActionListOperations("Menu gestion des comptes","4","Menu gestion des comptes",listChoixGestion);
		
			ArrayList<Action> listChoixGeneral =new ArrayList<Action>();
			listChoixGeneral.add(listeCompte);
			listChoixGeneral.add(compteNum);
			listChoixGeneral.add(menuOp);
			listChoixGeneral.add(menuGestion);
			
		ActionListAgenceBancaire menuGeneral = new ActionListAgenceBancaire("","0","Menu General",listChoixGeneral);
			try {
				menuGeneral.execute(monAg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}

	public static void maintest(String argv[]) {
		
		String choix;

		boolean continuer ;
		
		AgenceBancaire monAg ;
		
		String nom, numero;		
		Compte c;
		double montant;
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		
		monAg = AccesAgenceBancaire.getAgenceBancaire();
		
		continuer = true;
		while (continuer) {
			ApplicationAgenceBancaire.afficherMenu(monAg);
			choix = lect.next();
			//choix = choix.toLowerCase();
			switch (choix) {
				case "0" :
					System.out.println("ByeBye");
					ApplicationAgenceBancaire.tempo();
					continuer = false;
					break;
				default :
					System.out.println("Erreur de saisie ...");
					ApplicationAgenceBancaire.tempo();
					break;
			}
		}
		
	}
	

	public static void deposerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant d�p�t: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant d�pos�, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void retirerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retir�, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}

	}
}
