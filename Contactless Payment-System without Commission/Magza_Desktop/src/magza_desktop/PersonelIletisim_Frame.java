/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package magza_desktop;

import Beans.IletisimBeans;
import Beans.MusteriBeans;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author furka
 */
public class PersonelIletisim_Frame extends javax.swing.JFrame {

    String PersonelId = null, PersonelIsım = null, PersonelSoyisim = null;
    dbConn DB_Con = new dbConn();
    Connection con = null;
    byte [] IletiImage = null;
     
     
    public PersonelIletisim_Frame() {
        initComponents();
    }

    public PersonelIletisim_Frame(String PersonelId, String PersonelIsım, String PersonelSoyisim) {
        initComponents();
        this.PersonelId = PersonelId;
        this.PersonelIsım = PersonelIsım;
        this.PersonelSoyisim = PersonelSoyisim;
        con = DB_Con.getConnection_Magza_DB();
        comboboxDuzenle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        IletiKonu_jTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        IletiIcerik_TextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Gonder_jButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        OnemSeviye_jComboBox = new javax.swing.JComboBox<>();
        GorselEklejButton = new javax.swing.JButton();
        GorselEkle_jLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Tur_jComboBox = new javax.swing.JComboBox<>();
        Image_jLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        AnaSayfa_jMenuItem = new javax.swing.JMenuItem();
        IletiGoster_jMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IletiKonu_jTextField.setMaximumSize(new java.awt.Dimension(100, 100));

        IletiIcerik_TextArea.setColumns(20);
        IletiIcerik_TextArea.setRows(5);
        jScrollPane1.setViewportView(IletiIcerik_TextArea);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Konu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("İçerik");

        Gonder_jButton.setText("GÖNDER");
        Gonder_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Gonder_jButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ÖNEM SEVİYESİ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("      İLETİŞİM(HATA/ÖNERİ)  SAYFASI");

        OnemSeviye_jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        OnemSeviye_jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnemSeviye_jComboBoxActionPerformed(evt);
            }
        });

        GorselEklejButton.setText("Görse Ekle");
        GorselEklejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GorselEklejButtonActionPerformed(evt);
            }
        });

        GorselEkle_jLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("TÜR");

        Tur_jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OnemSeviye_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tur_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(IletiKonu_jTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Gonder_jButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(GorselEklejButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                        .addComponent(GorselEkle_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Image_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OnemSeviye_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tur_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Image_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GorselEklejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GorselEkle_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Gonder_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(IletiKonu_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jMenu1.setText("Seçenekler");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        AnaSayfa_jMenuItem.setText("Ana Sayfa");
        AnaSayfa_jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnaSayfa_jMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(AnaSayfa_jMenuItem);

        IletiGoster_jMenuItem.setText("İletileri Göster");
        IletiGoster_jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IletiGoster_jMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(IletiGoster_jMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Gonder_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Gonder_jButtonActionPerformed
        
        String SecilenTur = (String) Tur_jComboBox.getSelectedItem();
        String SecilenOnemSeviye = (String) OnemSeviye_jComboBox.getSelectedItem();
        String Konu = IletiKonu_jTextField.getText();
        String Icerik = IletiIcerik_TextArea.getText();
        String Durum = "Değerlendiriliyor";
        
        if(!SecilenTur.equals("") && !SecilenOnemSeviye.equals("") && !Konu.equals("") && !Icerik.equals("") && !Durum.equals("")){
            IletisimGirisleri(SecilenTur, SecilenOnemSeviye, Konu, Icerik, Durum);
        }
        else{
            JOptionPane.showMessageDialog(null, "Lütfen gerekli alanları tam doldurun");
        }
    }//GEN-LAST:event_Gonder_jButtonActionPerformed

    private void GorselEklejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GorselEklejButtonActionPerformed
                JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        GorselEkle_jLabel.setText(filename);
        ImageIcon icon = new ImageIcon(filename);
        ImageIcon ImgIcon = new ImageIcon(new ImageIcon(icon.getImage()).getImage().getScaledInstance(Image_jLabel.getWidth(), Image_jLabel.getHeight(), Image.SCALE_SMOOTH));
        Image_jLabel.setIcon(ImgIcon);
        try {
            File Image = new File(filename);
            FileInputStream fis = new FileInputStream(Image);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte [] buffer = new byte[1024];
            for (int readNum ; (readNum = fis.read(buffer)) != -1;) {
                baos.write(buffer,0,readNum);
            }
            
            IletiImage = baos.toByteArray();
                
        } catch (Exception e) {
        }
    }//GEN-LAST:event_GorselEklejButtonActionPerformed

    private void AnaSayfa_jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnaSayfa_jMenuItemActionPerformed

        PersonelAnaSayfa_Frame paf = new PersonelAnaSayfa_Frame(PersonelId, PersonelIsım, PersonelSoyisim);
        setVisible(false);
        paf.setVisible(true);
        
    }//GEN-LAST:event_AnaSayfa_jMenuItemActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void OnemSeviye_jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnemSeviye_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OnemSeviye_jComboBoxActionPerformed

    private void IletiGoster_jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IletiGoster_jMenuItemActionPerformed
       
        PersonelIletisimGoruntule_JFrame pig = new PersonelIletisimGoruntule_JFrame(PersonelId, PersonelIsım, PersonelSoyisim);
        setVisible(false);
        pig.setVisible(true);
        
    }//GEN-LAST:event_IletiGoster_jMenuItemActionPerformed

    public void IletisimGirisleri(String SecilenTur, String SecilenOnemSeviye, String Konu, String Icerik, String Durum) {
        
        String query = "INSERT INTO  Iletisim_Table (Iletisim_Persone_Id, Iletisim_Onem, Iletisim_Tur, Iletisim_Konu, Iletisim_Icerik, Iletisim_Gorsel, Iletisim_Tarih, Iletisim_Durum) \n"
                + "VALUES (?, ?, ?, ?, ?, ?,  GETDATE(), ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println();
            ps.setString(1, PersonelId);
            ps.setString(2, SecilenOnemSeviye);
            ps.setString(3, SecilenTur);
            ps.setString(4, Konu);
            ps.setString(5, Icerik);
            ps.setBytes(6, IletiImage);
            ps.setString(7, Durum);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "İletmek istediğiniz mesaj kaydedildi");
            Temizle();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "İletişim kaydı Kaydı Yapılamadı.  Okutmak istenilen barkod daga önce okutulmuş olabilir.");

        }
    }

    public void Temizle(){
        IletiImage = null;
        Tur_jComboBox.setSelectedIndex(0);
        OnemSeviye_jComboBox.setSelectedIndex(0);
        IletiKonu_jTextField.setText("");
        IletiIcerik_TextArea.setText("");
        GorselEkle_jLabel.setText("");
        Image_jLabel.setIcon(null);
        
    }
    
    public void comboboxDuzenle() {
        
        OnemSeviye_jComboBox.removeAllItems();
        Tur_jComboBox.removeAllItems();
        
        OnemSeviye_jComboBox.addItem("1");
        OnemSeviye_jComboBox.addItem("2");
        OnemSeviye_jComboBox.addItem("3");
        OnemSeviye_jComboBox.addItem("4");
        OnemSeviye_jComboBox.addItem("5");

        Tur_jComboBox.addItem("Öneri");
        Tur_jComboBox.addItem("Hata");
    }

    
   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PersonelIletisim_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonelIletisim_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonelIletisim_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonelIletisim_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonelIletisim_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AnaSayfa_jMenuItem;
    private javax.swing.JButton Gonder_jButton;
    private javax.swing.JLabel GorselEkle_jLabel;
    private javax.swing.JButton GorselEklejButton;
    private javax.swing.JMenuItem IletiGoster_jMenuItem;
    private javax.swing.JTextArea IletiIcerik_TextArea;
    private javax.swing.JTextField IletiKonu_jTextField;
    private javax.swing.JLabel Image_jLabel;
    private javax.swing.JComboBox<String> OnemSeviye_jComboBox;
    private javax.swing.JComboBox<String> Tur_jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
