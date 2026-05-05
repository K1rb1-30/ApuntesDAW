package examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class MainTestAlumnes {

	public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {

//	    System.out.println("===== TEST FITXERS DE TEXT =====");
//
//	    ArrayList<ItemBotiga> botiga = llegirBotiga();
//	    checkEquals(7, botiga.size(), "La botiga hauria de tenir 7 ítems");
//	    checkContains(botiga.toString(), "PocioVida", "La botiga hauria de contenir PocioVida");
//
//	    checkEquals(false, comprarItem("EscutFusta"), "EscutFusta no es pot comprar perquè no està disponible");
//	    checkEquals(true, comprarItem("EspasaRovellada"), "EspasaRovellada s'hauria de poder comprar");
//
//	    checkFileExists("botigaMod.txt", "comprarItem hauria de crear botigaMod.txt");
//	    checkFileContains("botigaMod.txt", "EspasaRovellada;80;Arma;0;false",
//	            "EspasaRovellada hauria de quedar amb quantitat 0 i disponible false");
//
//	    checkEquals(false, comprarItem("ObjecteInventat"), "Un objecte inexistent hauria de retornar false");


//	    System.out.println("\n===== TEST FITXERS SERIALITZATS =====");
//
//	    Efecte efCuracio = new Efecte("Curacio", 30);
//	    Efecte efMana = new Efecte("Mana", 20);
//	    Efecte efAtac = new Efecte("Atac", 5);
//
//	    ItemInventari inv1 = new ItemInventari("PocioVida", 2, "Consumible", efCuracio);
//	    ItemInventari inv2 = new ItemInventari("CristallMana", 1, "Consumible", efMana);
//	    ItemInventari inv3 = new ItemInventari("EspasaRovellada", 1, "Arma", efAtac);
//
//	    ArrayList<ItemInventari> inventari = new ArrayList<>();
//	    inventari.add(inv1);
//	    inventari.add(inv2);
//	    inventari.add(inv3);
//
//	    escriureInventari(inventari);
//	    checkFileExists("inventari.dat", "escriureInventari hauria de crear inventari.dat");
//
//	    ArrayList<ItemInventari> inventariLlegit = llegirInventari();
//	    checkEquals(3, inventariLlegit.size(), "llegirInventari hauria de retornar 3 objectes");
//	    checkContains(inventariLlegit.toString(), "PocioVida", "L'inventari hauria de contenir PocioVida");
//
//	    checkEquals(5, afegirInventari(new ItemInventari("PocioVida", 3, "Consumible", efCuracio)),
//	            "Afegir 3 PocioVida a les 2 existents hauria de retornar 5");
//
//	    checkEquals(1, afegirInventari(new ItemInventari("ClauAntiga", 1, "Especial", new Efecte("Obrir", 1))),
//	            "Afegir ClauAntiga nova hauria de retornar 1");
//
//	    inventariLlegit = llegirInventari();
//	    checkEquals(4, inventariLlegit.size(), "Ara l'inventari hauria de tenir 4 objectes diferents");
//	    checkContains(inventariLlegit.toString(), "ClauAntiga", "L'inventari hauria de contenir ClauAntiga");


//	    System.out.println("\n===== TEST FITXERS XML =====");
//
//	    Companyia companyia = llegirPersonatges("companyia.xml");
//	    checkContains(companyia.toString(), "Arya", "La companyia hauria de contenir Arya");
//	    checkContains(companyia.toString(), "Guerrera", "La companyia hauria de contenir una Guerrera");
//
//	    escriurePersonatges("companyia_test.xml", companyia);
//	    checkFileExists("companyia_test.xml", "escriurePersonatges hauria de crear companyia_test.xml");
//
//	    Companyia companyiaTest = llegirPersonatges("companyia_test.xml");
//	    checkContains(companyiaTest.toString(), "Nil", "companyia_test.xml hauria de contenir Nil");
//
//	    checkEquals(true, afegirHabilitat("companyia.xml", "Arya", "Crit heroic"),
//	            "Afegir habilitat a Arya hauria de retornar true");
//
//	    checkFileExists("companyia_mod.xml", "afegirHabilitat hauria de crear companyia_mod.xml");
//
//	    Companyia companyiaMod = llegirPersonatges("companyia_mod.xml");
//	    checkContains(companyiaMod.toString(), "Crit heroic",
//	            "companyia_mod.xml hauria de contenir la nova habilitat Crit heroic");
//
//	    checkEquals(false, afegirHabilitat("companyia.xml", "PersonatgeInventat", "HabilitatImpossible"),
//	            "Afegir habilitat a un personatge inexistent hauria de retornar false");


	    System.out.println("\n===== TEST FITXERS JSON =====");

	    checkEquals(2, millorarCompanyia("companyia.json", "Guerrera", 10),
	            "Hi hauria d'haver 2 personatges de classe Guerrera modificats");

	    checkFileExists("companyia_millorada.json",
	            "millorarCompanyia hauria de crear companyia_millorada.json");

	    checkFileContains("companyia_millorada.json", "\"nom\": \"Arya\"",
	            "companyia_millorada.json hauria de contenir Arya");

	    checkFileContains("companyia_millorada.json", "\"atac\": 25",
	            "Arya tenia atac 15 i amb +10 hauria de quedar a 25");

	    checkFileContains("companyia_millorada.json", "\"nom\": \"Brak\"",
	            "companyia_millorada.json hauria de contenir Brak");

	    checkEquals(0, millorarCompanyia("companyia.json", "ClasseInventada", 10),
	            "Una classe inexistent hauria de retornar 0");

	    System.out.println("\n===== TEST FINALITZAT =====");

		
		

	}

	public static void checkEquals(Object esperat, Object obtingut, String missatge) {
	    if ((esperat == null && obtingut == null) || (esperat != null && esperat.equals(obtingut))) {
	        System.out.println("[OK] " + missatge);
	    } else {
	        System.out.println("[ERROR] " + missatge);
	        System.out.println("       Esperat: " + esperat);
	        System.out.println("       Obtingut: " + obtingut);
	    }
	}

	public static void checkContains(String text, String fragment, String missatge) {
	    if (text != null && text.contains(fragment)) {
	        System.out.println("[OK] " + missatge);
	    } else {
	        System.out.println("[ERROR] " + missatge);
	        System.out.println("       No s'ha trobat: " + fragment);
	    }
	}

	public static void checkFileExists(String nomFitxer, String missatge) {
	    File f = new File(nomFitxer);
	    if (f.exists()) {
	        System.out.println("[OK] " + missatge);
	    } else {
	        System.out.println("[ERROR] " + missatge);
	        System.out.println("       No existeix el fitxer: " + nomFitxer);
	    }
	}

	public static void checkFileContains(String nomFitxer, String fragment, String missatge) throws IOException {
	    File f = new File(nomFitxer);

	    if (!f.exists()) {
	        System.out.println("[ERROR] " + missatge);
	        System.out.println("       No existeix el fitxer: " + nomFitxer);
	        return;
	    }

	    BufferedReader br = new BufferedReader(new FileReader(f));
	    StringBuilder contingut = new StringBuilder();
	    String linia;

	    while ((linia = br.readLine()) != null) {
	        contingut.append(linia).append("\n");
	    }

	    br.close();

	    if (contingut.toString().contains(fragment)) {
	        System.out.println("[OK] " + missatge);
	    } else {
	        System.out.println("[ERROR] " + missatge);
	        System.out.println("       No s'ha trobat: " + fragment);
	    }
	}


	// AFEGEIX AQUÍ ELS TEUS MÈTODES
	
	// ===== TEST FITXERS DE TEXT =====
	
	public static ArrayList<ItemBotiga> llegirBotiga(){
		
		ArrayList<ItemBotiga> llista = new ArrayList<ItemBotiga>();
		try {
            File f = new File("botiga.txt");
            FileReader fr;
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);            
            System.out.println("Reader Carregat Correctament");          
            
            while(br.ready()) {
            	 String[] item = br.readLine().split(";");
            	 
            	 ItemBotiga i = new ItemBotiga(item[0], Integer.parseInt(item[1]), item[2], Integer.parseInt(item[3]), Boolean.parseBoolean(item[4]));
                 
            	 llista.add(i);
//                 System.out.println(item[0]);
            }
            br.close();
            return llista;
        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Excepció general de lectura");
            e.printStackTrace();
        }
		
		
		return null;
		
	}
	
	public static boolean comprarItem(String nomitem) {
		ArrayList<ItemBotiga> botiga = llegirBotiga();
		
		try {
			
            // WRITER
			File f2 = new File("botigaMod.txt");
            FileWriter fw = new FileWriter(f2, true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("El fitxer s'ha copiat correctament");
            
            boolean trobat = false;
            
            for(ItemBotiga item : botiga) {
            	
            	if(item.nom.equals(nomitem)) {
            		if(item.disponible == true && item.quantitat > 0) {
            			
            			item.quantitat = item.quantitat - 1;
            			
            			System.out.println(item.quantitat);
            			
            			if(item.quantitat <= 0) {
            				item.quantitat = 0;
            				item.disponible = false;
            			}
            			
            			String lineacorta = item.nom + ";" + item.preu + ";" + item.tipus + ";" + item.quantitat + ";" + item.disponible;
            			System.out.println(lineacorta);
                    	bw.write("\n" + lineacorta);
                    	trobat = true;
            		}
            		
            	}else {
            		String lineacorta = item.nom + ";" + item.preu + ";" + item.quantitat + ";" + item.tipus + ";" + item.disponible;
                	bw.write("\n" + lineacorta);
            	}
            		
            		
            	
			}
            
            
            
            
            //Guarda tots els canvis que has fet al buffer intern. Escriu a fitxer
            bw.flush();            
            //close. Tanca el bufferedWriter i evita que quedi la memòria penjant
            bw.close();
            
            return trobat;
        
        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Excepció general d'escriptura");
            e.printStackTrace();
        }
		
		
		return false;
		
	}
	
	
	// 	===== TEST FITXERS XML =====
	
	public static Companyia llegirPersonatges(String nomFitxer) {
		File fitxerOrigen = new File(nomFitxer);
		try {
		    // Es crea el context indicant la classe arrel
		    //hauras de posar la classe adient, clar.
		    JAXBContext jaxbContext = JAXBContext.newInstance(Companyia.class);
		    // Es crea un Unmarshaller amb el context de la classe Entrada
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    // Es fa servir el mètode unmarshal, per a obtenir les dades. Sempre s'ha de fer un casteig. fitxerOrigen es una String amb el path al fitxer
		    Companyia c = (Companyia) jaxbUnmarshaller.unmarshal(fitxerOrigen);
		    return c;
		} catch (JAXBException je) {
		    je.printStackTrace();
		}
		return null;
	}
	
	public static void escriurePersonatges(String nomFitxer, Companyia com) {
		File fitxerDesti = new File(nomFitxer);
		try{
		    //si ja has creat el jaxbContext abans per llegir no cal aquesta línea, clar.
		    JAXBContext jaxbContext = JAXBContext.newInstance(Companyia.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    // Es grava el fitxer desti amb la sortida formatada (aixo ultim s'indica en la
		    // instruccio que segueix)
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    //entrada es un objecte de tipus Entrada. fitxerDesti es una String amb el path al fitxer
		    jaxbMarshaller.marshal(com, fitxerDesti);


		} catch (JAXBException je) {
		            je.printStackTrace();
		}
	}
	
	public static boolean afegirHabilitat(String nomFitxer, String nomPersonatge, String novaHabilitat) {
		File fitxerLlegir = new File(nomFitxer);
		try {
		    JAXBContext jaxbContext = JAXBContext.newInstance(Companyia.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		   
		    Companyia com = (Companyia) jaxbUnmarshaller.unmarshal(fitxerLlegir);
		    
		    boolean encontrado = false;
		    
		    for(Personatge p : com.getPersonatges()) {
		    	if(p.getNom().equals(nomPersonatge)) {
		    		p.getHabilitats().add(novaHabilitat);
		    		encontrado = true;
		    	}
		    }
		    
		    if(!encontrado) {
		    	System.out.println("Error aquesta persona no existeix");
		    	return false;
		    }
		    
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    jaxbMarshaller.marshal(com, new File("companyia_mod.xml"));
		    
		    System.out.println("Persona modificada");
		    
		    return true;
		    
		} catch (JAXBException je) {
		    je.printStackTrace();
		}
		
		return false;
	}
	
	// 	===== TEST FITXERS JSON =====
	
	
// Aquest esta fet sense mapping mirant els apunts jajajaja
	
	
//	public static int millorarCompanyia(String nomFitxer, String classePersonatge, int puntsAtac) throws IOException {
//		int nmodificat = 0;
//
//		JsonElement arrel = JsonParser.parseReader(new FileReader(nomFitxer));
//		JsonObject mdex = arrel.getAsJsonObject();
//		JsonArray personatges = mdex.get("personatges").getAsJsonArray();
//		for (JsonElement p : personatges) {
//
//			JsonObject obj = p.getAsJsonObject();
//			
////			System.out.println(obj);
//
//			if (obj.get("classe").getAsString().equals(classePersonatge)) {
//
//				JsonObject stats = obj.get("stats").getAsJsonObject();
//				int statAtac = stats.get("atac").getAsInt();
//				
//				statAtac += puntsAtac;
//				
//				
//				
//				if(statAtac > 30) {
//					statAtac = 30;
//				}
//				
//				stats.addProperty("atac", statAtac);
//				
////				obj.addProperty("stats", stats);
//				
//				System.out.println(stats);
//				
//				nmodificat++;
//
//			}
//		}
//		
//
//		Gson escriure = new GsonBuilder().setPrettyPrinting().create();
//		FileWriter fw = new FileWriter("companyia_millorada.json");
//
//		fw.append(escriure.toJson(mdex));
//		fw.flush();
//		fw.close();
//		
//		return nmodificat;
//	}
	
	
	public static int millorarCompanyia(String nomFitxer, String classePersonatge, int puntsAtac) throws IOException {
		Gson llegir = new GsonBuilder().setPrettyPrinting().create();
		Companyia c = llegir.fromJson(new FileReader(nomFitxer), Companyia.class);
		System.out.println(c);
		
		int nmodificat = 0;
		
		for (Personatge p : c.personatges) {
			if(p.getClasse().equals(classePersonatge)) {
				
				int pAtac = p.getStats().getAtac() + puntsAtac;
				
				if(pAtac > 30) {
					pAtac = 30;
				}
				System.out.println(pAtac);
				
				p.getStats().setAtac(pAtac);
				System.out.println(p.getStats().getAtac());
				nmodificat++;
			}
			
		}

		FileWriter fw = new FileWriter("companyia_millorada.json");
		fw.append(llegir.toJson(c));
		fw.flush();
		fw.close();
		System.out.println(c);
		
		return nmodificat;
	}

}
