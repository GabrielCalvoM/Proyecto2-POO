package UI;

import enums.PiezaEnum;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ImagenRegistro {
    
    private static ImagenRegistro instancia;
    private Map<PiezaEnum, ImageIcon> piezasBlancas;    // lista de imagenes
    private Map<PiezaEnum, ImageIcon> piezasNegras;     // 
    private Map<PiezaEnum, ImageIcon> marcadasBlancas;  //
    private Map<PiezaEnum, ImageIcon> marcadasNegras;   //
    private final String directorio = System.getProperty("user.dir") + "\\imagenes\\";
    
    
    private ImagenRegistro() {
        this.initIcons();
    }
    
    public static ImagenRegistro getInstance() {
        if (instancia == null) {
            instancia = new ImagenRegistro();
        }
        
        return instancia;
    }
    
    public Map<PiezaEnum, ImageIcon> getListaIcon(Color color, boolean marcada) {
        if (color == null) {
            return null;
        }
        else if (color.toString().equals(Color.white.toString())) {
            if (marcada) {
                return marcadasBlancas;
            }
            else {
                return piezasBlancas;
            }
        }
        else if (color.toString().equals(Color.black.toString())){
            if (marcada) {
                return marcadasNegras;
            }
            else {
                return piezasNegras;
            }
        }
        else {
            return null;
        }
    }
    
    public void ajustar(JComponent component, ImageIcon icon) {
        Image imagen = icon.getImage().getScaledInstance(component.getWidth(), component.getHeight(),
                                                         Image.SCALE_SMOOTH);
        icon.setImage(imagen);
    }
    
    public String getDir() {
        return this.directorio;
    }
    
    public ImageIcon getIcon(JComponent component, String ruta) {
        ImageIcon icon = new ImageIcon(this.directorio + ruta);
        this.ajustar(component, icon);
        return icon;
    }
    
    
    
    
    private void initIcons() {
        initLista(Color.white, false);
        initLista(Color.black, false);
        initLista(Color.white, true);
        initLista(Color.black, true);
    }
    
    private void initLista(Color color, boolean marcadas) {
        String dir = directorio;
        Map<PiezaEnum, ImageIcon> lista = new HashMap();
        
        if (color == Color.white){
            dir += "\\piezasBlancas";
            
            if (marcadas) {
                dir += "\\marcadas";
                marcadasBlancas = lista;
            }
            else {
                piezasBlancas = lista;
            }
        }
        else if (color == Color.black){
            dir += "\\piezasNegras";
            
            if (marcadas) {
                dir += "\\marcadas";
                marcadasNegras = lista;
            }
            else {
                piezasNegras = lista;
            }
        }
        else {
            return;
        }
        
        for (PiezaEnum tipo : PiezaEnum.values()) {
            String ruta = dir + ("\\" + tipo.toString() + ".png");
            ImageIcon imagen = new ImageIcon(ruta);
            lista.put(tipo, imagen);
        }
    }
    
    private static ImageIcon iconMarca(int diametro, Color color) {
        BufferedImage image = new BufferedImage(diametro, diametro, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(color);
        g2d.fillOval(0, 0, diametro - 5, diametro - 5);

        g2d.dispose();

        return new ImageIcon(image);
    }
}