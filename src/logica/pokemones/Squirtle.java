package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Squirtle extends Pokemon {
    public Squirtle() {
        super("Squirtle", TipoCarta.POKEMON, 20, TipoPokemon.AGUA, 60, 2, false);
    }
    @Override
    public void atacar(Pokemon objetivo) {
        
    }
}
