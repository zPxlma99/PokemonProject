package logica.CartasEntrenador;
import logica.TipoCarta;
import logica.Carta;
import logica.Pokemon;


public class Pocion extends Carta {

    public Pocion() {
        super("Pocion", TipoCarta.ENTRENADOR);
    }
    public void usar(Pokemon objetivo, String nombrePokemon){
    int newps=objetivo.getPs()+20;
    objetivo.setPs(newps);
    System.out.println("Se ha usado una pocion en "+nombrePokemon+" y ahora tiene "+
    objetivo.getPs()+" puntos de salud");
    }
    

}
