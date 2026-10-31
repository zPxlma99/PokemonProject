package logica;




public abstract class Pokemon extends Carta{
//constructor
    public Pokemon(String nombre, TipoCarta tipoCarta, int danioBase, TipoPokemon tipo, int ps, boolean isEX) 
    {
    super(nombre, tipoCarta);{
        this.danioBase = danioBase;
        this.tipo = tipo;
        this.ps = ps;
        this.isEX = isEX;
    }
}

//atributo
    protected int danioBase=10;
    protected  TipoPokemon tipo;
    protected  int ps;
    protected boolean isEX;
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

    public boolean isEX() {
        return isEX;
    }
    public void setEX(boolean isEX) {
        this.isEX = isEX;
    }

//--------
//metodo abstrato

    public abstract void atacar(Pokemon objetivo);
    public boolean retirada(){
        if(this.isEX()){
            if(this.getEnergiaAcumulada()>=3){
                this.setEnergiaAcumulada(this.getEnergiaAcumulada()-3);
                return true;
            }else{
                return false;
            }
        }else{
            if(this.getEnergiaAcumulada()>=1){
                this.setEnergiaAcumulada(this.getEnergiaAcumulada()-1);
                return true;
            }else{
                return false;
            }
        }
    }


}
