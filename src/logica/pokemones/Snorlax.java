package logica.pokemones;

import logica.TipoPokemon;
import logica.TipoCarta;

public class Snorlax extends Pokemon {
    public Snorlax () {
        super("Snorlax", TipoCarta.POKEMON, 100, 
        TipoPokemon.INCOLORO, 150,  false, false,3);
    }

    private String ataque1 = "Golpe Cuerpo";

    public String getAtaque1() {
        return ataque1;
    }
    @Override 
    public void atacar2(Pokemon objetivo){
        return; // Snorlax no tiene un segundo ataque
    }
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=3) {
                objetivo.setPs(objetivo.getPs()-danioBase);
                System.out.println("Ataque" + ataque1 + "realizado con exito");
            }else {
                System.out.println("No tiene suficiente energia para atacar");
                return;
            }
        }
    }

