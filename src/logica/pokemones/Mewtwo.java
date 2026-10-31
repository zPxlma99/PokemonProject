package logica.pokemones;
import logica.Pokemon;
import logica.TipoPokemon;
import logica.TipoCarta;


public class Mewtwo extends Pokemon {
    public Mewtwo() {super("Mewtwo", 
    TipoCarta.POKEMON, 50, TipoPokemon.PSIQUICO, 150, 2, true);}
    
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=2) {
            if (objetivo.getTipoP()==TipoPokemon.INCOLORO) {
                objetivo.setPs(objetivo.getPs()-(danioBase+20));
            }
            else {
                objetivo.setPs(objetivo.getPs()-danioBase);
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
        }
    }
    public void atacar2(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=3) {
            if (objetivo.getTipoP()==TipoPokemon.INCOLORO) {
                objetivo.setPs(objetivo.getPs()-((danioBase*3)+20));
            }
            else {
                objetivo.setPs(objetivo.getPs()-(danioBase*3));
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
        }
    }
}
