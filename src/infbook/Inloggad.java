/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/**
 *
 * @author Henrik
 */
public class Inloggad extends javax.swing.JFrame {

    private Connection connection;
    private String status;
    private String angivetAnv;
    private String namn;
    private DefaultListModel lista;
    private DefaultListModel lista2;
    private DefaultListModel lista3;

    private static final int port = 1500;
    /* 
    * IP:n för servern som används i projektet är 159.253.31.26
    * Använd 127.0.0.1 om du vill testa lokalt
    */
    private static final String server = "159.253.31.26";
    private Client client;
    private Boolean connected;

    public Inloggad(Connection connection, String status, String angivetAnv) {

        lista = new DefaultListModel();
        lista2 = new DefaultListModel();
        lista3 = new DefaultListModel();
        this.connection = connection;
        initComponents();
        this.setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        btnSkapaUnderkategori.setVisible(true);
        this.status = status;
        this.angivetAnv = angivetAnv;
        connected = true;
        kalender();

        fyllFlodeMedInlagg();

        new java.util.Timer().schedule(new TimerTask() {

            @Override
            public void run() {

                lista.removeAllElements();
                lista2.removeAllElements();
                lista3.removeAllElements();
                fyllFlodeMedInlagg();
                System.out.println("Refresh");
                
                //10005=5000 mlsec. i.e. 5 seconds. u can change accordngly 
            }
        }, 10005, 1000 * 60);

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
                kalender();

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

        ta.setEditable(false);
        getRootPane().setDefaultButton(btnSend);
        
        try {
            Statement stmt2 = connection.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT FORNAMN, EFTERNAMN FROM ANVANDARE WHERE PNR='" + angivetAnv + "'");
            rs2.next();
            String fornamn = rs2.getString("FORNAMN");
            String efternamn = rs2.getString("EFTERNAMN");

            namn = fornamn + " " + efternamn;
            lblNamn.setText("Välkommen " + namn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        // Skapar ett nytt klientobjekt
        client = new Client(server, port, namn, this);
        // Kontrollerar om det går att starta klienten
        if (!client.start()) {
            return;
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblInloggadSom = new javax.swing.JLabel();
        lblPic = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tabFlode = new javax.swing.JTabbedPane();
        pnlForskning = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstInlaggForskning = new javax.swing.JList();
        pnlUtbildning = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstInlaggUtbildning = new javax.swing.JList();
        pnlInformell = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstInlaggInformell = new javax.swing.JList<String>();
        pnlChatt = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        tf = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        btnAnslutningar = new javax.swing.JButton();
        btnSkapaInlagg = new javax.swing.JButton();
        btnSkapaUnderkategori = new javax.swing.JButton();
        btnHanteraFoljningar = new javax.swing.JButton();
        btnLoggaUt = new javax.swing.JButton();
        btnMinProfil = new javax.swing.JButton();
        sprHog = new javax.swing.JSeparator();
        btnSkapaSuperKategori = new javax.swing.JButton();
        btnSkapaAnvandare = new javax.swing.JButton();
        btnDoodle = new javax.swing.JButton();
        btnHanteraMoten = new javax.swing.JButton();
        btnHanteraAnvandare = new javax.swing.JButton();
        kalender = new com.toedter.calendar.JCalendar();
        sprLag = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnRefresh = new javax.swing.JButton();
        lblFloden = new javax.swing.JLabel();
        lblBloggIkon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Infbook");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Inloggning.class.getResource("/images/infbookIcon.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(46, 120, 186));

        lblStatus.setForeground(new java.awt.Color(255, 255, 255));

        lblInloggadSom.setForeground(new java.awt.Color(255, 255, 255));
        lblInloggadSom.setText("Inloggad som:");

        lblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbookvit.png"))); // NOI18N
        lblPic.setMaximumSize(new java.awt.Dimension(200, 200));
        lblPic.setPreferredSize(new java.awt.Dimension(200, 210));

        lblNamn.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblInloggadSom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(312, 312, 312)
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInloggadSom)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tabFlode.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));

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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        pnlForskningLayout.setVerticalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        tabFlode.addTab("Forskning", pnlForskning);

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        pnlUtbildningLayout.setVerticalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        tabFlode.addTab("Utbildning", pnlUtbildning);

