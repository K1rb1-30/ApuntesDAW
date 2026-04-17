package mokepon9;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Entrada pikachu = new Entrada(25, "Mikachu", "Electric");
		Entrada piplup = new Entrada(393, "Piplup", "Aigua");
		EscriureEntrada(piplup);
		Mokedex pokedex = new Mokedex("Gabri");
		pokedex.entrades.add(piplup);
		pokedex.entrades.add(pikachu);
		EscriureMokedex(pokedex);
		
		
		
		
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
	
}
