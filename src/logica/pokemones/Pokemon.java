package logica.pokemones;

import logica.Carta;
import logica.Jugador;
import logica.TipoCarta;
import logica.TipoPokemon;

public abstract class Pokemon extends Carta{
//constructor
    public Pokemon(String nombre, TipoCarta tipoCarta, int danioBase, TipoPokemon tipo, int ps, boolean isEX, boolean isActive, int energiaMin) 
    {
    super(nombre, tipoCarta);{
        this.danioBase = danioBase;
        this.tipo = tipo;
        this.ps = ps;
        this.isEX = isEX;
        this.isActive = isActive;
        this.energiaMin = energiaMin;
    }
}


//atributo
    protected int danioBase=10;
    protected  TipoPokemon tipo;
    protected  int ps;
    protected boolean isEX;
    protected int EnergiaAcumulada;
    protected boolean isActive;
    protected boolean turboVelocidadUsada=false;
    public String ataque1;
    public String ataque2;
    public int energiaMin;

    public int getEnergiaMin() {
        return energiaMin;
    }
    public String getAtaque1() {
        return ataque1;
    }
    public String getAtaque2() {
        return ataque2;
    }

    public boolean isTurboVelocidadUsada() {
        return turboVelocidadUsada;
    }

    public void setTurboVelocidadUsada(boolean turboVelocidadUsada) {
        this.turboVelocidadUsada = turboVelocidadUsada;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

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
    public abstract void atacar2(Pokemon objetivo);

//METODO RETIRADA
    
    public boolean PuedeRetirada(){
        if(this.isEX()){

            if(this.getEnergiaAcumulada()>=(this.turboVelocidadUsada? 2 : 3)){
                this.setEnergiaAcumulada(this.getEnergiaAcumulada()-(this.turboVelocidadUsada? 2 : 3));
                return true;
            }else{
                return false;
            }
        }else{
            if(this.getEnergiaAcumulada()>=(this.turboVelocidadUsada? 0 : 1)){
                this.setEnergiaAcumulada(this.getEnergiaAcumulada()-(this.turboVelocidadUsada? 0 : 1));
                return true;
            }else{
                return false;
            }
        }
    }

public Pokemon retirar(Jugador jugador,int opc,Pokemon pokemon){
    Pokemon nuevoActivo = jugador.getBanco()[opc - 1];
    jugador.setBanco(null, opc-1);
    jugador.setBanco(pokemon, opc-1);
    
    return nuevoActivo ;
}
}

