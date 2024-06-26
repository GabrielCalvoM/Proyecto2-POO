package logic.piezas;

import java.awt.Color;
import java.util.ArrayList;
import logic.Tablero;

import enums.PiezaEnum;

public class Dama extends Pieza {

    public Dama(Color color, Tablero tablero, int fila, int columna) {
        super(color, tablero, fila, columna, PiezaEnum.dama);
    }
    
    public Dama(Peon peon) {
        super(peon);
    }
    
    @Override
    public PiezaEnum getTipo() {
        return PiezaEnum.dama;
    }

    @Override
    public ArrayList<Integer[]> movimientos() {
        ArrayList<Integer[]> movimientos = new ArrayList<>();

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newX = fila;
            int newY = columna;

            while (true) {
                newX += dx[i];
                newY += dy[i];

                if (!tablero.esValida(newX, newY)) {
                    break;
                }

                if (tablero.estaOcupada(newX, newY)) {
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
