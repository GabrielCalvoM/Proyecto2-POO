package UI;

import control.Control;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PantallaJuego extends javax.swing.JPanel {
    
    private Timer timer;
    
    public PantallaJuego() {
        initComponents();
        this.jugadorBlanco.setColor(Color.white);
        this.jugadorNegro.setColor(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablero = new UI.TableroUI();
        jugadorBlanco = new UI.TablaJugador();
        jugadorNegro = new UI.TablaJugador();
        opcionesBtn = new javax.swing.JButton();
        abandonarBtn = new javax.swing.JButton();
        tablasBtn = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setOpaque(false);

        tablero.setPreferredSize(new java.awt.Dimension(440, 440));

        opcionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesBtnActionPerformed(evt);
            }
        });

        abandonarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abandonarBtnActionPerformed(evt);
            }
        });

        tablasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablasBtnActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(117, 16, 16));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jugadorBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(tablasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(abandonarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(opcionesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jugadorNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jugadorBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tablasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(opcionesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(abandonarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addComponent(jugadorNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void opcionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesBtnActionPerformed
        MainFrame.getInstance().showPage(MainFrame.MENU_JUEGO);
        ((MenuJuego) MainFrame.getInstance().getPage(MainFrame.MENU_JUEGO)).setIcon();
    }//GEN-LAST:event_opcionesBtnActionPerformed

    private void abandonarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abandonarBtnActionPerformed
        int abandonar = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
                                                      "¿Seguro que quiere abandonar la partida?",
                                                      "Abandonar", JOptionPane.YES_NO_OPTION);
        if (abandonar == JOptionPane.YES_OPTION) {
            Control control = Control.getInstance();
            String nombre = control.getNombreJugador(control.jugadorActual());
            control.abandonar(nombre);
            JOptionPane.showMessageDialog(MainFrame.getInstance(), nombre + " ha abandonado la partida",
                                          "Abandonar", JOptionPane.INFORMATION_MESSAGE);
            MainFrame.getInstance().showPage(MainFrame.MENU_PRINCIPAL);
        }
    }//GEN-LAST:event_abandonarBtnActionPerformed

    private void tablasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablasBtnActionPerformed
        boolean tablas = TablasDialog.verificarTablas(MainFrame.getInstance(), true);
        
        if (tablas) {
            Control control = Control.getInstance();
            control.esTablas();
            JOptionPane.showMessageDialog(MainFrame.getInstance(), "Se ha declarado tablas por ambos jugadores",
                                          "Declarar Tablas", JOptionPane.INFORMATION_MESSAGE);
            MainFrame.getInstance().showPage(MainFrame.MENU_PRINCIPAL);
        }
    }//GEN-LAST:event_tablasBtnActionPerformed
    
    public void reset() {
        this.jugadorBlanco.reset();
        this.jugadorNegro.reset();
    }
    
    public void mostrarPiezasTomadas() {
        this.jugadorBlanco.llenar();
        this.jugadorNegro.llenar();
    }
    
    public void mostrarMensajeError(String mensaje) {
        this.errorLabel.setText(mensaje);
        
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        
        timer = new Timer(3000, (ActionEvent e) -> {
            this.errorLabel.setText("");
            timer.stop();
        });
        timer.setRepeats(false);
        timer.start();
        System.out.println(mensaje);
    }
    
    public void empezarPartida() {
        //this.tablero.mostrar(tablero);
        Control control = Control.getInstance();
        this.jugadorBlanco.setNombre(control.getNombreJugador(Color.white));
        this.jugadorNegro.setNombre(control.getNombreJugador(Color.black));
        this.tablero.mostrar(control.mostrarTablero());
    }
    
    public void terminarPartida(Color color) {
        if (color != null) {
            Control control = Control.getInstance();
            String ganador = control.getNombreJugador(color);
            String perdedor = "segundo jugador";
            try {
                perdedor = control.getNombreJugador(control.switchColor(color));
            } catch (Exception ex) {
                
            }
            String mensaje = ganador + " ha logrado realizar un jaque mate a " + perdedor;
            
            JOptionPane.showMessageDialog(MainFrame.getInstance(), mensaje, "Fin de la partida",
                                          JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void setIcon() {
        this.opcionesBtn.setIcon(ImagenRegistro.getInstance().getIcon(this.opcionesBtn,
                                                                      "botones\\opciones.png"));
        this.abandonarBtn.setIcon(ImagenRegistro.getInstance().getIcon(this.opcionesBtn,
                                                                       "botones\\abandonar.png"));
        this.tablasBtn.setIcon(ImagenRegistro.getInstance().getIcon(this.opcionesBtn,
                                                                    "botones\\tablas.png"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abandonarBtn;
    private javax.swing.JLabel errorLabel;
    private UI.TablaJugador jugadorBlanco;
    private UI.TablaJugador jugadorNegro;
    private javax.swing.JButton opcionesBtn;
    private javax.swing.JButton tablasBtn;
    private UI.TableroUI tablero;
    // End of variables declaration//GEN-END:variables
}
