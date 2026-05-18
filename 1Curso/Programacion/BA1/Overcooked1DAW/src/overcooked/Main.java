package overcooked;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		Restaurant r1 = Restaurant.getInstance("El bistreau de DAW");
//		r1.obrirRestaurant();
//		Restaurant r2 = Restaurant.getInstance("La cuina de DAM");
//		r2.obrirRestaurant();
		
//		Restaurant restaurant = Restaurant.getInstance("El bistreau de DAW");
//		restaurant.obrirRestaurant();
//	      
//		Cuiner cuiner = new Cuiner("Dani",0);
//		Plat plat = new Plat("Pizza");
//		cuiner.cuinar(plat);
//  
//		Cuiner cuinera = new Cuiner("Claudia", 1);
//		Plat plat2 = new Plat("Paella");
//		cuinera.cuinar(plat2);
		
		Restaurant r = Restaurant.getInstance("El bistreau de DAW");
	   	r.afegirComanda(new Plat("Pizza"));
	   	r.afegirComanda(new Plat("Pasta"));
	   	r.afegirComanda(new Plat("Amanida"));
	   	
	   	r.afegirPlatBrut(new Plat("Plat de prova 1"));
	   	r.afegirPlatBrut(new Plat("Plat de prova 2"));
	   	
	   	System.out.println("Servint: " + r.servirComanda());
	   	System.out.println("Servint: " + r.servirComanda());
	   	
	   	r.iniciarRentatAutomatic();
	}

}
