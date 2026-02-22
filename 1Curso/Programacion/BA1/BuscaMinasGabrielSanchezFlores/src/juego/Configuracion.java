package juego;

import java.util.ArrayList;

/**
 * Clase que almacena la configuración del juego.
 * @author Gabriel Sanchez Flores
 */
public class Configuracion {
	/** 
	 * Número total de minas.
	 */
	int nMinas;
	/** 
	 * Número de filas del tablero.
	 */
	int filas;
	/** 
	 * Número de columnas del tablero. 
	 */
	int columnas;
	/** 
	 * Nombre del jugador. 
	 */
	String nombreJugador;
	/** 
	 * Estado actual de la partida.
	 */
	String estadoPartida;
	/** 
	 * Lista de jugadores ganadores. 
	 */
	ArrayList<String> winners = new ArrayList<>();
}
