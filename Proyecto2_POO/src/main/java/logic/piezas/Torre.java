package logic.piezas;

import java.awt.Color;
import java.util.ArrayList;
import logic.Tablero;

public class Torre extends Pieza {

    public Torre(Color color, Tablero tablero, int posX, int posY) {
        super(color, tablero, posX, posY);
    }

    @Override
    public ArrayList<Integer[]> movimientos() {
        ArrayList<Integer[]> movimientos = new ArrayList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newX = posX;
            int newY = posY;

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
