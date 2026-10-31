package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Jigglypuff extends Pokemon {
    public Jigglypuff() {
        super("Jigglypuff", TipoCarta.POKEMON, 20, 
        TipoPokemon.INCOLORO, 70, false);
    }
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=1) {  
                objetivo.setPs(objetivo.getPs()-danioBase);
            }
        }
    
}
