package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Uno {

	static ArrayList<Integer> mazo = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);  //Scanner global para poder usarlo en todas las funciones
	static int sentit = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Jugador j1 = new Jugador();
		Jugador j2 = new Jugador();
		Jugador j3 = new Jugador();
		Jugador j4 = new Jugador();
		
		Jugador[] jugadores = new Jugador[4];
		
		jugadores[0]=j1;
		jugadores[1]=j2;
		jugadores[2]=j3;
		jugadores[3]=j4;
		
		int torn = 0;
		int cartaActual = 5;
		
		inicializar(jugadores);
		boolean fi = false;
		while (!fi) {
		    int cartaEscollida = seleccionarCarta(jugadores[torn]);
		    boolean cartaValida = esCartaValida(cartaEscollida, cartaActual);
		    if (cartaValida) {
		        cartaActual = tirarCarta(jugadores[torn], cartaActual, cartaEscollida);
		    } else {
		        robar(jugadores[torn]);
		    }
		    fi = fiPartida(jugadores[torn]);
		    if(fi) {
		    	System.out.println("HA guanyat " + jugadores[torn].nombre);
		    }
		    torn = canviTorn(torn, cartaEscollida);
		    
		}
		

	}

	private static int canviTorn(int torn, int cartaEscollida) {
		
		if(cartaEscollida == 11) {
			torn = ((torn + 2 * sentit) % 4);
		}else if(cartaEscollida == 12) {
			sentit = sentit * -1;
			torn = ((torn + 1 * sentit) % 4);
		}else if(cartaEscollida == 13) {
			
			return torn;
			
		}else {
			torn = ((torn + 1 * sentit) % 4);
		}
		
		if(torn < 0) {
			torn = 4 + torn;
		}
		
		return torn;
	}

	private static boolean fiPartida(Jugador jugador) {
		// TODO Auto-generated method stub
		return (jugador.mano.size() == 0);
	}

	private static int tirarCarta(Jugador jugadores, int cartaActual, int cartaEscollida) {
		// TODO Auto-generated method stub
		mazo.add(cartaEscollida);
		jugadores.mano.remove(jugadores.mano.indexOf(cartaEscollida));
		if(cartaEscollida > 10) {
			return cartaActual;
		}else {
			return cartaEscollida;
		}
		
	}

	private static boolean esCartaValida(int cartaEscollida, int cartaActual) {
		// TODO Auto-generated method stub
		return (cartaActual==cartaEscollida || cartaActual==cartaEscollida+1 || cartaActual==cartaEscollida-1 || cartaEscollida >=11);
	}

	private static int seleccionarCarta(Jugador jugador) {
		// TODO Auto-generated method stub
		int indexCarta = 0;
		boolean valid = false;
		while(!valid) {
			System.out.println(jugador.mano);
			int c = sc.nextInt();
			indexCarta = jugador.mano.indexOf(c);
			if(indexCarta != -1) {
				valid=true;
			}
		}
		return jugador.mano.get(indexCarta);
		
	}

	private static void robar(Jugador jug) {
		// TODO Auto-generated method stub
		jug.mano.add(mazo.get(0));
		mazo.remove(0);
	}

	private static void inicializar(Jugador[] jugadores) {
		// TODO Auto-generated method stub
		
		añadircartasMazo(mazo);
		Collections.shuffle(mazo);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				robar(jugadores[i]);
			}
			
		}
		
	}

	private static void añadircartasMazo(ArrayList<Integer> mazo) {
		// TODO Auto-generated method stub
		int ncartas = 13;
		//Random r = new Random();
		
		for (int i = 1; i <= ncartas; i++) {
			mazo.add(i); // 4 por cada color del UNO
			mazo.add(i);
			mazo.add(i);
			mazo.add(i);
		}
	}

}
