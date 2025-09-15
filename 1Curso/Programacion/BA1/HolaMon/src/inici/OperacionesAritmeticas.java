package inici;

public class OperacionesAritmeticas {
	public static void main(String[] args) {
		
		//SUMA
		
		int a = 30;
		int b = 27;
		int suma = a + b;
		System.out.println(suma);
		
		
		//No se pueden sumar dos valores con distinto tipo
		
		double c = 0.1;
		
		int sumadecimal = (int) (a + c); //transforma el resultado double y nos retorna la suma en valor int
		
		//RESTA
		
		int resta = a - b;
		
		System.out.println(resta);
		
		// MULTIPLICACION
		
		int multi = a * b;
		
		System.out.println(multi);
		
		//Division
		
		int div = a / b;
		
		System.out.println(div);
		
		//Incrementar en uno
		
		a++;
		b++;
		
		System.out.println(a);
		System.out.println(b);
		
		//MODULO
		
		int y = 30;
		int x = 3;
		
		int modulo = y % x;
		
		System.out.println(modulo);
		
		//POTENCIA
		
		double potencia = Math.pow(x, y);
		System.out.println(potencia);
		
		
		
		
		
		
		
		
	}
}
