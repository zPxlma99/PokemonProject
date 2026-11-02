package logica;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntos;
    private ArrayList<Carta> mazo = new ArrayList<>();
    private ArrayList<Carta> mano = new ArrayList<>();
    private Pokemon pokemonActivo;
    private int energy;
    private Carta cartaEntrenador;
    private Pokemon Banco[] = new Pokemon[3];
    public Jugador(String nombre, int puntos, ArrayList<Carta> mazo, ArrayList<Carta> mano, int energy) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.mazo = mazo;
        this.mano = mano;
        this.energy = energy;
    }
    public Pokemon[] getBanco() {
        return Banco;
    }
    public void setBanco(Pokemon[] banco) {
        Banco = banco;
    }
    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public Pokemon getPokemonActivo() {
        return pokemonActivo;
    }
    public void setPokemonActivo(Pokemon pokemonActivo) {
        this.pokemonActivo = pokemonActivo;
    }
    
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

    
}
