package logic;

import enums.PiezasEnum;
import java.awt.Color;
import logic.piezas.*;

public class PiezaFactory {
    
    private Tablero tablero;
    
    
    public PiezaFactory(Tablero tablero) {
        this.tablero = tablero;
    }
    
    public Pieza crearPieza(PiezasEnum tipo, Color color) {
        switch (tipo.toString()) {
            case "peon" -> {
                return new Peon(color);
            }
            case "torre" -> {
                return new Torre(color);
            }
            case "rey" -> {
                return new Rey(color);
            }
            default -> {
                return null;
            }
        }
    }
    
}
