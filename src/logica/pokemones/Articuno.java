package logica.pokemones;

import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Articuno extends Pokemon {
    public Articuno () {
        super("Articuno", TipoCarta.POKEMON, 30, 
        TipoPokemon.AGUA, 130, true, false);}
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
        }else{
            System.out.println("No tiene suficiente energia para atacar");
        }
    }
    public void atacar2(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=3) {
            if (objetivo.getTipoP()==TipoPokemon.FUEGO) {
                objetivo.setPs(objetivo.getPs()-((100)+20));
            }
            else {
                objetivo.setPs(objetivo.getPs()-(100));
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
        }
    
}

}