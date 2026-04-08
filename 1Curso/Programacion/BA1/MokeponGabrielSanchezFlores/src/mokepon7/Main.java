package mokepon7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		afegirGimnas("INSTITUT SABADELL", "SABADELL", "MARC");
		afegirGimnas("GIMNAS DE MERDANYOLA", "MERDANYOLA", "MISCO");
		
	}
	
	public static void afegirGimnas(String nomGimnas, String ciutat, String liderGimnas) {
		try {
            //path al fitxer
			File f = new File("gimnasos.txt");
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(nomGimnas + ";" + ciutat + ";" + liderGimnas + ";" + 0 + "\n");
            
            //Guarda tots els canvis que has fet al buffer intern. Escriu a fitxer
            bw.flush();            
            //close. Tanca el bufferedWriter i evita que quedi la memòria penjant
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Excepció general d'escriptura");
            e.printStackTrace();
        }   
    }
		
	}
