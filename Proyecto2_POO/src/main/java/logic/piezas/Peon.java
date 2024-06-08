package logic.piezas;

import java.awt.Color;
import java.util.ArrayList;
import logic.Tablero;

import enums.PiezaEnum;

public class Peon extends Pieza {
    
    public Peon(Color color, Tablero tablero, int fila, int columna) {
        super(color, tablero, fila, columna, PiezaEnum.peon);
    }

    @Override
    public ArrayList<Integer[]> movimientos() {
        ArrayList<Integer[]> movimientos = new ArrayList<>();
    
        int direccion = (this.color == Color.WHITE) ? -1 : 1;
    
        // Movimiento hacia adelante
        if (tablero.esValida(fila + direccion, columna) && !tablero.estaOcupada(fila + direccion, columna)) {
            movimientos.add(new Integer[]{fila + direccion, columna});
        }
    
        // Movimiento de dos casillas hacia adelante
        if (!fueMovida && tablero.esValida(fila + 2*direccion, columna) && !tablero.estaOcupada(fila + 2*direccion, columna)) {
            movimientos.add(new Integer[]{fila + 2*direccion, columna});
        }
    
        // Movimientos diagonales para tomar piezas
        if (tablero.esValida(fila + direccion, columna - 1) && tablero.estaOcupadaPorColorContrario(fila + direccion, columna - 1, this.color)) {
            movimientos.add(new Integer[]{fila + direccion, columna - 1});
        }
        if (tablero.esValida(fila + direccion, columna + 1) && tablero.estaOcupadaPorColorContrario(fila + direccion, columna + 1, this.color)) {
            movimientos.add(new Integer[]{fila + direccion, columna + 1});
        }
    
        return movimientos;
    }
    
}
