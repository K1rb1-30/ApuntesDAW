package overcooked1;

public class Restaurant {
	
	 //atributs del restaurant
    private static Restaurant instance;
    private static String nom;
    
    //constructor privat de restaurant
    private Restaurant(String nom) {
		Restaurant.nom=nom;
	}
    
    //mètode getInstance que es cridarà des de fora i que accedirà al constructor privat
    public static Restaurant getInstance(String nom) {
		if(instance==null) {
			instance = new Restaurant(nom);
		}
		return instance;
	}
    
    // mètodes 
	public void obrirRestaurant() {
		System.out.println("El restaurant "+nom+" està obert!");
	}
	public static String getNom() {
		return nom;
	}

}
