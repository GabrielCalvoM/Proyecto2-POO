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
    
    private static Map<PiezaEnum, ImageIcon> piezasBlancas;     // lista de imagenes
    private static Map<PiezaEnum, ImageIcon> piezasNegras;      // 
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
    
    public void marcar() {
        this.marcado = !this.marcado;
        this.repaint();
    }
    
    
    
    
    
    public void ajustar(ImageIcon icon) {
        Image imagen = icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(),
                                                             Image.SCALE_SMOOTH);
        icon.setImage(imagen);
    }
    
    public void paintIcon(Graphics g) {
        Map<PiezaEnum, ImageIcon> lista = this.getListaIcon(color);
        
        if (this.pieza != null) {
            ImageIcon icon = lista.get(this.pieza);
            this.ajustar(icon);
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
                marcar();
            }
        });
    }
    
    public static void initIcons() {
        initLista(Color.white);
        initLista(Color.black);
    }
    
    private static void initLista(Color color) {
        String dir = System.getProperty("user.dir") + "\\imagenes";
        Map<PiezaEnum, ImageIcon> lista = new HashMap();
        
        if (color == Color.white){
            piezasBlancas = lista;
            dir += "\\piezasBlancas";
        }
        else if (color == Color.black){
            piezasNegras = lista;
            dir += "\\piezasNegras";
        }
        else {
            return;
        }
        
        for (PiezaEnum tipo : PiezaEnum.values()) {
            System.out.println(tipo);
            String ruta = dir + ("\\" + tipo.toString() + ".png");
            ImageIcon imagen = new ImageIcon(ruta);
            lista.put(tipo, imagen);
        }
    }
    
    private Map<PiezaEnum, ImageIcon> getListaIcon(Color color) {
        if (color == Color.white){
            return piezasBlancas;
        }
        else if (color == Color.black){
            return piezasNegras;
        }
        else {
            return null;
        }
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
