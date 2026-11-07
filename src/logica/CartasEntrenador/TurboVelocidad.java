package logica.CartasEntrenador;
import logica.pokemones.Pokemon;
import logica.Jugador;


public class TurboVelocidad extends CartaEntrenador {

    public TurboVelocidad() {
        super("Turbo Velocidad");
        this.isSupport = false;
    }

    // Reduce en 1 el costo de retirada del Pokémon activo este turno.
    @Override
    public boolean ActivarCarta(Jugador jugador, Pokemon objetivo) {
        Pokemon activo = jugador.getPokemonActivo();
        if (activo == null) {
            System.out.println("No tienes Pokémon activo.");
            return false;
        }
        activo.setTurboVelocidadUsada(true);
        this.isActivated = true;
        System.out.println("Turbo Velocidad usada: " + activo.getNombreCarta() + " tiene retirada reducida este turno.");
        return true;
    }
  
}
