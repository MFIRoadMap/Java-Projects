/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package magza_desktop;

import Beans.MusteriBeans;
import Beans.SiparisBeans;
import Beans.UrunBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author furka
 */
public class MagzaSiparisDetay_JFrame extends javax.swing.JFrame {

    String PersonelId = null, PersonelIsım = null, PersonelSoyisim = null, SecilenKasa = null, SHTId = null, SFT_FisId = null;
    String Iletisim_Id, Iletisim_Persone_Id, Iletisim_Onem, Iletisim_Tur, Iletisim_Konu, Iletisim_Icerik, Iletisim_Tarih, Iletisim_Durum;
    byte[] IletisimImage = null;
    ArrayList<UrunBeans> barcodes = new ArrayList<>();
    dbConn DB_Con = new dbConn();
    Connection con = null;

    public MagzaSiparisDetay_JFrame() {
        initComponents();
    }

    public MagzaSiparisDetay_JFrame(String PersonelId, String PersonelIsım, String PersonelSoyisim, String SecilenKasa, String SHTId, String SFT_FisId) {
        initComponents();
        this.PersonelId = PersonelId;
        this.PersonelIsım = PersonelIsım;
        this.PersonelSoyisim = PersonelSoyisim;
        this.SecilenKasa = SecilenKasa;
        this.SHTId = SHTId;
        this.SFT_FisId = SFT_FisId;
        con = DB_Con.getConnection_Magza_DB();
        SipariSorgu();
        ComboBox();
        
    }

    public void ComboBox() {
       
        Durums_Textfield_jComboBox.addItem("Hazırlanıyor");
        Durums_Textfield_jComboBox.addItem("Hazırlandı");
        Durums_Textfield_jComboBox.addItem("Alındı");
        
    }
    
    public void SipariSorgu() {

        SiparisBeans sb;
        String query, Satis_Urun_Barkod;

        try {
            Statement st = con.createStatement();
            query = "select * from Satis_Table  where Satis_Fis_Id = " + SFT_FisId;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Satis_Urun_Barkod = rs.getString("Satis_Urun_Barkod");
                Veritabanında_Bul(Satis_Urun_Barkod);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bu Id değerine sahip müşteri bilgisi bulunamadı");
        }

    }

    public void Veritabanında_Bul(String barcode) {

        String U_Barkod, U_Marka, U_Isim, U_Durum, U_Stok, U_Fiyat, query;
        byte[] UrunImage = null;
        UrunBeans ub;

        try {

            Statement st = con.createStatement();
            query = "SELECT * FROM Urun_Table WHERE Urun_Barkod ='" + barcode + "'";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                U_Barkod = rs.getString("Urun_Barkod");
                U_Marka = rs.getString("Urun_Marka");
                U_Isim = rs.getString("Urun_Isim");
                U_Stok = rs.getString("Urun_Stok");
                U_Durum = rs.getString("Urun_Durum");
                U_Fiyat = rs.getString("Urun_Fiyat");
                UrunImage = rs.getBytes("Urun_Gorsel");

                if (!U_Barkod.equals("") && !U_Stok.equals("0")) {

                    ub = new UrunBeans(U_Barkod, U_Marka, U_Isim, U_Stok, U_Durum, U_Fiyat, UrunImage);
                    barcodes.add(ub);
                    Show_Urun_Bean_List(ub);

                }
                if (U_Stok.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Ürünümüz Stokta Bulunmamaktadır");
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void Show_Urun_Bean_List(UrunBeans ul) {

        DefaultTableModel model = (DefaultTableModel) SiparisHazirlaDetay_Table.getModel();
        Object[] row = new Object[4];

        row[0] = ul.getUrun_Barkod();
        row[1] = ul.getUrun_Marka();
        row[2] = ul.getUrun_Isim();
        row[3] = ul.getUrun_Fiyat();
        model.addRow(row);

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
        jScrollPane4 = new javax.swing.JScrollPane();
        SiparisHazirlaDetay_Table = new javax.swing.JTable();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        DurumGuncelle_Button = new javax.swing.JButton();
        Durums_Textfield_jComboBox = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Geri_jMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SiparisHazirlaDetay_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barkod", "Marka", "Isim", "Fiyat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SiparisHazirlaDetay_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SiparisHazirlaDetay_TableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(SiparisHazirlaDetay_Table);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        DurumGuncelle_Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DurumGuncelle_Button.setText("Sipariş Durum Güncelle");
        DurumGuncelle_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DurumGuncelle_ButtonActionPerformed(evt);
            }
        });

        Durums_Textfield_jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        Durums_Textfield_jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Durums_Textfield_jComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(Durums_Textfield_jComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(DurumGuncelle_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Durums_Textfield_jComboBox)
                    .addComponent(DurumGuncelle_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jMenu1.setText("Seçenekler");

        Geri_jMenuItem.setText("Geri");
        Geri_jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Geri_jMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(Geri_jMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Geri_jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Geri_jMenuItemActionPerformed

        MagzaSiparis_JFrame pigf = new MagzaSiparis_JFrame(PersonelId, PersonelIsım, PersonelSoyisim, SecilenKasa);
        setVisible(false);
        pigf.setVisible(true);

    }//GEN-LAST:event_Geri_jMenuItemActionPerformed

    private void SiparisHazirlaDetay_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiparisHazirlaDetay_TableMouseClicked

    }//GEN-LAST:event_SiparisHazirlaDetay_TableMouseClicked

    private void DurumGuncelle_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DurumGuncelle_ButtonActionPerformed

       String SecilenDurum = (String) Durums_Textfield_jComboBox.getSelectedItem();
        
               String query = "UPDATE  Siparis_Hazirlat_Table SET SHT_Durum = ? Where SHT_Id = ?";
        boolean result = false;
        try {

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, SecilenDurum);
            ps.setString(2, SHTId);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sipariş Durumu Güncellendi");
            MagzaSiparis_JFrame msf = new MagzaSiparis_JFrame(PersonelId, PersonelIsım, PersonelSoyisim, SecilenKasa);
            setVisible(false);
            msf.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Stok değerinde hata oluştu Sıkıntılı");
            // TODO: handle exception
        }
    }//GEN-LAST:event_DurumGuncelle_ButtonActionPerformed

    
    

    
    
    private void Durums_Textfield_jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Durums_Textfield_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Durums_Textfield_jComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(MagzaSiparisDetay_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MagzaSiparisDetay_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MagzaSiparisDetay_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MagzaSiparisDetay_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MagzaSiparisDetay_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DurumGuncelle_Button;
    private javax.swing.JComboBox<String> Durums_Textfield_jComboBox;
    private javax.swing.JMenuItem Geri_jMenuItem;
    private javax.swing.JComboBox<String> KasaId_Textfield_jComboBox;
    private javax.swing.JComboBox<String> KasaId_Textfield_jComboBox1;
    private javax.swing.JTable SiparisHazirlaDetay_Table;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
