/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrik
 */
public class Profil extends javax.swing.JFrame {

    private String angivetAnv;
    private Connection connection;
    private String smsNotis;
    private String status;

    public Profil(Connection connection, String angivetAnv) {
        initComponents();
        this.setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.connection = connection;
        this.angivetAnv = angivetAnv;
        jlabelPnr.setText(angivetAnv);
        
        
        radSmsJa.setVisible(false);
        radSmsNej.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        radEpostJa.setVisible(false);
        radEpostNej.setVisible(false);
        
        
        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT FORNAMN FROM ANVANDARE WHERE PNR='" + angivetAnv+"'");
            rs.next();
            String fornamn = rs.getString("FORNAMN");
            lblFornamnDB.setText(fornamn);

            Statement stmt2 = connection.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT EFTERNAMN FROM ANVANDARE WHERE PNR='" + angivetAnv+"'");
            rs2.next();
            String efternamn = rs2.getString("EFTERNAMN");
            lblEfternamnDB.setText(efternamn);

            Statement stmt3 = connection.createStatement();
            ResultSet rs3 = stmt3.executeQuery("SELECT EMAIL FROM ANVANDARE WHERE PNR='" + angivetAnv+"'");
            rs3.next();
            String email = rs3.getString("EMAIL");
            lblEpostDB.setText(email);

            Statement stmt4 = connection.createStatement();
            ResultSet rs4 = stmt4.executeQuery("SELECT MOBILNMR FROM ANVANDARE WHERE PNR='" + angivetAnv+"'");
            rs4.next();
            String mobilnmr = rs4.getString("MOBILNMR");
            lblTlfnrDB.setText(mobilnmr);

            Statement stmt5 = connection.createStatement();
            ResultSet rs5 = stmt5.executeQuery("SELECT RUMSNMR FROM ANVANDARE WHERE PNR='" + angivetAnv+"'");
            rs5.next();
            String rumsnmr = rs5.getString("RUMSNMR");
            lblRumsnrDB.setText(rumsnmr);

            Statement stmt6 = connection.createStatement();
            ResultSet rs6 = stmt6.executeQuery("SELECT STATUS FROM ANVANDARE WHERE PNR='" + angivetAnv+"'");
            rs6.next();
            status = rs6.getString("STATUS");
            String braStatus = KonverteraStatus.konverteraStatus(status);
            lblAnvandarstatusDB.setText(braStatus);
            

            Statement stmt7 = connection.createStatement();
            ResultSet rs7 = stmt7.executeQuery("SELECT PROFILBILD FROM ANVANDARE WHERE PNR='" + angivetAnv+"'");
            rs7.next();

            byte[] img = rs7.getBytes("PROFILBILD");
            ImageIcon image = new ImageIcon(img);
            Image im = image.getImage();
            Image myImg = im.getScaledInstance(lblProfilBildDB.getWidth(), lblProfilBildDB.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(myImg);
            lblProfilBildDB.setIcon(newImage);

            Statement stmt8 = connection.createStatement();
            ResultSet rs8 = stmt8.executeQuery("SELECT FIRST 1 SMSNOTISER FROM ANVANDARE_SUPERKATEGORI WHERE ANVANDARE='" + angivetAnv + "'");
            rs8.next();
            String smsSvar = rs8.getString("SMSNOTISER");
            if (smsSvar.equals("JA")) {
                radSmsJa.setSelected(true);
            } else {
                radSmsNej.setSelected(true);
            }

            Statement stmt9 = connection.createStatement();
            ResultSet rs9 = stmt9.executeQuery("SELECT FIRST 1 EMAILNOTISER FROM ANVANDARE_SUPERKATEGORI WHERE ANVANDARE='" + angivetAnv + "'");
            rs9.next();
            String emailSvar = rs9.getString("EMAILNOTISER");
            
            if(emailSvar !=null){
            
        radSmsJa.setVisible(true);
        radSmsNej.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        radEpostJa.setVisible(true);
        radEpostNej.setVisible(true);
            
            }
            
            
            if (emailSvar.equals("JA")) {
                radEpostJa.setSelected(true);
            } else {
                radEpostNej.setSelected(true);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSms = new javax.swing.ButtonGroup();
        bgEpost = new javax.swing.ButtonGroup();
        lblFornamn = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();
        lblEpost = new javax.swing.JLabel();
        lblAnvandarstatus = new javax.swing.JLabel();
        lblRumsnummer = new javax.swing.JLabel();
        lblMobil = new javax.swing.JLabel();
        btnRedigeraInfo = new javax.swing.JButton();
        lblFornamnDB = new javax.swing.JLabel();
        lblEfternamnDB = new javax.swing.JLabel();
        lblAnvandarstatusDB = new javax.swing.JLabel();
        lblTlfnrDB = new javax.swing.JLabel();
        lblEpostDB = new javax.swing.JLabel();
        lblRumsnrDB = new javax.swing.JLabel();
        lblProfilBildDB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlabelPnr = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        radSmsJa = new javax.swing.JRadioButton();
        radSmsNej = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radEpostJa = new javax.swing.JRadioButton();
        radEpostNej = new javax.swing.JRadioButton();

        bgSms.add(radSmsJa);
        bgSms.add(radSmsNej);

        bgEpost.add(radEpostJa);
        bgEpost.add(radEpostNej);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblFornamn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFornamn.setText("Förnamn");

        lblEfternamn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEfternamn.setText("Efternamn");

        lblEpost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEpost.setText("E-post");

        lblAnvandarstatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAnvandarstatus.setText("Användarstatus");

        lblRumsnummer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRumsnummer.setText("Rumsnummer");

        lblMobil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMobil.setText("Telefonnummer");

        btnRedigeraInfo.setText("Redigera information");
        btnRedigeraInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigeraInfoActionPerformed(evt);
            }
        });

