package logic.piezas;

import java.awt.Color;
import java.util.ArrayList;
import logic.Tablero;

public class Torre extends Pieza {

    public Torre(Color color, Tablero tablero, int posX, int posY) {
        super(color, tablero, posX, posY);
    }

    @Override
    public void mover(int posX, int posY) {
        
    }

    @Override
    public ArrayList<Integer[]> movimientos() {
        return null;
    }
    
}
