package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Magikarp extends Pokemon {
    public Magikarp () {
        super("Magikarp", TipoCarta.POKEMON, 10, 
        TipoPokemon.AGUA, 30, 2, false);
    }
    @Override
    public void atacar(Pokemon objetivo) {
        
    }
}
