package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Jigglypuff extends Pokemon {
    public Jigglypuff() {
        super("Jigglypuff", TipoCarta.POKEMON, 20, 
        TipoPokemon.INCOLORO, 70, 2, false);
    }
    @Override
    public void atacar(Pokemon objetivo) {
        
    }
}