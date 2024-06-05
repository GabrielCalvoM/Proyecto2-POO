package logic.piezas;

import java.awt.Color;
import java.util.ArrayList;
import logic.Tablero;

public class Caballo extends Pieza {

    public Caballo(Color color, Tablero tablero, int posX, int posY) {
        super(color, tablero, posX, posY);
    }
    
    public Caballo(Peon peon) {
        super(peon);
    }

    @Override
    public ArrayList<Integer[]> movimientos() {
        ArrayList<Integer[]> movimientos = new ArrayList<>();

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < 8; i++) {
            int newX = posX + dx[i];
            int newY = posY + dy[i];

            if (tablero.esValida(newX, newY) && (!tablero.estaOcupada(newX, newY) || tablero.estaOcupadaPorColorContrario(newX, newY, this.color))) {
                movimientos.add(new Integer[]{newX, newY});
            }
        }

        return movimientos;
    }
    
}
