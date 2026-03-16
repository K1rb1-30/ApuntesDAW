package mokepon4;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;


public class TestCheksMokepon5 {
	/*
	 * Aquest test està preparat per testejar parts individuals. Comenta i
	 * descomenta cada bloc segons la part que vulguis provar.
	 *
	 * En alguns blocs faig servir reflection per poder forçar el sexe dels Mokepons
	 * i així provar les excepcions de reproducció de forma controlada.
	 */

	private static void checkEquals(String label, Object actual, Object expected) {
		boolean ok = (actual == null && expected == null) || (actual != null && actual.equals(expected));
		System.out.println(label + " -> actual: " + actual + " | esperat: " + expected + " | " + (ok ? "OK" : "KO"));
	}

	private static void checkTrue(String label, boolean condition, String expectedDescription) {
		System.out.println(label + " -> condició: " + condition + " | esperat: " + expectedDescription + " | "
				+ (condition ? "OK" : "KO"));
	}

	private static void sep(String title) {
		System.out.println("\n=== " + title + " ===");
	}

	private static void forcarSexe(Mokepon mok, Sexe sexe) {
		try {
			Field f = Mokepon.class.getDeclaredField("sexe");
			f.setAccessible(true);
			f.set(mok, sexe);
		} catch (Exception e) {
			System.out.println("No s'ha pogut forçar el sexe: " + e.getMessage());
		}
	}

	private static int MokeponMesRapid(Mokepon m1, Mokepon m2) {
		if (m1.getVel() >= m2.getVel()) {
			return 1;
		}
		return 2;
	}

	private static int triaAtac(int[] seqAtacs, int index) {
		return seqAtacs[index % seqAtacs.length];
	}

	private static boolean gestionarAtac(Mokepon m1, Mokepon m2, int torn, int numAtac) {
		if (torn == 1) {
			m1.atacar(m2, numAtac);
			return m2.isDebilitat();
		} else {
			m2.atacar(m1, numAtac);
			return m1.isDebilitat();
		}
	}

	private static boolean fiCombat(boolean debilitat, int torn) {
		if (debilitat) {
			System.out.println("Combat acabat. Guanya el Mokepon del torn " + torn);
			return true;
		}
		return false;
	}

	private static int canviTorn(int torn) {
		return (torn == 1) ? 2 : 1;
	}

