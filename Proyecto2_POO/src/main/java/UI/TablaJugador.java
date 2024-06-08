package UI;

import control.Control;
import enums.PiezaEnum;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TablaJugador extends javax.swing.JPanel {
    
    private Color color;
    private int contador;

    public TablaJugador() {
        initComponents();
        this.contador = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreLabel = new javax.swing.JLabel();
        jColor = new javax.swing.JPanel();
        piezasTomadas = new javax.swing.JPanel();
        Pieza1 = new javax.swing.JLabel();
        Pieza2 = new javax.swing.JLabel();
        Pieza3 = new javax.swing.JLabel();
        Pieza4 = new javax.swing.JLabel();
        Pieza5 = new javax.swing.JLabel();
        Pieza6 = new javax.swing.JLabel();
        Pieza7 = new javax.swing.JLabel();
        Pieza8 = new javax.swing.JLabel();
        Pieza9 = new javax.swing.JLabel();
        Pieza10 = new javax.swing.JLabel();
        Pieza11 = new javax.swing.JLabel();
        Pieza12 = new javax.swing.JLabel();
        Pieza13 = new javax.swing.JLabel();
        Pieza14 = new javax.swing.JLabel();
        Pieza15 = new javax.swing.JLabel();
        Pieza16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(202, 171, 89));

        nombreLabel.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(52, 0, 0));

        javax.swing.GroupLayout jColorLayout = new javax.swing.GroupLayout(jColor);
        jColor.setLayout(jColorLayout);
        jColorLayout.setHorizontalGroup(
            jColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );
        jColorLayout.setVerticalGroup(
            jColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        piezasTomadas.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(99, 99, 99)));
        piezasTomadas.setOpaque(false);
        piezasTomadas.setPreferredSize(new java.awt.Dimension(220, 220));
        piezasTomadas.setLayout(new java.awt.GridLayout(4, 4));
        piezasTomadas.add(Pieza1);
        piezasTomadas.add(Pieza2);
        piezasTomadas.add(Pieza3);
        piezasTomadas.add(Pieza4);
        piezasTomadas.add(Pieza5);
        piezasTomadas.add(Pieza6);
        piezasTomadas.add(Pieza7);
        piezasTomadas.add(Pieza8);
        piezasTomadas.add(Pieza9);
        piezasTomadas.add(Pieza10);
        piezasTomadas.add(Pieza11);
        piezasTomadas.add(Pieza12);
        piezasTomadas.add(Pieza13);
        piezasTomadas.add(Pieza14);
        piezasTomadas.add(Pieza15);
        piezasTomadas.add(Pieza16);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 15, 68));
        jLabel2.setText("Piezas Tomadas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(piezasTomadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(piezasTomadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public void setColor(Color color) {
        this.color = color;
        this.jColor.setBackground(color);
    }
    
    public void reset() {
        this.vaciar();
        this.nombreLabel.setText("");
    }
    
    public void setPiezaTomada(PiezaEnum pieza) {
        ImagenRegistro registro = ImagenRegistro.getInstance();
        Map<PiezaEnum, ImageIcon> lista = registro.getListaIcon(color, false);
        JLabel label = (JLabel) this.piezasTomadas.getComponent(this.contador);
        ImageIcon icon = lista.get(pieza);
        registro.ajustar(label, icon);
        label.setIcon(icon);
        this.contador++;
    }
    
    public void vaciar() {
        for (Component label : this.piezasTomadas.getComponents()) {
            ((JLabel) label).setIcon(null);
        }
        this.contador = 0;
    }
    
    public void setNombre(String nombre) {
        this.nombreLabel.setText(nombre);
    }
    
    public void llenar() {
        try {
            this.vaciar();
            
            List<PiezaEnum> piezas = Control.getInstance().getPiezasTomadas(this.color);
            
            for (PiezaEnum pieza : piezas) {
                this.setPiezaTomada(pieza);
            }
        }
        catch (Exception ex) {
            String msj = ("Ha ocurrido un error al recuperar las "
                          + "piezas tomadas de " + this.nombreLabel.getText());
            JOptionPane.showMessageDialog(MainFrame.getInstance(), msj, "Error",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pieza1;
    private javax.swing.JLabel Pieza10;
    private javax.swing.JLabel Pieza11;
    private javax.swing.JLabel Pieza12;
    private javax.swing.JLabel Pieza13;
    private javax.swing.JLabel Pieza14;
    private javax.swing.JLabel Pieza15;
    private javax.swing.JLabel Pieza16;
    private javax.swing.JLabel Pieza2;
    private javax.swing.JLabel Pieza3;
    private javax.swing.JLabel Pieza4;
    private javax.swing.JLabel Pieza5;
    private javax.swing.JLabel Pieza6;
    private javax.swing.JLabel Pieza7;
    private javax.swing.JLabel Pieza8;
    private javax.swing.JLabel Pieza9;
    private javax.swing.JPanel jColor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JPanel piezasTomadas;
    // End of variables declaration//GEN-END:variables
}
