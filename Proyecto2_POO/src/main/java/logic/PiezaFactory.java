package logic;

import enums.PiezaEnum;
import java.awt.Color;
import java.io.Serializable;
import logic.piezas.*;

public class PiezaFactory implements Serializable {
    
    private Tablero tablero;
    
    
    public PiezaFactory(Tablero tablero) {
        this.tablero = tablero;
    }
    
    public Pieza crearPieza(PiezaEnum tipo, Color color, Tablero tablero, int posX, int posY) {
        switch (tipo.toString()) {
            case "peon" -> {
                return new Peon(color, tablero, posX, posY);
            }
            case "torre" -> {
                return new Torre(color, tablero, posX, posY);
            }
            case "caballo" -> {
                return new Caballo(color, tablero, posX, posY);
            }
            case "alfil" -> {
                return new Alfil(color, tablero, posX, posY);
            }
            case "reina" -> {
                return new Dama(color, tablero, posX, posY);
            }
            case "rey" -> {
                return new Rey(color, tablero, posX, posY);
            }
            default -> {
                return null;
            }
        }
    }
    
    public Pieza promoverPeon(Peon peon, PiezaEnum tipo) {
        switch (tipo.toString()) {
            case "torre" -> {
                return new Torre(peon);
            }
            case "caballo" -> {
                return new Caballo(peon);
            }
            case "alfil" -> {
                return new Alfil(peon);
            }
            case "reina" -> {
                return new Dama(peon);
            }
            default -> {
                return null;
            }
        }
    }
    
}
