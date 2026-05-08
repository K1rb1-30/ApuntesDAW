package overcooked1;

public class Restaurant {
	
	 //atributs del restaurant
    private static Restaurant instance;
    private static String nom;
    private static Comandes cm = new Comandes();
    private static PlatsBruts pb = new PlatsBruts();
    
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
	
	public void afegirComanda(Plat p) {
		cm.add(p);
	}
	
	public Plat servirComanda() {
		return null;
	}
	
	public void afegirPlatBrut(Plat p) {
		pb.add(p);
	}
	
	public void iniciarRentatAutomatic() throws InterruptedException {
		while(pb.size() > 0) {
			System.out.println(pb.poll());
			Thread.sleep(3000);
			System.out.println("Plato Limpio");
		}
		
		System.out.println("Todos los platos se han limpiado correctamente");
		
	}

}
