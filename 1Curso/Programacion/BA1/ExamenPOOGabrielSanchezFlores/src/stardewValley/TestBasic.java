package stardewValley;

public class TestBasic {
	public static void sep(String titol) {
		System.out.println();
		System.out.println("========================================");
		System.out.println(titol);
		System.out.println("========================================");
	}

	public static void check(String msg, Object esperat, Object obtingut) {
		boolean ok = (esperat == null && obtingut == null)
				|| (esperat != null && esperat.equals(obtingut));

		System.out.println((ok ? "[OK]   " : "[FAIL] ") + msg
				+ " | esperat: " + esperat + " | obtingut: " + obtingut);
	}

	public static void checkB(String msg, boolean esperat, boolean obtingut) {
		System.out.println((esperat == obtingut ? "[OK]   " : "[FAIL] ") + msg
				+ " | esperat: " + esperat + " | obtingut: " + obtingut);
	}

	public static void main(String[] args) throws Exception {

		sep("1) CREACIO D'OBJECTES I PERSONATGES");

		Hortalissa patata = new Hortalissa("Patata", Tipus.TUBERCLE, 10);
		Hortalissa poma = new Hortalissa("Poma", Tipus.FRUITA, 15);

		Granger g = new Granger("Alex", patata);
		PersonatgeCasable abigail = new PersonatgeCasable("Abigail", poma, false);
		PersonatgeNoCasable pierre = new PersonatgeNoCasable("Pierre", patata, false);

		check("Nom del granger", "Alex", g.nom);
		check("Nom del personatge casable", "Abigail", abigail.nom);
		check("Preferida del granger", patata, g.preferida);
		checkB("Granger no comença casat", false, g.casat);
		check("Parella inicial del granger", null, g.parella);
		check("Apreci inicial personatge casable", 0, abigail.getApreci());
		check("Apreci màxim personatge casable", 10, abigail.getApreciMaxim());

		check("toString de Personatge", "Alex", g.toString());
		check("toString d'Objecte/Hortalissa", "Patata (TUBERCLE)", patata.toString());

		sep("2) REGALAR");

		Llavor llavorPatata = new Llavor("Llavor Patata", 3, patata);

		check("Apreci inicial d'Abigail", 0, abigail.getApreci());

		int apreci1 = g.regalar(abigail, llavorPatata);
		check("Regalar una llavor baixa l'apreci en 1, però no baixa de 0", 0, apreci1);

		int apreci2 = g.regalar(abigail, patata);
		check("Regalar una hortalissa puja l'apreci en 1", 1, apreci2);

		int apreci3 = g.regalar(abigail, poma);
		check("Regalar una altra hortalissa torna a pujar l'apreci en 1", 2, apreci3);

		sep("3) PLANTAR I REGAR");

		Conreu c = new Conreu();

		check("Conreu inicialment buit", null, c.conreat);

		g.plantar(c, llavorPatata);
		check("Després de plantar, el conreu té llavor", llavorPatata, c.conreat);
		check("Torns regada inicials", 0, c.conreat.tornsRegada);
		check("Torns per créixer", 3, c.conreat.tornsPerCreixer);

		g.regar(c);
		check("Després de regar 1 cop", 1, c.conreat.tornsRegada);

		g.regar(c);
		check("Després de regar 2 cops", 2, c.conreat.tornsRegada);

		g.regar(c);
		check("Després de regar 3 cops", 3, c.conreat.tornsRegada);

		sep("4) COLLIR");

		Hortalissa collida = g.collir(c);
		check("Collir retorna l'hortalissa associada a la llavor", patata, collida);

		System.out.println("Conreat després de collir: " + c.conreat);
		System.out.println("Si surt null és correcte si has decidit buidar el conreu.");

		sep("5) PROPOSTA DE PARELLA");

		checkB("Un personatge no casable sempre rebutja la proposta", false, pierre.propostaParella(g));
		check("La parella del granger continua sent null", null, g.parella);

		checkB("Un personatge casable amb apreci insuficient rebutja la proposta", false, abigail.propostaParella(g));
		check("La parella del granger encara és null", null, g.parella);

		for (int i = abigail.getApreci(); i < abigail.getApreciMaxim(); i++) {
			g.regalar(abigail, patata);
		}

		check("Apreci d'Abigail després de diversos regals", 10, abigail.getApreci());
		checkB("Un personatge casable amb apreci màxim accepta la proposta", true, abigail.propostaParella(g));
		check("La parella del granger és Abigail", abigail, g.parella);

		sep("6) VENDRE");

		check("Vendre una llavor retorna 0", 0, llavorPatata.vendre());
		check("Vendre una hortalissa retorna el preu de venda", 10, patata.vendre());

		sep("FI DEL TEST BASIC");
		System.out.println("Si la majoria surt [OK], la part basica pinta be.");
	}
}
