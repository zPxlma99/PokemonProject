package logica.pokemones;
import logica.Pokemon;
import logica.TipoPokemon;

public class Charmander extends Pokemon {
    public Charmander() {super(30, TipoPokemon.FUEGO, 60, 2, false);}
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=2) {
            if (objetivo.getTipoP()==TipoPokemon.AGUA) {
                objetivo.setPs(objetivo.getPs()-(danioBase+20));
            }
            else {
                objetivo.setPs(objetivo.getPs()-danioBase);
            }




        }
        System.out.println();
    }
}