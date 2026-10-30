package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Maltros extends Pokemon {
    public Maltros () {
        super("Maltros", TipoCarta.POKEMON, 30, 
        TipoPokemon.FUEGO, 130, 2, true);
    }
    @Override
    public void atacar(Pokemon objetivo) {
        
    }
}
