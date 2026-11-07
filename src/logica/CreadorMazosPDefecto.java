package logica;

import java.util.ArrayList;
import java.util.function.Supplier;
import logica.CartasEntrenador.*;
import logica.pokemones.*;


public class CreadorMazosPDefecto {
    

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
    agregar(mazo, PokPikachu::new, 2);
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
    agregar(mazo, PokPikachu::new, 2);
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
public static void mostrarMazos(ArrayList<Carta> mazo1, ArrayList<Carta> mazo2, ArrayList<Carta> mazo3) {
    System.out.println("----------------------------------------------------");
    System.out.printf("%-15s %-15s %-15s%n", "Mazo 1", "Mazo 2", "Mazo 3");
    for (int i = 0; i < mazo1.size(); i++) {
        System.out.printf("%-15s %-15s %-15s%n",
                mazo1.get(i).getNombreCarta(),
                mazo2.get(i).getNombreCarta(),
                mazo3.get(i).getNombreCarta());
    }
    System.out.println("----------------------------------------------------");
}


}
