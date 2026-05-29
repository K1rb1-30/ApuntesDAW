package examen;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MainTest {
	public static void main(String[] args) {

        // ============================================================
        // EX. 1 - LISTITERATOR
        // ============================================================
        System.out.println("=== EX. 1 - LISTITERATOR ===");
        List<Cultiu> cultius = new ArrayList<>();
        
        Verdura nap = new Verdura("Nap",      6,  35,  "Primavera", Qualitat.NORMAL);
        Verdura coliflor = new Verdura("Coliflor", 12, 175, "Primavera", Qualitat.PLATA);
        Fruita maduixa = new Fruita("Maduixa",   8,  120, "Primavera", Qualitat.NORMAL);
        Fruita melo = new Fruita("Meló",     12, 250, "Estiu",     Qualitat.OR);
        Flor tulipa = new Flor("Tulipa",      6,  30,  "Primavera", Qualitat.NORMAL);
        
        cultius.add(nap);
        cultius.add(melo);
        cultius.add(maduixa);
        cultius.add(new Fruita("Nabiu",     13, 80,  "Estiu",     Qualitat.PLATA));
        cultius.add(new Flor("Fada",        12, 100, "Estiu",     Qualitat.OR));
        cultius.add(tulipa);
        cultius.add(coliflor);

        System.out.println("La teva sortida:   " + cultius);
        System.out.println("Sortida esperada:  [Verdura [nom=Nap, dies=6, preu=35, estació=Primavera, qualitat=NORMAL], Fruita [nom=Meló, dies=12, preu=250, estació=Estiu, qualitat=OR], Fruita [nom=Maduixa, dies=8, preu=120, estació=Primavera, qualitat=NORMAL], Fruita [nom=Nabiu, dies=13, preu=80, estació=Estiu, qualitat=PLATA], Flor [nom=Fada, dies=12, preu=100, estació=Estiu, qualitat=OR], Flor [nom=Tulipa, dies=6, preu=30, estació=Primavera, qualitat=NORMAL], Verdura [nom=Coliflor, dies=12, preu=175, estació=Primavera, qualitat=PLATA]]");
        System.out.println();

        netejaPerEstacio(cultius, "Primavera");
        System.out.println("La teva sortida:   " + cultius);
        System.out.println("Sortida esperada:  [Verdura [nom=Nap, dies=6, preu=35, estació=Primavera, qualitat=NORMAL], Fruita [nom=Maduixa, dies=8, preu=120, estació=Primavera, qualitat=NORMAL], Flor [nom=Tulipa, dies=6, preu=30, estació=Primavera, qualitat=NORMAL], Verdura [nom=Coliflor, dies=12, preu=175, estació=Primavera, qualitat=PLATA]]");
        System.out.println();

        // ============================================================
        // EX. 2 - CALAIX (CUA)
        // ============================================================
        System.out.println("=== EX. 2 - CALAIX ===");
        Calaix calaix = new Calaix();
        calaix.dipositar(nap);
        calaix.dipositar(coliflor);
        calaix.dipositar(maduixa);
        calaix.dipositar(melo);
        calaix.dipositar(tulipa); // descarta "Nap"
        System.out.println("La teva sortida:   " + calaix);
        System.out.println("Sortida esperada:  [Verdura [nom=Coliflor, dies=12, preu=175, estació=Primavera, qualitat=PLATA], Fruita [nom=Maduixa, dies=8, preu=120, estació=Primavera, qualitat=NORMAL], Fruita [nom=Meló, dies=12, preu=250, estació=Estiu, qualitat=OR], Flor [nom=Tulipa, dies=6, preu=30, estació=Primavera, qualitat=NORMAL]]");

        calaix.vendre();
        System.out.println("Sortida esperada:  Vens Coliflor");
        System.out.println("La teva sortida:   " + calaix);
        System.out.println("Sortida esperada:  [Fruita [nom=Maduixa, dies=8, preu=120, estació=Primavera, qualitat=NORMAL], Fruita [nom=Meló, dies=12, preu=250, estació=Estiu, qualitat=OR], Flor [nom=Tulipa, dies=6, preu=30, estació=Primavera, qualitat=NORMAL]]");

        calaix.vendre();
        System.out.println("Sortida esperada:  Vens Maduixa");
        calaix.vendre();
        System.out.println("Sortida esperada:  Vens Meló per un bon preu!");
        System.out.println("La teva sortida:   " + calaix);
        System.out.println("Sortida esperada:  [Fruita [nom=Meló, dies=12, preu=250, estació=Estiu, qualitat=OR], Flor [nom=Tulipa, dies=6, preu=30, estació=Primavera, qualitat=NORMAL]]");
        System.out.println();

        // ============================================================
        // EX. 3 - SINGLETON
        // ============================================================
        System.out.println("=== EX. 3 - SINGLETON ===");
        Mercat m1 = Mercat.getInstance("Mercat de Pierre", 1000);

        m1.comprar(new Verdura("Meló",     12, 250, "Estiu",     Qualitat.OR));
        System.out.println("Sortida esperada:  Comprant al mercat: Mercat de Pierre. Diners restants: 750. Transacció 1/4");

        m1.comprar(new Fruita("Maduixa",   8,  120, "Primavera", Qualitat.NORMAL));
        System.out.println("Sortida esperada:  Comprant al mercat: Mercat de Pierre. Diners restants: 630. Transacció 2/4");

        Mercat m2 = Mercat.getInstance("Mercat de Willy", 500);
        m2.comprar(new Flor("Fada",        12, 100, "Estiu",     Qualitat.OR));
        System.out.println("Sortida esperada:  Comprant al mercat: Mercat de Pierre. Diners restants: 530. Transacció 3/4");

        m2.comprar(new Verdura("Coliflor", 12, 175, "Primavera", Qualitat.PLATA));
        System.out.println("Sortida esperada:  Comprant al mercat: Mercat de Pierre. Diners restants: 355. Transacció 4/4");

        m1.comprar(new Fruita("Nabiu",     13, 80,  "Estiu",     Qualitat.PLATA));
        System.out.println("Sortida esperada:  El mercat ha tancat per avui!");

        System.out.println("La teva sortida:   " + (m1 == m2));
        System.out.println("Sortida esperada:  true");
        System.out.println();

        m1.vendre(new Verdura("Nap",   6,  35,  "Primavera", Qualitat.NORMAL));
        System.out.println("Sortida esperada:  Venent Verdura [nom=Nap, dies=6, preu=35, estació=Primavera, qualitat=NORMAL] per 35G.");

        m1.vendre(new Fruita("Raïm",  10, 80,  "Tardor",    Qualitat.OR));
        System.out.println("Sortida esperada:  Venent Fruita [nom=Raïm, dies=10, preu=80, estació=Tardor, qualitat=OR] per 120G.");

        m1.vendre(new Flor("Rosella",  7,  50,  "Primavera", Qualitat.PLATA));
        System.out.println("Sortida esperada:  Venent Flor [nom=Rosella, dies=7, preu=50, estació=Primavera, qualitat=PLATA] per 50G.");

        System.out.println("La teva sortida:   " + m1);
        System.out.println("Sortida esperada:  Mercat [nom=Mercat de Pierre, diners=560]");

        m1.desferVenda();
        System.out.println("Sortida esperada:  Devolució de Flor [nom=Rosella, dies=7, preu=50, estació=Primavera, qualitat=PLATA]. Diners retornats: 50G.");

        m1.desferVenda();
        System.out.println("Sortida esperada:  Devolució de Fruita [nom=Raïm, dies=10, preu=80, estació=Tardor, qualitat=OR]. Diners retornats: 120G.");

        m1.desferVenda();
        System.out.println("Sortida esperada:  Devolució de Verdura [nom=Nap, dies=6, preu=35, estació=Primavera, qualitat=NORMAL]. Diners retornats: 35G.");

        m1.desferVenda();
        System.out.println("Sortida esperada:  No hi ha vendes per desfer.");

        System.out.println("La teva sortida:   " + m1);
        System.out.println("Sortida esperada:  Mercat [nom=Mercat de Pierre, diners=355]");
    }
    // TODO EX. 1
    public static void netejaPerEstacio(List<Cultiu> cultius, String estacio) {
        // ... el teu codi aquí
    	
    	ListIterator<Cultiu> iterator = cultius.listIterator();
		
		while (iterator.hasNext()) {
			
			if(!iterator.next().estacio.equals(estacio)) {
				iterator.remove();
			}
		}
		
		System.out.println("Se a acabado de limpiar");
	
    }
}
