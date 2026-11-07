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
    public void ActivarCarta(Jugador jugador,Pokemon pokemon) {
        this.isActivated = true;
        jugador.getMano().clear();                   
        for (int i = 0; i < 2 && !jugador.getMazo().isEmpty(); i++) {
        Carta robada = jugador.getMazo().remove(0);  
        jugador.getMano().add(robada);              
    }
}
    
}
        

