package batailleNavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille {
	private Scanner sc;

	public JoueurTexte(GrilleNavale g, String nom) {
		super(g, nom);

	}

	public JoueurTexte(GrilleNavale g) {
		super(g);
	}

	protected void retourAttaque(Coordonnee c, int etat) {

		if (etat == A_L_EAU)
			System.out.println("Votre tire � �t� col� dans l'eau");
		if (etat == TOUCHE)
			System.out.println("Votre tire a toucher le navire de votre adversaire");
		if (etat == COULE)
			System.out.println("Votre navire � �t� coul�");
		if (etat == GAMEOVER)
			System.out.println("Vous avez perdu");
	}

	protected void retourDefense(Coordonnee c, int etat) {
		if (etat == A_L_EAU)
			System.out.println("Le tire de votre adversaire � �t� col� dans l'eau");
		if (etat == TOUCHE)
			System.out.println("Le tire de votre adversaire a touch� votre navire");
		if (etat == COULE)
			System.out.println("Le navire de votre adversaire � �t� coul�");
		if (etat == GAMEOVER)
			System.out.println("Votre adversaire a perdu");
	}

	public Coordonnee choixAttaque() {
	
		System.out.println( "veuillez entrer une cordonn�e: ");
		Scanner sc = new Scanner(System.in);
		String s= sc.next();
		Coordonnee c = new Coordonnee(s);
		System.out.println( s);
		return c;
	}
}
