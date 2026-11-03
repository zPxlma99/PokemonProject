package logica.CartasEntrenador;
import logica.Carta;
import logica.TipoCarta;
import logica.Jugador;
import logica.Pokemon;



public class Pokebola extends Carta {
    public Pokebola() {
        super("Pokebola", TipoCarta.ENTRENADOR);
    }
public Pokemon ActivarCarta(Jugador jugador) {
    for (int i = 0; i < jugador.getMazo().size(); i++) {
        Carta c = jugador.getMazo().get(i);
        if (c.getTipoCarta() == TipoCarta.POKEMON) {
            Pokemon p = (Pokemon) c;
            if (!p.isEX()) {
                return p;
            }
        }
    }
    return null; 
}}
