package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Zapdos extends Pokemon {
    public Zapdos () {
        super("Zapdos", TipoCarta.POKEMON, 30, 
        TipoPokemon.ELECTRICO, 130,true, false);
    } @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=2) {
                objetivo.setPs(objetivo.getPs()-danioBase);
            }else{
            System.out.println("No tiene suficiente energia para atacar");
        }
    }
    public void atacar2(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=3) {
            if (objetivo.getTipoP()==TipoPokemon.AGUA) {
                objetivo.setPs(objetivo.getPs()-((danioBase*3)+20));
            }
            else {
                objetivo.setPs(objetivo.getPs()-(danioBase*3));
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
        }
    }
}

