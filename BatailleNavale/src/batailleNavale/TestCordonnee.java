package batailleNavale;

public class TestCordonnee {

	public static void main(String[] args) {
		Coordonnee c = new Coordonnee(5, 3);
		Coordonnee k = new Coordonnee("D5");
		boolean b = true;
		b =k.voisine(c);
		System.out.println(c);
		System.out.println(k);
		System.out.println(b);
		System.out.println(c.compareTo(k));
		System.out.println(c.equals(k));

	}

}
