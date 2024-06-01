package logic;

import java.awt.List;
import java.util.ArrayList;

public class Tablero {
    
    private String jugador1;
    private String jugador2;
    private PiezaFactory factory;
    private Pieza[][] matriz;
    private List piezasNegras;
    private List piezasBlancas;
    
    
    public Tablero(String jugador1, String jugador2) {
        
    }
    
    public Pieza getPieza(int posX, int posY) {
        return matriz[posX][posY];
    }
    
    public ArrayList<Integer[]> getMovimientosRey() {
        return new ArrayList();
    }
    
    public void enroque() {
        
    }
    
}
