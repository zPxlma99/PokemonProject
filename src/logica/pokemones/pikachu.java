//AL CREAR LA CLASE PIKACHU SE PONE AUTOMÁTICAMENTE EN MINÚSCULA ASÍ SE CREE VARIAS VECES
package logica.pokemones;
import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;

public class pikachu extends Pokemon {
    public pikachu() {super("Pikachu", TipoCarta.POKEMON, 20, TipoPokemon.ELECTRICO, 60,  false);}
    
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=1) {
            if (objetivo.getTipoP()==TipoPokemon.AGUA) {
                objetivo.setPs(objetivo.getPs()-(danioBase+20));
            }
            else {
                objetivo.setPs(objetivo.getPs()-danioBase);
            }
        }
    }
}
