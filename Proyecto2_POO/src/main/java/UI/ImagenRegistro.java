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
    private ImageIcon opcionesIcon;
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
    
    public ImageIcon getOpcionesIcon() {
        return this.opcionesIcon;
    }
    
    public void ajustar(JComponent component, ImageIcon icon) {
        Image imagen = icon.getImage().getScaledInstance(component.getWidth(), component.getHeight(),
                                                         Image.SCALE_SMOOTH);
        icon.setImage(imagen);
    }
    
    
    
    private void initIcons() {
        initLista(Color.white);
        initLista(Color.black);
        String ruta = directorio + "\\botones\\opciones.png";
        this.opcionesIcon = new ImageIcon(ruta);
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
