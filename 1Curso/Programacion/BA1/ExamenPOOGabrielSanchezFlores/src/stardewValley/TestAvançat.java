package stardewValley;

import java.util.Collections;

public class TestAvançat {
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
		Hortalissa patata2 = new Hortalissa("Patata", Tipus.TUBERCLE, 99);
		Hortalissa poma = new Hortalissa("Poma", Tipus.FRUITA, 15);
		Hortalissa blat = new Hortalissa("Blat", Tipus.CEREAL, 8);
		Hortalissa col = new Hortalissa("Col", Tipus.VERDURA, 12);

		Granger g = new Granger("Alex", patata);
		PersonatgeCasable abigail = new PersonatgeCasable("Abigail", patata, false);
		PersonatgeNoCasable pierre = new PersonatgeNoCasable("Pierre", blat, false);

		Llavor llavorPatata = new Llavor("Llavor Patata", 3, patata);
		Llavor llavorPoma = new Llavor("Llavor Poma", 2, poma);

		check("toString granger", "Alex", g.toString());
		check("toString hortalissa", "Patata (TUBERCLE)", patata.toString());
		check("Apreci inicial Abigail", 0, abigail.getApreci());
		check("Apreci màxim Abigail", 10, abigail.getApreciMaxim());
		check("Parella inicial del granger", null, g.parella);

		sep("2) REGALAR BASIC + HORTALISSA PREFERIDA");

		check("Regalar llavor baixa apreci però no sota 0", 0, g.regalar(abigail, llavorPatata));
		check("Apreci continua a 0", 0, abigail.getApreci());

		check("Regalar hortalissa preferida puja 2", 2, g.regalar(abigail, patata));
		check("Apreci després de preferida", 2, abigail.getApreci());

		check("Regalar hortalissa no preferida puja 1", 3, g.regalar(abigail, poma));
		check("Apreci després de no preferida", 3, abigail.getApreci());

		sep("3) EQUALS A HORTALISSA");

		checkB("Mateix nom i mateix tipus -> equals true", true, patata.equals(patata2));
		checkB("Nom/tipus diferents -> equals false", false, patata.equals(poma));

		sep("4) PLANTAR I REGAR");

		Conreu c = new Conreu();
		check("Conreu inicialment buit", null, c.conreat);

		g.plantar(c, llavorPatata);
		check("Després de plantar hi ha llavor", llavorPatata, c.conreat);
		check("Torns regada inicials", 0, c.conreat.tornsRegada);

		g.regar(c);
		g.regar(c);
		check("Després de 2 regs encara no està madura", 2, c.conreat.tornsRegada);

		sep("5) EXCEPCIO EN COLLIR: CONREU NO MADUR");

		try {
			g.collir(c);
			System.out.println("[FAIL] Hauria de llançar excepció perquè encara no està madur");
		} catch (GrangerIncompetentException e) {
			System.out.println("[OK]   Excepció correcta: " + e.getMessage());
		}

		sep("6) COLLIR CORRECTAMENT + BOSSA");

		g.regar(c);
		check("Ara ja està prou regat", 3, c.conreat.tornsRegada);

		Hortalissa collida = g.collir(c);
		check("Collir retorna la patata", patata, collida);
		check("La bossa té 1 element després de collir", 1, g.bossa.size());
		check("L'element 0 de la bossa és la patata", patata, g.bossa.get(0));
		check("Conreu buit després de collir (si has triat buidar-lo)", null, c.conreat);

		sep("7) BOSSA REMOVE VEN L'HORTALISSA");

		check("Mida de la bossa abans de remove", 1, g.bossa.size());
		Hortalissa venuda = g.bossa.remove(0);
		check("remove retorna l'hortalissa retirada", patata, venuda);
		check("Mida de la bossa després de remove", 0, g.bossa.size());

		sep("8) EXCEPCIO EN COLLIR: CONREU SENSE LLAVOR");

		try {
			g.collir(c);
			System.out.println("[FAIL] Hauria de llançar excepció perquè el conreu és buit");
		} catch (GrangerIncompetentException e) {
			System.out.println("[OK]   Excepció correcta: " + e.getMessage());
		}

		sep("9) PROPOSTA DE PARELLA");

		checkB("PersonatgeNoCasable rebutja sempre", false, pierre.propostaParella(g));
		check("La parella del granger continua sent null", null, g.parella);

		checkB("Abigail encara rebutja amb apreci insuficient", false, abigail.propostaParella(g));

		while (abigail.getApreci() < abigail.getApreciMaxim()) {
			g.regalar(abigail, patata);
		}

		check("Apreci d'Abigail al màxim", 10, abigail.getApreci());
		checkB("Abigail accepta la proposta", true, abigail.propostaParella(g));
		check("La parella del granger és Abigail", abigail, g.parella);

		sep("10) FUCKABLE / CASAR");

		checkB("Granger inicialment no casat", false, g.casat);
		checkB("Abigail inicialment no casada", false, abigail.casat);

		g.casar(abigail);
		checkB("Granger queda casat", true, g.casat);
		checkB("Abigail queda casada", true, abigail.casat);

		sep("11) VENDRE");

		check("Vendre llavor retorna 0", 0, llavorPoma.vendre());
		check("Vendre hortalissa retorna el preu", 15, poma.vendre());

		sep("12) COMPARABLE: ORDENAR PER PREU");

		g.bossa.add(poma);   // 15 FRUITA
		g.bossa.add(blat);   // 8 CEREAL
		g.bossa.add(col);    // 12 VERDURA
		g.bossa.add(patata); // 10 TUBERCLE

		System.out.println("Bossa abans d'ordenar: " + g.bossa);
		Collections.sort(g.bossa);
		System.out.println("Bossa després d'ordenar: " + g.bossa);

		check("Primer per preu: Blat", blat, g.bossa.get(0));
		check("Segon per preu: Patata", patata, g.bossa.get(1));
		check("Tercer per preu: Col", col, g.bossa.get(2));
		check("Quart per preu: Poma", poma, g.bossa.get(3));

		sep("13) COMPARABLE: MATEIX PREU, ORDRE PER TIPUS");

		Hortalissa t = new Hortalissa("T", Tipus.TUBERCLE, 20);
		Hortalissa c2 = new Hortalissa("C", Tipus.CEREAL, 20);
		Hortalissa v = new Hortalissa("V", Tipus.VERDURA, 20);
		Hortalissa f = new Hortalissa("F", Tipus.FRUITA, 20);

		g.bossa.clear();
		g.bossa.add(f);
		g.bossa.add(v);
		g.bossa.add(c2);
		g.bossa.add(t);

		System.out.println("Bossa abans d'ordenar amb mateix preu: " + g.bossa);
		Collections.sort(g.bossa);
		System.out.println("Bossa després d'ordenar amb mateix preu: " + g.bossa);

		check("Ordre 1: TUBERCLE", t, g.bossa.get(0));
		check("Ordre 2: CEREAL", c2, g.bossa.get(1));
		check("Ordre 3: VERDURA", v, g.bossa.get(2));
		check("Ordre 4: FRUITA", f, g.bossa.get(3));

		sep("FI DEL TEST COMPLET");
		System.out.println("Si la majoria surt [OK], la part basica i l'avancada pinten be.");
	}
}
