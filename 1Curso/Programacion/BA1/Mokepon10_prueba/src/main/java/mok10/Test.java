package mok10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class Test {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Evolucions pipluaevo = new Evolucions("-", "Empoleon");
		Entrada piplup = new Entrada(393, "Piplup", "Aigua", 5.2, pipluaevo);
		
		Evolucions empoevo = new Evolucions("Prinplup", "-");
		Entrada empoleon = new Entrada(395, "Empoleon", "Aigua", 84.5, empoevo);
		
//		afegirMokedex("mokedex.json", piplup);
//		afegirMokedex("mokedex.json", empoleon);
		GigantamaxPostEvolució("mokedex.json", 393);
	}
	
	public static void afegirMokedex(String nomFitxer, Entrada novaEntrada) throws JsonSyntaxException, JsonIOException, IOException {
		File fitxerDesti = new File(nomFitxer);
		
		Gson escriure = new GsonBuilder().setPrettyPrinting().create();

		 Mokedex m;

		    // Si el archivo no existe o está vacío
		    if (!fitxerDesti.exists() || fitxerDesti.length() == 0) {
		        m = new Mokedex(); // asegúrate de que inicializa la lista dentro
		    } else {
		        m = escriure.fromJson(new FileReader(nomFitxer), Mokedex.class);
		    

		        // Por si el JSON devuelve null
		        if (m == null) {
		            m = new Mokedex();
		        }
		    }

		    // Asegurar que la lista no sea null
		    if (m.getEntrades() == null) {
		        m.setEntrades(new ArrayList<>());
		    }

		    m.getEntrades().add(novaEntrada);

		    FileWriter fw = new FileWriter(fitxerDesti);
		    fw.write(escriure.toJson(m));
		    fw.close();
		
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
	}
}
