package mok10;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



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

  public int getId(){
      return id;
  }
  public void setId(int id){
      this.id = id;
  }

  public String getNom() {
      return nom;
  }
  public void setNom(String nom) {
      this.nom = nom;
  }

  public String getTipus() {
      return tipus;
  }
  
  public void setTipus(String t) {
      this.tipus = t;
  }

  public double getPes() {
	return pes;
  }
  public void setPes(double pes) {
	this.pes = pes;
  }
  
  public Evolucions getEvolucions() {
	return evolucions;
  }
  public void setEvolucions(Evolucions evolucions) {
	this.evolucions = evolucions;
  }
  
  public ArrayList<Localitzacio> getLocalitzacions() {
	return localitzacions;
  }
  public void setLocalitzacions(ArrayList<Localitzacio> localitzacions) {
	this.localitzacions = localitzacions;
  }
  
  
  
  
  
}

