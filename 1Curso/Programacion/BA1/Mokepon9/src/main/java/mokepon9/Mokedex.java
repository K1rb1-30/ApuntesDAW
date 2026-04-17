package mokepon9;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "nom_entrenador","entrades"})

public class Mokedex {
	String nom_entrenador;
	List<Entrada> entrades=new ArrayList<>();
	
	


	public Mokedex() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Mokedex(String nom_entrenador) {
		super();
		this.nom_entrenador = nom_entrenador;
	}




	public Mokedex(String nom_entrenador, List<Entrada> entrades) {
		super();
		this.nom_entrenador = nom_entrenador;
		this.entrades = entrades;
	}




	//l'element XML que fa d'embolcall es diu entrades
	@XmlElementWrapper(name="entrades")
	//cada element individual es diu entrada
	@XmlElement(name="entrada")  
	public List<Entrada> getEntrades() {
	    return entrades;
	}
	
	public void setEntrades(List<Entrada> entrades) {
		this.entrades = entrades;
	}

	@XmlElement
	public String getNom_entrenador() {
		return nom_entrenador;
	}


	@Override
	public String toString() {
		return "Mokedex [nom_entrenador=" + nom_entrenador + ", entrades=" + entrades + "]";
	}


	public void setNom_entrenador(String nom_entrenador) {
		this.nom_entrenador = nom_entrenador;
	}


	
	
	

}
