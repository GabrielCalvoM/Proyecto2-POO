package logic;

import enums.PiezasEnum;
import logic.piezas.*;
import java.awt.Color;
import java.util.*;

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
        
        this.inciarPiezas();
    }
    
    public Pieza getPieza(int posX, int posY) {
        return matriz[posX][posY];
    }
    
    public ArrayList<Integer[]> getMovimientosRey() {
        return new ArrayList();
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
    
    public void promocion(Peon peon, Pieza nuevaPieza) {
        
    }
    
    public boolean verificarJaque(Color color) throws Exception {
        Set<Integer[]> movimientos = new HashSet();
        
        for (Pieza pieza : this.getListaPiezas(color)) {
            movimientos.addAll(pieza.movimientos());
        }
        
        Color rival = this.switchColor(color);
        Rey reyRival = this.getRey(rival);
        Integer[] posRey = reyRival.getPosicion();
        
        return movimientos.contains(posRey);
    }
    
    public ArrayList<Pieza> getPiezasTomadas(Color color) throws Exception {
        ArrayList<Pieza> piezas = new ArrayList();
        
        for (Pieza pieza : this.getListaPiezas(color)) {
            if (pieza.getTomada()) {
                piezas.add(pieza);
            }
        }
        
        return piezas;
    }
    
    
    public Color switchColor(Color color) throws Exception {
        switch (color.toString()) {
            case "white" -> {
                return Color.black;
            }
            case "black" -> {
                return Color.white;
            }
            default -> throw new Exception("Ocurrió un error inesperado");
        }
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
    
    
    private List<Pieza> getListaPiezas(Color color) throws Exception {
        switch (color.toString()) {
            case "white" -> {
                return this.piezasBlancas;
            }
            case "black" -> {
                return this.piezasNegras;
            }
            default -> throw new Exception("Ocurrió un error inesperado");
        }
    }
    
    private Rey getRey(Color color) throws Exception {
        List<Pieza> piezas = this.getListaPiezas(color);
        
        for (Pieza pieza : piezas) {
            if (pieza instanceof Rey)
                return (Rey) pieza;
        }
        
        throw new Exception("Ocurrió un error inesperado");
    }
    
    private void inciarPiezas() {
        this.piezasBlancas = this.iniciarJugador(0, 1, Color.white);
        this.piezasNegras = this.iniciarJugador(7, 6, Color.black);
    }
    
    private List<Pieza> iniciarJugador(int filaPeones, int filaFrontal, Color color) {
        List<Pieza> piezas = new ArrayList();
        
        // coloca los peones
        for (int i = 0; i < 8; i++) {
            Pieza pieza = this.factory.crearPieza(PiezasEnum.peon, color, this, i, filaPeones);
            piezas.add(pieza);
            matriz[filaPeones][i] = pieza;
        }
        
        // coloca las piezas frontales excepto al rey y la reina
        for (int i = 0; i < 8; i++) {
            float col = (float) Math.abs(3.5 - i);      // determina si la columna es de
            PiezasEnum tipo = null;                     // torre, caballo o alfil
            
            if (col == 3.5) {
                tipo = PiezasEnum.torre;
            } else if (col == 2.5) {
                tipo = PiezasEnum.caballo;
            } else if (col == 1.5) {
                tipo = PiezasEnum.alfil;
            }
            
            if (tipo != null) {
                Pieza pieza = this.factory.crearPieza(tipo, color, this, i, filaFrontal);
                piezas.add(pieza);
                matriz[filaFrontal][i] = pieza;
            }
        }
        
        Pieza reina = this.factory.crearPieza(PiezasEnum.reina, color, this, 3, filaFrontal);
        piezas.add(reina);
        matriz[filaFrontal][3] = reina;
        
        Pieza rey = this.factory.crearPieza(PiezasEnum.rey, color, this, 4, filaFrontal);
        piezas.add(rey);
        matriz[filaFrontal][4] = rey;
        
        return piezas;
    }
    
}
