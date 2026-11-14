package logica.pokemones;

import logica.TipoPokemon;
import logica.TipoCarta;

public class Articuno extends Pokemon {
    public Articuno() {
        super("Articuno", TipoCarta.POKEMON, 30,
                TipoPokemon.AGUA, 130, true, false, 1, 3);
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
                System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ (danioBase+20)+" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+
                (objetivo.getPs() > 0 ? objetivo.getPs(): 0) );
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
    public void atacar2(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=this.getCostoEnergiaAtaque2()) {
            if (objetivo.getTipoP()==TipoPokemon.FUEGO) {
                objetivo.setPs(objetivo.getPs()-((100)+20));
                System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ ((100)+20)+" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+
                (objetivo.getPs() > 0 ? objetivo.getPs(): 0) );
                
            }else {
                objetivo.setPs(objetivo.getPs()-(100));
                System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ (100)+" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+
                (objetivo.getPs() > 0 ? objetivo.getPs(): 0) );
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
            return;
        }
    }
}
