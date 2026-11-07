package logica.pokemones;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Charmander extends Pokemon {
    public Charmander() 
    {super("Charmander", TipoCarta.POKEMON, 30, TipoPokemon.FUEGO, 60, false, false,2);};
    
    private String ataque1 = "Ascuas";

    public String getAtaque1() {
        return ataque1;
    }
    
    @Override 
    public void atacar2(Pokemon objetivo){
        return; // Charmander no tiene un segundo ataque
    }
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=2) {
            if (objetivo.getTipoP()==TipoPokemon.AGUA) {
                objetivo.setPs(objetivo.getPs()-(danioBase+20));
                System.out.println("Ataque" + ataque1 + "realizado con exito");
            }
            else{
                objetivo.setPs(objetivo.getPs()-danioBase);
                System.out.println("Ataque" + ataque1 + "realizado con exito");
            } 
            }else{
                System.out.println("No tiene suficiente energia para atacar");
                return;
            }
        }
}