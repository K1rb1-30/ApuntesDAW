package mokepon9;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Evolucions pikaevo = new Evolucions("Pichu", "Raichu");
//		Localitzacio paleta = new Localitzacio("Pueblo Paleta");
//		Entrada pikachu = new Entrada(25, "Pikachu", "Electric", 6.0, pikaevo);
//		pikachu.localitzacions.add(paleta);
//		
//		Evolucions pipluaevo = new Evolucions("-", "Prinplup");
//		Entrada piplup = new Entrada(393, "Piplup", "Aigua", 5.2, pipluaevo);
//		Localitzacio veraz = new Localitzacio("Lago Veraz");
//		piplup.localitzacions.add(paleta);
//		piplup.localitzacions.add(veraz);
//		EscriureEntrada(piplup);
//		Mokedex pokedex = new Mokedex("Gabri");
//		pokedex.entrades.add(piplup);
//		pokedex.entrades.add(pikachu);
//		EscriureMokedex(pokedex);
		
//		Evolucions empoevo = new Evolucions("Prinplup", "-");
//		Entrada empoleon = new Entrada(395, "Empoleon", "Aigua", 84.5, empoevo);
//		
//		afegirMokedex("mokedex.xml", empoleon);
		
//		modificarPes("mokedex.xml", 395, 10);
//		modificarPes("mokedex.xml", 100, 1);
		
