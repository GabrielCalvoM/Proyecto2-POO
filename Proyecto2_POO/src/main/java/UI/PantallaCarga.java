package UI;

import control.Control;
import java.io.IOException;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PantallaCarga extends javax.swing.JPanel {

    public PantallaCarga() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        partidas = new javax.swing.JTable();
        cargarPartidaBtn = new javax.swing.JButton();
        volverBtn1 = new javax.swing.JButton();

        setOpaque(false);

        jScrollPane1.setBackground(new java.awt.Color(70, 204, 89));
        jScrollPane1.setForeground(new java.awt.Color(17, 9, 67));

        partidas.setBackground(new java.awt.Color(70, 204, 89));
        partidas.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        partidas.setForeground(new java.awt.Color(17, 9, 67));
        partidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de la partida", "Jugado por última vez"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        partidas.setRowHeight(40);
        partidas.setShowVerticalLines(false);
        jScrollPane1.setViewportView(partidas);

        cargarPartidaBtn.setBackground(new java.awt.Color(172, 89, 0));
        cargarPartidaBtn.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        cargarPartidaBtn.setText("Cargar Partida");
        cargarPartidaBtn.setToolTipText("");
        cargarPartidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarPartidaBtnActionPerformed(evt);
            }
        });

        volverBtn1.setBackground(new java.awt.Color(172, 89, 0));
        volverBtn1.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        volverBtn1.setText("Volver");
        volverBtn1.setToolTipText("");
        volverBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(volverBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cargarPartidaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargarPartidaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cargarPartidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarPartidaBtnActionPerformed
        int fila = this.partidas.getSelectedRow();
        
        try {
            String partida = (String) this.partidas.getModel().getValueAt(fila, 0);
            Control.cargarPartida(partida);
            
            PantallaJuego panel = (PantallaJuego) MainFrame.getInstance().getPage(MainFrame.PANTALLA_JUEGO);
            panel.setIcon();
            panel.reset();
            MainFrame.getInstance().showPage(MainFrame.PANTALLA_JUEGO);
            
            panel.empezarPartida();
        } catch (IOException ex) {
            String msj = "Error al acceder al archivo de partida";
            JOptionPane.showMessageDialog(MainFrame.getInstance(), msj);
        } catch (ClassNotFoundException ex) {
            String msj = "Error de acceso de clase";
            JOptionPane.showMessageDialog(MainFrame.getInstance(), msj);
        }
    }//GEN-LAST:event_cargarPartidaBtnActionPerformed

    private void volverBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtn1ActionPerformed
        MainFrame.getInstance().showPage(MainFrame.MENU_PRINCIPAL);
    }//GEN-LAST:event_volverBtn1ActionPerformed
    
    public void mostrarPartidas() throws Exception {
        Map<String, String> lista = Control.getPartidas();
        DefaultTableModel model = (DefaultTableModel) this.partidas.getModel();
        model.setRowCount(0);

        for (String archivo : lista.keySet()) {
            String[] fila = {archivo.substring(0, archivo.lastIndexOf(".")), lista.get(archivo)};
            model.addRow(fila);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarPartidaBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable partidas;
    private javax.swing.JButton volverBtn1;
    // End of variables declaration//GEN-END:variables
}
