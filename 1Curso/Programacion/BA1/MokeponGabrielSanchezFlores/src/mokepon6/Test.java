package mokepon6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import objectes.*;

public class Test {

	public static void main(String[] args) {
		
		
		//podem crear un nou Mokepon perque existeix la classe i ara es un nou tipus de variable
        //el new Mokepon() es el seu constructor
		
        Mokepon mikachu = new Mokepon();
        
        //podem accedir als seus atributs interns amb el punt
        mikachu.setNom("Mikachu");
        
        //també podem accedir als seus mètodes interns amb el punt
        mikachu.diguesNom();
        
        System.out.println("-------------------------------------");
        mikachu.atorgarExperiencia(1000);
        
        System.out.println(mikachu.getExp() + " " + mikachu.getNivell());
        
        System.out.println("-------------------------------------");
        Mokepon missingNo = new Mokepon();
        System.out.println(missingNo.getNom());
        Mokepon marmander = new Mokepon("Marmander");
        System.out.println(marmander.getNom()+" "+marmander.getAtk());
        Mokepon mulmasaur = new Mokepon("Mulmasaur", 5);  
        System.out.println(mulmasaur.getNom()+" "+mulmasaur.getAtk());
        
        System.out.println("-------------------------------------");
        Mokepon piplup = new Mokepon("Piplup", Tipus.AIGUA);
        System.out.println(piplup.getNom()+" "+piplup.getAtk());
        if(piplup.getTipus() == Tipus.AIGUA) {
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
        
        Mokepon fuecoco = new Mokepon("Fuecoco", Tipus.FOC);
        
        MokeponCapturat elMeuCharmander = new MokeponCapturat(charmander, "Pepito", "GabrielSF");
        System.out.println(elMeuCharmander.getNom());
        elMeuCharmander.diguesNom();
        piplup.atacar(elMeuCharmander, 0);
        
        elMeuCharmander.mote();
        
        MokeponCapturat pakito = null;
		try {
			pakito = piplup.capturar("Gabri", "Pakito");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        MokeponCapturat pepito = null;
		try {
			pepito = capturar(fuecoco, "Gabrie", "Pepito");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		MokeponCapturat pepe = null;
        try {
			pepe = pepito.capturar("pepe", "ear");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			elMeuCharmander.capturar("Gabri", "Pepe2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        pakito.mote();
        
        System.out.println("-------------------------------------");
        
        Mokepon bulbasaur = new Mokepon();
        bulbasaur.estatic = "hola";
        Mokepon rotom = new Mokepon("Rotom");
        rotom.estatic = "adeu";
        System.out.println(bulbasaur.estatic);
        
        
        System.out.println();
        
        MokeponCapturat rotome = new MokeponCapturat(rotom, "rotillo", "GabrielSF");
        
        System.out.println(rotome.NombreMokeponsCapturats);
        
        System.out.println("-------------------------------------");
        
        System.out.println(hidrobomba);
        
        System.out.println(rotom);
        
        System.out.println(rotome);
        
        System.out.println("-------------------------------------");
        
        
//        Pocio po1 = new Pocio(20);
//        Reviure re1 = new Reviure();
        
        
//        
//        rotome.debilitarse();
//        
//        re1.utilitzar(rotome);
//        
//        System.out.println(rotome.getHp_actual());
//        po1.utilitzar(rotome);
//        System.out.println(rotome.getHp_actual());
//        po1.donar(rotome);
//        
//        System.out.println("-------------------------------------");
//        
//        System.out.println("Prueba para ver si los Objetos de equipamiento funcionan");
//        
//        System.out.println(rotome.getAtk());
//        System.out.println(rotome.getDef());
//        
////        Arma a1 = new Arma("Cinta Fuerte", 30);
////        Armadura d1 = new Armadura("Pluma Aguante", 20);
//        
//        a1.Equipar(rotome);
//        d1.Equipar(rotome);
        
        System.out.println(rotome.getAtk());
        System.out.println(rotome.getDef());
        
        System.out.println("-------------------------------------");
        
        System.out.println("Prueba para ver si se reproducen");
        
        //marmander.debilitarse();
        
        //el try-catch té dues parts
        try {
         //intentem fer el codi en el try
         Ou marmasaur = marmander.reproduccio(mulmasaur);
        //si salta una excepció al fer el codi que hi ha dintre del try, anirà a executar aquest codi, en comptes d'acabar el programa
        } catch (Exception e) {
            //Escrivim el missatge de l’excepció. El missatge és la String que hem posat en el constructor de l’excepció
            e.printStackTrace();
	  //el finally s'executa sempre, tant si ha saltat l'excepció com si no
        } finally {
            System.out.println(marmander.getNom() + " està molt cansat");
        }
        
        try {
            //intentem fer el codi en el try
            Ou marplup = marmander.reproduccio(piplup);
           //si salta una excepció al fer el codi que hi ha dintre del try, anirà a executar aquest codi, en comptes d'acabar el programa
           } catch (Exception e) {
               e.printStackTrace();
           } finally {
               System.out.println(marmander.getNom() + " està molt cansat");
           }
        
        System.out.println("-------------------------------------");
        
        System.out.println("Prueba para ordenar los pokemon");
        
        ArrayList<Mokepon> mokedex = new ArrayList<>();
        mokedex.add(new Mokepon("Charmander", Tipus.FOC, 10));
        mokedex.add(new Mokepon("Squirtle", Tipus.AIGUA, 8));
        mokedex.add(new Mokepon("Bulbasaur", Tipus.PLANTA, 12));
        mokedex.add(new Mokepon("Pidgey", Tipus.AIGUA, 7));
        mokedex.add(new Mokepon("Vulpix", Tipus.FOC, 15));
        mokedex.add(new Mokepon("Charmander", Tipus.FOC, 12));
        
        Collections.sort(mokedex);
        
        System.out.println(mokedex);
        
     

        
        System.out.println("-------------------------------------");
        
        System.out.println("Nom de tots");
        
        nomDeTots(mokedex);
        
        System.out.println("-------------------------------------");
        
        System.out.println("TEAM");
        
        Team<Mokepon> equipo = new Team<>();
        equipo.add(new Mokepon("Charmander", Tipus.FOC, 10));
        equipo.add(new Mokepon("Squirtle", Tipus.AIGUA, 8));
        equipo.add(new Mokepon("Bulbasaur", Tipus.PLANTA, 12));
        equipo.add(new Mokepon("Pidgey", Tipus.AIGUA, 7));
        equipo.add(new Mokepon("Vulpix", Tipus.FOC, 15));
        equipo.add(new Mokepon("Pikachu", Tipus.AIGUA, 12));
        
        boolean añadido = equipo.add(new Mokepon("Leafeon", Tipus.PLANTA, 13));

        System.out.println("¿Se añadió Leafeon? " + añadido);
        System.out.println("Tamaño del equipo: " + equipo.size());
        
        nomDeTots(equipo);
        
        System.out.println("-------------------------------------");
        
        System.out.println("FACTORY DE OBJETOS");
        
        String[] tipus = {"POCIO", "SUPERPOCIO", "HIPERPOCIO", "REVIURE", "ARMADURA", "ARMA"};

        Random r = new Random();
        String escollit = tipus[r.nextInt(tipus.length)];

        Objecte obj = ObjecteFactory.crearObjecte(escollit);

        System.out.println("Objecte generat: " + escollit);
        

    }
	
	static MokeponCapturat capturar(Mokepon mok, String nomEntrenador, String nomDonat) throws Exception {
		return mok.capturar(nomEntrenador, nomDonat);
	}
	
	//estem dient
    //? -> qualsevol classe
    //extends Mokepon -> que sigui Mokepon o filla seva
    public static void nomDeTots(ArrayList<? extends Mokepon> list) {
        for(Mokepon m : list) {
            m.diguesNom();
        }
    }
    

    
    

	
	
	
	

}


