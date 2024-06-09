package logic.piezas;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import enums.PiezaEnum;
import logic.Tablero;
 
public abstract class Pieza implements Serializable, Cloneable {
    
    protected boolean fueTomada;
    protected boolean fueMovida;
    protected Color color;
    protected Tablero tablero;
    protected int fila;
    protected int columna;
    
    public Pieza (Color color, Tablero tablero, int fila, int columna, PiezaEnum tipo) {
        this.color = color;
        this.tablero = tablero;
        this.fila = fila;
        this.columna = columna;
        this.fueMovida = false;
        this.fueTomada = false;
    }
    
    public Pieza (Peon peon) {
        this.color = peon.color;
        this.fueMovida = peon.fueMovida;
        this.fueTomada = peon.fueTomada;
        this.fila = peon.fila;
        this.columna = peon.columna;
        this.tablero = peon.tablero;
    }
    
    public abstract ArrayList<Integer[]> movimientos();
    
    public void mover(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.fueMovida = true;
    }
    
    public Integer[] getPosicion() {
        return new Integer[]{fila, columna};
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

    public void setY(int columna) {
        this.columna = columna;
    }

    public void setX(int fila) {
        this.fila = fila;
    }

    // Método para obtener el tipo de la pieza
    public abstract PiezaEnum getTipo();

    @Override
    public Pieza clone() {
        try {
            return (Pieza) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // No debería suceder
        }
    }
    
}