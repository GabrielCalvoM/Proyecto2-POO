package control;

import java.awt.Color;
import logic.Tablero;
import logic.piezas.Alfil;
import logic.piezas.Caballo;
import logic.piezas.Peon;
import logic.piezas.Pieza;
import logic.piezas.Rey;
import logic.piezas.Torre;
import logic.piezas.Dama;

public class Control {
    
    private static Control instance;
    private boolean juegaBlanco;
    private Tablero tablero;

    
    private Control() {
        this.juegaBlanco = true;
    }
    
    public static Control getInstance() {
        return Control.instance;
    }
    
    public void iniciarPartida(String jugador1, String jugador2) {
        this.tablero = new Tablero(jugador1, jugador2); // Inicializa el tablero
        this.tablero.inciarPiezas(); // Inicializa las piezas para cada jugador
    
        // Establece que el jugador 1 (blanco) juega primero
        this.juegaBlanco = true;
    }
    
    public String[][] mostrarTablero() {
        return new String[8][8];
    }
    
    public void mover(int posX, int posY, int nuevaPosX, int nuevaPosY) {

    }
    
    public void comer(int posX, int posY) {
        
    }
    
    public void seguirTurno() {
        
    }
    
    public Color verificarJaqueMate() {
        return Color.WHITE;
    }
    
    public void esTablas() {
        
    }
    
    public void abandonar() {
        
    }
    
    public static void guardarPartida() {
        
    }
    
    public static void cargarPartida() {
        
    }
    
}
