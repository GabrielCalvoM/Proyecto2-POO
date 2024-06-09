package logic.piezas;

import java.awt.Color;
import java.util.ArrayList;
import logic.Tablero;

import enums.PiezaEnum;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rey extends Pieza {
    
    public Rey(Color color, Tablero tablero, int fila, int columna) {
        super(color, tablero, fila, columna, PiezaEnum.rey);
    }
    
    @Override
    public PiezaEnum getTipo() {
        return PiezaEnum.rey;
    }

    @Override
    public ArrayList<Integer[]> movimientos() {
        ArrayList<Integer[]> movimientos = new ArrayList<>();
    
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
        for (int i = 0; i < 8; i++) {
            int newX = fila + dx[i];
            int newY = columna + dy[i];
    
            if (tablero.esValida(newX, newY) && (!tablero.estaOcupada(newX, newY) || tablero.estaOcupadaPorColorContrario(newX, newY, this.color))) {
                movimientos.add(new Integer[]{newX, newY});
            }
        }
    
        return movimientos;
    }
    
    
}
