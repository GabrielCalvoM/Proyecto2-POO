package logic;

import logic.piezas.Torre;
import logic.piezas.Peon;
import logic.piezas.Pieza;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class Tablero {
    
    private String jugador1;
    private String jugador2;
    private PiezaFactory factory;
    private Pieza[][] matriz;
    private List<Pieza> piezasNegras;
    private List<Pieza> piezasBlancas;
    
    
    public Tablero(String jugador1, String jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.factory = new PiezaFactory(this);
        this.matriz = new Pieza[8][8];
        this.piezasBlancas = new ArrayList();
        this.piezasNegras = new ArrayList();
    }
    
    public Pieza getPieza(int posX, int posY) {
        return matriz[posX][posY];
    }
    
    public ArrayList<Integer[]> getMovimientosRey() {
        return new ArrayList();
    }
    
    public void enroque(Torre torre) {
        if (torre)
    }
    
    public void promocion(Peon peon, Pieza nuevaPieza) {
        
    }
    
    public boolean verificarJaque(Color color) {
        return false;
    }
    
    public ArrayList<Pieza> getPiezasTomadas(Color color) {
        return new ArrayList();
    }

    public boolean esValida(int posX, int posY) {
        return posX >= 0 && posX < 8 && posY >= 0 && posY < 8;
    }
    
    public boolean estaOcupada(int posX, int posY) {
        return matriz[posX][posY] != null;
    }

    public boolean estaOcupadaPorColorContrario(int posX, int posY, Color color) {
        return matriz[posX][posY] != null && matriz[posX][posY].getColor() != color;
    }
}
