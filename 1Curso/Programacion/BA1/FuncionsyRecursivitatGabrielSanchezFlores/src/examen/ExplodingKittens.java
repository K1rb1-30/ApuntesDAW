package examen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class ExplodingKittens {
	
	static Scanner sc = new Scanner(System.in);  //Scanner global para poder usarlo en todas las funciones
	
	//Inicializamos el mazo para que ya este hecho
	public static ArrayList<Integer> baralla = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4,
			4, 4, 4, 5, 5, 5, 5, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 15, 15));

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creamos los jugadores 
		Jugador j1 = new Jugador();
		Jugador j2 = new Jugador();
		Jugador j3 = new Jugador();
		
		//Les ponemos nombre a los jugadores
		j1.nom = "Jugador 1";
		j2.nom = "Jugador 2";
		j3.nom = "Jugador 3";
		
		//Creamos una lista de jugadores
		Jugador[] jugadores = new Jugador[3];
		
		//Los añadimos a la lista
		jugadores[0]=j1;
		jugadores[1]=j2;
		jugadores[2]=j3;

		
		
		
		init(jugadores);
		boolean fi = false;
		int torn = 0;
		while (!fi) {
			
			if(jugadores[torn].viu == true) { //mientras el jugador este vivo se jugara su turno
				System.out.println("Torn del jugador "+ jugadores[torn].nom);
				
				int cartaSeleccionada = seleccionarCarta(jugadores[torn], true); //Seleccionamos la carta que queramos tirar
				
				if (cartaSeleccionada != 0) { //Si hemos tirado carta se comprueba si es carta de accion.
					gestionarCartaTirada(cartaSeleccionada, jugadores[torn], jugadores);
				}
				boolean isKitten = robar(jugadores[torn]); //volvemos a robar y en este caso si sale un 15 nos lo indicara con TRUE
				if (isKitten) {
					Explotar(jugadores[torn]); 
				}
			}
			torn = canviTorn(torn, jugadores);
			fi = fiPartida(jugadores);
			
		}
	}
	
	

	private static boolean fiPartida(Jugador[] jugadores) {
		// TODO Auto-generated method stub
		int jVivos = 0; // Esto contara cuantos jugadores vivos hay
		String ultimoJugador = ""; //esto dira el nombre del ultimo jugador
		
		for (int i = 0; i < jugadores.length; i++) { //Esto comprueva y cuenta cuantos jugadores hay vivos
			if(jugadores[i].viu == true) {
				jVivos++;
				ultimoJugador = jugadores[i].nom; //tambien añade el ultimo jugador vivo
			}
		}
		
		if(jVivos == 1) { //si solo queda un jugador devolvera true y dira que se a acabado la partida dando como ganador el ultimo jugador en pie
			System.out.println("SE ACABO LA PARTIDA");
			System.out.println("El ganador es: ");
			System.out.println(ultimoJugador);
			return true;
		}
		
		return false;
	}



	private static int canviTorn(int torn, Jugador[] llistaJugadors) {
		// Si es el ultimo jugador se volvera a empezar de cero
		if(torn == llistaJugadors.length - 1) {
			torn = 0;
		}else { // sino ira el siguiente jugador
			torn++;
		}
		
		return torn; //retorna el turno
	}



	private static void Explotar(Jugador jugador) {
		// Revisamos si el jugador se salva o si muere.
		
		if(jugador.ma.contains(15)) {
			
			baralla.add(15);// añadimos la desactivacion a la baraja
			jugador.ma.remove(jugador.ma.indexOf(15)); //Quitamos la desactivacion al jugador
			
			boolean valid = false; //creamos un boolean para defender
			
			int posicionova = 0; // la posicion en que ira la explosion nueva
			
			while(!valid) {
				
				System.out.println("Escull la posicio on vols deixar el exploding kitten: ");
				
				System.out.println("Del 1 al " + baralla.size()); 
				
				posicionova = sc.nextInt() - 1 ;
				
				if(posicionova > -1 && posicionova < baralla.size()) {
					valid = true;
				}
			}
			
			baralla.add(posicionova, 14); //Añadimos a la baraja la explosion en la posicion deseada
			jugador.ma.remove(jugador.ma.indexOf(14)); //Le quitamos al jugador la explosion que habia robado antes
			
		}else { //Si no tiene desactivacion morira
			System.out.println("Has mort, tenies un exploding kitten i cap desactivació");
			jugador.viu = false;
		}
	}



	private static void gestionarCartaTirada(int cartaEscollida, Jugador jugador, Jugador[] listaJugadores) {
		// TODO Auto-generated method stub
		
		baralla.add(cartaEscollida);
		jugador.ma.remove(jugador.ma.indexOf(cartaEscollida));
		
		if (cartaEscollida == 11) {
			System.out.println("Es mezclara la baralla");
			Collections.shuffle(baralla); //barrellara la baralla

		} else if (cartaEscollida == 12) { //Si es un 12 el jugador veura les tres primeres cartas de la baralla
			
			System.out.println("Veuras el futur... les 3 primeres cartes de la baralla");
			
			System.out.println("Aquestes son les 3 primeres cartes:");
			System.out.print("Primera carta: ");
			System.out.println(baralla.get(0));
			System.out.print("Segona carta: ");
			System.out.println(baralla.get(1));
			System.out.print("Tercera carta: ");
			System.out.println(baralla.get(2));

		} else if (cartaEscollida == 13) { // Si tira un 13 el jugador podra robarle la carta a otro
			
			boolean valid = false; // con esto comprovamos que el jugador que a escogido es valido
			int jugadorEscollit = 0;
			
			while(!valid) {
				System.out.println("Favor... Escull un Jugador al que robar una carta: ");
				
				for (int i = 0; i < listaJugadores.length; i++) {
					if(listaJugadores[i] != jugador) {
						if(listaJugadores[i].viu == true) {
							System.out.println( i + 1 + ". " + listaJugadores[i].nom);
						}
					}
				}
				System.out.println("");
				
				jugadorEscollit = sc.nextInt() - 1;
				
				if(listaJugadores[jugadorEscollit].viu == true) {
					valid = true;
				}
				System.out.println();
			}
			
			System.out.println(listaJugadores[jugadorEscollit].nom + ", Escull la carta per donarli a " + jugador.nom);
			
			int cartaDonada = seleccionarCarta(listaJugadores[jugadorEscollit], false); // el rival elige la carta para darsela al jugador, EL FALSE ES PARA SABER QUE NO SE PUEDE NO DAR CARTA
			
			jugador.ma.add(cartaDonada); //se añade a la mano del jugador
			
			listaJugadores[jugadorEscollit].ma.remove(listaJugadores[jugadorEscollit].ma.indexOf(cartaDonada)); //y se quita al rival
			

		}
	}



	private static int seleccionarCarta(Jugador jugador, boolean tipo) { //el 
		// Seleccionaremos la carta (el tipo es si se puede no dar carta a otro jugador)
		
		int indexCarta = 0; //index de la carta a tirar
		
		boolean valid = false; //para comprovar si la carta tirada es valida o sino se repetira
		
		while (!valid) {
			System.out.println(jugador.ma);//Le mostramos al jugador su mano
			int c = sc.nextInt();
			
			if(c == 0 && tipo == true) { //Si el jugador decideix no tirar carta retornara 0
				return 0;
			}
			
			if(c == 15 && tipo == true) { //si se da la desactivacion pone este mensaje
				System.out.println("Tu eres tonto no des la desactivacion chavalin");
			}else {
				//Si si que tira carta es mirar el index de la carta y si es diferent a -1 significa que es valid y saldra del bucle
				indexCarta = jugador.ma.indexOf(c);
				if (indexCarta != -1) {
					valid = true;
				}
			}
			
			
		}
		return jugador.ma.get(indexCarta); //retornara el tipus de carta
	}


	private static void init(Jugador[] jugadores) {
		// TODO Auto-generated method stub
		Collections.shuffle(baralla); //Se mezcla la baraja al principio
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				robar(jugadores[i]); //Se le da a cada jugador 4 cartas
			}
			
			jugadores[i].ma.add(15); //Despues se le da una quinta carta a cada jugador que si o si sera un 15 (desactivacion)
		}
		
		//Despues de repartir se ponen en la baraja los dos exploding kittens
		baralla.add(14);
		baralla.add(14);
		
		//Por ultimo se mezcla de nuevo la baraja
		Collections.shuffle(baralla);
	}


	private static boolean robar(Jugador jugador) {
		// Al jugador se le da la primera carta de la baraja y despues se borra para que no este en la baraja
		jugador.ma.add(baralla.get(0));
		if(baralla.get(0) == 14) { //Si la carta robada es un exploding kitten es retornara true
			return true;
		}
		baralla.remove(0); //se quitara la carta de la baralla.
		
		return false; //sino es retornara false en cas de necesitar-ho
	}

}
