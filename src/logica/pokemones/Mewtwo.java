package logica.pokemones;
import logica.TipoPokemon;
import logica.TipoCarta;


public class Mewtwo extends Pokemon {
    public Mewtwo() {super("Mewtwo", 
    TipoCarta.POKEMON, 50, TipoPokemon.PSIQUICO, 150, true, false,2, 3);}
    
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
            if (objetivo.getTipoP()==TipoPokemon.INCOLORO) {
                objetivo.setPs(objetivo.getPs()-((danioBase*3)+20));
                System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ ((danioBase*3)+20)+" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+objetivo.getPs());
            }
            else {
                objetivo.setPs(objetivo.getPs()-(danioBase*3));
                System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ (danioBase*3)+" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+objetivo.getPs());
            }
        }else{
            System.out.println("No tiene suficiente energia para atacar");
            return;
        }
    }
}
