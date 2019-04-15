package batailleNavale;

public class TestNavire {

	public static void main(String[] args) {
		Coordonnee c1 = new Coordonnee("E1");
		Coordonnee c2 = new Coordonnee("F4");
//		Coordonnee[] i = new recoi;
		int nbr = 0;
		Navire n1 = new Navire(c1, 5, false);
		Navire n2 = new Navire(c2, 3, true);
		System.out.println(n1.contient(c2));
//		System.err.println(i[]);

	}

}
