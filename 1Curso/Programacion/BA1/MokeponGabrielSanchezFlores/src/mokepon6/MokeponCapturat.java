package mokepon6;

import java.util.Objects;

import objectes.*;

public class MokeponCapturat extends Mokepon{
	//posem només els atributs nous, no els de Mokepon. És a dir, posem els atributs que tindrà MokeponCapturat, però no Mokepon
	private String nomPosat;
	private String nomEntrenador;
	private int felicitat;
	
	static int NombreMokeponsCapturats = 0;
	
	private Objecte objecte;
	private Equipament objecteEquipat;
	
	
	
    public MokeponCapturat(String nom, Tipus tipus) {
        //cridem al constructor idèntic del pare
        super(nom, tipus);
        //la resta de variables les posem nosaltres
        this.nomPosat = nom;
        this.nomEntrenador = "Marc";
        this.felicitat = 50;
        NombreMokeponsCapturats++;
    }
    
    public MokeponCapturat() {
    	super();
    	
    	
    	this.nomPosat = "Sense definir";
        this.nomEntrenador = "Sense definir";
        this.felicitat = 1;
        NombreMokeponsCapturats++;
    }
    
    public MokeponCapturat(Mokepon mok, String nomPosat, String nomEntrenador) {
    	super(mok.getNom(), mok.getNivell(), mok.getHp_max(), mok.getAtk(), mok.getDef(), mok.getVel());
    	
    	this.nomPosat = nomPosat;
    	this.nomEntrenador = nomEntrenador;
    	this.felicitat = 50;
    	NombreMokeponsCapturats++;
    }
    
    public void mote() {
    	System.out.println("Este " + this.getNom() + " tiene de mote " + this.getNomPosat());
    }
    
    public void acariciar() {
    	if(this.felicitat < 100) {
    		this.felicitat += 10;
    	}
    }
    
    public void atacar(Mokepon atacat, int num_atac) {
		
		if(this.debilitat == false && this.Atacs.get(num_atac).moviments_actuals > 0) {
			
			System.out.println(this.getNom() + " ataca con " + this.Atacs.get(num_atac).nom + " a " + atacat.getNom() + " rival");
			
			double dany = ((((((2 * this.getNivell()) / 5) + 2) * this.Atacs.get(num_atac).poder * (this.getAtk() / atacat.getDef()))/50) + 2) * super.efectivitat(this.Atacs.get(num_atac).tipus, atacat.getTipus());
			
			if(this.felicitat >= 50) {
				dany *= 1.2;
			}else {
				dany *= 0.8;
			}
			
			atacat.setHp_actual(atacat.getHp_actual() - (int) dany);
			
			this.Atacs.get(num_atac).moviments_actuals--; //
			
//			System.out.println(efectivitat(this.Atacs.get(num_atac).tipus, atacat.tipus));
			
			System.out.println(this.getNom() + " le ha hecho " + (int) dany + " al " + atacat.getNom() + " del rival");
			
		}else if(this.debilitat == false && this.Atacs.get(num_atac).moviments_actuals <= 0){
			System.out.println("No te quedan mas PP de este movimiento");
		}else if(this.debilitat == true){
			System.out.println("Tu pokemon esta muerto y no puede atacar");
		}
		
		
	}
    
    public void utilitzaObjecte() {
    	this.getObjecte().utilitzar(this);
    }
    
    
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nomEntrenador, nomPosat);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MokeponCapturat other = (MokeponCapturat) obj;
		return Objects.equals(nomEntrenador, other.nomEntrenador) && Objects.equals(nomPosat, other.nomPosat);
	}
	
	

	@Override
	public String toString() {
		return "MokeponCapturat [nomPosat=" + nomPosat + ", nomEntrenador=" + nomEntrenador + ", felicitat=" + felicitat
				+ "]";
	}

	public String getNomEntrenador() {
		return nomEntrenador;
	}

	public void setNomEntrenador(String nomEntrenador) {
		this.nomEntrenador = nomEntrenador;
	}
	

	public String getNomPosat() {
		return nomPosat;
	}

	public void setNomPosat(String nomPosat) {
		this.nomPosat = nomPosat;
	}

	public Objecte getObjecte() {
		return objecte;
	}

	public void setObjecte(Objecte objecte) {
		this.objecte = objecte;
	}

	public Equipament getObjecteEquipat() {
		return objecteEquipat;
	}

	public void setObjecteEquipat(Equipament objecteEquipat) {
		this.objecteEquipat = objecteEquipat;
	}
    
    

}
