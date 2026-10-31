package logica;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntos;
    private ArrayList<Carta> cartas;
    private ArrayList<Carta> mazo = new ArrayList<>();
    private ArrayList<Carta> mano = new ArrayList<>();
    private boolean isCurrentPlayer;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    public ArrayList<Carta> getMazo() {
        return mazo;
    }
    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }
    public ArrayList<Carta> getMano() {
        return mano;
    }
    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }
    public boolean isCurrentPlayer() {
        return isCurrentPlayer;
    }
    public void setCurrentPlayer(boolean isCurrentPlayer) {
        this.isCurrentPlayer = isCurrentPlayer;
    }
    
}
