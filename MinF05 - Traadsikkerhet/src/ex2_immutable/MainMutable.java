package ex2_immutable;

public class MainMutable {

	public static void main(String[] args) {

		MeldingMutable m1 = new MeldingMutable("Hallo");
		m1.leggTil(" p� do!");
		System.out.println(m1);

		m1.setInnhold("Hade p� bade!");
		System.out.println(m1);
		// Kan en MeldingMutable deles og brukes av flere tr�der samtidig?

	}

}