package logic.piezas;

import java.awt.Color;
import java.util.ArrayList;
import logic.Tablero;

public class Peon extends Pieza {
    
    public Peon(Color color, Tablero tablero, int posX, int posY) {
        super(color, tablero, posX, posY);
    }

    @Override
    public ArrayList<Integer[]> movimientos() {
        ArrayList<Integer[]> movimientos = new ArrayList<>();
    
        int direccion = (this.color == Color.WHITE) ? -1 : 1;
    
        // Movimiento hacia adelante
        if (tablero.esValida(posX + direccion, posY) && !tablero.estaOcupada(posX + direccion, posY)) {
            movimientos.add(new Integer[]{posX + direccion, posY});
        }
    
        // Movimiento de dos casillas hacia adelante
        if (!fueMovida && tablero.esValida(posX + 2*direccion, posY) && !tablero.estaOcupada(posX + 2*direccion, posY)) {
            movimientos.add(new Integer[]{posX + 2*direccion, posY});
        }
    
        // Movimientos diagonales para tomar piezas
        if (tablero.esValida(posX + direccion, posY - 1) && tablero.estaOcupadaPorColorContrario(posX + direccion, posY - 1, this.color)) {
            movimientos.add(new Integer[]{posX + direccion, posY - 1});
        }
        if (tablero.esValida(posX + direccion, posY + 1) && tablero.estaOcupadaPorColorContrario(posX + direccion, posY + 1, this.color)) {
            movimientos.add(new Integer[]{posX + direccion, posY + 1});
        }
    
        return movimientos;
    }
    
}
