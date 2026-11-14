package logica.pokemones;
import logica.TipoPokemon;
import logica.TipoCarta;

public class Charmander extends Pokemon {
    public Charmander() 
    {super("Charmander", TipoCarta.POKEMON, 30, TipoPokemon.FUEGO, 60, false, false,2, 3);};
    
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
                 System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ (danioBase+20)+" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+
                (objetivo.getPs() > 0 ? objetivo.getPs(): 0) );
            }
            else{
                objetivo.setPs(objetivo.getPs()-danioBase);
                System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ (danioBase)+" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+
                (objetivo.getPs() > 0 ? objetivo.getPs(): 0) );
            } 
            }else{
                System.out.println("No tiene suficiente energia para atacar");
                return;
            }
        }
}