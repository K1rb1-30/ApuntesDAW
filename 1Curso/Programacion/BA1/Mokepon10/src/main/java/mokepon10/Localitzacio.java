package mokepon10;

import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

//l'element es diu persona en el XML
//@XmlRootElement (name = "localitzacio")
//l'ordre en que apareixeran els seus elements interns en el XML
//@XmlType(propOrder = {"localitzacio","tipus"})
public class Localitzacio {
	String nom;

	public Localitzacio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Localitzacio(String nom) {
		super();
		this.nom = nom;
	}
	
	@XmlValue
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
