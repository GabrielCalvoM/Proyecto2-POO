package UI;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

public class MainFrame extends javax.swing.JFrame {
    
    public static final String MENU_PRINCIPAL = "MenuPrincipal";
    public static final String PANTALLA_JUEGO = "PantallaJuego";
    public static final String MENU_JUEGO = "MenuJuego";
    
    private static MainFrame instance;
    
    public MainFrame() {
        initComponents();
        CardLayout cardLayout = new CardLayout();
        this.panel.setLayout(cardLayout);
        this.initPanel();
    }
    
    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajedrez");
        setBackground(new java.awt.Color(68, 160, 68));
        setResizable(false);
        setSize(new java.awt.Dimension(720, 455));

        panel.setBackground(new java.awt.Color(68, 160, 68));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void initPanel() {
        this.panel.add(new MenuPrincipal(), MENU_PRINCIPAL);
        this.panel.add(new PantallaJuego(), PANTALLA_JUEGO);
        this.panel.add(new MenuJuego(), MENU_JUEGO);
    }
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame.getInstance().setVisible(true);
            }
        });
    }
    
    public void showPage(String panelName) {
        CardLayout cardLayout = (CardLayout) this.panel.getLayout();
        cardLayout.show(this.panel, panelName);
        this.panel.revalidate();
        this.panel.repaint();
    }
    
    public JPanel getPage(String panelName) {
        return (JPanel) (switch (panelName) {
            case MENU_PRINCIPAL -> this.panel.getComponent(0);
            case PANTALLA_JUEGO -> this.panel.getComponent(1);
            case MENU_JUEGO -> this.panel.getComponent(2);
            default -> null;
        });
    }
    
    
    public static void salir() {
        instance.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
