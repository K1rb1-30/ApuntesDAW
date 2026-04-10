package mokepon7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		afegirGimnas("INSTITUT SABADELL", "SABADELL", "MARC", 2);
//		afegirGimnas("GIMNAS DE MERDANYOLA", "MERDANYOLA", "MISCO", 5);
//		
//		mostrarGimnasos();
//		cercarLider("INSTITUT SABADELL");
		
//		invictes(4);
		
//		copiaSeguretat("gimnasos.txt", "gimnasoscopy.txt");
		
		canviLider("INSTITUT SABADELL", "DANI");
	}
	
	public static void afegirGimnas(String nomGimnas, String ciutat, String liderGimnas, int nsuperat) {
		try {
            //path al fitxer
			File f = new File("gimnasos.txt");
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(nomGimnas + ";" + ciutat + ";" + liderGimnas + ";" + nsuperat + "\n");
            
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
	
	public static void mostrarGimnasos() {
		try {
            File f = new File("gimnasos.txt");
            FileReader fr;
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);            
            System.out.println("Reader Mostrar Gimnasos Carregat Correctament");          
            //FUNCIONS IMPORTANTS DEL BUFFEREDREADER
            //READ - LLEGEIX UN CARÀCTER
//            char c = (char) br.read();
//            System.out.println(c);
//            //READY - diu si queden coses al fitxer
//            System.out.println(br.ready());
            // Leer solo los GYMS
            
            while(br.ready()) {
            	 String[] gimnas = br.readLine().split(";");
                 
                 System.out.println(gimnas[0]);
            }
            //READLINE - llegeix una línia de cop. Exactament igual que al scanner
//            System.out.println(br.readLine());
//            System.out.println(br.ready());
           //CLOSE - tanca el bufferedReader i evita que quedi la memòria penjant
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Excepció general de lectura");
            e.printStackTrace();
        }
	}
	
	public static void cercarLider(String gimnasc) {
		try {
            File f = new File("gimnasos.txt");
            FileReader fr;
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);            
            System.out.println("Reader Cercar Lider Carregat Correctament");          
            // Leer solo los lideres
            
            while(br.ready()) {
            	 String[] gimnas = br.readLine().split(";");
                 if(gimnas[0].equals(gimnasc)) {
                	 System.out.println(gimnas[2]);
                 }
                 
            }

           //CLOSE - tanca el bufferedReader i evita que quedi la memòria penjant
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Excepció general de lectura");
            e.printStackTrace();
        }
	}
	
	public static void invictes(int n) {
		try {
            File f = new File("gimnasos.txt");
            FileReader fr;
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);            
            System.out.println("Reader Gimnas Invictes Carregat Correctament");          
            // Leer solo invictes
            
            while(br.ready()) {
            	 String[] gimnas = br.readLine().split(";");
                 if( Integer.parseInt(gimnas[3]) < n) {
                	 System.out.println(gimnas[0]);
                 }
                 
            }

           //CLOSE - tanca el bufferedReader i evita que quedi la memòria penjant
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Excepció general de lectura");
            e.printStackTrace();
        }
	}
	
	public static void copiaSeguretat(String path1, String path2) {
		try {
			// READEAR
			File f1 = new File(path1);
            FileReader fr;
            fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
			
            // WRITER
			File f2 = new File(path2);
            FileWriter fw = new FileWriter(f2, true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("El fitxer s'ha copiat correctament");
            
            while(br.ready()) {
            	bw.write(br.readLine() + "\n");
            }
            
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
	
	public static void canviLider(String nomGimnas, String nouLider) {
		try {
			// READEAR
			File f1 = new File("gimnasos.txt");
            FileReader fr;
            fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
			
            // WRITER
			File f2 = new File("temp.txt");
            FileWriter fw = new FileWriter(f2, true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("El fitxer s'ha copiat correctament");
            
            while(br.ready()) {
            	
            	String[] gimnas = br.readLine().split(";");
                if(gimnas[0].equals(nomGimnas)) {
                	bw.write(gimnas[0] + ";" + gimnas[1] + ";" + nouLider + ";" + gimnas[3] + "\n");
                }else {
                	bw.write(gimnas[0] + ";" + gimnas[1] + ";" + gimnas[2] + ";" + gimnas[3] + "\n");
                }
            }
            
            //Guarda tots els canvis que has fet al buffer intern. Escriu a fitxer
            bw.flush();            
            //close. Tanca el bufferedWriter i evita que quedi la memòria penjant
            bw.close();
            br.close();
            
            f1.delete();
            //renombrem el arxiu
            f2.renameTo(f1);
            
            
            
        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Excepció general d'escriptura");
            e.printStackTrace();
        }
	}
	
	
	
	
		
	}
