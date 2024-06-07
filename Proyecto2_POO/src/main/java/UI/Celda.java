package UI;

import enums.PiezaEnum;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;
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
        
        if (this.pieza == null) {
            this.setEnabled(marcado);
        }
        
        this.repaint();
    }
    public boolean isMarcado() {
        return this.marcado;
    }
    
    
    
    
    
    public void paintIcon(Graphics g) {
        ImagenRegistro registro = ImagenRegistro.getInstance();
        Map<PiezaEnum, ImageIcon> lista = registro.getListaIcon(color);
        
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
        
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tablero.seleccionar((Celda) e.getSource());
                marcar(!marcado);
            }
        });
    }
    
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if (marcado) {
            Graphics2D g2d = (Graphics2D) g.create();
            int diameter = Math.min(getWidth(), getHeight()) - 10;
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;
            Shape circle = new Ellipse2D.Double(x, y, diameter, diameter);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            
            if (this.pieza == null) {
                g2d.setColor(Color.white);
            }
            else {
                g2d.setColor(Color.RED);
            }
            
            g2d.fill(circle);
            g2d.dispose();
        }
        
        paintIcon(g);
    }
        
}
