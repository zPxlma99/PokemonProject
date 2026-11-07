package logica.CartasEntrenador;
import logica.Carta;
import logica.TipoCarta;
import logica.Pokemon;
import logica.TipoPokemon;
import logica.Jugador;

public class Misty extends CartaEntrenador {
    private boolean isSupport = true;
    private boolean isActivated;
    
    public void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public boolean isSupport() {
        return isSupport;
    }

    public Misty() {
        super("Misty");
        this.isSupport = true;
        this.isActivated = false;
    }
    @Override 
    public void ActivarCarta(Jugador jugador,Pokemon objetivo) {
        //VALIDAR SI HAY UN PROFESOR ACTIVO EN EL MISMO TURNO QUE SE INVOCA LA MISMA.
        Carta pokemon=(Carta) objetivo;
            if (objetivo.getTipoP() == TipoPokemon.AGUA) {
                this.isActivated = true;
                int newEnergia = objetivo.getEnergiaAcumulada() + 3;
                objetivo.setEnergiaAcumulada(newEnergia);
                System.out.println("Se ha usado la carta Misty en " + pokemon.getNombreCarta() + " y ahora tiene " +
                        objetivo.getEnergiaAcumulada() + " puntos de energía acumulada.");
            } else {
                System.out.println("Tú pokemon no es de tipo Agua, por lo que no se puede usar la carta Misty en él.");
                this.isActivated = false;
                return;
            }

        
    }
}
