/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.sql.Connection;

/**
 *
 * @author Henrik
 */
public class Inloggad extends javax.swing.JFrame {

    private Connection connection;
    private String status;
    private String angivetAnv;
    /**
     * Creates new form Inloggad
     */
    public Inloggad(Connection connection, String status, String angivetAnv) {
        this.connection = connection;
        initComponents();
        this.status = status;
        this.angivetAnv = angivetAnv;
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txaUtbildning = new javax.swing.JTextArea();
        pnlForskning = new javax.swing.JPanel();
        pnlInformell = new javax.swing.JPanel();
        lblFloden = new javax.swing.JLabel();
        btnSkapaInlagg = new javax.swing.JButton();
        btnSkapaUnderkategori = new javax.swing.JButton();
        btnMinProfil = new javax.swing.JButton();
        btnHanterAnv = new javax.swing.JButton();
        lblInloggadSom = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txaUtbildning.setColumns(20);
        txaUtbildning.setRows(5);
        jScrollPane1.setViewportView(txaUtbildning);

        javax.swing.GroupLayout pnlUtbildningLayout = new javax.swing.GroupLayout(pnlUtbildning);
        pnlUtbildning.setLayout(pnlUtbildningLayout);
        pnlUtbildningLayout.setHorizontalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUtbildningLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlUtbildningLayout.setVerticalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUtbildningLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSkapaUnderkategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMinProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHanterAnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSkapaInlagg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblInloggadSom)
                    .addComponent(lblStatus))
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFloden)
                    .addComponent(tabFlode, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(150, 150, 150)
                        .addComponent(lblInloggadSom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(tabFlode, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHanterAnv;
    private javax.swing.JButton btnMinProfil;
    private javax.swing.JButton btnSkapaInlagg;
    private javax.swing.JButton btnSkapaUnderkategori;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFloden;
    private javax.swing.JLabel lblInloggadSom;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlForskning;
    private javax.swing.JPanel pnlInformell;
    private javax.swing.JPanel pnlUtbildning;
    private javax.swing.JTabbedPane tabFlode;
    private javax.swing.JTextArea txaUtbildning;
    // End of variables declaration//GEN-END:variables
}
