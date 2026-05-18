package overcooked;

public class Restaurant {
	
	//atributs del restaurant
    private static Restaurant instance;
    private static String nom;
    private Comandes comandaments = new Comandes();
    private PlatsBruts platsB = new PlatsBruts();
    
    //Constructor privat: ningú de fora pot fer 'new Restaurant()'
    private Restaurant(String nom) {
		Restaurant.nom=nom;
	}
    //Punt d'acces global: mètode getInstance que es cridarà des de fora i que accedirà al constructor privat. Sempre retorna la mateixa instancia
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
	
	public Comandes getComandaments() {
		return comandaments;
	}
	public void setComandaments(Comandes comandaments) {
		this.comandaments = comandaments;
	}
	
	public void afegirComanda(Plat p) {
		this.comandaments.afegir(p);
	}
	
	public Plat servirComanda() {
		return this.comandaments.servir();
	}
	
	public void afegirPlatBrut(Plat p) {
		this.platsB.afegir(p);
	}
	
	public void iniciarRentatAutomatic() throws InterruptedException {
		while(this.platsB.mida() > 0) {
			System.out.println(this.platsB.rentar());
			Thread.sleep(3000);
			System.out.println("Plato Limpio");
		}
		
		System.out.println("Todos los platos se han limpiado correctamente");
		
	}
}
