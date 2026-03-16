package mokepon6;

import java.util.Scanner;

public class ScannerArreglat {
	Scanner sc;
	boolean hemFetUnNextInt;
	
	public ScannerArreglat(){
        sc = new Scanner(System.in);
        hemFetUnNextInt = false;
    }
	
	public String nextLine() {
        String s;
        //si venim de fer un nextInt
        if(hemFetUnNextInt) {
            s = sc.nextLine();
            //trim es un metode que treu tots els espais, salts de linea, tabulacio etc, al principi i al final d'un string
            //per tant, si s.trim es una string buida, significa que només hi havia un salt de línea, i per tant s'activaba EL BUG
            if(s.trim().equals("")) {
                //tornem a llegir. i per tant serà la segona línea la que tornarem.
                s = sc.nextLine();
            }
        }else {
            s = sc.nextLine();
        }
        //ja podem desactivar el hem fetun NextInt perquè l'últim que hem fet es un nextLine i estem en nova línea
        hemFetUnNextInt = false;
        return s;
       
    }
   
    public int nextInt() {
        int res = sc.nextInt();
        hemFetUnNextInt = true;
        return res;
    }


    public double nextDouble() {
        double res = sc.nextDouble();
        //tecnicament no hem fet un nextInt, però el mètode funciona exactament igual per els doubles
        hemFetUnNextInt = true;
        return res;
    }


}
