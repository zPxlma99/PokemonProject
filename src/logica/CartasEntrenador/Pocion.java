package logica.CartasEntrenador;
import logica.TipoCarta;
import logica.Carta;
import logica.Pokemon;
import logica.Jugador;


public class Pocion extends CartaEntrenador {

    public Pocion() {
        super("Pocion");
        this.isSupport = false;
    }

    @Override
    public boolean requiereObjetivo() { return true; }

    @Override
    public boolean ActivarCarta(Jugador jugador, Pokemon objetivo) {
        if (objetivo == null) {
            return false;
        }
        objetivo.setPs(objetivo.getPs() + 20);
        this.isActivated = true;
        System.out.println("Se ha usado una poción en " + objetivo.getNombreCarta()
                + " y ahora tiene " + objetivo.getPs() + " puntos de salud");
        return true;
    }
}
