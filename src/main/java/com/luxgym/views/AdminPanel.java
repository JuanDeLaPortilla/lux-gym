package com.luxgym.views;

import com.luxgym.controllers.AdminControlador;
import java.awt.Color;
import java.sql.SQLException;

public class AdminPanel extends javax.swing.JFrame {

    int xMouse, yMouse;

    public AdminPanel() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        favicon1 = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        matriculasBtn = new javax.swing.JPanel();
        matriculasBtnTxt = new javax.swing.JLabel();
        nivelesBtn = new javax.swing.JPanel();
        nivelesBtnTxt = new javax.swing.JLabel();
        entrenadoresBtn = new javax.swing.JPanel();
        entrenadoresBtnTxt = new javax.swing.JLabel();
        especialidadesBtn = new javax.swing.JPanel();
        especialidadesBtnTxt = new javax.swing.JLabel();
        usuariosBtn = new javax.swing.JPanel();
        usuariosBtnTxt = new javax.swing.JLabel();
        horariosBtn = new javax.swing.JPanel();
        horariosBtnTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(550, 459));
        bg.setPreferredSize(new java.awt.Dimension(550, 459));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        favicon1.setBackground(new java.awt.Color(187, 155, 107));
        favicon1.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        favicon1.setForeground(new java.awt.Color(255, 255, 255));
        favicon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        favicon1.setText("LUX GYM");

        favicon.setBackground(new java.awt.Color(187, 155, 107));
        favicon.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        favicon.setForeground(new java.awt.Color(255, 255, 255));
        favicon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        favicon.setText("Panel de Control");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(favicon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(favicon, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(favicon1)
                .addGap(18, 18, 18)
                .addComponent(favicon)
                .addGap(35, 35, 35))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 570, 190));

        matriculasBtn.setBackground(new java.awt.Color(228, 228, 228));
        matriculasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        matriculasBtnTxt.setBackground(new java.awt.Color(235, 235, 235));
        matriculasBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        matriculasBtnTxt.setForeground(new java.awt.Color(0, 0, 0));
        matriculasBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        matriculasBtnTxt.setText("MATRICULAS");
        matriculasBtnTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        matriculasBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        matriculasBtnTxt.setMaximumSize(new java.awt.Dimension(147, 34));
        matriculasBtnTxt.setMinimumSize(new java.awt.Dimension(147, 34));
        matriculasBtnTxt.setPreferredSize(new java.awt.Dimension(147, 34));
        matriculasBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matriculasBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                matriculasBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                matriculasBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout matriculasBtnLayout = new javax.swing.GroupLayout(matriculasBtn);
        matriculasBtn.setLayout(matriculasBtnLayout);
        matriculasBtnLayout.setHorizontalGroup(
            matriculasBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matriculasBtnLayout.createSequentialGroup()
                .addComponent(matriculasBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        matriculasBtnLayout.setVerticalGroup(
            matriculasBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matriculasBtnLayout.createSequentialGroup()
                .addComponent(matriculasBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.add(matriculasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 180, 80));

        nivelesBtn.setBackground(new java.awt.Color(228, 228, 228));
        nivelesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        nivelesBtnTxt.setBackground(new java.awt.Color(235, 235, 235));
        nivelesBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        nivelesBtnTxt.setForeground(new java.awt.Color(0, 0, 0));
        nivelesBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivelesBtnTxt.setText("NIVEL");
        nivelesBtnTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        nivelesBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nivelesBtnTxt.setMaximumSize(new java.awt.Dimension(147, 34));
        nivelesBtnTxt.setMinimumSize(new java.awt.Dimension(147, 34));
        nivelesBtnTxt.setPreferredSize(new java.awt.Dimension(147, 34));
        nivelesBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nivelesBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivelesBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivelesBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout nivelesBtnLayout = new javax.swing.GroupLayout(nivelesBtn);
        nivelesBtn.setLayout(nivelesBtnLayout);
        nivelesBtnLayout.setHorizontalGroup(
            nivelesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nivelesBtnLayout.createSequentialGroup()
                .addComponent(nivelesBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        nivelesBtnLayout.setVerticalGroup(
            nivelesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nivelesBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        bg.add(nivelesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 180, 80));

        entrenadoresBtn.setBackground(new java.awt.Color(228, 228, 228));
        entrenadoresBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        entrenadoresBtnTxt.setBackground(new java.awt.Color(235, 235, 235));
        entrenadoresBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        entrenadoresBtnTxt.setForeground(new java.awt.Color(0, 0, 0));
        entrenadoresBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entrenadoresBtnTxt.setText("ENTRENADORES");
        entrenadoresBtnTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        entrenadoresBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrenadoresBtnTxt.setMaximumSize(new java.awt.Dimension(147, 34));
        entrenadoresBtnTxt.setMinimumSize(new java.awt.Dimension(147, 34));
        entrenadoresBtnTxt.setPreferredSize(new java.awt.Dimension(147, 34));
        entrenadoresBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entrenadoresBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                entrenadoresBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                entrenadoresBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout entrenadoresBtnLayout = new javax.swing.GroupLayout(entrenadoresBtn);
        entrenadoresBtn.setLayout(entrenadoresBtnLayout);
        entrenadoresBtnLayout.setHorizontalGroup(
            entrenadoresBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entrenadoresBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        entrenadoresBtnLayout.setVerticalGroup(
            entrenadoresBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entrenadoresBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        bg.add(entrenadoresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 180, 80));

        especialidadesBtn.setBackground(new java.awt.Color(235, 235, 235));
        especialidadesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        especialidadesBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        especialidadesBtnTxt.setForeground(new java.awt.Color(0, 0, 0));
        especialidadesBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        especialidadesBtnTxt.setText("ESPECIALIDAD");
        especialidadesBtnTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        especialidadesBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        especialidadesBtnTxt.setMaximumSize(new java.awt.Dimension(147, 34));
        especialidadesBtnTxt.setMinimumSize(new java.awt.Dimension(147, 34));
        especialidadesBtnTxt.setPreferredSize(new java.awt.Dimension(147, 34));
        especialidadesBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                especialidadesBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                especialidadesBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                especialidadesBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout especialidadesBtnLayout = new javax.swing.GroupLayout(especialidadesBtn);
        especialidadesBtn.setLayout(especialidadesBtnLayout);
        especialidadesBtnLayout.setHorizontalGroup(
            especialidadesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(especialidadesBtnLayout.createSequentialGroup()
                .addComponent(especialidadesBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        especialidadesBtnLayout.setVerticalGroup(
            especialidadesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(especialidadesBtnLayout.createSequentialGroup()
                .addComponent(especialidadesBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.add(especialidadesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 180, 80));

        usuariosBtn.setBackground(new java.awt.Color(235, 235, 235));
        usuariosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        usuariosBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        usuariosBtnTxt.setForeground(new java.awt.Color(0, 0, 0));
        usuariosBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuariosBtnTxt.setText("USUARIOS");
        usuariosBtnTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        usuariosBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuariosBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuariosBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usuariosBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usuariosBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout usuariosBtnLayout = new javax.swing.GroupLayout(usuariosBtn);
        usuariosBtn.setLayout(usuariosBtnLayout);
        usuariosBtnLayout.setHorizontalGroup(
            usuariosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuariosBtnLayout.createSequentialGroup()
                .addComponent(usuariosBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        usuariosBtnLayout.setVerticalGroup(
            usuariosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuariosBtnLayout.createSequentialGroup()
                .addComponent(usuariosBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.add(usuariosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, 80));

        horariosBtn.setBackground(new java.awt.Color(235, 235, 235));
        horariosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        horariosBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        horariosBtnTxt.setForeground(new java.awt.Color(0, 0, 0));
        horariosBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horariosBtnTxt.setText("HORARIO");
        horariosBtnTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        horariosBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horariosBtnTxt.setMaximumSize(new java.awt.Dimension(147, 34));
        horariosBtnTxt.setMinimumSize(new java.awt.Dimension(147, 34));
        horariosBtnTxt.setPreferredSize(new java.awt.Dimension(147, 34));
        horariosBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horariosBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                horariosBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                horariosBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout horariosBtnLayout = new javax.swing.GroupLayout(horariosBtn);
        horariosBtn.setLayout(horariosBtnLayout);
        horariosBtnLayout.setHorizontalGroup(
            horariosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(horariosBtnLayout.createSequentialGroup()
                .addComponent(horariosBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        horariosBtnLayout.setVerticalGroup(
            horariosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(horariosBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        bg.add(horariosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 180, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entrenadoresBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrenadoresBtnTxtMouseEntered
        entrenadoresBtn.setBackground(new Color(60, 63, 65));
        entrenadoresBtnTxt.setForeground(Color.white);
    }//GEN-LAST:event_entrenadoresBtnTxtMouseEntered

    private void entrenadoresBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrenadoresBtnTxtMouseExited
        entrenadoresBtn.setBackground(new Color(235, 235, 235));
        entrenadoresBtnTxt.setForeground(Color.black);
    }//GEN-LAST:event_entrenadoresBtnTxtMouseExited

    private void entrenadoresBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrenadoresBtnTxtMouseClicked

    }//GEN-LAST:event_entrenadoresBtnTxtMouseClicked

    private void especialidadesBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_especialidadesBtnTxtMouseClicked

    }//GEN-LAST:event_especialidadesBtnTxtMouseClicked

    private void especialidadesBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_especialidadesBtnTxtMouseEntered
        especialidadesBtn.setBackground(new Color(60, 63, 65));
        especialidadesBtnTxt.setForeground(Color.white);
    }//GEN-LAST:event_especialidadesBtnTxtMouseEntered

    private void especialidadesBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_especialidadesBtnTxtMouseExited
        especialidadesBtn.setBackground(new Color(235, 235, 235));
        especialidadesBtnTxt.setForeground(Color.black);
    }//GEN-LAST:event_especialidadesBtnTxtMouseExited

    private void usuariosBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosBtnTxtMouseClicked

    }//GEN-LAST:event_usuariosBtnTxtMouseClicked

    private void usuariosBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosBtnTxtMouseEntered
        usuariosBtn.setBackground(new Color(60, 63, 65));
        usuariosBtnTxt.setForeground(Color.white);
    }//GEN-LAST:event_usuariosBtnTxtMouseEntered

    private void usuariosBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosBtnTxtMouseExited
        usuariosBtn.setBackground(new Color(235, 235, 235));
        usuariosBtnTxt.setForeground(Color.black);
    }//GEN-LAST:event_usuariosBtnTxtMouseExited

    private void horariosBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horariosBtnTxtMouseClicked

    }//GEN-LAST:event_horariosBtnTxtMouseClicked

    private void horariosBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horariosBtnTxtMouseEntered
        horariosBtn.setBackground(new Color(60, 63, 65));
        horariosBtnTxt.setForeground(Color.white);
    }//GEN-LAST:event_horariosBtnTxtMouseEntered

    private void horariosBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horariosBtnTxtMouseExited
        horariosBtn.setBackground(new Color(235, 235, 235));
        horariosBtnTxt.setForeground(Color.black);
    }//GEN-LAST:event_horariosBtnTxtMouseExited

    private void nivelesBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivelesBtnTxtMouseClicked

    }//GEN-LAST:event_nivelesBtnTxtMouseClicked

    private void nivelesBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivelesBtnTxtMouseEntered
        nivelesBtn.setBackground(new Color(60, 63, 65));
        nivelesBtnTxt.setForeground(Color.white);
    }//GEN-LAST:event_nivelesBtnTxtMouseEntered

    private void nivelesBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivelesBtnTxtMouseExited
        nivelesBtn.setBackground(new Color(235, 235, 235));
        nivelesBtnTxt.setForeground(Color.black);
    }//GEN-LAST:event_nivelesBtnTxtMouseExited

    private void matriculasBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculasBtnTxtMouseClicked

    }//GEN-LAST:event_matriculasBtnTxtMouseClicked

    private void matriculasBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculasBtnTxtMouseEntered
        matriculasBtn.setBackground(new Color(60, 63, 65));
        matriculasBtnTxt.setForeground(Color.white);
    }//GEN-LAST:event_matriculasBtnTxtMouseEntered

    private void matriculasBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculasBtnTxtMouseExited
        matriculasBtn.setBackground(new Color(235, 235, 235));
        matriculasBtnTxt.setForeground(Color.black);
    }//GEN-LAST:event_matriculasBtnTxtMouseExited

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(new Color(102, 102, 102));
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseExited

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.black);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked

    }//GEN-LAST:event_exitTxtMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        AdminPanel vista = new AdminPanel();
        AdminControlador controlador = new AdminControlador(vista);
        vista.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel entrenadoresBtn;
    public javax.swing.JLabel entrenadoresBtnTxt;
    private javax.swing.JPanel especialidadesBtn;
    public javax.swing.JLabel especialidadesBtnTxt;
    private javax.swing.JPanel exitBtn;
    public javax.swing.JLabel exitTxt;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel favicon1;
    private javax.swing.JPanel horariosBtn;
    public javax.swing.JLabel horariosBtnTxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel matriculasBtn;
    public javax.swing.JLabel matriculasBtnTxt;
    private javax.swing.JPanel nivelesBtn;
    public javax.swing.JLabel nivelesBtnTxt;
    private javax.swing.JPanel usuariosBtn;
    public javax.swing.JLabel usuariosBtnTxt;
    // End of variables declaration//GEN-END:variables
}
