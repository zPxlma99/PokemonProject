package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Snorlax extends Pokemon {
    public Snorlax () {
        super("Snorlax", TipoCarta.POKEMON, 100, 
        TipoPokemon.INCOLORO, 150,  false);
    }
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=3) {
                objetivo.setPs(objetivo.getPs()-danioBase);
            }
        }
    }