//		afegirLocalitzacio("mokedex.xml", 395, "Ciudad Plateada");
//		afegirLocalitzacio("mokedex.xml", 10, "Cueva del Team Rocket");
		
		
//		postEvolucio("mokedex.xml", 395);
//		postEvolucio("mokedex.xml", 393);
		
		
		
	}
	
	public static void Llegir() {
		File fitxerOrigen = new File("exemple2.xml");
		try {
		    // Es crea el context indicant la classe arrel
		    //hauras de posar la classe adient, clar.
		    JAXBContext jaxbContext = JAXBContext.newInstance(Entrada.class);
		    // Es crea un Unmarshaller amb el context de la classe Entrada
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    // Es fa servir el mètode unmarshal, per a obtenir les dades. Sempre s'ha de fer un casteig. fitxerOrigen es una String amb el path al fitxer
		    Entrada p = (Entrada) jaxbUnmarshaller.unmarshal(fitxerOrigen);
		} catch (JAXBException je) {
		    je.printStackTrace();
		}

	}
	
	public static void LlegirMokedex() {
		File fitxerOrigen = new File("mokedex.xml");
		try {
		    // Es crea el context indicant la classe arrel
		    //hauras de posar la classe adient, clar.
		    JAXBContext jaxbContext = JAXBContext.newInstance(Mokedex.class);
		    // Es crea un Unmarshaller amb el context de la classe Entrada
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    // Es fa servir el mètode unmarshal, per a obtenir les dades. Sempre s'ha de fer un casteig. fitxerOrigen es una String amb el path al fitxer
		    Mokedex m = (Mokedex) jaxbUnmarshaller.unmarshal(fitxerOrigen);
		} catch (JAXBException je) {
		    je.printStackTrace();
		}

	}
	
	public static void EscriureEntrada(Entrada entrada) {
		File fitxerDesti = new File("exemple2.xml");
		try{
		    //si ja has creat el jaxbContext abans per llegir no cal aquesta línea, clar.
		    JAXBContext jaxbContext = JAXBContext.newInstance(Entrada.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    // Es grava el fitxer desti amb la sortida formatada (aixo ultim s'indica en la
		    // instruccio que segueix)
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    //entrada es un objecte de tipus Entrada. fitxerDesti es una String amb el path al fitxer
		    jaxbMarshaller.marshal(entrada, fitxerDesti);


		} catch (JAXBException je) {
		            je.printStackTrace();
		}

	}
	
	public static void EscriureMokedex(Mokedex mokedex) {
		File fitxerDesti = new File("mokedex.xml");
		try{
		    //si ja has creat el jaxbContext abans per llegir no cal aquesta línea, clar.
		    JAXBContext jaxbContext = JAXBContext.newInstance(Mokedex.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    // Es grava el fitxer desti amb la sortida formatada (aixo ultim s'indica en la
		    // instruccio que segueix)
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    //entrada es un objecte de tipus Entrada. fitxerDesti es una String amb el path al fitxer
		    jaxbMarshaller.marshal(mokedex, fitxerDesti);


		} catch (JAXBException je) {
		            je.printStackTrace();
		}

	}
	
	public static void afegirMokedex(String nomFitxer, Entrada novaEntrada) {
		File fitxerDesti = new File(nomFitxer);
		try {
		    JAXBContext jaxbContext = JAXBContext.newInstance(Mokedex.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		   
		    Mokedex mokedex = (Mokedex) jaxbUnmarshaller.unmarshal(fitxerDesti);
		    
		    mokedex.getEntrades().add(novaEntrada);
		    
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    jaxbMarshaller.marshal(mokedex, fitxerDesti);
		    
		} catch (JAXBException je) {
		    je.printStackTrace();
		}
	}
	
	public static void modificarPes(String nomFitxer, int idEntrada, double pesExtra) {
		File fitxerDesti = new File(nomFitxer);
		try {
		    JAXBContext jaxbContext = JAXBContext.newInstance(Mokedex.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		   
		    Mokedex mokedex = (Mokedex) jaxbUnmarshaller.unmarshal(fitxerDesti);
		    
		    boolean encontrado = false;
		    
		    for(Entrada e : mokedex.getEntrades()) {
		    	if(e.getId() == idEntrada) {
		    		e.setPes(pesExtra + e.getPes());
		    		encontrado = true;
		    	}
		    }
		    
		    if(!encontrado) {
		    	System.out.println("Error aquesta entrada no existeix");
		    	return;
		    }
		    
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    jaxbMarshaller.marshal(mokedex, fitxerDesti);
		    
		    System.out.println("Pes modificat");
		    
		} catch (JAXBException je) {
		    je.printStackTrace();
		}
	}
	
	public static void afegirLocalitzacio(String nomFitxer, int idEntrada, String novaLoc) {
		File fitxerDesti = new File(nomFitxer);
		try {
		    JAXBContext jaxbContext = JAXBContext.newInstance(Mokedex.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		   
		    Mokedex mokedex = (Mokedex) jaxbUnmarshaller.unmarshal(fitxerDesti);
		    
		    boolean encontrado = false;
		    
		    for(Entrada e : mokedex.getEntrades()) {
		    	if(e.getId() == idEntrada) {
		    		Localitzacio l = new Localitzacio(novaLoc);
		    		e.getLocalitzacions().add(l);
		    		encontrado = true;
		    	}
		    }
		    
		    if(!encontrado) {
		    	System.out.println("Error aquesta entrada no existeix");
		    	return;
		    }
		    
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    jaxbMarshaller.marshal(mokedex, fitxerDesti);
		    
		    System.out.println("Localitzacio Afegida");
		    
		} catch (JAXBException je) {
		    je.printStackTrace();
		}
	}
	
	public static void postEvolucio(String nomFitxer, int idEntrada) {
		File fitxerDesti = new File(nomFitxer);
		try {
		    JAXBContext jaxbContext = JAXBContext.newInstance(Mokedex.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		   
		    Mokedex mokedex = (Mokedex) jaxbUnmarshaller.unmarshal(fitxerDesti);
		    
		    boolean encontrado = false;
		    
		    for(Entrada e : mokedex.getEntrades()) {
		    	if(e.getId() == idEntrada) {
		    		String poste = e.getEvolucions().getPost_evolucio();
		    		if(poste.equals("-")) {
		    			System.out.println( e.getNom() + " no te post evolució.");
		    		}else {
		    			System.out.println("La post evolució de " + e.getNom() + " es " + poste + ".");
		    		}
		    		encontrado = true;
		    	}
		    }
		    
		    if(!encontrado) {
		    	System.out.println("Error aquesta entrada no existeix");
		    	return;
		    }
		    
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    jaxbMarshaller.marshal(mokedex, fitxerDesti);
		    
		} catch (JAXBException je) {
		    je.printStackTrace();
		}
	}
	
	
	
}
