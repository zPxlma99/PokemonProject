//AL CREAR LA CLASE PIKACHU SE PONE AUTOMÁTICAMENTE EN MINÚSCULA ASÍ SE CREE VARIAS VECES
package logica.pokemones;
import logica.TipoPokemon;
import logica.TipoCarta;

public class PokPikachu extends Pokemon {
    public PokPikachu() {super("Pikachu", TipoCarta.POKEMON, 20, TipoPokemon.ELECTRICO, 60,  false, false,1);}
    
    private String ataque1 = "Mordisco";

    public String getAtaque1() {
        return ataque1;
    }
    @Override 
    public void atacar2(Pokemon objetivo){
        return; // Pikachú no tiene un segundo ataque
    }
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=1) {
            if (objetivo.getTipoP()==TipoPokemon.AGUA) {
                objetivo.setPs(objetivo.getPs()-(danioBase+20));
                System.out.println("Ataque" + ataque1 + "realizado con exito");
            }
            else {
                objetivo.setPs(objetivo.getPs()-danioBase);
                System.out.println("Ataque" + ataque1 + "realizado con exito");
            }
        }else {
            System.out.println("No tiene suficiente energia para atacar");
            return;
        }
    }
}
