package logic.piezas;

import java.awt.Color;
import java.util.ArrayList;
import logic.Tablero;

import enums.PiezaEnum;

public class Torre extends Pieza {

    public Torre(Color color, Tablero tablero, int fila, int columna) {
        super(color, tablero, fila, columna, PiezaEnum.torre);
    }
    
    public Torre(Peon peon) {
        super(peon);
    }

    @Override
    public ArrayList<Integer[]> movimientos() {
        ArrayList<Integer[]> movimientos = new ArrayList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newX = fila;
            int newY = columna;

            while (true) {
                newX += dx[i];
                newY += dy[i];

                if (!tablero.esValida(newX, newY) || tablero.estaOcupada(newX, newY)) {
                    if (tablero.estaOcupadaPorColorContrario(newX, newY, this.color)) {
                        movimientos.add(new Integer[]{newX, newY});
                    }
                    break;
                }

                movimientos.add(new Integer[]{newX, newY});
            }
        }

        return movimientos;
    }
    
}
