package UI;

import control.IdentificadorPieza;
import enums.PiezaEnum;
import java.awt.Color;
import java.util.Map;
import javax.swing.ImageIcon;

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
        if (this.presionado == null) {
            this.presionado = celda;
        }
        else if (this.presionado == celda) {
            this.presionado = null;
        }
        else {
            // movimiento
        }
    }
    
    public void mostrar(IdentificadorPieza[][] tablero) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                IdentificadorPieza pieza = tablero[i][j];
                Celda celda = this.celdas[i][j];
                
                if (pieza == null) {
                    celda.setPieza(null);
                    celda.setColor(null);
                    celda.setEnabled(false);
                }
                else {
                    celda.setPieza(pieza.getTipo());
                    celda.setColor(pieza.getColor());
                    celda.setEnabled(true);
                }
                
                celda.repaint();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
