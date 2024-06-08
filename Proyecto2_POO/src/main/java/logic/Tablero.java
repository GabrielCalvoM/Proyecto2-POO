package logic;

import enums.PiezaEnum;
import logic.piezas.*;
import java.awt.Color;
import java.io.Serializable;
import java.util.*;

public class Tablero implements Serializable {
    
    private String jugador1;
    private String jugador2;
    private PiezaFactory factory;
    private Pieza[][] matriz;
    private List<Pieza> piezasNegras;
    private List<Pieza> piezasBlancas;
    
    
    public Tablero(String jugador1, String jugador2) {
        if ("".equals(jugador1) || jugador1 == null) {
            jugador1 = "Jugador Blanco";
        }
        
        if ("".equals(jugador2) || jugador2 == null) {
            jugador2 = "Jugador Negro";
        }
        
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.factory = new PiezaFactory(this);
        this.matriz = new Pieza[8][8];
        
        this.inciarPiezas();
    }

    public Tablero(Tablero otroTablero) {
        this.jugador1 = otroTablero.jugador1;
        this.jugador2 = otroTablero.jugador2;
        this.factory = otroTablero.factory;
        this.matriz = new Pieza[8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (otroTablero.matriz[i][j] != null) {
                    this.matriz[i][j] = otroTablero.matriz[i][j].clone();
                } else {
                    this.matriz[i][j] = null;
                }
            }
        }
    }
    
    public Pieza getPieza(int fila, int columna) {
        return matriz[fila][columna];
    }

    public void setPieza(int fila, int columna, Pieza pieza) {
        matriz[fila][columna] = pieza;
    }
    
    public void enroque(Torre torre, Rey rey) throws Exception {
        Color color = torre.getColor();
        Color rival = this.switchColor(color);
        
        if (rey.getMovida()) {
            throw new Exception("El rey ya ha sido movida");
        }
        else if (torre.getMovida()) {
            throw new Exception("La torre ya ha sido movida");
        }
        else if (this.verificarJaque(rival)) {
            throw new Exception("El rey está en jaque");
        }
    }
    
    public void promocion(Peon peon, PiezaEnum nuevaPieza) throws Exception {
        try {
            Integer[] pos = peon.getPosicion();
            Pieza pieza = this.factory.promoverPeon(peon, nuevaPieza);

            List<Pieza> lista = this.getListaPiezas(pieza.getColor());
            lista.add(pieza);
            lista.remove(peon);
            this.matriz[pos[0]][pos[1]] = pieza;
        } catch (Exception e) {
            System.out.println("Error captado en logic.Tablero.promocion(Peon peon, PiezaEnum nuevaPieza)");
            throw e;
        }
    }
    
    public boolean verificarJaque(Color color) throws Exception {
        try {
            Set<Integer[]> movimientos = new HashSet();

            for (Pieza pieza : this.getListaPiezas(color)) {
                movimientos.addAll(pieza.movimientos());
            }

            Color rival = this.switchColor(color);
            Rey reyRival = this.getRey(rival);
            Integer[] posRey = reyRival.getPosicion();

            return movimientos.contains(posRey);
        } catch (Exception e) {
            System.out.println("Error captado en logic.Tablero.verificarJaque(Color color)");
            throw e;
        }
    }
    
    public ArrayList<Pieza> getPiezasTomadas(Color color) throws Exception {
        try {
            ArrayList<Pieza> piezas = new ArrayList();

            for (Pieza pieza : this.getListaPiezas(color)) {
                if (pieza.getTomada()) {
                    piezas.add(pieza);
                }
            }

            return piezas;
        } catch (Exception e) {
            System.out.println("Error captado en logic.Tablero.getPiezasTomadas(Color color)");
            throw e;
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
    
    public boolean esValida(int fila, int columna) {
        return fila >= 0 && fila < 8 && columna >= 0 && columna < 8;
    }
    
    public boolean estaOcupada(int fila, int columna) {
        return matriz[fila][columna] != null;
    }

    public boolean estaOcupadaPorColorContrario(int fila, int columna, Color color) {
        return matriz[fila][columna] != null && matriz[fila][columna].getColor() != color;
    }
    
    
    private List<Pieza> getListaPiezas(Color color) throws Exception {
        if (color == Color.white) {
            return this.piezasBlancas;
        }
        else if (color == Color.black) {
            return this.piezasNegras;
        }
        else {
            throw new Exception("No se logró encontrar lasta perteneciente al jugador");
        }
    }
    
    public Rey getRey(Color color) throws Exception {
        List<Pieza> piezas = this.getListaPiezas(color);
        
        for (Pieza pieza : piezas) {
            if (pieza instanceof Rey)
                return (Rey) pieza;
        }
        
        throw new Exception("No se logró obtener el rey");
    }
    
    public void inciarPiezas() {
        this.piezasBlancas = this.iniciarJugador(6, 7, Color.white);
        this.piezasNegras = this.iniciarJugador(1, 0, Color.black);
    }
    
    private List<Pieza> iniciarJugador(int filaPeones, int filaFrontal, Color color) {
        List<Pieza> piezas = new ArrayList();
        
        // coloca los peones
        for (int i = 0; i < 8; i++) {
            Pieza pieza = this.factory.crearPieza(PiezaEnum.peon, color, this, filaPeones, i);
            piezas.add(pieza);
            matriz[filaPeones][i] = pieza;
        }
        
        // coloca las piezas frontales excepto al rey y la dama
        for (int i = 0; i < 8; i++) {
            float col = (float) Math.abs(3.5 - i);      // determina si la columna es de
            PiezaEnum tipo = null;                     // torre, caballo o alfil
            
            if (col == 3.5) {
                tipo = PiezaEnum.torre;
            } else if (col == 2.5) {
                tipo = PiezaEnum.caballo;
            } else if (col == 1.5) {
                tipo = PiezaEnum.alfil;
            }
            
            if (tipo != null) {
                Pieza pieza = this.factory.crearPieza(tipo, color, this, filaFrontal, i);
                piezas.add(pieza);
                matriz[filaFrontal][i] = pieza;
            }
        }
        
        Pieza dama = this.factory.crearPieza(PiezaEnum.dama, color, this, filaFrontal, 3);
        piezas.add(dama);
        matriz[filaFrontal][3] = dama;
        
        Pieza rey = this.factory.crearPieza(PiezaEnum.rey, color, this, filaFrontal, 4);
        piezas.add(rey);
        matriz[filaFrontal][4] = rey;

        return piezas;
    }
    
    public void moverPieza(Pieza pieza, int fila, int columna) {
        matriz[pieza.getPosicion()[0]][pieza.getPosicion()[1]] = null;
        matriz[fila][columna] = pieza;
        
    }

    public void eliminarPieza(Pieza pieza) {
        matriz[pieza.getPosicion()[0]][pieza.getPosicion()[1]] = null;
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }
}
