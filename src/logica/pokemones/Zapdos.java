package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Zapdos extends Pokemon {
    public Zapdos () {
        super("Zapdos", TipoCarta.POKEMON, 30, 
        TipoPokemon.ELECTRICO, 130, 2, true);
    }
    @Override
    public void atacar(Pokemon objetivo) {
        
    }
}
