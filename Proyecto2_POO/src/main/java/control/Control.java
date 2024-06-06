package control;

import java.awt.Color;
import java.util.ArrayList;

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
    
    public IdentificadorPieza[][] mostrarTablero() {
        return new IdentificadorPieza[8][8];
    }
    
    public void mover(int posX, int posY, int nuevaPosX, int nuevaPosY) {
        // Obtener la pieza en la posición actual
        Pieza pieza = this.tablero.getPieza(posX, posY);

        // Verificar si la pieza puede moverse a la nueva posición
        ArrayList<Integer[]> movimientosPosibles = pieza.movimientos();
        for (Integer[] movimiento : movimientosPosibles) {
            if (movimiento[0] == nuevaPosX && movimiento[1] == nuevaPosY) {
                // Si hay una pieza en la nueva posición, marcarla como tomada
                if (this.tablero.estaOcupada(nuevaPosX, nuevaPosY)) {
                    Pieza piezaEnNuevaPos = this.tablero.getPieza(nuevaPosX, nuevaPosY);
                    piezaEnNuevaPos.setTomada(true);
                }

                // Actualizar la posición de la pieza en el tablero y en la pieza misma
                this.tablero.moverPieza(pieza, nuevaPosX, nuevaPosY);
                pieza.mover(nuevaPosX, nuevaPosY);

                return;
            }
        }

        // Si la pieza no puede moverse a la nueva posición, lanzar una excepción
        throw new IllegalArgumentException("Movimiento no válido");
    }
    
    public void comer(int posX, int posY) {
        // Obtener la pieza en la posición actual
        Pieza pieza = this.tablero.getPieza(posX, posY);
    
        // Verificar si la pieza ha sido tomada
        if (pieza.getTomada()) {
            // Si la pieza ha sido tomada, eliminarla del tablero
            this.tablero.eliminarPieza(pieza);
        } else {
            // Si la pieza no ha sido tomada, lanzar una excepción
            throw new IllegalArgumentException("La pieza no ha sido tomada");
        }
    }
    
    public void seguirTurno() {
        // Cambia el turno al otro jugador
        this.juegaBlanco = !this.juegaBlanco;
    }
    
    public Color verificarJaqueMate() {
        Color[] colores = {Color.WHITE, Color.BLACK};
    
        for (Color color : colores) {
            try {
                if (this.tablero.verificarJaque(color)) {
                    Rey rey = this.tablero.getRey(color);
                    ArrayList<Integer[]> movimientosPosibles = rey.movimientos();
    
                    boolean estaEnJaqueMate = true;
                    for (Integer[] movimiento : movimientosPosibles) {
                        Tablero copiaTablero = new Tablero(this.tablero);
                        copiaTablero.moverPieza(rey, movimiento[0], movimiento[1]);
    
                        if (!copiaTablero.verificarJaque(color)) {
                            estaEnJaqueMate = false;
                            break;
                        }
                    }
    
                    if (estaEnJaqueMate) {
                        return color;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error captado en Control.verificarJaqueMate()");
                e.printStackTrace();
            }
        }
    
        return null;
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
