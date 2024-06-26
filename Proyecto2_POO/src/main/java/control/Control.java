package control;

import java.awt.Color;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.util.ArrayList;

import enums.PiezaEnum;
import java.util.List;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import logic.Tablero;
import logic.piezas.Peon;
import logic.piezas.Pieza;
import logic.piezas.Rey;
import logic.piezas.Torre;

public class Control implements Serializable {
    
    private static Control instance;
    private static final String dir = "C:/partidasAjedrez/";
    private String partidaActual;
    private boolean juegaBlanco;
    private Tablero tablero;

    
    private Control() {
        this.partidaActual = "";
        this.juegaBlanco = true;
    }
    
    public static Control getInstance() {
        if (instance == null) {
            instance = new Control();
        }
        
        return Control.instance;
    }
    
    public void iniciarPartida(String partida, String jugador1, String jugador2) {
        this.tablero = new Tablero(jugador1, jugador2); // Inicializa el tablero
        this.tablero.inciarPiezas(); // Inicializa las piezas para cada jugador
    
        // Establece que el jugador 1 (blanco) juega primero
        this.juegaBlanco = true;
        
        // Guarda el nombre de la partida
        this.partidaActual = partida;
    }
    
    public boolean estaJugando(Color color) {
        return (color == Color.white) == this.juegaBlanco;
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
    
    public List<Integer[]> getMovimientos(int fila, int columna){
        Pieza pieza = this.tablero.getPieza(fila, columna);
        
        try {
            if (pieza instanceof Rey) {
                return this.tablero.getMovimientosRey(pieza.getColor());
            }
        }
        catch (Exception e) {
            System.out.println("Error captado en control.Control.getMovimientos(int fila, int columna)");
        }
        
        return pieza.movimientos();
    }
    
    public void mover(int fila, int columna, int nuevaFila, int nuevaColumna) throws Exception {
        // Obtener la pieza en la posición actual
        Pieza pieza = this.tablero.getPieza(fila, columna);
        if (this.tablero.verificarJaque(this.tablero.switchColor(pieza.getColor()))) {
            if (!this.tablero.evitaJaque(pieza, nuevaFila, nuevaColumna)) {
                throw new Exception("El rey está en jaque");
            }
        }

        // Si hay una pieza en la nueva posición, marcarla como tomada
        if (this.tablero.estaOcupada(nuevaFila, nuevaColumna)) {
            Pieza piezaEnNuevaPos = this.tablero.getPieza(nuevaFila, nuevaColumna);
            piezaEnNuevaPos.setTomada(true);
        }

        // Actualizar la posición de la pieza en el tablero y en la pieza misma
        boolean movida = pieza.getMovida();
        this.tablero.moverPieza(pieza, nuevaFila, nuevaColumna);
        pieza.mover(nuevaFila, nuevaColumna);
        
        // Verifica si es enroque
        if (pieza instanceof Rey && !movida) {
            Integer[] colTorre = this.tablero.verificarEnroque((Rey) pieza);
            
            if (colTorre != new Integer[]{0, 0}) {
                Torre torre = (Torre) this.tablero.getPieza(fila, colTorre[0]);
                
                this.tablero.moverPieza(torre, fila, colTorre[1]);
                torre.mover(fila, colTorre[1]);
            }
        }
    }
    
    public void comer(int fila, int columna) {
        // Obtener la pieza en la posición actual
        Pieza pieza = this.tablero.getPieza(fila, columna);
    
        // Verificar si la pieza ha sido tomada
        if (pieza.getTomada()) {
            // Si la pieza ha sido tomada, eliminarla del tablero
            this.tablero.eliminarPieza(pieza);
        } else {
            // Si la pieza no ha sido tomada, lanzar una excepción
            throw new IllegalArgumentException("La pieza no ha sido tomada");
        }
    }
    
    public void promocion(PiezaEnum tipo, int fila, int columna) {
        try {
            System.out.println(tipo + " " + fila + "-" + columna);
            Peon peon = (Peon) this.tablero.getPieza(fila, columna);
            this.tablero.promocion(peon, tipo);
        }
        catch (Exception e) {
            System.out.println("Error captado en control.Control.getMovimientos(int fila, int columna)");
        }
    }
    
    public void seguirTurno() {
        // Cambia el turno al otro jugador
        this.juegaBlanco = !this.juegaBlanco;
    }
    
    public List<PiezaEnum> getPiezasTomadas(Color color) throws Exception {
        List<Pieza> piezas = this.tablero.getPiezasTomadas(color);
        List<PiezaEnum> lista = new ArrayList();
        
        for (Pieza pieza : piezas) {
            lista.add(pieza.getTipo());
        }
        
        return lista;
    }
    
    public Color verificarJaqueMate() {
        Color[] colores = {Color.WHITE, Color.BLACK};
    
        for (Color color : colores) {
            try {
                if (this.tablero.verificarJaque(this.tablero.switchColor(color))) {
                    Rey rey = this.tablero.getRey(color);
                    List<Integer[]> movimientosPosibles = this.tablero.getMovimientosRey(color);
                    
                    if (movimientosPosibles.isEmpty()) {
                        List<Pieza> piezasAliadas = this.tablero.getListaPiezas(color);
    
                        boolean estaEnJaqueMate = true;
                        
                        for (Pieza pieza : piezasAliadas) {
                            if (pieza != rey && pieza.movimientos() != null) {
                                for (Integer[] movimiento : pieza.movimientos()) {
                                    if (this.tablero.evitaJaque(pieza, movimiento[0], movimiento[1])) {
                                        estaEnJaqueMate = false;
                                        break;
                                    }
                                }
                            }
                        }

                        if (estaEnJaqueMate) {
                            return color;
                        }
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
    
    public Color switchColor(Color color) throws Exception {
        if (color == Color.white) {
            return Color.black;
        }
        else if (color == Color.black) {
            return Color.white;
        }
        else {
            throw new Exception("El color no pertenece a ningún jugador");
        }
    }
    
    public static void guardarPartida() throws FileNotFoundException, IOException, ClassNotFoundException {
        File carpeta = new File(dir);
        carpeta.mkdir();
        
        FileOutputStream file = new FileOutputStream(dir + instance.partidaActual + ".bin");
        ObjectOutputStream stream = new ObjectOutputStream(file);
        
        stream.writeObject(instance);
        stream.close();
        file.close();
    }
    
    public static void cargarPartida(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(dir + archivo + ".bin");
        ObjectInputStream stream = new ObjectInputStream(file);
        instance = (Control) stream.readObject();
        stream.close();
        file.close();
    }
    
    public static void borrarPartida() {
        File partida = new File(dir + instance.partidaActual + ".bin");
        
        if (partida.exists()) {
            if (partida.delete()) {
                
            }
        }
    }
    
    public static Map<String, String> getPartidas() throws Exception {
        // Map<nombreArchivo, fecha>
        File carpeta = new File(dir);
        carpeta.mkdir();
        FileFilter filter = file -> file.isFile() && file.getName().endsWith(".bin");
        Map<String, String> partidas = new HashMap();
        
        for (File archivo : carpeta.listFiles(filter)) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = formatter.format(archivo.lastModified());
            partidas.put(archivo.getName(), fecha);
        }
        
        return partidas;
    }
    
}
