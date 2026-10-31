package logica.CartasEntrenador;
import logica.Carta;
import logica.TipoCarta;
import logica.Pokemon;
import logica.Jugador;


public class TurboVelocidad extends Carta {
    public TurboVelocidad() {
        super("Turbo Velocidad", TipoCarta.ENTRENADOR);


    }
//Reduce en 1 el costo de retirada del Pokémon activo este turno.
    public void use(Pokemon objetivo, Jugador jugador) {
    if(objetivo.isActive()){
        objetivo.setTurboVelocidadUsada(true);

    }
}
}
