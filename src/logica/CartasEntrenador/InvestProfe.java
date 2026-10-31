package logica.CartasEntrenador;
import logica.Carta;
import logica.TipoCarta;

public class InvestProfe extends Carta {
    private boolean isSupport = true;
    private boolean isActivated;
    public boolean isSupport() {
        return isSupport;
    }
    public InvestProfe(boolean isSupport, boolean isActivated) {
        super("Invest Profe", TipoCarta.ENTRENADOR);
        this.isSupport = isSupport;
        this.isActivated = isActivated;

    }
    public void ActivarCarta() {
        this.isActivated = true;
        //por implementar la logica de la carta
    }
        


}
