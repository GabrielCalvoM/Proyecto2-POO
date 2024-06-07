package logic.piezas;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import enums.PiezaEnum;
import logic.Tablero;
 
public abstract class Pieza implements Serializable {
    
    protected boolean fueTomada;
    protected boolean fueMovida;
    protected Color color;
    protected Tablero tablero;
    protected int posX;
    protected int posY;
    protected PiezaEnum tipo; // Campo para almacenar el tipo de la pieza
    
    public Pieza (Color color, Tablero tablero, int posX, int posY, PiezaEnum tipo) {
        this.color = color;
        this.tablero = tablero;
        this.posX = posX;
        this.posY = posY;
        this.fueMovida = false;
        this.fueTomada = false;
        this.tipo = tipo; // Inicializar el tipo de la pieza
    }
    
    public Pieza (Peon peon) {
        this.color = peon.color;
        this.fueMovida = peon.fueMovida;
        this.fueTomada = peon.fueTomada;
        this.posX = peon.posX;
        this.posY = peon.posY;
        this.tablero = peon.tablero;
        this.tipo = peon.tipo; 
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

    // Método para obtener el tipo de la pieza
    public PiezaEnum getTipo() {
        return this.tipo;
    }

    @Override
    public Pieza clone() {
        try {
            return (Pieza) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // No debería suceder
        }
    }
    
}