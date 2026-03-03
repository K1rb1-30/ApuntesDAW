package mokepon2;

public class MokeponCapturat extends Mokepon {
	//posem només els atributs nous, no els de Mokepon. És a dir, posem els atributs que tindrà MokeponCapturat, però no Mokepon
	String nomPosat;
	String nomEntrenador;
	int felicitat;
	
	
	
	
    public MokeponCapturat(String nom, Tipus tipus) {
        //cridem al constructor idèntic del pare
        super(nom, tipus);
        //la resta de variables les posem nosaltres
        this.nomPosat = nom;
        this.nomEntrenador = "Marc";
        this.felicitat = 50;
    }
    
    public MokeponCapturat() {
    	super();
    	
    	
    	this.nomPosat = "Sense definir";
        this.nomEntrenador = "Sense definir";
        this.felicitat = 1;
    }
    
    public MokeponCapturat(Mokepon mok, String nomPosat, String nomEntrenador) {
    	super(mok.nom, mok.nivell, mok.hp_max, mok.atk, mok.def, mok.vel);
    	
    	this.nomPosat = nomPosat;
    	this.nomEntrenador = nomEntrenador;
    	this.felicitat = 50;
    }
    
    public void mote() {
    	System.out.println("Este " + this.nom + " tiene de mote " + this.nomPosat);
    }
    
    public void acariciar() {
    	if(this.felicitat < 100) {
    		this.felicitat += 10;
    	}
    }
    
    public void atacar(Mokepon atacat, int num_atac) {
		
		if(this.debilitat == false && this.Atacs.get(num_atac).moviments_actuals > 0) {
			
			System.out.println(this.nom + " ataca con " + this.Atacs.get(num_atac).nom + " a " + atacat.nom + " rival");
			
			double dany = ((((((2 * this.nivell) / 5) + 2) * this.Atacs.get(num_atac).poder * (this.atk / atacat.def))/50) + 2) * super.efectivitat(this.Atacs.get(num_atac).tipus, atacat.tipus);
			
			if(this.felicitat >= 50) {
				dany *= 1.2;
			}else {
				dany *= 0.8;
			}
			
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

}