	public static void main(String[] args) {

		// ============================================================
		// PART A) Atac.equals()
		// ============================================================

//		sep("PART A: equals() d'Atac");
//
//		Atacs a1 = new Atacs("Flamarada", 50, Tipus.FOC, 10);
//		Atacs a2 = new Atacs("Flamarada", 50, Tipus.FOC, 10);
//		Atacs a3 = new Atacs("Fulla Tallant", 50, Tipus.PLANTA, 10);
//
//		checkTrue("Dos atacs iguals retornen true", a1.equals(a2), "true");
//		checkTrue("Dos atacs diferents retornen false", !a1.equals(a3), "true");

		// ============================================================
		// PART B) Atac.compareTo()
		// ============================================================

//		sep("PART B: compareTo() d'Atac");
//
//		Atacs a1 = new Atacs("A", 40, Tipus.FOC, 10);
//		Atacs a2 = new Atacs("B", 60, Tipus.FOC, 10);
//		Atacs a3 = new Atacs("Ala", 60, Tipus.FOC, 10);
//
//		checkTrue("Un atac amb menys poder és més petit", a1.compareTo(a2) < 0, "true");
//		checkTrue("Un atac amb més poder és més gran", a2.compareTo(a1) > 0, "true");
//		checkTrue("Si tenen el mateix poder, ordena per nom", a3.compareTo(a2) < 0, "true");

		// ============================================================
		// PART C) Mokepon.equals()
		// ============================================================

//		sep("PART C: equals() de Mokepon");
//
//		Mokepon m1 = new Mokepon("Mikachu", Tipus.PLANTA);
//		Mokepon m2 = new Mokepon("Mikachu", Tipus.PLANTA);
//
//		forcarSexe(m1, Sexe.Masculí);
//		forcarSexe(m2, Sexe.Masculí);
//
//		checkTrue("Dos Mokepons amb mateixes dades són iguals", m1.equals(m2), "true");
//
//		m2.setHp_actual(1);
//		m2.setDebilitat(true);
//		checkTrue("Segueixen sent iguals encara que canviï hp_actual i debilitat", m1.equals(m2), "true");
//
//		// ============================================================
//		// PART D) MokeponCapturat.equals()
//		// ============================================================
//
//		sep("PART D: equals() de MokeponCapturat");
//
//		Mokepon base1 = new Mokepon("Marmander", Tipus.FOC);
//		Mokepon base2 = new Mokepon("Marmander", Tipus.FOC);
//
//		MokeponCapturat c1 = new MokeponCapturat(base1, "Draki", "Dani");
//		MokeponCapturat c2 = new MokeponCapturat(base2, "Draki", "Dani");
//		MokeponCapturat c3 = new MokeponCapturat(base2, "Draki2", "Dani");
//		
//		forcarSexe(c1, Sexe.Femení);
//		forcarSexe(c2, Sexe.Femení);
//
//		checkTrue("Dos capturats iguals retornen true", c1.equals(c2), "true");
//		checkTrue("Si canvia nom posat o entrenador, retornen false", !c1.equals(c3), "true");

		// ============================================================
		// PART E) Mokepon.compareTo() i ordenació de mokedex
		// ============================================================

//		sep("PART E: compareTo() de Mokepon i Collections.sort()");
//
//		ArrayList<Mokepon> mokedex = new ArrayList<>();
//		Mokepon m1 = new Mokepon("Bublo", Tipus.AIGUA);
//		Mokepon m2 = new Mokepon("Ardi", Tipus.FOC);
//		Mokepon m3 = new Mokepon("Ardi", 3, 20, 3, 3, 3);
//		m3.setTipus(Tipus.FOC);
//		Mokepon m4 = new Mokepon("Verdi", Tipus.PLANTA);
//
//		mokedex.add(m4);
//		mokedex.add(m3);
//		mokedex.add(m1);
//		mokedex.add(m2);
//
//		Collections.sort(mokedex);
//
//		System.out.println("Mokedex ordenada: " + mokedex);
//		checkEquals("Primer ha de ser Ardi", mokedex.get(0).getNom(), "Ardi");
//		checkEquals("Segon també Ardi", mokedex.get(1).getNom(), "Ardi");
//		checkEquals("Tercer ha de ser Bublo", mokedex.get(2).getNom(), "Bublo");
//		checkEquals("Quart ha de ser Verdi", mokedex.get(3).getNom(), "Verdi");

		// ============================================================
		// PART F) capturar() i MokeponJaCapturatException
		// ============================================================

//		sep("PART F: capturar() i excepció");
//		try {
//			Mokepon m = new Mokepon("Salguin", Tipus.AIGUA);
//			MokeponCapturat capturat = m.capturar("Dani", "Peixet");
//			checkTrue("La captura crea un MokeponCapturat", capturat instanceof MokeponCapturat, "true");
//
//			boolean excepcio = false;
//			try {
//				capturat.capturar("Dani", "Un altre nom");
//			} catch (MokeponJaCapturatException e) {
//				excepcio = true;
//				System.out.println("Missatge excepció: " + e.getMessage());
//			}
//			checkTrue("Si ja està capturat, llança MokeponJaCapturatException", excepcio, "true");
//		} catch (Exception e) {
//			System.out.println("Error inesperat: " + e.getMessage());
//		}

		// ============================================================
		// PART G) reproduccio() correcta
		// ============================================================

//		sep("PART G: reproduccio() correcta");
//		try {
//			Mokepon pare1 = new Mokepon("Mikachu", Tipus.PLANTA);
//			Mokepon pare2 = new Mokepon("Verdi", Tipus.PLANTA);
//			forcarSexe(pare1, Sexe.Masculí);
//			forcarSexe(pare2, Sexe.Femení);
//
//			Ou ou = pare1.reproduccio(pare2);
//			checkTrue("Si compleixen les condicions, retorna un Ou", ou != null, "true");
//
//			Mokepon fill = ou.eclosionar();
//			checkTrue("Quan eclosiona, surt un Mokepon", fill != null, "true");
//			checkEquals("El tipus del fill coincideix amb el dels pares", fill.getTipus(), Tipus.PLANTA);
//		} catch (Exception e) {
//			System.out.println("No hauria d'haver fallat: " + e.getMessage());
//		}

		// ============================================================
		// PART H) reproduccio() -> TipusDiferentException
		// ============================================================

//		sep("PART H: TipusDiferentException");
//		try {
//			Mokepon m1 = new Mokepon("Marmander", Tipus.FOC);
//			Mokepon m2 = new Mokepon("Salguin", Tipus.AIGUA);
//			forcarSexe(m1, Sexe.Masculí);
//			forcarSexe(m2, Sexe.Femení);
//
//			m1.reproduccio(m2);
//			checkTrue("No hauria d'arribar aquí", false, "false");
//		} catch (TipusDiferentException e) {
//			checkTrue("Llença TipusDiferentException", true, "true");
//			System.out.println("Missatge: " + e.getMessage());
//		} catch (Exception e) {
//			checkTrue("Ha llençat l'excepció correcta", false, "true");
//		}

		// ============================================================
		// PART I) reproduccio() -> MateixSexeException
		// ============================================================

//		sep("PART I: MateixSexeException");
//		try {
//			Mokepon m1 = new Mokepon("Mikachu", Tipus.PLANTA);
//			Mokepon m2 = new Mokepon("Verdi", Tipus.PLANTA);
//			forcarSexe(m1, Sexe.Masculí);
//			forcarSexe(m2, Sexe.Masculí);
//
//			m1.reproduccio(m2);
//			checkTrue("No hauria d'arribar aquí", false, "false");
//		} catch (MateixSexeException e) {
//			checkTrue("Llença MateixSexeException", true, "true");
//			System.out.println("Missatge: " + e.getMessage());
//		} catch (Exception e) {
//			checkTrue("Ha llençat l'excepció correcta", false, "true");
//		}

		// ============================================================
		// PART J) reproduccio() -> DebilitatException
		// ============================================================

//		sep("PART J: DebilitatException");
//		try {
//			Mokepon m1 = new Mokepon("Mikachu", Tipus.PLANTA);
//			Mokepon m2 = new Mokepon("Verdi", Tipus.PLANTA);
//			forcarSexe(m1, Sexe.Masculí);
//			forcarSexe(m2, Sexe.Femení);
//			m2.setDebilitat(true);
//
//			m1.reproduccio(m2);
//			checkTrue("No hauria d'arribar aquí", false, "false");
//		} catch (DebilitatException e) {
//			checkTrue("Llença DebilitatException", true, "true");
//			System.out.println("Missatge: " + e.getMessage());
//		} catch (Exception e) {
//			checkTrue("Ha llençat l'excepció correcta", false, "true");
//		}

		// ============================================================
		// PART K) Ou.eclosionar()
		// ============================================================

//		sep("PART K: Ou.eclosionar()");
//
//		Ou ou = new Ou("Flameta", Tipus.FOC);
//		Mokepon fill = ou.eclosionar();
//
//		checkEquals("El nom del fill és l'espècie de l'ou", fill.getNom(), "Flameta");
//		checkEquals("El tipus del fill és el tipus de l'ou", fill.getTipus(), Tipus.FOC);


		// ============================================================
		// PART M) Prova visual mínima activa
		// ============================================================

//		sep("PART M: Prova visual mínima activa");
//
//		Mokepon m1 = new Mokepon("Mikachu", Tipus.PLANTA);
//		Mokepon m2 = new Mokepon("Verdi", Tipus.PLANTA);
//		forcarSexe(m1, Sexe.Masculí);
//		forcarSexe(m2, Sexe.Femení);
//
//		try {
//			Ou ou = m1.reproduccio(m2);
//			checkTrue("La reproducció correcta retorna un Ou", ou != null, "true");
//		} catch (Exception e) {
//			checkTrue("No hauria de fallar la reproducció d'aquest exemple", false, "true");
//		}
	}

}
