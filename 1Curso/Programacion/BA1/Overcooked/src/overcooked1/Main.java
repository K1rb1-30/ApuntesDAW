package overcooked1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Restaurant r1 = Restaurant.getInstance("El bistreau de DAMvi");
//		r1.obrirRestaurant();
//		Restaurant r2 = Restaurant.getInstance("La cuina de DAM");
//		r2.obrirRestaurant();
		
		Restaurant restaurant = Restaurant.getInstance("El bistreau de DAMvi");
		restaurant.obrirRestaurant();
		Cuiner cuiner = new Cuiner("Dani",0);
		Plat plat = new Plat("Pizza");
		cuiner.cuinar(plat);
	       
	       
	}

}
