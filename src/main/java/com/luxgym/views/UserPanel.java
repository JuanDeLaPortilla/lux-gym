package com.luxgym.views;

import com.luxgym.controllers.UserControlador;
import com.luxgym.models.Usuario;
import java.awt.Color;
import java.sql.SQLException;

public class UserPanel extends javax.swing.JFrame {

    int xMouse, yMouse;

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UserPanel(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        this.txtName.setText(this.usuario.getNombre() + " " + this.usuario.getApellido());
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        panel7 = new javax.swing.JPanel();
        cboEntrenador = new javax.swing.JComboBox<>();
        ciclolbl1 = new javax.swing.JLabel();
        registerBtn = new javax.swing.JPanel();
        matriculaBtnTxt = new javax.swing.JLabel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        favicon1 = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        favicon3 = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEntrenador = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel7.setBackground(new java.awt.Color(148, 192, 252));

        cboEntrenador.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        cboEntrenador.setBorder(null);
        cboEntrenador.setLightWeightPopupEnabled(false);
        cboEntrenador.setOpaque(false);
        cboEntrenador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboEntrenadorMouseClicked(evt);
            }
        });

        ciclolbl1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        ciclolbl1.setForeground(new java.awt.Color(0, 0, 153));
        ciclolbl1.setText("ID Entrenador");

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ciclolbl1)
                .addGap(18, 18, 18)
                .addComponent(cboEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ciclolbl1))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        bg.add(panel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 350, 30));

        registerBtn.setBackground(new java.awt.Color(182, 249, 205));
        registerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        matriculaBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 18)); // NOI18N
        matriculaBtnTxt.setForeground(new java.awt.Color(79, 209, 123));
        matriculaBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        matriculaBtnTxt.setText("MATRICULAR");
        matriculaBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        matriculaBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matriculaBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                matriculaBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                matriculaBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout registerBtnLayout = new javax.swing.GroupLayout(registerBtn);
        registerBtn.setLayout(registerBtnLayout);
        registerBtnLayout.setHorizontalGroup(
            registerBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(matriculaBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        registerBtnLayout.setVerticalGroup(
            registerBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(matriculaBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        bg.add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 120, 50));

        exitBtn.setBackground(new java.awt.Color(102, 102, 102));

        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(255, 255, 255));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exitBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exitBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bg.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        header.setBackground(new java.awt.Color(51, 51, 51));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        favicon1.setBackground(new java.awt.Color(187, 155, 107));
        favicon1.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        favicon1.setForeground(new java.awt.Color(255, 255, 255));
        favicon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        favicon1.setText("LUX GYM");

        favicon.setBackground(new java.awt.Color(187, 155, 107));
        favicon.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        favicon.setForeground(new java.awt.Color(255, 255, 255));
        favicon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        favicon.setText("Selecciona la ID del Entrenador y el Boton de MATRICULAR para Culminar tu Matrícula");

        favicon3.setBackground(new java.awt.Color(187, 155, 107));
        favicon3.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon3.setForeground(new java.awt.Color(255, 255, 255));
        favicon3.setText("Bienvenido ");

        txtName.setBackground(new java.awt.Color(187, 155, 107));
        txtName.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setText("############");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(favicon, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(favicon1)
                .addGap(18, 18, 18)
                .addComponent(favicon3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(favicon3)
                        .addComponent(txtName))
                    .addComponent(favicon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(favicon)
                .addGap(14, 14, 14))
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 110));

        tableEntrenador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "DIA", "HORA", "ESPECIALIDAD"
            }
        ));
        jScrollPane1.setViewportView(tableEntrenador);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 780, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked

    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.black);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(new Color(102, 102, 102));
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseExited

    private void matriculaBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculaBtnTxtMouseEntered
        registerBtn.setBackground(new Color(79, 209, 123));
        matriculaBtnTxt.setForeground(Color.white);
    }//GEN-LAST:event_matriculaBtnTxtMouseEntered

    private void matriculaBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculaBtnTxtMouseExited
        registerBtn.setBackground(new Color(182, 249, 205));
        matriculaBtnTxt.setForeground(new Color(79, 209, 123));
    }//GEN-LAST:event_matriculaBtnTxtMouseExited

    private void matriculaBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculaBtnTxtMouseClicked

    }//GEN-LAST:event_matriculaBtnTxtMouseClicked

    private void cboEntrenadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboEntrenadorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEntrenadorMouseClicked

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario();
        UserPanel userPanel = new UserPanel(usuario);
        UserControlador userControlador = new UserControlador(userPanel);
        userPanel.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    public javax.swing.JComboBox<String> cboEntrenador;
    private javax.swing.JLabel ciclolbl1;
    private javax.swing.JPanel exitBtn;
    public javax.swing.JLabel exitTxt;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel favicon1;
    private javax.swing.JLabel favicon3;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel matriculaBtnTxt;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel registerBtn;
    public javax.swing.JTable tableEntrenador;
    private javax.swing.JLabel txtName;
    // End of variables declaration//GEN-END:variables
}
