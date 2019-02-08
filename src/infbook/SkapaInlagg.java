/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tomasz
 */
public class SkapaInlagg extends javax.swing.JFrame {

    private DefaultListModel lista;
    private Connection connection;
    private String s = null;
    private String angivetAnv;
    private File selectedFile;
    private String path;
    private String extension;
    JFileChooser file = new JFileChooser();

    /**
     * Creates new form SkapaInlagg
     */
    public SkapaInlagg(Connection connection, String angivetAnv) {
        this.connection = connection;

        initComponents();
        txaInlagg.setLineWrap(true);
        this.angivetAnv = angivetAnv;
        fyllComboBoxSuperkategori();
        lista = new DefaultListModel();
        lblBild.setBounds(10, 10, 60, 60);
        btnBifogaFiler.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = file.getSelectedFile();
                    path = selectedFile.getAbsolutePath();

                    int i = path.lastIndexOf(".");

                    String nyPath = path.substring(i, i + 4);

                    lblBild.setText(nyPath);
                    Icon icon = javax.swing.filechooser.FileSystemView.getFileSystemView().getSystemIcon(selectedFile);
                    lblBild.setIcon(icon);

                    s = path;
                }

            }
        });

        lblBild.addMouseListener(new MouseListener() {

            public void mouseReleased(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseClicked(MouseEvent e) {
                File u = new File(path);
                try {

                    java.awt.Desktop.getDesktop().open(u);
                } catch (IOException ex) {
                    Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);

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

        txtTitel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaInlagg = new javax.swing.JTextArea();
        lblInlagg = new javax.swing.JLabel();
        lblTitel = new javax.swing.JLabel();
        cmbSuperkategori = new javax.swing.JComboBox();
        lblSubkategori = new javax.swing.JLabel();
        btnSkapaInlagg = new javax.swing.JButton();
        btnBifogaFiler = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<String>();
        lblBild = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txaInlagg.setColumns(20);
        txaInlagg.setRows(5);
        jScrollPane1.setViewportView(txaInlagg);

        lblInlagg.setText("Inlägg");

        lblTitel.setText("Titel");

        cmbSuperkategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Välj Superkategori" }));
        cmbSuperkategori.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSuperkategoriItemStateChanged(evt);
            }
        });
        cmbSuperkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSuperkategoriActionPerformed(evt);
            }
        });

        lblSubkategori.setText("Välj subkategori");

        btnSkapaInlagg.setText("Skapa inlägg");
        btnSkapaInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaInlaggActionPerformed(evt);
            }
        });

        btnBifogaFiler.setText("Bifoga filer");
        btnBifogaFiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBifogaFilerActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubkategori)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblInlagg)
                            .addComponent(lblTitel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbSuperkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                                .addComponent(btnBifogaFiler))
                            .addComponent(jScrollPane1)
                            .addComponent(txtTitel))
                        .addGap(114, 114, 114)
                        .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSkapaInlagg)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitel)
                .addGap(18, 18, 18)
                .addComponent(txtTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblInlagg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSuperkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBifogaFiler))
                .addGap(18, 18, 18)
                .addComponent(lblSubkategori)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnSkapaInlagg)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public ImageIcon ResizeImage(String ImagePath) {

        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lblBild.getWidth(), lblBild.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void skapaEttInlagg() throws FileNotFoundException {

        String valdSubkategori = (String) jList1.getSelectedValue();
        try {

            Statement stmt1 = connection.createStatement();

            ResultSet rs1 = stmt1.executeQuery("SELECT SUBKATEGORIID FROM SUBKATEGORI WHERE SKNAMN ='" + valdSubkategori + "' ");
            rs1.next();
            int subkategoriId = rs1.getInt("SUBKATEGORIID");

            Statement stmt100 = connection.createStatement();
            ResultSet rs100 = stmt100.executeQuery("SELECT SUPERKATEGORI FROM SUBKATEGORI WHERE SKNAMN='" + valdSubkategori + "'");
            rs100.next();
            int superkategori = rs100.getInt("SUPERKATEGORI");

            Statement stmt101 = connection.createStatement();
            ResultSet rs101 = stmt101.executeQuery("SELECT MOBILNMR FROM ANVANDARE JOIN ANVANDARE_SUPERKATEGORI ON ANVANDARE_SUPERKATEGORI.ANVANDARE=ANVANDARE.PNR WHERE SUPERKATEGORIID=" + superkategori + " AND SMSNOTISER='JA'");

            while (rs101.next()) {
                String mobilnmr = rs101.getString("MOBILNMR");
                System.out.println(mobilnmr);
                SMSNotiser hej = new SMSNotiser();
                hej.skickaNotis("Ett nytt inlägg har skapats i en kategori som du följer - InfBook", mobilnmr);
            }
            
            
            
            Statement stmt102 = connection.createStatement();
            ResultSet rs102 = stmt102.executeQuery("SELECT EMAIL FROM ANVANDARE JOIN ANVANDARE_SUPERKATEGORI ON ANVANDARE_SUPERKATEGORI.ANVANDARE=ANVANDARE.PNR WHERE SUPERKATEGORIID=" + superkategori + " AND EMAILNOTISER='JA'");
            while(rs102.next())
            {
                String email = rs102.getString("EMAIL");
                System.out.println(email);
                SendMail.send(email, "Ett nytt inlägg i InfBook", "Ett nytt inlägg har skapats i en kategori som du följer.", "mail@infbook.page", "Infbook2019");
            }
            
            
            
            
            

            Statement stmt2 = connection.createStatement();

            ResultSet rs2 = stmt2.executeQuery("SELECT FIRST 1  * FROM INLAGG ORDER BY INLAGGSID DESC");
            rs2.next();
            int hogstaVarde = rs2.getInt("INLAGGSID");
            int nyaVardet = hogstaVarde + 1;

            PreparedStatement ps2 = connection.prepareStatement("insert into INLAGG(INLAGGSID,TEXT,ANVANDARE,SUBKATEGORI,TITEL) values(?,?,?,?,?)");
            ps2.setInt(1, nyaVardet);
            ps2.setString(2, txaInlagg.getText());
            ps2.setString(3, angivetAnv);
            ps2.setInt(4, subkategoriId);
            ps2.setString(5, txtTitel.getText());
            ps2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inlägget har skapats");

            Statement stmt3 = connection.createStatement();
            ResultSet rs3 = stmt3.executeQuery("SELECT FIRST 1  * FROM FILER ORDER BY FILID DESC");
            rs3.next();
            int hogstaVarde2 = rs3.getInt("FILID");
            int nyaVardet2 = hogstaVarde2 + 1;

            PreparedStatement ps3 = connection.prepareStatement("INSERT INTO FILER(FILID,FIL,TYP, INLAGG) VALUES (?,?,?, ?)");
            InputStream is = new FileInputStream(new File(s));
            selectedFile = file.getSelectedFile();
            path = selectedFile.getAbsolutePath();

            extension = "";

            int i = path.lastIndexOf(".");

            extension = path.substring(i, i + 4);

            ps3.setInt(1, nyaVardet2);
            ps3.setBlob(2, is);
            ps3.setString(3, extension);
            ps3.setInt(4, nyaVardet);
            ps3.executeUpdate();

        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void fyllComboBoxSuperkategori() {
        Statement stmt;
        try {
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT SKNAMN FROM SUPERKATEGORI");

            while (rs.next()) {

                cmbSuperkategori.addItem(rs.getString("SKNAMN"));
                //cmbSuperkategori.addItem("SKNAMN");

            }
        } catch (SQLException ex) {
            Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fyllComboBoxSubkategori() {

        Statement stmt;
        try {
            stmt = connection.createStatement();
            Object valdSakObject = cmbSuperkategori.getSelectedItem();
            String superKategoriNamn = valdSakObject.toString();

            ResultSet rs2 = stmt.executeQuery("SELECT SUPERKATEGORIID FROM SUPERKATEGORI WHERE SKNAMN ='" + superKategoriNamn + "' ");
            rs2.next();
            int superkategoriId = rs2.getInt("SUPERKATEGORIID");

            ResultSet rs = stmt.executeQuery("SELECT SKNAMN FROM SUBKATEGORI WHERE SUPERKATEGORI = " + superkategoriId);

            while (rs.next()) {

                lista.addElement(rs.getString("SKNAMN"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }

        jList1.setModel(lista);

    }


    private void btnSkapaInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaInlaggActionPerformed

        try {
            skapaEttInlagg();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSkapaInlaggActionPerformed

    private void cmbSuperkategoriItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSuperkategoriItemStateChanged
//När ett item väljs, kommer sub-kategorierna populeras. 

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSuperkategoriItemStateChanged

    private void cmbSuperkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSuperkategoriActionPerformed
        fyllComboBoxSubkategori();

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSuperkategoriActionPerformed

    private void btnBifogaFilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBifogaFilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBifogaFilerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBifogaFiler;
    private javax.swing.JButton btnSkapaInlagg;
    private javax.swing.JComboBox cmbSuperkategori;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBild;
    private javax.swing.JLabel lblInlagg;
    private javax.swing.JLabel lblSubkategori;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JTextArea txaInlagg;
    private javax.swing.JTextField txtTitel;
    // End of variables declaration//GEN-END:variables
}
