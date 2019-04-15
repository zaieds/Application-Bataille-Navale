package batailleNavale;

import java.util.Scanner;

public class JoueurAuto extends JoueurAvecGrille {
	
public JoueurAuto(GrilleNavale g, String nom) {
	super(g, nom);

}

public JoueurAuto(GrilleNavale g) {
	super(g);

}

protected void retourDefense(Coordonnee c, int etat) {
}



protected void retourAttaque(Coordonnee c, int etat) {
	
}

public Coordonnee choixAttaque() {
	System.out.println( "veuillez entrer une cordonnée: ");
	Scanner sc = new Scanner(System.in);
	String s= sc.next();
	Coordonnee c = new Coordonnee(s);
	System.out.println( s);
	return c;

}
}