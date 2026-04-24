package mokepon10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.FileReader;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Evolucions pipluaevo = new Evolucions("-", "Empoleon");
		Entrada piplup = new Entrada(393, "Piplup", "Aigua", 5.2, pipluaevo);
		
		Evolucions empoevo = new Evolucions("Prinplup", "-");
		Entrada empoleon = new Entrada(395, "Empoleon", "Aigua", 84.5, empoevo);
		
		afegirMokedex("mokedex.json", piplup);
		afegirMokedex("mokedex.json", empoleon);
//		GigantamaxPostEvolució("mokedex.json", 393);
	}
	
	public static void afegirMokedex(String nomFitxer, Entrada novaEntrada) throws IOException  {
		File fitxerDesti = new File(nomFitxer);
			
		try {
			Gson escriure = new GsonBuilder().setPrettyPrinting().create();
			
			Mokedex m = escriure.fromJson(new FileReader(nomFitxer), Mokedex.class);
			
			m.getEntrades().add(novaEntrada);
			
			FileWriter fw = new FileWriter(fitxerDesti);
			fw.append(escriure.toJson(m));
			fw.flush();
			fw.close();
		}
		catch (Exception e){
			Gson escriure = new GsonBuilder().setPrettyPrinting().create();
			
			Mokedex m = new Mokedex("ASH");
			
			FileWriter fw = new FileWriter(fitxerDesti);
			fw.append(escriure.toJson(m));
			fw.flush();
			fw.close();
			e.printStackTrace();
		}
			
		
	}
	
	public static void GigantamaxPostEvolució(String nomFitxer, int idEntrada) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson llegir = new GsonBuilder().setPrettyPrinting().create();

		Entrada j = llegir.fromJson(new FileReader(nomFitxer), Entrada.class);

//		System.out.println(j);
		
		String nomevo;
		
		if(idEntrada == j.getId()) {
			System.out.println(j);
			nomevo = j.getEvolucions().post_evolucio;
		}
		

//		for (Personatge p : j.personatges) {
//
//			System.out.println(p.getNom());
//
//		}
//		
//		Type tipusArrayListPersonatge = new TypeToken<ArrayList<Personatge>>(){}.getType();
//		
//		ArrayList<Personatge> personatges = llegir.fromJson(new FileReader("personatges2.json"), tipusArrayListPersonatge);
//
//		System.out.println(personatges);  
	}
	
	

}
