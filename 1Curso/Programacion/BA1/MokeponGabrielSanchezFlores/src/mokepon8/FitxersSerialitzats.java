package mokepon8;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import mokepon6.MokeponCapturat;
import objectes.Arma;
import objectes.Armadura;
import objectes.Objecte;
import objectes.ObjecteFactory;
import objectes.Pocio;
import objectes.Reviure;

public class FitxersSerialitzats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Objecte obj1 = ObjecteFactory.crearObjecte("SUPERPOCIO");
		afegirObjecte(obj1);
		recuperarObjecte();
	}
	
	
	public static void afegirObjecte(Objecte obj) {
		try {
            File f = new File("objectes.dat");
            //funciona de forma similar a un fileWriter, amb append inclós
            FileOutputStream fos = new FileOutputStream(f, true);
            AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos, true);
//            Objecte obj1 = ObjecteFactory.crearObjecte("SUPERPOCIO");
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            fos.close(); //És molt important tancar bé el fos. Si no el fitxer queda obert
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void recuperarObjecte() {
		try {
            File f = new File("objectes.dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            if(ois.readObject() instanceof Pocio) {
            	Pocio p = (Pocio) ois.readObject();
            	System.out.println(p);
            }else if(ois.readObject() instanceof Reviure) {
            	Reviure p = (Reviure) ois.readObject();
            	System.out.println(p);
            }else if(ois.readObject() instanceof Arma) {
            	Arma p = (Arma) ois.readObject();
            	System.out.println(p);
            }else if(ois.readObject() instanceof Armadura) {
            	Armadura p = (Armadura) ois.readObject();
            	System.out.println(p);
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("no existeix el fitxer");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("excepció d'entrada/sortida");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("no s'ha trobat la classe demanada");
            e.printStackTrace();
        }
	}
	
	public static void recuperarObjectes() {
		try {
            File f = new File("objectes.dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Objecte> lista = new ArrayList<Objecte>();
            try {
            	while(true) {
                	if(ois.readObject() instanceof Pocio) {
                    	Pocio p = (Pocio) ois.readObject();
                    	lista.add(p);
                    }else if(ois.readObject() instanceof Reviure) {
                    	Reviure p = (Reviure) ois.readObject();
                    	lista.add(p);
                    }else if(ois.readObject() instanceof Arma) {
                    	Arma p = (Arma) ois.readObject();
                    	lista.add(p);
                    }else if(ois.readObject() instanceof Armadura) {
                    	Armadura p = (Armadura) ois.readObject();
                    	lista.add(p);
                    }
                }
            	
                
            } catch (EOFException e) {
                System.out.println(lista);
            }
               
        } catch (FileNotFoundException e) {
            System.out.println("no existeix el fitxer");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("excepció d'entrada/sortida");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("no s'ha trobat la classe demanada");
            e.printStackTrace();
        }
	}
	
	public static Pocio recuperaPocioConcreta(int n) {
		try {
            File f = new File("objectes.dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Objecte> lista = new ArrayList<Objecte>();
            try {
            	while(true) {
                	if(ois.readObject() instanceof Pocio) {
                    	Pocio p = (Pocio) ois.readObject();
                    	if(p.hp_curada == n) {
                    		return p;
                    	}
                    }
                }
            } catch (EOFException e) {
                System.out.println(lista);
            }
               
        } catch (FileNotFoundException e) {
            System.out.println("no existeix el fitxer");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("excepció d'entrada/sortida");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("no s'ha trobat la classe demanada");
            e.printStackTrace();
        }
		return null;
	}
	
	public static void afegeixMokepon(MokeponCapturat mok) {
		try {
            File f = new File("objectes.dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Objecte> lista = new ArrayList<Objecte>();
            try {
            	while(true) {
                	if(ois.readObject() instanceof Pocio) {
                    	Pocio p = (Pocio) ois.readObject();
                    	lista.add(p);
                    }else if(ois.readObject() instanceof Reviure) {
                    	Reviure p = (Reviure) ois.readObject();
                    	lista.add(p);
                    }else if(ois.readObject() instanceof Arma) {
                    	Arma p = (Arma) ois.readObject();
                    	lista.add(p);
                    }else if(ois.readObject() instanceof Armadura) {
                    	Armadura p = (Armadura) ois.readObject();
                    	lista.add(p);
                    }
                }
            	
                
            } catch (EOFException e) {
                System.out.println(lista);
            }
               
        } catch (FileNotFoundException e) {
            System.out.println("no existeix el fitxer");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("excepció d'entrada/sortida");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("no s'ha trobat la classe demanada");
            e.printStackTrace();
        }
	}
	
	
	
	
	
	

}
