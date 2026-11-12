package logica.pokemones;

import logica.TipoPokemon;
import logica.TipoCarta;

public class Moltres extends Pokemon {
    public Moltres () {
        super("Moltres", TipoCarta.POKEMON, 30, 
        TipoPokemon.FUEGO, 130,  true, false,1);
    } 
    private String ataque1 = "Aleteo";
    private String ataque2 = "Danza Infernal";
    
    public String getAtaque1() {
        return ataque1;
    }

    public String getAtaque2() {
        return ataque2;
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
    public void atacar2(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=3) {
            if (objetivo.getTipoP()==TipoPokemon.AGUA) {
                objetivo.setPs(objetivo.getPs()-((70)+20));
                System.out.println("Ataque" + ataque2 + "realizado con exito"); 
            }
            else {
                objetivo.setPs(objetivo.getPs()-(70));
                System.out.println("Ataque" + ataque2 + "realizado con exito");
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
            return;
        }
    }
}

