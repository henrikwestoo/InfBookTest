/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Henrik
 */
public class AndraProfil extends javax.swing.JFrame {

    private Connection connection;
    private String personnummer;
    private JFileChooser file;
    private File selectedFile;
    private String path;
    private String status;

    /**
     * Creates new form AndraProfil
     */
    public AndraProfil(Connection connection, String personnummer, String status) {
        initComponents();
        this.setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.connection = connection;
        this.personnummer = personnummer;
        this.status = status;
        txtPNR.setText(personnummer);
        txtPNR.setEditable(false);
        cmbStatus.setVisible(false);
        lblAnvandarstatus.setVisible(false);
        lblNotis.setVisible(false);
        System.out.println(status);
        
        
        String[] alternativCA = new String[]{"Centraladministratör", "Forskningsadministratör", "Utbildningsadministratör", "Forskningsanvändare", "Utbildningsanvändare", "Amanuens"};
        String[] alternativUA = new String[]{"Utbildningsanvändare", "Amanuens"};
        String[] alternativFA = new String[]{"Forskningsanvändare", "Amanuens"};

        if (status.equals("UA")) {

            cmbStatus.setModel(new DefaultComboBoxModel(alternativUA)); //Om man är ua väljs denna array för att fylla boxen

        } else if (status.equals("FA")) {

            cmbStatus.setModel(new DefaultComboBoxModel(alternativFA)); // etc etc

        } else if (status.equals("CA")) {

            cmbStatus.setModel(new DefaultComboBoxModel(alternativCA)); // etc etc

        }
        
        if (status.equals("CA") || status.equals("UA") || status.equals("FA")) {
            cmbStatus.setVisible(true);
            lblAnvandarstatus.setVisible(true);
        }
        
        
        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT FORNAMN FROM ANVANDARE WHERE PNR='" + personnummer+"'");
            rs.next();
            String fornamn = rs.getString("FORNAMN");
            txtFornamn.setText(fornamn);

            Statement stmt2 = connection.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT EFTERNAMN FROM ANVANDARE WHERE PNR='" + personnummer+"'");
            rs2.next();
            String efternamn = rs2.getString("EFTERNAMN");
            txtEfternamn.setText(efternamn);

            Statement stmt3 = connection.createStatement();
            ResultSet rs3 = stmt3.executeQuery("SELECT EMAIL FROM ANVANDARE WHERE PNR='" + personnummer+"'");
            rs3.next();
            String email = rs3.getString("EMAIL");
            txtEpost.setText(email);

            Statement stmt4 = connection.createStatement();
            ResultSet rs4 = stmt4.executeQuery("SELECT MOBILNMR FROM ANVANDARE WHERE PNR='" + personnummer+"'");
            rs4.next();
            String mobilnmr = rs4.getString("MOBILNMR");
            txtTelefon.setText(mobilnmr);

            Statement stmt5 = connection.createStatement();
            ResultSet rs5 = stmt5.executeQuery("SELECT RUMSNMR FROM ANVANDARE WHERE PNR='" + personnummer+"'");
            rs5.next();
            String rumsnmr = rs5.getString("RUMSNMR");
            txtRum.setText(rumsnmr);

//            Statement stmt6 = connection.createStatement();
//            ResultSet rs6 = stmt6.executeQuery("SELECT STATUS FROM ANVANDARE WHERE PNR=" + personnummer);
//            rs6.next();
//            String status = rs6.getString("STATUS");

            cmbStatus.setSelectedItem(KonverteraStatus.konverteraStatus(status));

            Statement stmt7 = connection.createStatement();
            ResultSet rs7 = stmt7.executeQuery("SELECT PROFILBILD FROM ANVANDARE WHERE PNR='" + personnummer+"'");
            rs7.next();

            byte[] img = rs7.getBytes("PROFILBILD");
            ImageIcon image = new ImageIcon(img);
            Image im = image.getImage();
            Image myImg = im.getScaledInstance(lblProfilBildDB.getWidth(), lblProfilBildDB.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(myImg);
            lblProfilBildDB.setIcon(newImage);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {

        }

        btnBytBild.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = file.getSelectedFile();
                    path = selectedFile.getAbsolutePath();

                    int i = path.lastIndexOf(".");

                    lblProfilBildDB.setIcon(ResizeImage(path));

                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFornamn = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();
        lblEpost = new javax.swing.JLabel();
        lblProfilBildDB = new javax.swing.JLabel();
        lblAnvandarstatus = new javax.swing.JLabel();
        lblPNR = new javax.swing.JLabel();
        lblRumsnummer = new javax.swing.JLabel();
        lblMobil = new javax.swing.JLabel();
        txtFornamn = new javax.swing.JTextField();
        txtEfternamn = new javax.swing.JTextField();
        txtPNR = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtRum = new javax.swing.JTextField();
        txtEpost = new javax.swing.JTextField();
        btnBytBild = new javax.swing.JButton();
        cmbStatus = new javax.swing.JComboBox();
        btnSpara = new javax.swing.JButton();
        btnBytLosenord = new javax.swing.JButton();
        lblNotis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblFornamn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFornamn.setText("Förnamn");

        lblEfternamn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEfternamn.setText("Efternamn");

        lblEpost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEpost.setText("E-post");

        lblAnvandarstatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAnvandarstatus.setText("Användarstatus");

        lblPNR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPNR.setText("Användarnamn");

        lblRumsnummer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRumsnummer.setText("Rumsnummer");

        lblMobil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMobil.setText("Telefonnummer");

        txtTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonActionPerformed(evt);
            }
        });

        btnBytBild.setText("Byt profilbild");
        btnBytBild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBytBildActionPerformed(evt);
            }
        });

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Centraladministratör", "Forskningsadministratör", "Utbildningsadministratör", "Forskningsanvändare", "Utbildningsanvändare", "Amanuens" }));

        btnSpara.setText("Spara ändringar");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        btnBytLosenord.setText("Byt lösenord");
        btnBytLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBytLosenordActionPerformed(evt);
            }
        });

        lblNotis.setText("Profilen har ändrats!");

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
                            .addComponent(btnBytBild)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMobil)
                                            .addComponent(lblRumsnummer))
                                        .addGap(93, 93, 93))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtRum, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTelefon))
                                        .addGap(60, 60, 60)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAnvandarstatus)
                                    .addComponent(lblEpost)
                                    .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBytLosenord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNotis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSpara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblPNR)
                            .addGap(18, 18, 18)
                            .addComponent(txtPNR, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFornamn)
                                .addComponent(lblEfternamn))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEfternamn, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                .addComponent(txtFornamn)))))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMobil)
                            .addComponent(lblEpost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRumsnummer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFornamn)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEfternamn)
                                    .addComponent(txtEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblAnvandarstatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnBytLosenord)
                                .addGap(18, 18, 18)
                                .addComponent(lblNotis)
                                .addGap(5, 5, 5))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblProfilBildDB, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnBytBild)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(txtFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPNR)
                            .addComponent(txtPNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSpara)
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed

        if (Validering.isString(txtFornamn)
                && Validering.isString(txtEfternamn)
                && Validering.isTextFältTomt(txtTelefon)
                && Validering.isTextFältTomt(txtRum)
                && Validering.isTextFältTomt(txtEpost)
                && Validering.isTextFältTomt(txtFornamn)
                && Validering.isTextFältTomt(txtEfternamn)
                && Validering.isTelefonNummer(txtTelefon)) {

            String PNR = txtPNR.getText();
            String rumsnmr = txtRum.getText();
            String mobilnmr = txtTelefon.getText();
            String email = txtEpost.getText();
            String fornamn = Validering.makeFirstLetterUpperCase(txtFornamn.getText());
            String efternamn = Validering.makeFirstLetterUpperCase(txtEfternamn.getText());
            String status = cmbStatus.getSelectedItem().toString();

            if (cmbStatus.getSelectedItem().toString().equals("Centraladministratör")) {
                status = "CA";
            }
            if (cmbStatus.getSelectedItem().toString().equals("Utbildningsadministratör")) {
                status = "UA";
            }
            if (cmbStatus.getSelectedItem().toString().equals("Forskningsadministratör")) {
                status = "FA";
            }
            if (cmbStatus.getSelectedItem().toString().equals("Amanuens")) {
                status = "A";
            }
            if (cmbStatus.getSelectedItem().toString().equals("Forskningsanvändare")) {
                status = "F";
            }
            if (cmbStatus.getSelectedItem().toString().equals("Utbildningsanvändare")) {
                status = "U";
            }

            try {
                Statement stmt = connection.createStatement();
                stmt.executeUpdate("UPDATE ANVANDARE SET RUMSNMR='" + rumsnmr + "', MOBILNMR='" + mobilnmr + "', EMAIL='" + email + "', FORNAMN='" + fornamn + "', EFTERNAMN='" + efternamn + "', STATUS='" + status + "' WHERE PNR='" + PNR + "'");
                lblNotis.setVisible(true);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE ANVANDARE SET PROFILBILD =? WHERE PNR='" + PNR + "'");
                InputStream is = new FileInputStream(new File(path));
                selectedFile = file.getSelectedFile();
                path = selectedFile.getAbsolutePath();
                ps.setBlob(1, is);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            } catch (FileNotFoundException | NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void btnBytBildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBytBildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBytBildActionPerformed

    private void btnBytLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBytLosenordActionPerformed

        BytLosenord bytLosenord = new BytLosenord(connection, personnummer);
        bytLosenord.setVisible(true);

    }//GEN-LAST:event_btnBytLosenordActionPerformed

    private void txtTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonActionPerformed

    public ImageIcon ResizeImage(String ImagePath) {

        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lblProfilBildDB.getWidth(), lblProfilBildDB.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBytBild;
    private javax.swing.JButton btnBytLosenord;
    private javax.swing.JButton btnSpara;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JLabel lblAnvandarstatus;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblMobil;
    private javax.swing.JLabel lblNotis;
    private javax.swing.JLabel lblPNR;
    private javax.swing.JLabel lblProfilBildDB;
    private javax.swing.JLabel lblRumsnummer;
    private javax.swing.JTextField txtEfternamn;
    private javax.swing.JTextField txtEpost;
    private javax.swing.JTextField txtFornamn;
    private javax.swing.JTextField txtPNR;
    private javax.swing.JTextField txtRum;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
