package logic;

import enums.PiezasEnum;
import java.awt.Color;

public class PiezaFactory {
    
    private Tablero tablero;
    
    
    public PiezaFactory(Tablero tablero) {
        this.tablero = tablero;
    }
    
    /*public Pieza crearPieza(PiezasEnum tipo, int posX, int posY, Color color) {
        return new Pieza(color);
    }*/
    
}
