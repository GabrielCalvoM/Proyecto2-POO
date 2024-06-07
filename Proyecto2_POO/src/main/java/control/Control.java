package control;

import java.awt.Color;
import java.io.FileInputStream;
import java.util.ArrayList;

import enums.PiezaEnum;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import logic.Tablero;
import logic.piezas.Pieza;
import logic.piezas.Rey;

public class Control implements Serializable {
    
    private static Control instance;
    private boolean juegaBlanco;
    private Tablero tablero;

    
    private Control() {
        this.juegaBlanco = true;
    }
    
    public static Control getInstance() {
        if (instance == null) {
            instance = new Control();
        }
        
        return Control.instance;
    }
    
    public void iniciarPartida(String jugador1, String jugador2) {
        this.tablero = new Tablero(jugador1, jugador2); // Inicializa el tablero
        this.tablero.inciarPiezas(); // Inicializa las piezas para cada jugador
    
        // Establece que el jugador 1 (blanco) juega primero
        this.juegaBlanco = true;
    }
    
    public IdentificadorPieza[][] mostrarTablero() {
        IdentificadorPieza[][] estadoTablero = new IdentificadorPieza[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = this.tablero.getPieza(i, j);
                if (pieza != null) {
                    // Asumiendo que Pieza tiene métodos getColor() y getTipo() que retornan Color y PiezaEnum respectivamente
                    Color colorPieza = pieza.getColor();
                    PiezaEnum tipoPieza = pieza.getTipo();
                    estadoTablero[i][j] = new IdentificadorPieza(colorPieza, tipoPieza);
                } else {
                    // Si no hay pieza en la posición, se deja como null o se asigna un valor que represente una celda vacía
                    estadoTablero[i][j] = null;
                }
            }
        }
        return estadoTablero;
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
        // Termina la partida y declara un empate
        System.out.println("La partida ha terminado en tablas.");
        this.tablero = null; // Esto efectivamente termina la partida
    }
    
    public void abandonar(String jugadorAbandona) {
        String ganador = (jugadorAbandona.equals(this.tablero.getJugador1())) ? this.tablero.getJugador2() : this.tablero.getJugador1();
        System.out.println(jugadorAbandona + " ha abandonado la partida. El ganador es " + ganador + ".");
        this.tablero = null; // Esto efectivamente termina la partida
    }
    
    public Color jugadorActual() {
        if (this.juegaBlanco) {
            return Color.white;
        }
        else {
            return Color.black;
        }
    }
    
    public String getNombreJugador(Color color) {
        if (color == Color.white) {
            return this.tablero.getJugador1();
        }
        else if (color == Color.black) {
            return this.tablero.getJugador2();
        }
        else {
            return "";
        }
    }
    
    public static void guardarPartida(Control control) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream file = new FileOutputStream("partida.bin");
        ObjectOutputStream stream = new ObjectOutputStream(file);
        stream.writeObject(control);
        stream.close();
        file.close();
    }
    
    public static Control cargarPartida() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("partida.bin");
        ObjectInputStream stream = new ObjectInputStream(file);
        Control control = (Control) stream.readObject();
        stream.close();
        file.close();
        return control;
    }
    
}