        lblFornamnDB.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        lblEfternamnDB.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        lblAnvandarstatusDB.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        lblTlfnrDB.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        lblEpostDB.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        lblRumsnrDB.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Användarnamn");

        jlabelPnr.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jButton1.setText("Hantera följningar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        radSmsJa.setText("Ja");
        radSmsJa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radSmsJaActionPerformed(evt);
            }
        });

        radSmsNej.setText("Nej");
        radSmsNej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radSmsNejActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Notiser SMS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Notiser E-post");

        radEpostJa.setText("Ja");
        radEpostJa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radEpostJaActionPerformed(evt);
            }
        });

        radEpostNej.setText("Nej");
        radEpostNej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radEpostNejActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProfilBildDB, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblRumsnrDB, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblMobil, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(lblRumsnummer)
                                    .addComponent(lblTlfnrDB, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAnvandarstatus)
                                            .addComponent(lblEpost)
                                            .addComponent(lblAnvandarstatusDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(113, 113, 113))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEpostDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(btnRedigeraInfo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEfternamn)
                                    .addComponent(lblFornamn))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFornamnDB, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEfternamnDB, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(jlabelPnr, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(41, 41, 41))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(radSmsJa)
                                    .addGap(67, 67, 67)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radSmsNej)
                                .addGap(61, 61, 61)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radEpostNej)
                            .addComponent(radEpostJa)
                            .addComponent(jLabel3))
                        .addGap(0, 113, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRedigeraInfo)
                            .addComponent(jButton1))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMobil)
                            .addComponent(lblEpost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTlfnrDB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEpostDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRumsnummer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRumsnrDB, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblAnvandarstatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAnvandarstatusDB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))))
                    .addComponent(lblProfilBildDB, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFornamnDB, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFornamn))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEfternamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEfternamnDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlabelPnr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radSmsJa)
                            .addComponent(radEpostJa))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radSmsNej)
                            .addComponent(radEpostNej))))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRedigeraInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraInfoActionPerformed
        AndraProfil andraProfil = new AndraProfil(connection, angivetAnv, status);
        andraProfil.setVisible(true);
    }//GEN-LAST:event_btnRedigeraInfoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HanteraFoljningar följ = new HanteraFoljningar(connection, angivetAnv);
        följ.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radSmsJaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radSmsJaActionPerformed

        try {
            Statement stmt = connection.createStatement();

            stmt.executeUpdate("UPDATE ANVANDARE_SUPERKATEGORI SET SMSNOTISER='JA' WHERE ANVANDARE ='" + angivetAnv + "'");
        } catch (SQLException ex) {
        }

    }//GEN-LAST:event_radSmsJaActionPerformed

    private void radSmsNejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radSmsNejActionPerformed

        try {
            Statement stmt = connection.createStatement();

            stmt.executeUpdate("UPDATE ANVANDARE_SUPERKATEGORI SET SMSNOTISER='NEJ' WHERE ANVANDARE ='" + angivetAnv + "'");
        } catch (SQLException ex) {
        }

    }//GEN-LAST:event_radSmsNejActionPerformed

    private void radEpostJaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radEpostJaActionPerformed

        try {
            Statement stmt = connection.createStatement();

            stmt.executeUpdate("UPDATE ANVANDARE_SUPERKATEGORI SET EMAILNOTISER='JA' WHERE ANVANDARE ='" + angivetAnv + "'");
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_radEpostJaActionPerformed

    private void radEpostNejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radEpostNejActionPerformed

        try {
            Statement stmt = connection.createStatement();

            stmt.executeUpdate("UPDATE ANVANDARE_SUPERKATEGORI SET EMAILNOTISER='NEJ' WHERE ANVANDARE ='" + angivetAnv + "'");
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_radEpostNejActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgEpost;
    private javax.swing.ButtonGroup bgSms;
    private javax.swing.JButton btnRedigeraInfo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jlabelPnr;
    private javax.swing.JLabel lblAnvandarstatus;
    private javax.swing.JLabel lblAnvandarstatusDB;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEfternamnDB;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblEpostDB;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblFornamnDB;
    private javax.swing.JLabel lblMobil;
    private javax.swing.JLabel lblProfilBildDB;
    private javax.swing.JLabel lblRumsnrDB;
    private javax.swing.JLabel lblRumsnummer;
    private javax.swing.JLabel lblTlfnrDB;
    private javax.swing.JRadioButton radEpostJa;
    private javax.swing.JRadioButton radEpostNej;
    private javax.swing.JRadioButton radSmsJa;
    private javax.swing.JRadioButton radSmsNej;
    // End of variables declaration//GEN-END:variables
}
