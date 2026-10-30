package logica;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntos;
    private Carta[] cartas;
    private Carta mazo=cartas[20];
    private ArrayList<Carta>mano;
    private boolean isCurrentPlayer;
}
