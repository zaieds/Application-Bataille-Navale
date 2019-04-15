package batailleNavale;

public class GrilleNavale {
	private static final String Coordonnee = null;
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;

	public GrilleNavale(int taille, int[] taillesNavires) {
		this.navires = new Navire[taillesNavires.length];

		this.taille = taille;
		this.nbNavires = taillesNavires.length;

		for (int n = 0; n < navires.length; n++) {
			navires[n] = new Navire(new Coordonnee((int) Math.random() * taille, (int) Math.random() * taille),
					taillesNavires[n], Math.random() < 0.5);
		}
		Coordonnee tab[] = new Coordonnee[taille * taille];
		tirsRecus = tab;
		nbTirsRecus = 0;
	}

	public GrilleNavale(int taille, int nbNavires) {
		this.taille = taille;
		this.nbNavires = nbNavires;
		Coordonnee[] tirsRecus = new Coordonnee[taille * taille];
		nbTirsRecus = 0;
	}

//	public String toString() {
//		String s = "   ";
//        for (int j = 0; j < taille; j++) {
//            s += (char) ('A' + j) + " ";
//
//        }
//        s += "\n";
//        for (int i = 0; i < taille; i++) {
//
//            s += i + 1 + "  ";
//
//            for (int j = 0; j < taille; j++) {
//                int n = 1;
//                Coordonnee c = new Coordonnee(i, j);
//                //for (int k = 0; k < navires.length; k++) {
//                    
//                    if (this.estTouche(c)) {
//                        s+= "X"+" ";
//                    }
//                    else if (this.estALEau(c)) {
//                        s+= "O"+" ";
//                    }
//                    else {
//                        boolean navire=false;
//                        for (int ii=0 ; ii< nbNavires ; ii++) {
//                            if (navires[ii].contient(c)) {
//                                s+= "#"+" ";
//                                navire=true;
//                                break;
//                            }
//                        }
//                        if (!navire) {
//                            s+= "."+" ";
//                        }
//                    }
//
//    
//            }
//            s += "\n";
//        }
//
//        return s;
//    }

	public String toString() {
		String[][] matrice = new String[taille][taille];
		
			for (int i = 0; i < taille; i++) {
				for (int j = 0; j < taille; j++) {
					Coordonnee c = new Coordonnee(i, j);
					for (int r=0;r<nbNavires;r++) {
					if (this.navires[r] != null && this.navires[r].contient(c))
					matrice[i][j] = "#";
					else 
						{if (this.navires[r].recoitTir(c))
						matrice[i][j] = "O"; 
					else if (this.navires[r].estTouche(c))  
						matrice[i][j] = "X";
					else 
						matrice[i][j] = ".";
					} } 
				}

			}
		
	
		String resultat = "  ";

		for (int z = 0; z < this.taille; z++) {
			resultat = resultat + (char) ((65) + z) + " ";
		}
		resultat = resultat + "\n";

		for (int numeroDeLigne = 1; numeroDeLigne < taille; numeroDeLigne++) {
			resultat = resultat + numeroDeLigne + " ";

			for (int numerDeColonne = 0; numerDeColonne < taille; numerDeColonne++) {
				resultat = resultat + matrice[numeroDeLigne][numerDeColonne] + " ";
			}
			resultat += "\n";
		}
			
	
			return resultat;	
	}

	public void placementAuto(int[] taillesNavires) {
		for (int n = 0; n < navires.length; n++) {
			navires[n] = new Navire(new Coordonnee((int) Math.random() * taille, (int) Math.random() * taille),
					taillesNavires[n], Math.random() < 0.5);
		}
	}

	private boolean estDansGrille(Coordonnee c) {
		return (c.getLigne() <= taille && c.getColonne() <= taille);
	}

	private boolean estDansTirsRecus(Coordonnee c) {
		boolean r = true;
		for (int n = 0; n < tirsRecus.length; n++) {
			if (this.tirsRecus[n].equals(c)) {
				r = true;
				break;
			} else {
				r = false;
			}
		}
		return r;
	}

	private boolean ajouteDansTirsRecus(Coordonnee c) {
		boolean r = true;
		for (int n = 0; n < tirsRecus.length; n++) {
			if (this.tirsRecus[n].equals(c) && this.tirsRecus[n] != this.tirsRecus[n - 1]) {
				r = true;
				break;
			} else {
				r = false;
			}
		}
		return r;
	}

	public boolean recoitTir(Coordonnee c) {
		boolean r = false;
		for (int n = 0; n < tirsRecus.length; n++) {
			if (this.tirsRecus[n].equals(c)) {
				for (int i = 0; i < navires.length; i++) {
					if (navires[i].contient(c) == false) {
						r = true;
						break;
					}
				}
			}
		}
		return r;
	}

	public boolean estTouche(Coordonnee c) {
		boolean m = true;
		for (int n = 0; n <navires.length; n++) {
			if (navires[n] != null)
			if (navires[n].estTouche()) {
				m = true;
			} else {
				m = false;
			}
		}
		return m;
	}

	public boolean estALEau(Coordonnee c) {
		boolean t = false;
		for (int n = 0; n < navires.length; n++) {
			if ((c.getLigne() <= taille && c.getColonne() <= taille) && navires[n].estTouche() == false) {
				t = true;
				break;
			}
		}
		return t;
	}

	public boolean estCoule(Coordonnee c) {
		boolean b = false;
		for (int i = 0; i < navires.length; i++) {
			if (navires[i].estTouche(c) && navires[i].estCoule())
				;
			b = true;
			break;

		}
		return b;
	}

	public boolean perdu() {
		boolean b = true;
		for (int i = 0; i < navires.length; i++) {
			if (!navires[i].estCoule())
				b = false;
			break;
		}
		return b;
	}

	public int getTaille() {
		return taille;
	}

}