package examen;

import java.util.ArrayDeque;

public class Mercat {
	private static Mercat instance;
	private static String nom;
	private int diners;
	private static final int MAX_TRANSACCIONS = 4;
	
	private int transaccions;
	
	ArrayDeque<Cultiu> historial = new ArrayDeque<Cultiu>();
	
	private static int PREU_FINAL;
	
	private Mercat(String nom, int diners) {
		Mercat.nom = nom;
		this.diners = diners;
	}

	public static Mercat getInstance(String nom, int diners) {
		if (instance == null) {
			instance = new Mercat(nom, diners);
		}
		return instance;
	}
	

	public void comprar(Cultiu cultiu) {
		if(transaccions == MAX_TRANSACCIONS) {
			System.out.println("El mercat ha tancat per avui!");
			return;
		}
		diners -= cultiu.preu;
		transaccions++;
		System.out.println("Comprant al mercat: " + nom + ". Diners restants: " + diners + ". Transaccio " + transaccions + "/4");
	}
	
	public void vendre(Cultiu cultiu) {
		if(cultiu.qualitat.equals(Qualitat.OR)) {
			PREU_FINAL = (int) (cultiu.preu * 1.5);
		}else {
			PREU_FINAL = cultiu.preu;
		}
		
		diners+= PREU_FINAL;
		
		
		
		historial.push(cultiu);
		
		System.out.println("Venent " + cultiu + " per " + PREU_FINAL + "G.");
	}
	
	public void desferVenda() {
		if(historial.isEmpty()) {
			System.out.println("no hi ha vendes per desfer.");
			return;
		}
		
		if(historial.peek().qualitat.equals(Qualitat.OR)) {
			PREU_FINAL = (int) (historial.peek().preu * 1.5);
		}else {
			PREU_FINAL = historial.peek().preu;
		}
		
		diners -= PREU_FINAL;
		System.out.println("Devolució de " + historial.peek() + ". Diners retornats: " +  PREU_FINAL + "G.");
		
		historial.poll();
	}

	@Override
	public String toString() {
		return "Mercat [Nom="+ nom +" diners=" + diners + "]";
	}
	
	
	
	
	
	
}
