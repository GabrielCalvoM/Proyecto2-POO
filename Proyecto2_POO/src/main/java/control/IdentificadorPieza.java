package control;

import enums.PiezaEnum;
import java.awt.Color;

public class IdentificadorPieza {
    
    private Color color;
    private PiezaEnum tipo;
    
    
    public IdentificadorPieza(Color color, PiezaEnum tipo) {
        this.color = color;
        this.tipo = tipo;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public PiezaEnum getTipo() {
        return this.tipo;
    }
    
}
