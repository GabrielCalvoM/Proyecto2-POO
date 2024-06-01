package logic;

import java.awt.Color;

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
