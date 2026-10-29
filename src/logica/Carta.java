package logica;

public abstract class Carta {
    protected String nombre;
    protected TipoCarta tipoCarta;
    public String getNombreCarta() {
        return nombre;
    }
    public void setNombreCarta(String nombre) {
        this.nombre = nombre;
    }
    public TipoCarta getTipoCarta() {
        return tipoCarta;
    }
    public void setTipoCarta(TipoCarta tipo) {
        this.tipoCarta = tipo;
    }
}
