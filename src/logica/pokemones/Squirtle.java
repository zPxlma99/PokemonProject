package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Squirtle extends Pokemon {
    public Squirtle() {
        super("Squirtle", TipoCarta.POKEMON, 20, TipoPokemon.AGUA, 60, false, false);
    }
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=1) {
            if (objetivo.getTipoP()==TipoPokemon.FUEGO) {
                objetivo.setPs(objetivo.getPs()-(danioBase+20));
            }
            else {
                objetivo.setPs(objetivo.getPs()-danioBase);
            }
        }
        System.out.println();
    }
}
