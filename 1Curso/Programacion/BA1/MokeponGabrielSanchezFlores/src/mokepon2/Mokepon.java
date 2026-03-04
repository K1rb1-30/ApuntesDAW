package mokepon2;

import java.util.ArrayList;
import java.util.Random;

public class Mokepon {
	//atributs del pokemon
    private String nom;
    private int nivell;
    private int atk;
    private int def;
    private int vel;
    
    private int exp;
    private int hp_max;
    private int hp_actual;
    private Tipus tipus;
    
    boolean debilitat;
    
    ArrayList<Atacs> Atacs = new ArrayList<>();
    
    //fixa't que el constuctor no té retorn, ja que el que retorna es la propia classe
    public Mokepon() {
        this.nom = "Sense definir";
        this.nivell = 1;
        this.atk = 1;
        this.def = 1;
        this.vel = 1;
        this.debilitat = false;
    }
    
    //podem crear múltiples constructors sempre que tinguin paràmetres diferents
    public Mokepon(String nom) {
        //this.nom fa referència a la variable global i nom a la local que hem passat per paràmetre
        this.nom = nom;
        this.nivell = 1;
        this.atk = 1;
        this.def = 1;
        this.vel = 1;
        this.hp_max = 10;
        this.hp_actual = 10;
        this.debilitat = false;
    }
    
    public Mokepon(String nom, int nivell) {
        //aquest constructor crida al constructor de nom primer, per això el this(nom), amb el que farà tot el que el constructor de nom digui
        this(nom);
        //podem fer fors dintre d'un constructor com si fos una funció normal
        for (int i = 1; i < nivell; i++) {
            //podem cridar a funcions de la nostra propia classe amb el this
            this.pujarNivell();
        }
    }
    
    public Mokepon(String nom, int nivell, int hp_max, int atk, int def, int vel) {
    	this(nom, nivell);
    	this.hp_max = hp_max;
    	this.hp_actual = this.hp_max;
    	this.atk = atk;
    	this.def = def;
    	this.vel = vel;
    }
    
    
    //podem crear múltiples constructors sempre que tinguin paràmetres diferents
    public Mokepon(String nom, Tipus tipus) {
        //this.nom fa referència a la variable global i nom a la local que hem passat per paràmetre
        this(nom);
        this.tipus = tipus;
    }


    
    public void atorgarExperiencia(int exp_atorgada) {
    	this.exp += exp_atorgada;
    	
    	while(this.exp> 100) {
    		this.exp -= 100;
    		pujarNivell();
    	}
    }
    
    public void pujarNivell() {
		// TODO Auto-generated method stub
    	Random r = new Random();
		this.nivell++;
		this.hp_max = r.nextInt(0, 6);
		this.atk = r.nextInt(0, 3);
		this.def = r.nextInt(0, 3);
		this.vel = r.nextInt(0, 3);
	}

	public void diguesNom() {
        //per a accedir a un atribut fem this.nomDeLAtribut
        //this es una paraula especial que fa referencia a nosaltres mateixos.
        System.out.println(this.nom);
    }
	
	public void afegirAtac(Atacs at) {
		if(this.Atacs.size()<2) {
			this.Atacs.add(at);
		}
	}
	
	public double efectivitat(Tipus atac, Tipus defensa) {
        if(atac == Tipus.FOC && defensa == Tipus.AIGUA ||atac == Tipus.AIGUA && defensa == Tipus.PLANTA ||atac == Tipus.PLANTA && defensa == Tipus.FOC ) {
            return 0.5;
        }else if (atac == Tipus.AIGUA && defensa == Tipus.FOC ||atac == Tipus.FOC && defensa == Tipus.PLANTA ||atac == Tipus.PLANTA && defensa == Tipus.AIGUA ) {
            return 2;
        }else {
            return 1;
        }        
    }
	
	public void atacar(Mokepon atacat, int num_atac) {
		
		if(this.debilitat == false && this.Atacs.get(num_atac).moviments_actuals > 0) {
			
			System.out.println(this.nom + " ataca con " + this.Atacs.get(num_atac).nom + " a " + atacat.nom + " rival");
			
			double dany = ((((((2 * this.nivell) / 5) + 2) * this.Atacs.get(num_atac).poder * (this.atk / atacat.def))/50) + 2) * efectivitat(this.Atacs.get(num_atac).tipus, atacat.tipus);

			atacat.hp_actual -= (int) dany;
			
			this.Atacs.get(num_atac).moviments_actuals--; //
			
//			System.out.println(efectivitat(this.Atacs.get(num_atac).tipus, atacat.tipus));
			
			System.out.println(this.nom + " le ha hecho " + (int) dany + " al " + atacat.nom + " del rival");
			
		}else if(this.debilitat == false && this.Atacs.get(num_atac).moviments_actuals <= 0){
			System.out.println("No te quedan mas PP de este movimiento");
		}else if(this.debilitat == true){
			System.out.println("Tu pokemon esta muerto y no puede atacar");
		}
		
		
	}
	
	public void debilitarse() {
		this.debilitat = true;
	}
	
	public void curar() {
		if(this.debilitat == true) {
			this.debilitat = false;
		}
		System.out.println("HP del Mokepon restaurada al maxim.");
		this.hp_actual = this.hp_max;
	}
	
	public MokeponCapturat capturar(String nomEntrenador, String nomDonat) {
		if(!(this instanceof MokeponCapturat)) {
			System.out.println(this.nom + " ha sigut capturat");
			MokeponCapturat poke = new MokeponCapturat(this, nomDonat, nomEntrenador);
			return poke;
		}else {
			 //El mokepon ja està capturat. No el pots tornar.
            System.out.println("No pots capturar un Mokepon que ja esta capturat");
            
          //podem castejar perque estem segurs de que es un MokeponCapturat gracies al instanceof
            return (MokeponCapturat) this;
		}
		
	}


}
