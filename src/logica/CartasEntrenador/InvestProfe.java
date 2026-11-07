package logica.CartasEntrenador;
import logica.Pokemon;
import java.util.Random;
import logica.Carta;
import logica.TipoCarta;
import logica.Jugador;

public class InvestProfe extends CartaEntrenador {
   
    public boolean isSupport() {
        return isSupport;
    }
    
    public InvestProfe() {
    super("InvestigacionDelProfesor");
    this.isSupport = true;
    this.isActivated = false;
}
@Override
public boolean ActivarCarta(Jugador jugador, Pokemon objetivo) {
    this.isActivated = true;
    jugador.getMano().clear();
    for (int i = 0; i < 2 && !jugador.getMazo().isEmpty(); i++) {
        Carta robada = jugador.getMazo().remove(0);
        jugador.getMano().add(robada);
    }
    System.out.println("Has robado 2 cartas del mazo.");
    System.out.println("Cartas nuevas en la mano:");
    for (Carta carta : jugador.getMano()) {
        System.out.println("- " + carta.getNombreCarta());
    }
    return true;
}
}
        

