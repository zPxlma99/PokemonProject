package logica.pokemones;

import logica.TipoPokemon;
import logica.TipoCarta;

public class Squirtle extends Pokemon {
    public Squirtle() {
        super("Squirtle", TipoCarta.POKEMON, 20, TipoPokemon.AGUA, 60, false, false,1, 0);
    }
    private String ataque1 = "Placaje";

    public String getAtaque1() {
        return ataque1;
    }
    @Override 
    public void atacar2(Pokemon objetivo){
        return; // Squirtle no tiene un segundo ataque
    }
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=1) {
            if (objetivo.getTipoP()==TipoPokemon.FUEGO) {
                objetivo.setPs(objetivo.getPs()-(danioBase+20));
                System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ (danioBase)+" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+
                (objetivo.getPs() > 0 ? objetivo.getPs(): 0) );
            }
            else {
                objetivo.setPs(objetivo.getPs()-danioBase);
                System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ (danioBase)+" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+
                (objetivo.getPs() > 0 ? objetivo.getPs(): 0) );
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
            return;
        }
    }
}
