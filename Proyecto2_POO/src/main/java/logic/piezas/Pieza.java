package logic.piezas;

import java.awt.Color;
import java.util.ArrayList;
import logic.Tablero;
 
public abstract class Pieza {
    
    protected boolean fueTomada;
    protected boolean fueMovida;
    protected Color color;
    protected Tablero tablero;
    protected int posX;
    protected int posY;
    
    public Pieza (Color color, Tablero tablero, int posX, int posY) {
        this.color = color;
        this.tablero = tablero;
        this.posX = posX;
        this.posY = posY;
        this.fueMovida = false;
        this.fueTomada = false;
    }
    
    public abstract ArrayList<Integer[]> movimientos();
    
    public void mover(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.fueMovida = true;
    }
    
    public Integer[] getPosicion() {
        return new Integer[]{posX, posY};
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public boolean getMovida() {
        return this.fueMovida;
    }
    
    public boolean getTomada() {
        return this.fueTomada;
    }
    
    public void setTomada(boolean tomada) {
        this.fueTomada = tomada;
    }

    public void setY(int posY) {
        this.posY = posY;
    }

    public void setX(int posX) {
        this.posX = posX;
    }
    
}