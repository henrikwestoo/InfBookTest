/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import com.toedter.calendar.JCalendar;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;
import javax.swing.JList;
import javax.swing.Timer;

/**
 *
 * @author Henrik
 */
public class Inloggad extends javax.swing.JFrame {

    private Connection connection;
    private String status;
    private String angivetAnv;
    private DefaultListModel lista;
    private DefaultListModel lista2;
    private DefaultListModel lista3;

    public Inloggad(Connection connection, String status, String angivetAnv) {
        
new java.util.Timer().schedule(new TimerTask(){
        @Override
        public void run() {
            
            lista.removeAllElements();
            lista2.removeAllElements();
            lista3.removeAllElements();
            fyllFlodeMedInlagg();
            System.out.println("Refresh");
            
           //your code here 
           //10005=5000 mlsec. i.e. 5 seconds. u can change accordngly 
        }
    },10005,1000*60);

        lista = new DefaultListModel();
        lista2 = new DefaultListModel();
        lista3 = new DefaultListModel();
        this.connection = connection;
        initComponents();
        btnSkapaUnderkategori.setVisible(true);
        this.status = status;
        this.angivetAnv = angivetAnv;

        fyllFlodeMedInlagg();

        btnSkapaSuperKategori.setVisible(false);
        btnSkapaAnvandare.setVisible(false);
        btnHanteraAnvandare.setVisible(false);
        txtArea.setEditable(false);
        txtArea.setLineWrap(true);

        if (status.equals("CA") || status.equals("UA") || status.equals("FA")) {
            btnSkapaSuperKategori.setVisible(true);
            btnSkapaAnvandare.setVisible(true);
            btnHanteraAnvandare.setVisible(true);
        }

        String braStatus = KonverteraStatus.konverteraStatus(status);
        lblStatus.setText(braStatus);

        kalender.addPropertyChangeListener("calendar", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent e) {

                txtArea.setText("");
                SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd"); //Omformaterar datumet som väljs i DateChoosern så det matchar formatet som datum lagras i databasen.
                String date1 = dFormat.format(kalender.getDate());

                try {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT MOTE.INFO ||' - '|| MOTE.TID ||'  '|| MOTE.SAL AS INFORMATION FROM MOTE WHERE MOTE.DATUM='" + date1 + "'");
                    while (rs.next()) {
                        String info = rs.getString("INFORMATION");
                        txtArea.append(info + "\n\n");

                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Något blev fel");
                } catch (NullPointerException e2) {
                    JOptionPane.showMessageDialog(null, "Det finns inga bokade möten den dagen");
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

        jScrollBar1 = new javax.swing.JScrollBar();
        tabFlode = new javax.swing.JTabbedPane();
        pnlForskning = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstInlaggForskning = new javax.swing.JList();
        pnlInformell = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstInlaggInformell = new javax.swing.JList<>();
        pnlUtbildning = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstInlaggUtbildning = new javax.swing.JList();
        lblFloden = new javax.swing.JLabel();
        btnSkapaInlagg = new javax.swing.JButton();
        btnSkapaUnderkategori = new javax.swing.JButton();
        btnMinProfil = new javax.swing.JButton();
        btnHanteraAnvandare = new javax.swing.JButton();
        lblInloggadSom = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnSkapaSuperKategori = new javax.swing.JButton();
        btnSkapaAnvandare = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnLoggaUt = new javax.swing.JButton();
        sprHog = new javax.swing.JSeparator();
        sprMitten = new javax.swing.JSeparator();
        sprLag = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        kalender = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        btnHanteraMoten = new javax.swing.JButton();
        btnDoodle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Infbook");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Inloggning.class.getResource("/images/infbookIcon.png")));

        pnlForskning.setMinimumSize(new java.awt.Dimension(200, 200));

        lstInlaggForskning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstInlaggForskningMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstInlaggForskning);

        javax.swing.GroupLayout pnlForskningLayout = new javax.swing.GroupLayout(pnlForskning);
        pnlForskning.setLayout(pnlForskningLayout);
        pnlForskningLayout.setHorizontalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        pnlForskningLayout.setVerticalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        tabFlode.addTab("Forskning", pnlForskning);

        pnlInformell.setPreferredSize(new java.awt.Dimension(500, 500));

        lstInlaggInformell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstInlaggInformellMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(lstInlaggInformell);

        javax.swing.GroupLayout pnlInformellLayout = new javax.swing.GroupLayout(pnlInformell);
        pnlInformell.setLayout(pnlInformellLayout);
        pnlInformellLayout.setHorizontalGroup(
            pnlInformellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        pnlInformellLayout.setVerticalGroup(
            pnlInformellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        tabFlode.addTab("Informell", pnlInformell);

        lstInlaggUtbildning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstInlaggUtbildningMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstInlaggUtbildning);

        javax.swing.GroupLayout pnlUtbildningLayout = new javax.swing.GroupLayout(pnlUtbildning);
        pnlUtbildning.setLayout(pnlUtbildningLayout);
        pnlUtbildningLayout.setHorizontalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        pnlUtbildningLayout.setVerticalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        tabFlode.addTab("Utbildning", pnlUtbildning);

        lblFloden.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFloden.setText("Samtliga bloggflöden");

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

        btnHanteraAnvandare.setText("Hantera användare");
        btnHanteraAnvandare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHanteraAnvandareActionPerformed(evt);
            }
        });

        lblInloggadSom.setText("Inloggad som:");

        btnSkapaSuperKategori.setText("Skapa överkategori");
        btnSkapaSuperKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaSuperKategoriActionPerformed(evt);
            }
        });

        btnSkapaAnvandare.setText("Skapa användare");
        btnSkapaAnvandare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaAnvandareActionPerformed(evt);
            }
        });

        btnRefresh.setText("↻");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnLoggaUt.setText("Logga ut");
        btnLoggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaUtActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbookIcon2small.png"))); // NOI18N

        kalender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kalenderMouseClicked(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jButton1.setText("Hantera följningar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnHanteraMoten.setText("Hantera möten");
        btnHanteraMoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHanteraMotenActionPerformed(evt);
            }
        });

        btnDoodle.setText("Doodle");
        btnDoodle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoodleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnMinProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSkapaInlagg, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSkapaUnderkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 161, Short.MAX_VALUE)
                                .addComponent(btnLoggaUt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(sprMitten)
                        .addComponent(sprHog)
                        .addComponent(sprLag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnHanteraAnvandare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSkapaSuperKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSkapaAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(btnDoodle, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnHanteraMoten, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kalender, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabFlode, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInloggadSom)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(434, 434, 434)
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(lblFloden)
                        .addGap(37, 37, 37)
                        .addComponent(btnRefresh)))
                .addContainerGap(650, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInloggadSom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFloden)
                                    .addComponent(btnRefresh))
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabFlode)
                        .addGap(121, 121, 121))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sprHog, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSkapaInlagg)
                            .addComponent(btnSkapaUnderkategori)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMinProfil)
                            .addComponent(btnLoggaUt))
                        .addGap(59, 59, 59)
                        .addComponent(sprMitten, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSkapaSuperKategori)
                            .addComponent(btnSkapaAnvandare)
                            .addComponent(btnDoodle))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHanteraAnvandare)
                            .addComponent(btnHanteraMoten))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sprLag, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(kalender, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkapaInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaInlaggActionPerformed
        new SkapaInlagg(connection, angivetAnv).setVisible(true);
    }//GEN-LAST:event_btnSkapaInlaggActionPerformed

    private void btnSkapaUnderkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaUnderkategoriActionPerformed
        new SkapaSubkategori(connection).setVisible(true);
    }//GEN-LAST:event_btnSkapaUnderkategoriActionPerformed

    private void btnMinProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinProfilActionPerformed
        new Profil(connection, angivetAnv).setVisible(true);
    }//GEN-LAST:event_btnMinProfilActionPerformed

    private void btnHanteraAnvandareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHanteraAnvandareActionPerformed
        new HanteraAnvandare(connection, status).setVisible(true);
    }//GEN-LAST:event_btnHanteraAnvandareActionPerformed

    private void btnSkapaSuperKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaSuperKategoriActionPerformed
        new SkapaSuperKategori(connection).setVisible(true);
    }//GEN-LAST:event_btnSkapaSuperKategoriActionPerformed

    private void btnSkapaAnvandareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaAnvandareActionPerformed
        new SkapaAnvandare(connection, status).setVisible(true);
    }//GEN-LAST:event_btnSkapaAnvandareActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        lista.removeAllElements();
        lista2.removeAllElements();
        lista3.removeAllElements();
        fyllFlodeMedInlagg();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaUtActionPerformed
        setVisible(false);
        new Inloggning(connection).setVisible(true);
    }//GEN-LAST:event_btnLoggaUtActionPerformed

    private void btnHanteraMotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHanteraMotenActionPerformed
        new HanteraMoten(connection, status, angivetAnv).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnHanteraMotenActionPerformed

    private void lstInlaggForskningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstInlaggForskningMouseClicked
        try {
            lstInlaggForskning = (JList) evt.getSource();
            if (evt.getClickCount() == 2) {
                setCursor(WAIT_CURSOR);
                int index = lstInlaggForskning.locationToIndex(evt.getPoint());
                String valtInlagg = (String) lstInlaggForskning.getSelectedValue();
                String inlaggsID = valtInlagg.substring(0, valtInlagg.indexOf(" "));

                new VisatInlagg(connection, inlaggsID, status, angivetAnv).setVisible(true);
                setCursor(DEFAULT_CURSOR);

            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_lstInlaggForskningMouseClicked

    private void lstInlaggUtbildningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstInlaggUtbildningMouseClicked
        try {
            lstInlaggUtbildning = (JList) evt.getSource();
            if (evt.getClickCount() == 2) {
                setCursor(WAIT_CURSOR);
                int index = lstInlaggUtbildning.locationToIndex(evt.getPoint());
                String valtInlagg = (String) lstInlaggUtbildning.getSelectedValue();
                String inlaggsID = valtInlagg.substring(0, valtInlagg.indexOf(" "));

                new VisatInlagg(connection, inlaggsID, status, angivetAnv).setVisible(true);
                setCursor(DEFAULT_CURSOR);
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_lstInlaggUtbildningMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HanteraFoljningar folj = new HanteraFoljningar(connection, angivetAnv);
        folj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lstInlaggInformellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstInlaggInformellMouseClicked
        try {
            lstInlaggInformell = (JList) evt.getSource();
            if (evt.getClickCount() == 2) {
                setCursor(WAIT_CURSOR);
                int index = lstInlaggInformell.locationToIndex(evt.getPoint());
                String valtInlagg = (String) lstInlaggInformell.getSelectedValue();
                String inlaggsID = valtInlagg.substring(0, valtInlagg.indexOf(" "));

                new VisatInlagg(connection, inlaggsID, status, angivetAnv).setVisible(true);
                setCursor(DEFAULT_CURSOR);
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_lstInlaggInformellMouseClicked

    private void btnDoodleActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Doodle hej = new Doodle(connection, angivetAnv);
        hej.setVisible(true);
    }
                                                   
private void kalenderMouseClicked(java.awt.event.MouseEvent evt) {
    }                                         

private void fyllFlodeMedInlagg() {

    
    
    
        try {
            Statement stmt = connection.createStatement(); //utbildning
            ResultSet rs = stmt.executeQuery("SELECT INLAGGSID ||' - '|| TITEL ||' - '|| FORNAMN ||'  '|| EFTERNAMN AS INFORMATION FROM INLAGG  JOIN ANVANDARE ON ANVANDARE.PNR = INLAGG.ANVANDARE JOIN SUBKATEGORI ON INLAGG.SUBKATEGORI = SUBKATEGORI.SUBKATEGORIID JOIN SUPERKATEGORI ON SUBKATEGORI.SUPERKATEGORI = SUPERKATEGORI.SUPERKATEGORIID JOIN KATEGORI ON SUPERKATEGORI.KATEGORI = KATEGORI.KATEGORIID WHERE KATEGORIID = 1 ORDER BY INLAGGSID DESC");

            while (rs.next()) {
                lista.addElement(rs.getString("INFORMATION"));
                lstInlaggUtbildning.setModel(lista);

            }

            Statement stmt2 = connection.createStatement(); //forskning
            ResultSet rs2 = stmt2.executeQuery("SELECT INLAGGSID ||' - '|| TITEL ||' - '|| FORNAMN ||'  '|| EFTERNAMN AS INFORMATION FROM INLAGG  JOIN ANVANDARE ON ANVANDARE.PNR = INLAGG.ANVANDARE JOIN SUBKATEGORI ON INLAGG.SUBKATEGORI = SUBKATEGORI.SUBKATEGORIID JOIN SUPERKATEGORI ON SUBKATEGORI.SUPERKATEGORI = SUPERKATEGORI.SUPERKATEGORIID JOIN KATEGORI ON SUPERKATEGORI.KATEGORI = KATEGORI.KATEGORIID WHERE KATEGORIID = 2 ORDER BY INLAGGSID DESC");

            while (rs2.next()) {
                lista2.addElement(rs2.getString("INFORMATION"));
                lstInlaggForskning.setModel(lista2);
            }
            Statement stmt3 = connection.createStatement(); //informella
            ResultSet rs3 = stmt3.executeQuery("SELECT INLAGGSID ||' - '|| TITEL ||' - '|| FORNAMN ||'  '|| EFTERNAMN AS INFORMATION FROM INLAGG  JOIN ANVANDARE ON ANVANDARE.PNR = INLAGG.ANVANDARE JOIN SUBKATEGORI ON INLAGG.SUBKATEGORI = SUBKATEGORI.SUBKATEGORIID JOIN SUPERKATEGORI ON SUBKATEGORI.SUPERKATEGORI = SUPERKATEGORI.SUPERKATEGORIID JOIN KATEGORI ON SUPERKATEGORI.KATEGORI = KATEGORI.KATEGORIID WHERE KATEGORIID = 3 ORDER BY INLAGGSID DESC");

            while (rs3.next()) {
                lista3.addElement(rs3.getString("INFORMATION"));
                lstInlaggInformell.setModel(lista3);
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoodle;
    private javax.swing.JButton btnHanteraAnvandare;
    private javax.swing.JButton btnHanteraMoten;
    private javax.swing.JButton btnLoggaUt;
    private javax.swing.JButton btnMinProfil;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSkapaAnvandare;
    private javax.swing.JButton btnSkapaInlagg;
    private javax.swing.JButton btnSkapaSuperKategori;
    private javax.swing.JButton btnSkapaUnderkategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JCalendar kalender;
    private javax.swing.JLabel lblFloden;
    private javax.swing.JLabel lblInloggadSom;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList lstInlaggForskning;
    private javax.swing.JList<String> lstInlaggInformell;
    private javax.swing.JList lstInlaggUtbildning;
    private javax.swing.JPanel pnlForskning;
    private javax.swing.JPanel pnlInformell;
    private javax.swing.JPanel pnlUtbildning;
    private javax.swing.JSeparator sprHog;
    private javax.swing.JSeparator sprLag;
    private javax.swing.JSeparator sprMitten;
    private javax.swing.JTabbedPane tabFlode;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
