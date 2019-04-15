package batailleNavale;

public class Coordonnee implements Comparable<Coordonnee> {
	private int ligne;
	private int colonne;

	public Coordonnee(int ligne, int colonne) {/** *(commentaire java doc) */
		if (ligne < 0 || ligne > 25)
			throw new IllegalAccessError("ligne " + ligne + " incorrecte");
		if (colonne < 0 || colonne > 25)
			throw new IllegalAccessError("colonne " + colonne + " incorrecte");
		this.ligne = ligne;
		this.colonne = colonne;

	}

	public Coordonnee(String s) {
		int c = s.charAt(0);
		this.colonne = c - 'A';
		this.ligne = Integer.parseInt(s.substring(1));
	}

	public String toString() {
		String str = "";
		str = str + (char) (this.colonne + 'A') +this.ligne;
		return str;
	}

	public int getLigne() {
		return this.ligne;

	}

	public int getColonne() {
		return this.colonne;

	}

	public boolean equals(Object obj) {
		Coordonnee r = null;
		if (obj instanceof Coordonnee) {
			r = (Coordonnee) obj;
		}
		if ((this.ligne != r.ligne) || (this.colonne != r.colonne)) {
			return false;
		} else
			return true;
	}

	public boolean voisine(Coordonnee c) {

		if ((this.ligne == c.ligne - 1 || this.ligne == c.ligne + 1) && (this.colonne == c.colonne)) {

			return true;
		}
		if ((this.colonne == c.colonne - 1) || (this.colonne == this.colonne + 1) && (this.ligne == c.ligne)) {
			return true;
		} else
			return false;

	}

	public int compareTo(Coordonnee c) {
		if ((this.ligne < c.ligne) || (this.ligne == c.ligne) && (this.colonne < c.colonne))
			return -1;
		if ((this.ligne == c.ligne) && (this.colonne == c.colonne))
			return 0;
		else
			return 1;

	}
}