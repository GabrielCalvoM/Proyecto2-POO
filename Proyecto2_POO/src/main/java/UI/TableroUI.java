package UI;

import control.Control;
import control.IdentificadorPieza;
import enums.PiezaEnum;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableroUI extends javax.swing.JPanel {
    
    private Celda celdas[][];
    private Celda presionado;

    public TableroUI() {
        initComponents();
        initCeldas();
    }
    
    private void initCeldas() {
        this.celdas = new Celda[8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Celda celda = new Celda(i, j);
                celda.setTablero(this);
                int sum = i + j;
                
                if (sum % 2 == 0) {
                    celda.setBackground(new Color(224, 153, 78));
                }
                else {
                    celda.setBackground(new Color(91, 39, 0));
                }
                
                this.celdas[i][j] = celda;
                this.add(celdas[i][j]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 6, true));
        setLayout(new java.awt.GridLayout(8, 8));
    }// </editor-fold>//GEN-END:initComponents
    
    public void seleccionar(Celda celda) {
        if (this.presionado == celda) {
            this.presionado = null;
            this.marcar(-1, -1);
        }
        else {
            if (celda.isMarcado()) {
                try {
                    int fila = celda.getFila();
                    int columna = celda.getColumna();
                    Control control = Control.getInstance();
                    control.mover(this.presionado.getFila(), this.presionado.getColumna(),
                                                fila, columna);
                    
                    if (this.presionado.getColor() == Color.white && fila == 0) {
                        PromocionDialog dialog = new PromocionDialog(MainFrame.getInstance(), true);
                        dialog.initIcons(Color.white);
                        dialog.setVisible(true);
                        PiezaEnum tipo = dialog.getTipo();
                        control.promocion(tipo, fila, columna);
                    }
                    else if (this.presionado.getColor() == Color.black && fila == 7) {
                        control.promocion(PromocionDialog.select(Color.black), fila, columna);
                    }
                    
                    this.terminarTurno();
                }
                catch (Exception e) {
                    PantallaJuego pantalla = (PantallaJuego) MainFrame.getInstance().getPage(MainFrame.PANTALLA_JUEGO);
                    pantalla.mostrarMensajeError(e.getMessage());
                }
            }
            else {
                this.presionado = celda;
                this.marcar(this.presionado.getFila(), this.presionado.getColumna());
            }
        }
    }
    
    public Celda getSeleccionado() {
        return this.presionado;
    }
    
    public void marcar(int fila, int columna) {
        List<Integer[]> movimientos = new ArrayList();
        
        if (0 <= fila && fila < 8 && 0 <= columna && columna < 8) {
            movimientos = Control.getInstance().getMovimientos(fila, columna);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Integer[] pos = {i, j};
                Celda celda = this.celdas[i][j];
                boolean posibleMovimiento = this.esMovimiento(movimientos, pos);
                celda.marcar(posibleMovimiento);
            }
        }
    }
    
    public void mostrar(IdentificadorPieza[][] tablero) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                IdentificadorPieza pieza = tablero[i][j];
                Celda celda = this.celdas[i][j];
                celda.marcar(false);
                
                if (pieza == null) {
                    celda.setPieza(null);
                    celda.setColor(null);
                }
                else {
                    celda.setPieza(pieza.getTipo());
                    celda.setColor(pieza.getColor());
                    celda.setEnabled(Control.getInstance().estaJugando(celda.getColor()));
                }
                
                celda.setIcon();
            }
        }
        
        ((PantallaJuego) MainFrame.getInstance().getPage(MainFrame.PANTALLA_JUEGO)).mostrarPiezasTomadas();
    }
    
    private void terminarTurno() {
        Control control = Control.getInstance();
        control.seguirTurno();
        this.mostrar(control.mostrarTablero());
        Color color = control.verificarJaqueMate();
        
        if (color != null) {
            ((PantallaJuego) MainFrame.getInstance().getPage(MainFrame.PANTALLA_JUEGO)).terminarPartida(color);
        }
    }
    
    public boolean esMovimiento(List<Integer[]> movimientos, Integer[] pos) {
        for (Integer[] mov : movimientos) {
            if (Arrays.equals(mov, pos)) {
                return true;
            }
        }
        
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
