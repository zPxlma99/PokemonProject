package logica;




public abstract class Pokemon extends Carta{

    private int danioBase=10;
    private TipoPokemon tipo;
    private int ps;
    private int costoDeRetirada;
<<<<<<< HEAD
    private boolean isX;
    public TipoPokemon getTipoP() {
        return tipo;
    }
    public abstract void atacar(Pokemon objetivo, TipoPokemon tipoAtaque, int danio,int costeDeEnergia);
    public void setTipoPokemon(TipoPokemon tipo) {
        this.tipo = tipo;
    }
    public int getPs() {
        return ps;
    }
    public void setPs(int ps) {
        this.ps = ps;
    }
    public int getCostoDeRetirada() {
        return costoDeRetirada;
    }
    public void setCostoDeRetirada(int costoDeRetirada) {
        this.costoDeRetirada = costoDeRetirada;
    }
    public boolean isX() {
        return isX;
    }
    public void setX(boolean isX) {
        this.isX = isX;
    }
=======
    private ArrayList<Ataque>ataques;
    private boolean isEX;
>>>>>>> 4c7451f155f2695bf2ec065029fdfafcd9d28ec3
    


}
