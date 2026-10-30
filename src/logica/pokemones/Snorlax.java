package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Snorlax extends Pokemon {
    public Snorlax () {
        super("Snorlax", TipoCarta.POKEMON, 100, 
        TipoPokemon.AGUA, 150, 2, false);
    }
    @Override
    public void atacar(Pokemon objetivo) {
        
    }
}
