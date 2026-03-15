package mokepon6;

import java.util.Objects;

public class Atacs implements Comparable<Atacs> {

	String nom;
	double poder;
	Tipus tipus;
	int moviments_maxims;
	int moviments_actuals;

	public Atacs(String nom, double poder, Tipus tipus, int moviments_maxims) {
		this.nom = nom;
		this.poder = poder;
		this.tipus = tipus;
		this.moviments_maxims = moviments_maxims;
		this.moviments_actuals = this.moviments_maxims;
		
		if(this.poder < 10) {
			this.poder = 10;
		}else if(this.poder > 100) {
			this.poder = 100;
		}
	}
	
	public Atacs(String nom, Tipus tipus){
		this.nom = nom;
		this.tipus = tipus;
		this.poder = 10;
		this.moviments_maxims = 10;
		this.moviments_actuals = this.moviments_maxims;
	}

	@Override
	public String toString() {
		return "Atacs [nom=" + nom + ", poder=" + poder + ", tipus=" + tipus + ", moviments_maxims=" + moviments_maxims
				+ ", moviments_actuals=" + moviments_actuals + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moviments_actuals, moviments_maxims, nom, poder, tipus);
	}

	@Override
	public boolean equals(Object obj) {
		//si els dos objectes son el mateix objecte torna true
		if (this == obj)
			return true;
		//si l'objecte passat es null torna false
		if (obj == null)
			return false;
		//si l'objecte passat es d'una classe diferent a atac torna false
		if (getClass() != obj.getClass())
			return false;
		//casteja l'objecte a atac
		Atacs other = (Atacs) obj;
		//compara tots els atributs d'aquest objecte amb els de l'altre objecte
		if(tipus==other.tipus && nom.equals(other.nom)&&poder==other.poder&&moviments_actuals==other.moviments_actuals&&moviments_maxims==other.moviments_maxims) {
				return true;
			}else {
				return false;
			}
	}
	
	@Override
    public int compareTo(Atacs arg0) {
		//castejo l'altre objecte a Atac
        Atacs altre = (Atacs) arg0;
        //comparo per poder. si l'altre té més poder, soc mes petit
        if(altre.poder>this.poder) {
		return -1;
	  }else if(this.poder>altre.poder) {
		return 1;
        }//si tenen el mateix poder comparem per nom
        else
	  {//com que nom es una string i string te el seu propi compareTo, el podem fer servir
		return this.nom.compareTo(altre.nom);
	  }
    }

	
	
	
	
}
