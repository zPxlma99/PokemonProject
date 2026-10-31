package logica.CartasEntrenador;
import logica.Carta;
import logica.TipoCarta;

public class Misty extends Carta {
    private boolean isSupport = true;
    private boolean isActivated;
    public boolean isSupport() {
        return isSupport;
    }
    public Misty(boolean isSupport, boolean isActivated) {
        super("Misty", TipoCarta.ENTRENADOR);
        this.isSupport = isSupport;
        this.isActivated = isActivated;

}}