        pnlInformell.setBackground(new java.awt.Color(255, 255, 255));
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
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        pnlInformellLayout.setVerticalGroup(
            pnlInformellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        tabFlode.addTab("Informell", pnlInformell);

        ta.setColumns(20);
        ta.setLineWrap(true);
        ta.setRows(5);
        jScrollPane5.setViewportView(ta);

        btnSend.setText("Skicka meddelande");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnAnslutningar.setText("Se anslutna användare");
        btnAnslutningar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnslutningarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChattLayout = new javax.swing.GroupLayout(pnlChatt);
        pnlChatt.setLayout(pnlChattLayout);
        pnlChattLayout.setHorizontalGroup(
            pnlChattLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(pnlChattLayout.createSequentialGroup()
                .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChattLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnslutningar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        pnlChattLayout.setVerticalGroup(
            pnlChattLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChattLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addGroup(pnlChattLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChattLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnAnslutningar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend))
                    .addGroup(pnlChattLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tabFlode.addTab("Chatt", pnlChatt);

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

        btnHanteraFoljningar.setText("Hantera följningar");
        btnHanteraFoljningar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHanteraFoljningarActionPerformed(evt);
            }
        });

        btnLoggaUt.setText("Logga ut");
        btnLoggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaUtActionPerformed(evt);
            }
        });

        btnMinProfil.setText("Min profil");
        btnMinProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinProfilActionPerformed(evt);
            }
        });

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

        btnDoodle.setText("Boodle");
        btnDoodle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoodleActionPerformed(evt);
            }
        });

        btnHanteraMoten.setText("Hantera möten");
        btnHanteraMoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHanteraMotenActionPerformed(evt);
            }
        });

        btnHanteraAnvandare.setText("Hantera användare");
        btnHanteraAnvandare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHanteraAnvandareActionPerformed(evt);
            }
        });

        kalender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kalenderMouseClicked(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnRefresh.setText("↻");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblFloden.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFloden.setText("Samtliga bloggflöden");

        lblBloggIkon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbookIcon2small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnSkapaInlagg, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                        .addComponent(btnMinProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnLoggaUt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSkapaUnderkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnHanteraFoljningar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDoodle, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnSkapaSuperKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnHanteraAnvandare, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnSkapaAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHanteraMoten, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(5, 5, 5))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kalender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sprHog, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sprLag, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblBloggIkon)
                        .addGap(23, 23, 23)
                        .addComponent(lblFloden)
                        .addGap(54, 54, 54)
                        .addComponent(btnRefresh))
                    .addComponent(tabFlode, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFloden)
                                .addComponent(btnRefresh))
                            .addGap(1, 1, 1))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSkapaInlagg)
                            .addComponent(btnSkapaUnderkategori)
                            .addComponent(btnHanteraFoljningar)))
                    .addComponent(lblBloggIkon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMinProfil)
                            .addComponent(btnLoggaUt)
                            .addComponent(btnDoodle))
                        .addGap(18, 18, 18)
                        .addComponent(sprHog, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSkapaSuperKategori)
                            .addComponent(btnSkapaAnvandare))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHanteraAnvandare)
                            .addComponent(btnHanteraMoten))
                        .addGap(18, 18, 18)
                        .addComponent(sprLag, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kalender, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabFlode))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkapaInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaInlaggActionPerformed
        SkapaInlagg ettInlagg = new SkapaInlagg(connection, angivetAnv);
        ettInlagg.setVisible(true);
        
        while(ettInlagg.getSkapatInlagg()) {
            this.fyllFlodeMedInlagg();
            ettInlagg.setSkapatInlagg(false);
        }
        
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
        try {
            client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
            setVisible(false);
            new Inloggning(connection).setVisible(true);
        } catch (Exception e) {
            setVisible(false);
            new Inloggning(connection).setVisible(true);
        }
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

    private void btnHanteraFoljningarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHanteraFoljningarActionPerformed

        HanteraFoljningar folj = new HanteraFoljningar(connection, angivetAnv);
        folj.setVisible(true);

    }//GEN-LAST:event_btnHanteraFoljningarActionPerformed

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

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // Skicka det skrivna meddelandet om klienten är ansluten
        if (connected) {

            client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, tf.getText()));
            tf.setText("");
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnAnslutningarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnslutningarActionPerformed

        client.sendMessage(new ChatMessage(ChatMessage.WHOISIN, ""));
    }//GEN-LAST:event_btnAnslutningarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        try {
            client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
        } catch (Exception e) {
            System.exit(0);
        }

    }//GEN-LAST:event_formWindowClosing

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

    public void kalender() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int offset = cal.get(Calendar.DAY_OF_WEEK);
        int mon = kalender.getMonthChooser().getMonth() + 1;
        int yr = kalender.getYearChooser().getYear();
        JPanel jPanel = kalender.getDayChooser().getDayPanel();
        Component component[] = jPanel.getComponents();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String kalenderdatum = format.format(kalender.getDate());
        System.out.println(kalenderdatum);

        Color oruBlue = new Color(46,120,186);
        String sql2 = "SELECT DATUM FROM MOTE";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql2);

            while (rs.next()) {
                String datumet = rs.getString("DATUM");

                String aret = datumet.substring(0, 4);
                int year = Integer.parseInt(aret);

                String manaden = datumet.substring(5, 7);
                int month = Integer.parseInt(manaden);

                String dagen = datumet.substring(8, 10);
                int day = Integer.parseInt(dagen);
                int ctr = 0;
                for (int i = 7; i < 14; i++) {

                    if (component[i].isVisible() == false) {
                        ctr++;
                    }
                }

                if (yr == year && mon == month) {

                    component[day + offset + ctr].setBackground(oruBlue);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    // Metod för att hämta strängar från servern
    public void append(String str) {

        int count = ta.getText().length();

        ta.append(str);
        ta.setCaretPosition(ta.getText().length() - 1);

        System.out.println(angivetAnv.length());
        
        Color oruBlue = new Color(46,120,186);

        if (str.contains("@" + angivetAnv)) {
            Highlighter highlighter = ta.getHighlighter();
            HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(oruBlue);
            int p0 = count + str.indexOf("@");
            int p1 = p0 + angivetAnv.length() + 1;
            try {
                highlighter.addHighlight(p0, p1, painter);
            } catch (BadLocationException ex) {
                Logger.getLogger(Inloggad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    // Metod som sätter anslutningen till false
    public void connectionFailed() {
        connected = false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnslutningar;
    private javax.swing.JButton btnDoodle;
    private javax.swing.JButton btnHanteraAnvandare;
    private javax.swing.JButton btnHanteraFoljningar;
    private javax.swing.JButton btnHanteraMoten;
    private javax.swing.JButton btnLoggaUt;
    private javax.swing.JButton btnMinProfil;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSkapaAnvandare;
    private javax.swing.JButton btnSkapaInlagg;
    private javax.swing.JButton btnSkapaSuperKategori;
    private javax.swing.JButton btnSkapaUnderkategori;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private com.toedter.calendar.JCalendar kalender;
    private javax.swing.JLabel lblBloggIkon;
    private javax.swing.JLabel lblFloden;
    private javax.swing.JLabel lblInloggadSom;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblPic;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList lstInlaggForskning;
    private javax.swing.JList<String> lstInlaggInformell;
    private javax.swing.JList lstInlaggUtbildning;
    private javax.swing.JPanel pnlChatt;
    private javax.swing.JPanel pnlForskning;
    private javax.swing.JPanel pnlInformell;
    private javax.swing.JPanel pnlUtbildning;
    private javax.swing.JSeparator sprHog;
    private javax.swing.JSeparator sprLag;
    private javax.swing.JTextArea ta;
    private javax.swing.JTabbedPane tabFlode;
    private javax.swing.JTextField tf;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
