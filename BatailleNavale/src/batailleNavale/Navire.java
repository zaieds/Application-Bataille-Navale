package batailleNavale;

public class Navire {

	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partieTouchees;
	private int nbTouchees;
	private String s = "";
	private int longueur = 0;
	private boolean estVertical;

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		if (debut == null || longueur < 0)
			throw new IllegalArgumentException("coordonnée de début null ou longeur négative");
		this.debut = debut;
		this.longueur = longueur;
		if (estVertical) {
			this.fin = new Coordonnee(this.debut.getLigne() + this.longueur, this.debut.getColonne());
			s = "vertical";
		} else {
			this.fin = new Coordonnee(this.debut.getLigne(), this.debut.getColonne() + this.longueur);
			s = "horizontal";
		}
		this.partieTouchees = new Coordonnee[longueur];
		this.nbTouchees = 0;

	}

	public String toString() {

		return "Navire (" + this.debut + ", " + this.longueur + "," + s + ")";
	}

	public Coordonnee getDebut() {
		return this.debut;
	}

	public Coordonnee getFin() {
		return this.fin;
	}

	public boolean contient(Coordonnee c) {
		return (c.getColonne() >= debut.getColonne() && c.getColonne() <= fin.getColonne()
				&& c.getLigne() >= debut.getLigne() && c.getLigne() <= fin.getLigne());

	}

	public boolean touche(Navire n) {

		return ((n.fin.getColonne() == this.debut.getColonne() - 1) || (n.debut.getColonne() == fin.getColonne() + 1))
				&& ((n.debut.getLigne() <= this.fin.getLigne()) && (this.debut.getLigne() <= n.fin.getLigne()))
				|| (((n.fin.getLigne() == this.debut.getLigne() - 1) || (n.debut.getLigne() == fin.getLigne() + 1))
						&& ((n.debut.getColonne() <= this.fin.getColonne())
								&& (this.debut.getColonne() <= n.fin.getColonne())));
	}

	public boolean chevauche(Navire n) {
		return ((n.fin.getColonne() == this.debut.getColonne()) || (n.debut.getColonne() == this.fin.getColonne()))
				&& ((n.debut.getLigne() == this.fin.getLigne()) || (this.debut.getLigne() == n.fin.getLigne()))
				&&(n.debut.getColonne() == this.debut.getLigne()) || (n.debut.getColonne() == this.debut.getLigne())
				&& ((n.fin.getLigne() == this.fin.getColonne()) || (this.fin.getLigne() == n.fin.getColonne()))
				&& ((n.debut.getLigne() <= this.fin.getColonne())|| (n.debut.getLigne() >= this.debut.getColonne()))
				&& ((this.debut.getLigne() <= n.fin.getColonne())|| (this.debut.getLigne() >= n.debut.getColonne()));
	}

	public boolean recoitTir(Coordonnee c) {

		if (this.contient(c)) {
				partieTouchees[nbTouchees] = c;
				nbTouchees++;
				return true;

			}

		
		return false;
}
	

	public boolean estTouche(Coordonnee c) {
		
				return recoitTir(c);

	}

	public boolean estTouche() {
		return nbTouchees > 0;

	}

	public boolean estCoule() {
		return (partieTouchees.length == nbTouchees);

	}

}