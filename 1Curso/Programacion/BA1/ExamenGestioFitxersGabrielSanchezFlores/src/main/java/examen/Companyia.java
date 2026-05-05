package examen;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder = { "nom","personatges"})
public class Companyia {
	String nom;
	ArrayList<Personatge> personatges;
	
	public Companyia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Companyia(String nom, ArrayList<Personatge> personatges) {
		super();
		this.nom = nom;
		this.personatges = personatges;
	}

	//es un atribut. els atributs son els que es posen a la propia etiqueta arrel
	@XmlAttribute
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//l'element XML que fa d'embolcall es diu entrades
	@XmlElementWrapper(name="personatges")
	//cada element individual es diu entrada
	@XmlElement(name="personatge")  
	public ArrayList<Personatge> getPersonatges() {
		return personatges;
	}

	public void setPersonatges(ArrayList<Personatge> personatges) {
		this.personatges = personatges;
	}

	@Override
	public String toString() {
		return "Companyia [nom=" + nom + ", personatges=" + personatges + "]";
	}
	
	
	
	
}
