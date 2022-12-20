package com.luxgym.views;

import com.luxgym.controllers.SignUpControlador;
import java.awt.Color;
import java.sql.SQLException;

public class SignUp extends javax.swing.JFrame {

    int xMouse, yMouse;

    public SignUp() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        matriculaBtn = new javax.swing.JPanel();
        registrarBtnTxt = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panel6 = new javax.swing.JPanel();
        nombrelbl2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        panel9 = new javax.swing.JPanel();
        nombrelbl5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        panel10 = new javax.swing.JPanel();
        nombrelbl6 = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        nombrelbl1 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        favicon1 = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitBtn.setBackground(new java.awt.Color(102, 102, 102));
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));

        exitTxt.setBackground(new java.awt.Color(255, 255, 255));
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
            .addGroup(exitBtnLayout.createSequentialGroup()
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitBtnLayout.createSequentialGroup()
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        matriculaBtn.setBackground(new java.awt.Color(182, 249, 205));
        matriculaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        registrarBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 18)); // NOI18N
        registrarBtnTxt.setForeground(new java.awt.Color(79, 209, 123));
        registrarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrarBtnTxt.setText("REGISTRARSE");
        registrarBtnTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 209, 123), 2));
        registrarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrarBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout matriculaBtnLayout = new javax.swing.GroupLayout(matriculaBtn);
        matriculaBtn.setLayout(matriculaBtnLayout);
        matriculaBtnLayout.setHorizontalGroup(
            matriculaBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matriculaBtnLayout.createSequentialGroup()
                .addComponent(registrarBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        matriculaBtnLayout.setVerticalGroup(
            matriculaBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matriculaBtnLayout.createSequentialGroup()
                .addComponent(registrarBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.add(matriculaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 150, 50));

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(204, 204, 204));
        txtNombre.setText("Ingrese su nombre");
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombre.setCaretColor(new java.awt.Color(0, 51, 204));
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        bg.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 360, 40));

        panel6.setBackground(new java.awt.Color(153, 153, 255));
        panel6.setBorder(new javax.swing.border.MatteBorder(null));

        nombrelbl2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        nombrelbl2.setForeground(new java.awt.Color(0, 0, 102));
        nombrelbl2.setText("Apellido");

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombrelbl2)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nombrelbl2))
        );

        bg.add(panel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 130, -1));

        txtApellido.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(204, 204, 204));
        txtApellido.setText("Ingrese su apellido");
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtApellido.setCaretColor(new java.awt.Color(0, 51, 204));
        txtApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoMousePressed(evt);
            }
        });
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        bg.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 360, 40));

        panel9.setBackground(new java.awt.Color(153, 153, 255));
        panel9.setBorder(new javax.swing.border.MatteBorder(null));

        nombrelbl5.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        nombrelbl5.setForeground(new java.awt.Color(0, 0, 102));
        nombrelbl5.setText("Correo Electrónico");

        javax.swing.GroupLayout panel9Layout = new javax.swing.GroupLayout(panel9);
        panel9.setLayout(panel9Layout);
        panel9Layout.setHorizontalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombrelbl5)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panel9Layout.setVerticalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nombrelbl5))
        );

        bg.add(panel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(204, 204, 204));
        txtCorreo.setText("Ingrese su correo electrónico");
        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCorreo.setCaretColor(new java.awt.Color(0, 51, 204));
        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCorreoMousePressed(evt);
            }
        });
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        bg.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 360, 40));

        panel10.setBackground(new java.awt.Color(153, 153, 255));
        panel10.setBorder(new javax.swing.border.MatteBorder(null));

        nombrelbl6.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        nombrelbl6.setForeground(new java.awt.Color(0, 0, 102));
        nombrelbl6.setText("Contraseña");

        javax.swing.GroupLayout panel10Layout = new javax.swing.GroupLayout(panel10);
        panel10.setLayout(panel10Layout);
        panel10Layout.setHorizontalGroup(
            panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombrelbl6)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panel10Layout.setVerticalGroup(
            panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nombrelbl6))
        );

        bg.add(panel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 170, -1));

        panel5.setBackground(new java.awt.Color(153, 153, 255));
        panel5.setBorder(new javax.swing.border.MatteBorder(null));

        nombrelbl1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        nombrelbl1.setForeground(new java.awt.Color(0, 0, 102));
        nombrelbl1.setText("Nombre");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombrelbl1)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nombrelbl1))
        );

        bg.add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 130, 30));

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
        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setForeground(new java.awt.Color(255, 255, 255));
        favicon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        favicon.setText("Registro de Usuario");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(favicon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(favicon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(favicon)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 130));

        txtPass.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtPass.setForeground(new java.awt.Color(204, 204, 204));
        txtPass.setText("********");
        txtPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPassMousePressed(evt);
            }
        });
        bg.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 360, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
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

    private void registrarBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarBtnTxtMouseEntered
        matriculaBtn.setBackground(new Color(79, 209, 123));
        registrarBtnTxt.setForeground(Color.white);
    }//GEN-LAST:event_registrarBtnTxtMouseEntered

    private void registrarBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarBtnTxtMouseExited
        matriculaBtn.setBackground(new Color(182, 249, 205));
        registrarBtnTxt.setForeground(new Color(79, 209, 123));
    }//GEN-LAST:event_registrarBtnTxtMouseExited

    private void registrarBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarBtnTxtMouseClicked

    }//GEN-LAST:event_registrarBtnTxtMouseClicked

    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        if (txtNombre.getText().equals("Ingrese su nombre")) {
            txtNombre.setText("");
            txtNombre.setForeground(Color.black);
        }
        if (txtApellido.getText().isEmpty()) {
            txtApellido.setText("Ingrese su apellido");
            txtApellido.setForeground(Color.gray);
        }
        if (txtCorreo.getText().isEmpty()) {
            txtCorreo.setText("Ingrese su correo electrónico");
            txtCorreo.setForeground(Color.gray);
        }
        if (String.valueOf(txtPass.getPassword()).isEmpty()) {
            txtPass.setText("********");
            txtPass.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtNombreMousePressed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMousePressed
        if (txtApellido.getText().equals("Ingrese su apellido")) {
            txtApellido.setText("");
            txtApellido.setForeground(Color.black);
        }
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setText("Ingrese su nombre");
            txtNombre.setForeground(Color.gray);
        }
        if (txtCorreo.getText().isEmpty()) {
            txtCorreo.setText("Ingrese su correo electrónico");
            txtCorreo.setForeground(Color.gray);
        }
        if (String.valueOf(txtPass.getPassword()).isEmpty()) {
            txtPass.setText("********");
            txtPass.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtApellidoMousePressed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtCorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMousePressed
        if (txtCorreo.getText().equals("Ingrese su correo electrónico")) {
            txtCorreo.setText("");
            txtCorreo.setForeground(Color.black);
        }
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setText("Ingrese su nombre");
            txtNombre.setForeground(Color.gray);
        }
        if (txtApellido.getText().isEmpty()) {
            txtApellido.setText("Ingrese su apellido");
            txtApellido.setForeground(Color.gray);
        }
        if (String.valueOf(txtPass.getPassword()).isEmpty()) {
            txtPass.setText("********");
            txtPass.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtCorreoMousePressed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMousePressed
        if (String.valueOf(txtPass.getPassword()).equals("********")) {
            txtPass.setText("");
            txtPass.setForeground(Color.black);
        }
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setText("Ingrese su nombre");
            txtNombre.setForeground(Color.gray);
        }
        if (txtApellido.getText().isEmpty()) {
            txtApellido.setText("Ingrese su apellido");
            txtApellido.setForeground(Color.gray);
        }
        if (txtCorreo.getText().isEmpty()) {
            txtCorreo.setText("Ingrese su correo electrónico");
            txtCorreo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPassMousePressed

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        SignUp vista = new SignUp();
        SignUpControlador controlador = new SignUpControlador(vista);
        vista.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel exitBtn;
    public javax.swing.JLabel exitTxt;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel favicon1;
    private javax.swing.JPanel header;
    private javax.swing.JPanel matriculaBtn;
    private javax.swing.JLabel nombrelbl1;
    private javax.swing.JLabel nombrelbl2;
    private javax.swing.JLabel nombrelbl5;
    private javax.swing.JLabel nombrelbl6;
    private javax.swing.JPanel panel10;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel9;
    public javax.swing.JLabel registrarBtnTxt;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
