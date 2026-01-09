package joelmatrius;

import java.util.Scanner;

public class Alfil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		sc.nextLine();
		
		for(int i = 0; i < casos; i++) {
			
			int[][] tablero = new int[8][8];
			
			for (int e = 0; e < tablero.length; e++) {
				for (int j = 0; j < tablero[0].length; j++) {
					tablero[e][j] = 0;
				}
			}
			
			String posicio = sc.nextLine();
			
			String[] separado = posicio.split("");
			
			int posicionRealColumna = 0;
			int posicionRealFila = Integer.parseInt(separado[1]);
			
			switch (separado[0]) {
			case "a":
				posicionRealColumna = 0;
				break;
			case "b":
				posicionRealColumna = 1;
				break;
			case "c":
				posicionRealColumna = 2;
				break;
			case "d":
				posicionRealColumna = 3;
				break;
			case "e":
				posicionRealColumna = 4;
				break;
			case "f":
				posicionRealColumna = 5;
				break;
			case "g":
				posicionRealColumna = 6;
				break;
			case "h":
				posicionRealColumna = 7;
				break;
			default:
				System.out.println("error");
			}
			
			tablero[posicionRealFila - 1][posicionRealColumna] = 1;
			
			printarMatriu(tablero);
			
			boolean sigo = true;
			
			int contador = 0;
			
			
			int filaTempDiagonalDerecha = posicionRealFila - 1;
			int columnaTempDiagonalDerecha = posicionRealColumna;
			while(sigo) {
				if(tablero[filaTempDiagonalDerecha][columnaTempDiagonalDerecha] < 0) {
					sigo = false;
				}else if(tablero[filaTempDiagonalDerecha][columnaTempDiagonalDerecha] == 0) {
					contador++;
					
					filaTempDiagonalDerecha++;
					columnaTempDiagonalDerecha++;
				}else {
					filaTempDiagonalDerecha++;
					columnaTempDiagonalDerecha++;
				}
				
			}
			
			System.out.println(contador);
			
			
			
			
		}
		

	}
	
	
	public static void printarMatriu(int[][] patata) {
		for (int i = 0; i < patata.length; i++) {
			for (int j = 0; j < patata[0].length; j++) {
				System.out.print(patata[i][j] + " ");
			}
			System.out.println();
		}

	}

}
