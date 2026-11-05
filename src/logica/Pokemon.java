package logica;




public abstract class Pokemon extends Carta{
//constructor
    public Pokemon(int danioBase, TipoPokemon tipo, int ps, int costoDeRetirada, boolean isX) {
        this.danioBase = danioBase;
        this.tipo = tipo;
        this.ps = ps;
        this.costoDeRetirada = costoDeRetirada;
        this.isX = isX;
    }

//atributo
    protected int danioBase=10;
    protected  TipoPokemon tipo;
    protected  int ps;
    protected int costoDeRetirada;
    protected boolean isX;
    protected int EnergiaAcumulada;

//set y get
    public TipoPokemon getTipoP() {
        return tipo;
    }
    
    public void setEnergiaAcumulada(int x){
        this.EnergiaAcumulada= x;
    }

    public int getEnergiaAcumulada(){
        return EnergiaAcumulada;
    }

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
//--------
//metodo abstrato

 public abstract void atacar(Pokemon objetivo);
    


}
