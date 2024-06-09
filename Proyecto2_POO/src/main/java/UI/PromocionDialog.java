package UI;

import enums.PiezaEnum;
import java.awt.Color;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PromocionDialog extends javax.swing.JDialog {
    
    private PiezaEnum selected;
    
    public PromocionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, true);
        initComponents();
        this.selected = null;
    }
    
    public void initIcons(Color color) {
        ImagenRegistro registro = ImagenRegistro.getInstance();
        Map<PiezaEnum, ImageIcon> lista = registro.getListaIcon(color, false);
        
        this.setIcon(this.torreBtn, lista, PiezaEnum.torre);
        this.setIcon(this.alfilBtn, lista, PiezaEnum.alfil);
        this.setIcon(this.caballoBtn, lista, PiezaEnum.caballo);
        this.setIcon(this.reinaBtn, lista, PiezaEnum.dama);
    }
    
    private void setIcon(JButton boton, Map<PiezaEnum, ImageIcon> lista, PiezaEnum tipo) {
        ImageIcon icon = lista.get(tipo);
        ImagenRegistro.getInstance().ajustar(boton, icon);
        boton.setIcon(icon);
    }
    
    public static PiezaEnum select(Color color) {
        PromocionDialog dialog = new PromocionDialog(MainFrame.getInstance(), false);
        dialog.initIcons(color);
        dialog.setVisible(true);
        PiezaEnum tipo = dialog.getTipo();
        System.out.println(tipo);
        return tipo;
    }
    
    public PiezaEnum getTipo() {
        return this.selected;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        torreBtn = new javax.swing.JButton();
        alfilBtn = new javax.swing.JButton();
        caballoBtn = new javax.swing.JButton();
        reinaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Promoción");

        jPanel1.setBackground(new java.awt.Color(197, 197, 197));

        torreBtn.setBackground(new java.awt.Color(47, 52, 55));
        torreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torreBtnActionPerformed(evt);
            }
        });

        alfilBtn.setBackground(new java.awt.Color(47, 52, 55));
        alfilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alfilBtnActionPerformed(evt);
            }
        });

        caballoBtn.setBackground(new java.awt.Color(47, 52, 55));
        caballoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caballoBtnActionPerformed(evt);
            }
        });

        reinaBtn.setBackground(new java.awt.Color(47, 52, 55));
        reinaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reinaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(torreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alfilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(caballoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reinaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(torreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alfilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caballoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reinaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void torreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torreBtnActionPerformed
        this.selected = PiezaEnum.torre;
        this.dispose();
    }//GEN-LAST:event_torreBtnActionPerformed

    private void alfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alfilBtnActionPerformed
        this.selected = PiezaEnum.alfil;
        this.dispose();
    }//GEN-LAST:event_alfilBtnActionPerformed

    private void caballoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caballoBtnActionPerformed
        this.selected = PiezaEnum.caballo;
        this.dispose();
    }//GEN-LAST:event_caballoBtnActionPerformed

    private void reinaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reinaBtnActionPerformed
        this.selected = PiezaEnum.dama;
        this.dispose();
    }//GEN-LAST:event_reinaBtnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PromocionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PromocionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PromocionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PromocionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PromocionDialog dialog = new PromocionDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alfilBtn;
    private javax.swing.JButton caballoBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton reinaBtn;
    private javax.swing.JButton torreBtn;
    // End of variables declaration//GEN-END:variables
}
