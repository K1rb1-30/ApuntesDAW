package mokepon9;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//l'element es diu persona en el XML
@XmlRootElement (name = "entrada")
//l'ordre en que apareixeran els seus elements interns en el XML
@XmlType(propOrder = {"nom","tipus","pes","evolucions","localitzacions"})

public class Entrada {
  
  int id;
  String nom, tipus;
  double pes;
  Evolucions evolucions;
  ArrayList<Localitzacio> localitzacions = new ArrayList<>();

  public Entrada() {
	super();
	// TODO Auto-generated constructor stub
}
  public Entrada(int id, String nom, String tipus) {
	super();
	this.id = id;
	this.nom = nom;
	this.tipus = tipus;
}
  


  public Entrada(int id, String nom, String tipus, double pes, Evolucions evolucions) {
	super();
	this.id = id;
	this.nom = nom;
	this.tipus = tipus;
	this.pes = pes;
	this.evolucions = evolucions;
}
  public Entrada(int id, String nom, String tipus, double pes, Evolucions evolucions,
		ArrayList<Localitzacio> localitzacions) {
	super();
	this.id = id;
	this.nom = nom;
	this.tipus = tipus;
	this.pes = pes;
	this.evolucions = evolucions;
	this.localitzacions = localitzacions;
}
  //es un atribut. els atributs son els que es posen a la propia etiqueta arrel
  @XmlAttribute
  public int getId(){
      return id;
  }
  public void setId(int id){
      this.id = id;
  }
  //es un element. Com que no especifiquem name, s'assumeix que es diu nom
  @XmlElement
  public String getNom() {
      return nom;
  }
  public void setNom(String nom) {
      this.nom = nom;
  }


  //aquests tags es posen sempre abans del getter
  @XmlElement
  public String getTipus() {
      return tipus;
  }
  
  public void setTipus(String t) {
      this.tipus = t;
  }
  
  @XmlElement
  public double getPes() {
	return pes;
  }
  public void setPes(double pes) {
	this.pes = pes;
  }
  
  @XmlElement
  public Evolucions getEvolucions() {
	return evolucions;
  }
  public void setEvolucions(Evolucions evolucions) {
	this.evolucions = evolucions;
  }
  
  @XmlElementWrapper(name = "localitzacions")
  @XmlElement(name = "localitzacio")
  public ArrayList<Localitzacio> getLocalitzacions() {
	return localitzacions;
  }
  public void setLocalitzacions(ArrayList<Localitzacio> localitzacions) {
	this.localitzacions = localitzacions;
  }
  
  
  
  
  
}

