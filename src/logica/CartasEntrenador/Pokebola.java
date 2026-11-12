package logica.CartasEntrenador;
import logica.Carta;
import logica.TipoCarta;
import logica.pokemones.Pokemon;
import logica.Jugador;



public class Pokebola extends CartaEntrenador {

    public Pokebola() {
        super("Pokebola");
        this.isSupport = false;
    }

    @Override
    public boolean ActivarCarta(Jugador jugador, Pokemon objetivo) {
        if (jugador.getMano().size() >= 10) {
            System.out.println("No se puede robar más cartas, la mano está llena.");
            return false;
        }
        for (int i = 0; i < jugador.getMazo().size(); i++) {
            Carta c = jugador.getMazo().get(i);
            if (c.getTipoCarta() == TipoCarta.POKEMON && !((Pokemon) c).isEX()) {
                jugador.getMazo().remove(i);
                jugador.getMano().add(c);
                this.isActivated = true;
                System.out.println("Se ha robado un Pokémon: " + c.getNombreCarta());
                return true;
            }
        }
        System.out.println("No quedan Pokémon (que no sean EX) en el mazo.");
        return false;
    }
}
