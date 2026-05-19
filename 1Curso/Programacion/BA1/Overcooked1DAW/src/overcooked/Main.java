package overcooked;

import java.util.Iterator;

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
		
//		Restaurant r = Restaurant.getInstance("El bistreau de DAW");
//	   	r.afegirComanda(new Plat("Pizza"));
//	   	r.afegirComanda(new Plat("Pasta"));
//	   	r.afegirComanda(new Plat("Amanida"));
//	   	
//	   	r.afegirPlatBrut(new Plat("Plat de prova 1"));
//	   	r.afegirPlatBrut(new Plat("Plat de prova 2"));
//	   	
//	   	System.out.println("Servint: " + r.servirComanda());
//	   	System.out.println("Servint: " + r.servirComanda());
//	   	
//	   	r.iniciarRentatAutomatic();
		
//		Restaurant r = Restaurant.getInstance("El bistreau de DAW");
//	   	r.obrirRestaurant();
//	   	
//	   	r.afegirComanda(new Plat("Pizza"));
//	   	r.afegirComanda(new Plat("Pasta"));
//	   	r.afegirComanda(new Plat("Amanida"));
//	   	
//	   	Cuiner c1 = new Cuiner("Dani", 0);
//	   	Cuiner c2 = new Cuiner("Maria", 1);
//	   	
//	   	c1.cuinar("El bistreau de DAMvi");
//	   	c2.cuinar("El bistreau de DAMvi");
//	   	c1.cuinar("El bistreau de DAMvi");
//	   	
//	   	r.iniciarRentatAutomatic();
	   	
	   	
//	   	Restaurant r = Restaurant.getInstance("El bistreau de DAW");
//	   	
//	   	r.afegirComanda(new Plat("Pizza"));
//	   	r.afegirComanda(new Plat("Pasta"));
//	   	r.afegirComanda(new Plat("Pizza"));
//	   	r.afegirComanda(new Plat("Amanida"));
//	   	
//	   	r.llistarComandes();
		
//		Restaurant r = Restaurant.getInstance("El bistreau de DAW");
//	   	
//	   	r.afegirComanda(new Plat("Pizza"));
//	   	r.afegirComanda(new Plat("Pasta"));
//	   	r.afegirComanda(new Plat("Pizza"));
//	   	r.afegirComanda(new Plat("Amanida"));
//	   	
//	   	r.llistarComandes();
//	   	r.cancelarComanda("Pizza");
//	   	r.llistarComandes();
		
		Restaurant r = Restaurant.getInstance("Restaurant Gabriel");
		
		r.afegirComanda(new Plat("Pizza"));
		r.afegirComanda(new Plat("Esparragos"));
		r.afegirComanda(new Plat("Macarrones"));
		r.afegirComanda(new Plat("Helado"));
		r.afegirComanda(new Plat("Patatas"));
		
		r.llistarComandes();
		
		r.cancelarComanda("Pizza");
		
		
		Cuiner c1 = new Cuiner("Ash", 0);
		Cuiner c2 = new Cuiner("Misty",1);
		
		System.out.println(" ");
		
		r.llistarComandes();
		
		System.out.println(" ");
		
		int midaReal = r.getComandaments().mida();
		
		for (int i = 0; i < midaReal; i++) {
			if(i % 2 == 0) {
				c1.cuinar("Restaurant Gabriel");
			}else {
				c2.cuinar("Restaurant Gabriel");
			}
		}
		
		r.iniciarRentatAutomatic();
	   	
	   	
	   	
	   	
	   	
	}

}
