package UI;

import control.Control;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MenuJuego extends javax.swing.JPanel {

    public MenuJuego() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        guardarSalirBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();
        guardarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(216, 163, 107));
        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(216, 163, 107));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 10, true));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 29, 128));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menú de pausa");

        guardarSalirBtn.setBackground(new java.awt.Color(104, 56, 9));
        guardarSalirBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        guardarSalirBtn.setForeground(new java.awt.Color(255, 224, 113));
        guardarSalirBtn.setText("Guardar y Saliir");
        guardarSalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarSalirBtnActionPerformed(evt);
            }
        });

        salirBtn.setBackground(new java.awt.Color(104, 56, 9));
        salirBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        salirBtn.setForeground(new java.awt.Color(255, 224, 113));
        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        guardarBtn.setBackground(new java.awt.Color(104, 56, 9));
        guardarBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        guardarBtn.setForeground(new java.awt.Color(255, 224, 113));
        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(guardarSalirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(guardarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(guardarSalirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(355, 355, 355))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(volverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(volverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        MainFrame.getInstance().showPage(MainFrame.PANTALLA_JUEGO);
    }//GEN-LAST:event_volverBtnActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        String string = "<html>¿Desea salir de la partida?"
                        + "<br>(Se perderá el progreso no guardado)";
        this.salir(string);
    }//GEN-LAST:event_salirBtnActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        this.guardar();
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void guardarSalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarSalirBtnActionPerformed
        String string = "¿Desea salir de la partida?";
        this.guardar();
        this.salir(string);
    }//GEN-LAST:event_guardarSalirBtnActionPerformed

    public void setIcon() {
        ImageIcon icon = ImagenRegistro.getInstance().getIcon(this.volverBtn, "botones\\salir.png");
        this.volverBtn.setIcon(icon);
    }
    
    private void guardar() {
        try {
            Control.guardarPartida();
            String msj = "Se ha guardado la partida correctamente";
            JOptionPane.showMessageDialog(MainFrame.getInstance(), msj);
        }
        catch (IOException ex) {
            String msj = "Error al guardar la partida";
            JOptionPane.showMessageDialog(MainFrame.getInstance(), msj);
        }
        catch (ClassNotFoundException ex) {
            String msj = "Error de acceso de clase";
            JOptionPane.showMessageDialog(MainFrame.getInstance(), msj);
        }
    }
    
    private void salir(String string) {
        int salir = JOptionPane.showConfirmDialog(MainFrame.getInstance(), string,
                                                  "Salir", JOptionPane.YES_NO_OPTION);
        if (salir == JOptionPane.YES_OPTION) {
            MainFrame.getInstance().showPage(MainFrame.MENU_PRINCIPAL);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarBtn;
    private javax.swing.JButton guardarSalirBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salirBtn;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables
}
