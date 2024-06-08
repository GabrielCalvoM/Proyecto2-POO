package UI;

import control.Control;
import enums.PiezaEnum;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Celda extends JButton {
    
    private boolean marcado;    // posible movimiento de la pieza escogida
    private int fila;
    private int columna;
    private Color color;        // info de pieza en la celda
    private PiezaEnum pieza;    //
    private TableroUI tablero;
    
    
    public Celda() {
        super();
        setContentAreaFilled(false);
        this.columna = 0;
        this.fila = 0;
        
        this.initBoton();
    }
    
    public Celda(int posY, int posX) {
        super();
        this.columna = posX;
        this.fila = posY;
        
        this.initBoton();
    }
    
    public int getFila() {
        return this.fila;
    }
    
    public int getColumna() {
        return this.columna;
    }
    
    public PiezaEnum getPieza() {
        return this.pieza;
    }
    
    public void setPieza(PiezaEnum pieza) {
        this.pieza = pieza;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setTablero(TableroUI tablero) {
        this.tablero = tablero;
    }
    
    public void marcar(boolean marcado) {
        this.marcado = marcado;
        
        this.setIcon();
    }
    public boolean isMarcado() {
        return this.marcado;
    }
    
    public void setIcon() {
        ImagenRegistro registro = ImagenRegistro.getInstance();
        
        if (this.pieza != null) {
            Map<PiezaEnum, ImageIcon> lista = registro.getListaIcon(color, marcado);
            ImageIcon icon = lista.get(this.pieza);
            registro.ajustar(this, icon);
            this.setIcon(icon);
        }
        else {
            if (this.marcado) {
                ImageIcon icon = registro.getIcon(this, "marca\\marca.png");
                registro.ajustar(this, icon);
                this.setIcon(icon);
            }
            else {
                this.setIcon(null);
            }
        }
    }
    
    
    public void paintIcon(Graphics g) {
        ImagenRegistro registro = ImagenRegistro.getInstance();
        Map<PiezaEnum, ImageIcon> lista = registro.getListaIcon(color, false);
        
        if (this.pieza != null) {
            ImageIcon icon = lista.get(this.pieza);
            registro.ajustar(this, icon);
            int iconX = (getWidth() - icon.getIconWidth()) / 2;
            int iconY = (getHeight() - icon.getIconHeight()) / 2;
            icon.paintIcon(this, g, iconX, iconY);
        }
    }
    
    
    private void initBoton() {
        this.marcado = false;
        
        this.addActionListener((ActionEvent e) -> {
            if (this.pieza != null || marcado) {
                if (this.tablero.getSeleccionado() != null || Control.getInstance().estaJugando(color)) {
                    tablero.seleccionar(this);
                }
            }
        });
    }
    
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if (getIcon() != null) {
            int iconX = (getWidth() - getIcon().getIconWidth()) / 2;
            int iconY = (getHeight() - getIcon().getIconHeight()) / 2;
            getIcon().paintIcon(this, g, iconX, iconY);
        }
    }
        
}
