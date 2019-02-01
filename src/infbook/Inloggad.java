/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrik
 */
public class Inloggad extends javax.swing.JFrame {

    private Connection connection;
    private String status;
    private String angivetAnv;
    
    public Inloggad(Connection connection, String status, String angivetAnv) {
        this.connection = connection;
        initComponents();
        this.status = status;
        this.angivetAnv = angivetAnv;
        fyllFlodeMedInlagg();
        btnSkapaSuperKategori.setVisible(false);
        
        System.out.println(status);
        
        if(status.equals("CA") || status.equals("UA") || status.equals("FA")){
            
        btnSkapaSuperKategori.setVisible(true);
        
        }
        
        String braStatus = KonverteraStatus.konverteraStatus(status);
        
        
        lblStatus.setText(braStatus);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        tabFlode = new javax.swing.JTabbedPane();
        pnlUtbildning = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstInlagg = new javax.swing.JList();
        pnlForskning = new javax.swing.JPanel();
        pnlInformell = new javax.swing.JPanel();
        lblFloden = new javax.swing.JLabel();
        btnSkapaInlagg = new javax.swing.JButton();
        btnSkapaUnderkategori = new javax.swing.JButton();
        btnMinProfil = new javax.swing.JButton();
        btnHanterAnv = new javax.swing.JButton();
        lblInloggadSom = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSkapaSuperKategori = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(lstInlagg);

        javax.swing.GroupLayout pnlUtbildningLayout = new javax.swing.GroupLayout(pnlUtbildning);
        pnlUtbildning.setLayout(pnlUtbildningLayout);
        pnlUtbildningLayout.setHorizontalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );
        pnlUtbildningLayout.setVerticalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
        );

        tabFlode.addTab("Utbildning", pnlUtbildning);

        pnlForskning.setMinimumSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout pnlForskningLayout = new javax.swing.GroupLayout(pnlForskning);
        pnlForskning.setLayout(pnlForskningLayout);
        pnlForskningLayout.setHorizontalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );
        pnlForskningLayout.setVerticalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        tabFlode.addTab("Forskning", pnlForskning);

        pnlInformell.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout pnlInformellLayout = new javax.swing.GroupLayout(pnlInformell);
        pnlInformell.setLayout(pnlInformellLayout);
        pnlInformellLayout.setHorizontalGroup(
            pnlInformellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );
        pnlInformellLayout.setVerticalGroup(
            pnlInformellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        tabFlode.addTab("Informell", pnlInformell);

        lblFloden.setText("Flöden");

        btnSkapaInlagg.setText("Skapa inlägg");
        btnSkapaInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaInlaggActionPerformed(evt);
            }
        });

        btnSkapaUnderkategori.setText("Skapa underkategori");
        btnSkapaUnderkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaUnderkategoriActionPerformed(evt);
            }
        });

        btnMinProfil.setText("Min profil");
        btnMinProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinProfilActionPerformed(evt);
            }
        });

        btnHanterAnv.setText("Hantera användare");
        btnHanterAnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHanterAnvActionPerformed(evt);
            }
        });

        lblInloggadSom.setText("Inloggad som");

        jButton1.setText("Visa inlägg");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSkapaSuperKategori.setText("Skapa superkategori");
        btnSkapaSuperKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaSuperKategoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSkapaUnderkategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMinProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHanterAnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSkapaInlagg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInloggadSom)
                    .addComponent(lblStatus)
                    .addComponent(btnSkapaSuperKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFloden)
                    .addComponent(tabFlode, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFloden)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnSkapaInlagg)
                        .addGap(18, 18, 18)
                        .addComponent(btnSkapaUnderkategori)
                        .addGap(18, 18, 18)
                        .addComponent(btnMinProfil)
                        .addGap(18, 18, 18)
                        .addComponent(btnHanterAnv)
                        .addGap(18, 18, 18)
                        .addComponent(btnSkapaSuperKategori)
                        .addGap(103, 103, 103)
                        .addComponent(lblInloggadSom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(tabFlode, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkapaInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaInlaggActionPerformed
        new SkapaInlagg(connection,angivetAnv).setVisible(true);
    }//GEN-LAST:event_btnSkapaInlaggActionPerformed

    private void btnSkapaUnderkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaUnderkategoriActionPerformed
        new SkapaKategori(connection).setVisible(true);
    }//GEN-LAST:event_btnSkapaUnderkategoriActionPerformed

    private void btnMinProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinProfilActionPerformed
        new Profil(connection, angivetAnv).setVisible(true);
    }//GEN-LAST:event_btnMinProfilActionPerformed

    private void btnHanterAnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHanterAnvActionPerformed
        new HanteraAnvandare(connection).setVisible(true);
    }//GEN-LAST:event_btnHanterAnvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String valtInlagg = (String) lstInlagg.getSelectedValue();
       String inlaggsID = valtInlagg.substring(0, valtInlagg.indexOf(" "));
       
       new VisatInlagg(connection, inlaggsID).setVisible(true);
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSkapaSuperKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaSuperKategoriActionPerformed
        new SkapaSuperKategori(connection).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnSkapaSuperKategoriActionPerformed

    
    private void fyllFlodeMedInlagg()
    {
        
        DefaultListModel lista = new DefaultListModel();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT INLAGGSID ||' - '|| TITEL ||' - '|| FORNAMN ||'  '|| EFTERNAMN AS INFORMATION FROM INLAGG  JOIN ANVANDARE ON ANVANDARE.PNR = INLAGG.ANVANDARE JOIN SUBKATEGORI ON INLAGG.SUBKATEGORI = SUBKATEGORI.SUBKATEGORIID JOIN SUPERKATEGORI ON SUBKATEGORI.SUPERKATEGORI = SUPERKATEGORI.SUPERKATEGORIID JOIN KATEGORI ON SUPERKATEGORI.KATEGORI = KATEGORI.KATEGORIID WHERE KATEGORIID = 1 ORDER BY INLAGGSID DESC");
            
            
            while(rs.next())
            {
                lista.addElement(rs.getString("INFORMATION"));
                lstInlagg.setModel(lista);
              
            }
        }
        
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHanterAnv;
    private javax.swing.JButton btnMinProfil;
    private javax.swing.JButton btnSkapaInlagg;
    private javax.swing.JButton btnSkapaSuperKategori;
    private javax.swing.JButton btnSkapaUnderkategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFloden;
    private javax.swing.JLabel lblInloggadSom;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList lstInlagg;
    private javax.swing.JPanel pnlForskning;
    private javax.swing.JPanel pnlInformell;
    private javax.swing.JPanel pnlUtbildning;
    private javax.swing.JTabbedPane tabFlode;
    // End of variables declaration//GEN-END:variables
}
