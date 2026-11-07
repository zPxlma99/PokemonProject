package logica.CartasEntrenador;
import logica.Carta;
import logica.TipoCarta;
import logica.Pokemon;
import logica.TipoPokemon;
import logica.Jugador;

public class Misty extends CartaEntrenador {

    public Misty() {
        super("Misty");
    }

    @Override
    public boolean requiereObjetivo() { return true; }

    @Override
    public String getAvisoObjetivo() { return "(SOLO POKEMONES DE AGUA)"; }

    @Override
    public boolean ActivarCarta(Jugador jugador, Pokemon objetivo) {
        if (objetivo == null || objetivo.getTipoP() != TipoPokemon.AGUA) {
            System.out.println("Tu Pokémon no es de tipo Agua, por lo que no se puede usar Misty en él.");
            return false;
        }
        this.isActivated = true;
        objetivo.setEnergiaAcumulada(objetivo.getEnergiaAcumulada() + 3);
        System.out.println("Se ha usado Misty en " + objetivo.getNombreCarta() + " y ahora tiene "
                + objetivo.getEnergiaAcumulada() + " puntos de energía acumulada.");
        return true;
    }
}