package UI;

import enums.PiezaEnum;
import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ImagenRegistro {
    
    private static ImagenRegistro instancia;
    private Map<PiezaEnum, ImageIcon> piezasBlancas;     // lista de imagenes
    private Map<PiezaEnum, ImageIcon> piezasNegras;      // 
    private final String directorio = System.getProperty("user.dir") + "\\imagenes";
    
    
    private ImagenRegistro() {
        this.initIcons();
    }
    
    public static ImagenRegistro getInstance() {
        if (instancia == null) {
            instancia = new ImagenRegistro();
        }
        
        return instancia;
    }
    
    public Map<PiezaEnum, ImageIcon> getListaIcon(Color color) {
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
        initLista(Color.white);
        initLista(Color.black);
    }
    
    private void initLista(Color color) {
        String dir = directorio;
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
            String ruta = dir + ("\\" + tipo.toString() + ".png");
            ImageIcon imagen = new ImageIcon(ruta);
            lista.put(tipo, imagen);
        }
    }
}