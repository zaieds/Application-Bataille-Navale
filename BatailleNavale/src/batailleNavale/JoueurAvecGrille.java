package batailleNavale;

public class JoueurAvecGrille extends Joueur {

	private GrilleNavale grille;

	public JoueurAvecGrille(GrilleNavale g, String nom) {
		super(g.getTaille(), nom);
		this.grille = g;

	}

	public JoueurAvecGrille(GrilleNavale g) {
		super(g.getTaille());
		this.grille = g;

	}

	public int defendre(Coordonnee c) {
		int res = 0;
		this.grille.recoitTir(c);

		if (this.grille.estTouche(c)) {
			res = TOUCHE;
		}
		if (this.grille.estCoule(c)) {
			res = COULE;
		}
		if (this.grille.estALEau(c)) {
			res = A_L_EAU;
		}
		if (this.grille.perdu()) {
			res = GAMEOVER;
		}
		return res;

	}

	@Override
	protected void retourAttaque(Coordonnee c, int etat) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void retourDefense(Coordonnee c, int etat) {
		// TODO Auto-generated method stub

	}

	@Override
	public Coordonnee choisirAttaque() {
		// TODO Auto-generated method stub
		return null;
	}
}
