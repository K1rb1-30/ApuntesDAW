package arrays;

import java.util.Scanner;

public class EscalaReial {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();

        for (int i = 0; i < casos; i++) {

            int[] flop = new int[7];

            // Leer las 7 cartas
            for (int e = 0; e < 7; e++) {
                flop[e] = sc.nextInt();
            }

            // BUBBLE SORT (ordenar de menor a mayor)
            int max = flop.length;
            boolean ordenado = false;
            int e = 0;

            while (e < max - 1 && !ordenado) {
                ordenado = true; // supondremos que ya está ordenado
                int j = 0;
                while (j < max - e - 1) {
                    if (flop[j] > flop[j + 1]) {
                        int temp = flop[j];
                        flop[j] = flop[j + 1];
                        flop[j + 1] = temp;
                        ordenado = false; // hubo intercambio, no está ordenado
                    }
                    j++;
                }
                e++;
            }

            // --- COMPROBAR ESCALA REIAL ---
            boolean tieneAs = false;
            boolean tiene10 = false;
            boolean tieneJ = false;
            boolean tieneQ = false;
            boolean tieneK = false;

            for (int c = 0; c < 7; c++) {
                if (flop[c] == 1) tieneAs = true;
                else if (flop[c] == 10) tiene10 = true;
                else if (flop[c] == 11) tieneJ = true;
                else if (flop[c] == 12) tieneQ = true;
                else if (flop[c] == 13) tieneK = true;
            }

            boolean escalaReial = (tieneAs && tiene10 && tieneJ && tieneQ && tieneK);

            // --- COMPROBAR ESCALA NORMAL ---
            boolean escala = false;

            // Eliminar duplicados
            int[] sinDuplicados = new int[7];
            int nuevoTam = 0;
            int c = 0;
            while (c < 7) {
                if (c == 0 || flop[c] != flop[c - 1]) {
                    sinDuplicados[nuevoTam] = flop[c];
                    nuevoTam++;
                }
                c++;
            }

            // Buscar 5 consecutivas
            int contador = 1;
            int pos = 1;
            while (pos < nuevoTam) {
                if (sinDuplicados[pos] == sinDuplicados[pos - 1] + 1) {
                    contador++;
                } else {
                    contador = 1;
                }
                if (contador >= 5) {
                    escala = true;
                }
                pos++;
            }

            // --- MOSTRAR RESULTADO ---
            if (escalaReial) {
                System.out.println("Escala Reial");
            } else if (escala) {
                System.out.println("Escala");
            } else {
                System.out.println("No tens res");
            }
        }

        sc.close();
    }
}
