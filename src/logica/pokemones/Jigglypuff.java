package logica.pokemones;

import logica.TipoPokemon;
import logica.TipoCarta;

public class Jigglypuff extends Pokemon {
    public Jigglypuff() {
        super("Jigglypuff", TipoCarta.POKEMON, 20, 
        TipoPokemon.INCOLORO, 70, false, false,1);
    }
    private String ataque1 = "Golpe";

    public String getAtaque1() {
        return ataque1;
    }
    
    @Override 
    public void atacar2(Pokemon objetivo){
        return; // Jigglypuff no tiene un segundo ataque
    }
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=1) {  
                objetivo.setPs(objetivo.getPs()-danioBase);
                System.out.println("Ataque" + ataque1 + "realizado con exito");
            }else{
                System.out.println("No tiene suficiente energia para atacar");
                return;
            }
        }
    
}
