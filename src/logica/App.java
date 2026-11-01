package logica;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import logica.Carta;
import logica.CartasEntrenador.InvestProfe;
import logica.CartasEntrenador.Misty;
import logica.CartasEntrenador.Pocion;
import logica.CartasEntrenador.Pokebola;
import logica.CartasEntrenador.TurboVelocidad;
import logica.pokemones.*;
import java.util.function.Supplier;
public class App {
    //Ataque ataquesPikachu[] = new Ataque[1];
    //Ataque mordisco = new Ataque("Mordisco", 1, 20);
    //ataquesPikachu[0] = mordisco;
    //Pokemon pikachu = new Pokemon(TipoPokemon.ELECTRICO, 60, 1,
      //   ataques.add(mordisco), false);
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    public void manoInicial(){
Random rand = new Random(); 
int num = rand.nextInt(15) + 1; 
    }
    
    

private static void agregar(ArrayList<Carta> mazo, Supplier<Carta> carta, int copias) {
    for (int i = 0; i < copias; i++) {
        mazo.add(carta.get());  
    }
}

public static ArrayList<Carta> mazo1() {
    ArrayList<Carta> mazo = new ArrayList<>();
    agregar(mazo, Articuno::new, 2);
    agregar(mazo, Squirtle::new, 2);
    agregar(mazo, Magikarp::new, 2);
    agregar(mazo, Jigglypuff::new, 2);
    agregar(mazo, Snorlax::new, 2);
    agregar(mazo, Mewtwo::new, 2);
    agregar(mazo, Misty::new, 2);
    agregar(mazo, Pokebola::new, 2);
    agregar(mazo, InvestProfe::new, 2);
    agregar(mazo, TurboVelocidad::new, 2);
    return mazo;
}

public static ArrayList<Carta> mazo2() {
    ArrayList<Carta> mazo = new ArrayList<>();
    agregar(mazo, Moltres::new, 2);
    agregar(mazo, Charmander::new, 2);
    agregar(mazo, pikachu::new, 2);
    agregar(mazo, Squirtle::new, 2);
    agregar(mazo, Zapdos::new, 2);
    agregar(mazo, Snorlax::new, 2);
    agregar(mazo, Pocion::new, 2);
    agregar(mazo, Pokebola::new, 2);
    agregar(mazo, InvestProfe::new, 2);
    agregar(mazo, TurboVelocidad::new, 2);
    return mazo;
}

public static ArrayList<Carta> mazo3() {
    ArrayList<Carta> mazo = new ArrayList<>();
    agregar(mazo, Zapdos::new, 1);
    agregar(mazo, Mewtwo::new, 1);
    agregar(mazo, pikachu::new, 2);
    agregar(mazo, Charmander::new, 2);
    agregar(mazo, Magikarp::new, 2);
    agregar(mazo, Jigglypuff::new, 2);
    agregar(mazo, Snorlax::new, 2);
    agregar(mazo, Pocion::new, 2);
    agregar(mazo, Pokebola::new, 2);
    agregar(mazo, InvestProfe::new, 2);
    agregar(mazo, TurboVelocidad::new, 2);
    return mazo;
}
}
