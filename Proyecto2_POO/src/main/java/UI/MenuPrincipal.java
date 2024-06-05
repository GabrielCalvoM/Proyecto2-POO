package UI;

import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JPanel {

    public MenuPrincipal() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nuevaPartidaBtn = new javax.swing.JButton();
        cargarPartidaBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(68, 160, 68));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(720, 405));

        jLabel1.setFont(new java.awt.Font("Castellar", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 55, 55));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ajedrez");

        nuevaPartidaBtn.setBackground(new java.awt.Color(172, 89, 0));
        nuevaPartidaBtn.setFont(new java.awt.Font("Century", 0, 24)); // NOI18N
        nuevaPartidaBtn.setText("Nueva Pratida");
        nuevaPartidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaPartidaBtnActionPerformed(evt);
            }
        });

        cargarPartidaBtn.setBackground(new java.awt.Color(172, 89, 0));
        cargarPartidaBtn.setFont(new java.awt.Font("Century", 0, 24)); // NOI18N
        cargarPartidaBtn.setText("Cargar Pratida");
        cargarPartidaBtn.setToolTipText("");

        salirBtn.setBackground(new java.awt.Color(166, 105, 40));
        salirBtn.setFont(new java.awt.Font("Century", 0, 24)); // NOI18N
        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addComponent(nuevaPartidaBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargarPartidaBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(nuevaPartidaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cargarPartidaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        int salir = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
                                                  "¿Desea salir de la aplicación?",
                                                  "Salir", JOptionPane.YES_NO_OPTION);
        if (salir == JOptionPane.YES_OPTION) {
            MainFrame.salir();
        }
    }//GEN-LAST:event_salirBtnActionPerformed

    private void nuevaPartidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaPartidaBtnActionPerformed
        MainFrame.getInstance().showPage("PantallaJuego");
    }//GEN-LAST:event_nuevaPartidaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarPartidaBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton nuevaPartidaBtn;
    private javax.swing.JButton salirBtn;
    // End of variables declaration//GEN-END:variables
}
