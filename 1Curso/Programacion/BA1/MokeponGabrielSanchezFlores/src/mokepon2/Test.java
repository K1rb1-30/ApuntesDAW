package mokepon2;

public class Test {

	public static void main(String[] args) {
		
		
		//podem crear un nou Mokepon perque existeix la classe i ara es un nou tipus de variable
        //el new Mokepon() es el seu constructor
		
        Mokepon mikachu = new Mokepon();
        
        //podem accedir als seus atributs interns amb el punt
        mikachu.nom = "Mikachu";
        
        //també podem accedir als seus mètodes interns amb el punt
        mikachu.diguesNom();
        
        System.out.println("-------------------------------------");
        mikachu.atorgarExperiencia(1000);
        
        System.out.println(mikachu.exp + " " + mikachu.nivell);
        
        System.out.println("-------------------------------------");
        Mokepon missingNo = new Mokepon();
        System.out.println(missingNo.nom);
        Mokepon marmander = new Mokepon("Marmander");
        System.out.println(marmander.nom+" "+marmander.atk);
        Mokepon mulmasaur = new Mokepon("Mulmasaur", 5);  
        System.out.println(mulmasaur.nom+" "+mulmasaur.atk);
        
        System.out.println("-------------------------------------");
        Mokepon piplup = new Mokepon("Piplup", Tipus.AIGUA);
        System.out.println(piplup.nom+" "+piplup.atk);
        if(piplup.tipus == Tipus.AIGUA) {
            System.out.println("Piplup es de Aigua!");
        }
        
        System.out.println("-------------------------------------");
        
        Atacs hidrobomba = new Atacs("Hidrobomba", Tipus.AIGUA);
        Atacs nitrocarga = new Atacs("nitrocarga", 3, Tipus.FOC, 2);
        piplup.afegirAtac(hidrobomba);
        piplup.afegirAtac(nitrocarga);
        
        
        System.out.println("-------------------------------------");
        Mokepon browt = new Mokepon("Browt", Tipus.PLANTA);
        
        piplup.atacar(browt, 1);
        piplup.atacar(browt, 1);
        piplup.debilitarse();
        piplup.atacar(browt, 1);
        piplup.curar();
        piplup.atacar(browt, 0);
        
        
        System.out.println("-------------------------------------");
        
        Mokepon charmander = new Mokepon("Charmander", Tipus.FOC);
        
        MokeponCapturat elMeuCharmander = new MokeponCapturat(charmander, "Pepito", "GabrielSF");
        System.out.println(elMeuCharmander.nom);
        elMeuCharmander.diguesNom();
        piplup.atacar(elMeuCharmander, 0);
        
        elMeuCharmander.mote();
        
        MokeponCapturat pakito = piplup.capturar("Gabri", "Pakito");
        
        elMeuCharmander.capturar("Gabri", "Pepe2");
        
        pakito.mote();

    }
	
	static MokeponCapturat capturar(Mokepon mok, String nomEntrenador, String nomDonat) {
		return mok.capturar(nomEntrenador, nomDonat);
	}

}


