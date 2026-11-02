package logica.CartasEntrenador;
import logica.Carta;
import logica.TipoCarta;
import logica.Jugador;
import logica.Pokemon;



public class Pokebola extends Carta {
    public Pokebola() {
        super("Pokebola", TipoCarta.ENTRENADOR);
    }
public void ActivarCarta(Jugador jugador) {
    if (jugador.getMano().size() >= 10) {
        System.out.println("No se puede robar más cartas, la mano está llena.");
        return;
    }
    for (int i = 0; i < jugador.getMazo().size(); i++) {
        Carta c = jugador.getMazo().get(i);
        if (c.getTipoCarta() == TipoCarta.POKEMON) {
            Pokemon p = (Pokemon) c;
            if (!p.isEX()) {
                jugador.getMazo().remove(i);
                jugador.getMano().add(p);
                System.out.println("Se ha robado un Pokémon: " + c.getNombreCarta());
                return;
            }
        }
    }
    
}}
