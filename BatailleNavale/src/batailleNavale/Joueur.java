package batailleNavale;

public abstract class Joueur {

	public final static int TOUCHE = 1;
	public final static int COULE = 2;
	public final static int A_L_EAU = 3;
	public final static int GAMEOVER = 4;
	private Joueur adversaire;
	private int tailleGrille;
	private String nom;

	public Joueur(int tailleGrille, String nom) {
		this.nom = nom;
		this.tailleGrille = tailleGrille;

	}

	public Joueur(int tailleGrille) {
		this.tailleGrille = tailleGrille;
	}

	public int getTailleGrille() {
		return tailleGrille;

	}

	public String getNom() {
		return nom;
	}

	public void jouerAvec(Joueur j) {
		if (this.tailleGrille == j.tailleGrille && j.adversaire == null) {
			this.adversaire= j;
			j.adversaire = this;
			deroulementJeu(this, j);
		}
	}

	private static void deroulementJeu(Joueur attaquant, Joueur defenseur) {
		int res = 0;
		while (res != GAMEOVER) {
			Coordonnee c = attaquant.choisirAttaque();
			res = defenseur.defendre(c);
			attaquant.retourAttaque(c, res);
			defenseur.retourDefense(c, res);
			Joueur x = attaquant;
			attaquant = defenseur;
			defenseur = x;
		}
	}

	protected abstract void retourAttaque(Coordonnee c, int etat);

	protected abstract void retourDefense(Coordonnee c, int etat);

	public abstract Coordonnee choisirAttaque();

	public abstract int defendre(Coordonnee c);

}
