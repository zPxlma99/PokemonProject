package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Moltres extends Pokemon {
    public Moltres () {
        super("Moltres", TipoCarta.POKEMON, 30, 
        TipoPokemon.FUEGO, 130,  true);
    } @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=1) {
                objetivo.setPs(objetivo.getPs()-danioBase);
            
        }else{
            System.out.println("No tiene suficiente energia para atacar");
        }
    }
    public void atacar2(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=3) {
            if (objetivo.getTipoP()==TipoPokemon.AGUA) {
                objetivo.setPs(objetivo.getPs()-((70)+20));
            }
            else {
                objetivo.setPs(objetivo.getPs()-(70));
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
        }
    }
}

