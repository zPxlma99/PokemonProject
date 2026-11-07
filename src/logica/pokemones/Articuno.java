package logica.pokemones;

import logica.TipoPokemon;
import logica.TipoCarta;

public class Articuno extends Pokemon {
    public Articuno() {
        super("Articuno", TipoCarta.POKEMON, 30,
                TipoPokemon.AGUA, 130, true, false, 1);
    }
    private String ataque1 = "Viento Helado";
    public String getAtaque1() {
        return ataque1;
    }
    private String ataque2 = "Ventisca";

    public String getAtaque2() {
        return ataque2;
    }
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=1) {
            if (objetivo.getTipoP()==TipoPokemon.FUEGO) {
                objetivo.setPs(objetivo.getPs()-(danioBase+20));
                System.out.println("Ataque" + ataque1 + "realizado con exito");
            }
            else {
                objetivo.setPs(objetivo.getPs()-danioBase);
                System.out.println("Ataque" + ataque1 + "realizado con exito");
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
            return;
        }
    }
    public void atacar2(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=3) {
            if (objetivo.getTipoP()==TipoPokemon.FUEGO) {
                objetivo.setPs(objetivo.getPs()-((100)+20));
                System.out.println("Ataque" + ataque2 + "realizado con exito");
            }
            else {
                objetivo.setPs(objetivo.getPs()-(100));
                System.out.println("Ataque " + ataque2 + " realizado con exito");
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
            return;
        }
    
}

}