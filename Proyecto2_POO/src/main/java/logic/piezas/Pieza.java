package logic.piezas;

import java.awt.Color;
import java.util.ArrayList;
import logic.Tablero;

public abstract class Pieza {
    
    protected boolean fueTomada;
    protected boolean fueMovida;
    protected Color color;
    protected Tablero tablero;
    
    
    public Pieza (Color color) {
        
    }
    
    public ArrayList<Integer[]> movimientos() {
        return new ArrayList();
    }
    
    public abstract void mover(int posX, int posY);
    
    public Integer[] getPosicion() {
        return new Integer[2];
    }
    
    public Color getColor() {
        return Color.WHITE;
    }
    
    public boolean getTomada() {
        return false;
    }
    
    public void setTomada(boolean tomada) {
        
    }
    
}
