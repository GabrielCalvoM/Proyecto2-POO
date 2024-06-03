package logic;

import enums.PiezasEnum;
import java.awt.Color;
import logic.piezas.*;

public class PiezaFactory {
    
    private Tablero tablero;
    
    
    public PiezaFactory(Tablero tablero) {
        this.tablero = tablero;
    }
    
    public Pieza crearPieza(PiezasEnum tipo, Color color, Tablero tablero, int posX, int posY) {
        switch (tipo.toString()) {
            case "peon" -> {
                return new Peon(color, tablero, posX, posY);
            }
            case "torre" -> {
                return new Torre(color, tablero, posX, posY);
            }
            case "rey" -> {
                return new Rey(color, tablero, posX, posY);
            }
            default -> {
                return null;
            }
        }
    }
    
}
