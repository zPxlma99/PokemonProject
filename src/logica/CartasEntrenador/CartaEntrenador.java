package logica.CartasEntrenador;

import logica.Carta;
import logica.TipoCarta;

public class CartaEntrenador extends Carta {
    protected boolean isSupport = true;
    protected boolean isActivated;

    public CartaEntrenador(String nombre) {
        super(nombre, TipoCarta.ENTRENADOR);
    }

    public void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public boolean isSupport() {
        return isSupport;
    }

}
