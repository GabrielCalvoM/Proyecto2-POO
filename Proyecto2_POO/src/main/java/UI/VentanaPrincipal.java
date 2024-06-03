package UI;

import processing.core.*;

public class VentanaPrincipal extends PApplet {
    
    public static void main(String[] args) {
        PApplet.main("VentanaPrincipal");
    }

    public void settings() {
        size(400, 400);
    }

    public void setup() {
        size(400, 400);
    }

    public void draw() {
        background(255);
        ellipse(width/2, height/2, 50, 50);
    }
    
}
