package logica.pokemones;
import logica.TipoPokemon;
import logica.TipoCarta;


public class Mewtwo extends Pokemon {
    public Mewtwo() {super("Mewtwo", 
    TipoCarta.POKEMON, 50, TipoPokemon.PSIQUICO, 150, true, false,2);}
    
    private String ataque1 = "Ataque Psíquico";
    private String ataque2 = "Psicorrayo";

    public String getAtaque1() {
        return ataque1;
    }

    public String getAtaque2() {
        return ataque2;
    }

    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=2) {
            if (objetivo.getTipoP()==TipoPokemon.INCOLORO) {
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
            if (objetivo.getTipoP()==TipoPokemon.INCOLORO) {
                objetivo.setPs(objetivo.getPs()-((danioBase*3)+20));
                System.out.println("Ataque" + ataque2 + "realizado con exito");
            }
            else {
                objetivo.setPs(objetivo.getPs()-(danioBase*3));
                System.out.println("Ataque" + ataque2 + "realizado con exito");
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
            return;
        }
    }
}
