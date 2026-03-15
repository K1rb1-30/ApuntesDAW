package objectes;

public class ObjecteFactory {
	
	public static Objecte crearObjecte(String tipus) {
		if (tipus == null || tipus.isEmpty())
            return null;
        switch (tipus) {
        case "POCIO":
            return new Pocio(50);  //les pocions per defecte curen 50 de vida
        case "SUPERPOCIO":
            return new Pocio(100);
        case "HIPERPOCIO":
            return new Pocio(200);
        case "REVIURE":
        	return new Reviure();
        case "ARMADURA":
        	return new Armadura(50);
        case "ARMA":
        	return new Arma(50);
        default:
            throw new IllegalArgumentException("Tipus d'objecte desconegut "+tipus);
        }

	}
}
