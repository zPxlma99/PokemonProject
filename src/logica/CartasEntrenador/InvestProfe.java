package logica.CartasEntrenador;

import java.util.Random;

import logica.Carta;
import logica.TipoCarta;
import logica.Jugador;

public class InvestProfe extends Carta {
    private boolean isSupport = true;
    private boolean isActivated;
    public boolean isSupport() {
        return isSupport;
    }
    
    public InvestProfe() {
    super("InvestProfe", TipoCarta.ENTRENADOR);
    this.isSupport = true;
    this.isActivated = false;
}
    public void ActivarCarta(Jugador jugador) {
        this.isActivated = true;
        jugador.getMano().clear();                   
        for (int i = 0; i < 2 && !jugador.getMazo().isEmpty(); i++) {
        Carta robada = jugador.getMazo().remove(0);  
        jugador.getMano().add(robada);              
    }
}
    
}
        

