package applicationBanqueAction.banque;

import applicationBanqueAction.banque.exception.CompteException;

/************************************************************
 * Classe Compte permettant de g�rer des comptes simples.<BR>
 * Un Compte a un num�ro, appartient � un propri�taire et on peut y faire des
 * versements (cr�dits) et des retraits (d�bits).<BR>
 * Seuls des contr�les de montants des op�rations >=0 sont r�alis�s.<BR>
 * 
 * @author Andr� P�ninou.
 * @version 3.01
 *****************************/

// Classe des comptes standards

public class Compte extends Object
// Si cet h�ritage n'est pas pr�cis�, il est implicite
{
	/*********************************
	 * Partie priv�e d'impl�mentation
	 **********************************/

	// Attributs

	// Nom du propri�taire
	private String proprietaire;

	// Numero de Compte
	private String numCompte;

	// Attributs debit et credit
	// Permettent de comptabiliser depots et retraits
	private double debits, credits;

	// Nb Op�rations
	private int nbDebits, nbCredits;

	// Constructeurs

	/**
	 * Constructeur non param�tr�, appel� aussi constructeur "par d�faut".<BR>
	 * <BR>
	 * Permet de cr�er un Compte.<BR>
	 * Les cr�dits et d�bits sont initialis�s � 0. le num�ro est initialis� �
	 * "Pas de num�ro", le propri�taire � "Pas de propri�taire"<BR>
	 * <BR>
	 * 
	 * @see Compte#Compte(String, String)
	 */
	public Compte() {
		this("Pas de num�ro", "Pas de propri�taire");
	}

	/**
	 * Constructeur param�tr�.<BR>
	 * <BR>
	 * Permet de cr�er un Compte en donnant son num�ro et son propri�taire.<BR>
	 * Les cr�dits et d�bits sont initialis�s � 0.<BR>
	 * <BR>
	 * 
	 * @param pNumCompte
	 *            Le num�ro du Compte.
	 * @param pNomProp
	 *            Le nom du propri�taire.
	 */
	public Compte(String pNumCompte, String pNomProp) {
		this.numCompte = pNumCompte;
		this.proprietaire = pNomProp;
		this.debits = 0;
		this.credits = 0;
		this.nbCredits = 0;
		this.nbDebits = 0;
	}

	/**
	 * Permet d'obtenir le solde d'un Compte.<BR>
	 * <BR>
	 * 
	 * @return Le solde du Compte.
	 */
	public double soldeCompte() {
		return this.credits - this.debits;
	}

	/**
	 * Permet d'obtenir le propri�taire d'un Compte.<BR>
	 * <BR>
	 * 
	 * @see Compte#setProprietaire(String)
	 * @return Le propri�taire du Compte.
	 */
	public String getProprietaire() {
		return this.proprietaire;
	}

	/**
	 * Permet d'obtenir le num�ro d'un Compte.<BR>
	 * <BR>
	 * 
	 * @return Le num�ro du Compte.
	 */
	public String getNumCompte() {
		return this.numCompte;
	}

	/**
	 * Affiche un Compte - <B>SPECIAL TP.</B><BR>
	 * <BR>
	 * Affiche this.toString()<BR>
	 * <BR>
	 * <B>ATTENTION : M�thode sp�ciale pour les TP.</B><BR>
	 * <BR>
	 */
	public void afficher() {
		System.out.println(this.toString());
	}

	/**
	 * Permet d'obtenir la repr�sentation String d'un compte.<BR>
	 * <BR>
	 * Construit une chaine contenant le num�ro de compte, le propri�taire, le
	 * total des d�bits, le total des cr�dits, le nombre d'op�rations r�alis�es.<BR>
	 * "  Num. : aaa  - Prop. : bbb - Debit xxx E / Credit yyy E / NbOps zzz"<BR>
	 * <BR>
	 */
	public String toString() {
		return "  Num. : " + this.numCompte + " - Prop. : " + this.proprietaire
				+ " - Debit " + this.debits + " E / Credit " + this.credits
				+ " E / NbOps " + (this.nbCredits + this.nbDebits);
	}

	// Methodes de mise a jour

	/**
	 * Permet d'effectuer un retrait sur un Compte.<BR>
	 * <BR>
	 * Effectue un retrait (d�bit) de pSomme Euros sur le Compte.<BR>
	 * L�ve une exception si pSomme < 0. <BR>
	 * 
	 * @param pSomme
	 *            Le montant retir� sur le Compte.
	 * @throws CompteException
	 *             Lorsque pSomme < 0
	 * @see Compte#deposer(double)
	 */
	public void retirer(double pSomme) throws CompteException {
		if (pSomme < 0) {
			throw new CompteException(
					"Erreur de somme n�gative lors d'un retrait sur " + this.numCompte);
		}
		this.debits = this.debits + pSomme;
		this.nbDebits++;
	}

	/**
	 * Permet d'effectuer un d�pot sur un Compte.<BR>
	 * <BR>
	 * Effectue un d�pot (cr�dit) de pSomme Euros sur le Compte.<BR>
	 * L�ve une exception si pSomme < 0.<BR>
	 * 
	 * @param pSomme
	 *            Le montant d�pos� sur le Compte.
	 * @throws CompteException
	 *             Lorsque pSomme < 0
	 * @see Compte#retirer(double)
	 */
	public void deposer(double pSomme) throws CompteException {
		if (pSomme < 0) {
			throw new CompteException(
					"Erreur de somme n�gative lors d'un d�pot sur " + this.numCompte);
		}
		this.credits = this.credits + pSomme;
		this.nbCredits++;
	}

	/**
	 * Permet de modifier le propri�taire d'un Compte.<BR>
	 * <BR>
	 * 
	 * @param pNomProp
	 *            Le nom du propri�taire.
	 * @see Compte#getProprietaire()
	 */
	public void setProprietaire(String pNomProp) {
		this.proprietaire = pNomProp;
	}

}
