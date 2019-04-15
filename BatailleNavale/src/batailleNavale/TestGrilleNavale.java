package batailleNavale;

public class TestGrilleNavale {

	public static void main(String[] args) {
//		int [] tab= {3,2,1};
//		String nom ="siwar ";
//		GrilleNavale c = new GrilleNavale(9, tab);
//		Joueur j = new JoueurTexte(c, nom);
//		System.out.println("vous etes le joueur : "+ nom);
//		System.out.println(c.toString());
//		
//		Coordonnee c1 = new Coordonnee(3, 2);
//        Coordonnee c2 = new Coordonnee(2, 3);
        int t1 []= {7, 1, 5,6}; 
        int t2 []= {7, 8, 5,9};

//        Navire N = new Navire(c1, 1, true);
//        Navire monNavire = new Navire(c2, 1, true);

        GrilleNavale magrille = new GrilleNavale(10, t1);
        GrilleNavale grilleAuto = new GrilleNavale(10, t2);
//        System.out.println(magrille.toString());
        JoueurTexte M = new JoueurTexte(magrille, " siwar");
        System.out.println("ma grille : "+ "\n" + magrille.toString());

        JoueurAuto J = new JoueurAuto(grilleAuto,"ikaram");
        
        System.out.println(grilleAuto.toString());

        J.jouerAvec(M);
	}

}
