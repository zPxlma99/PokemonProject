package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Articuno extends Pokemon {
    public Articuno () {
        super("Articuno", TipoCarta.POKEMON, 30, 
        TipoPokemon.AGUA, 130, 2, true);
    }
    @Override
    public void atacar(Pokemon objetivo) {
        
    }
}