
package Kasirku;

import Com.Config.MyConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;



public class Kasirku extends javax.swing.JFrame {
    private Statement St;
    private Connection Con;
    private ResultSet Rs;
    private String sql = "";
    private DefaultTableModel model;

    
public void clear() {
        BoxNama.setText("");
        BoxHarga.setText("");
        BoxJumlah.setText("");
        BoxNama.requestFocus();
    }

public  void insertData(){
        DefaultTableModel model = (DefaultTableModel) TabelProduk.getModel();
        int row = TabelProduk.getRowCount();
        model.addRow(new Object[]{
            row += 1,
            BoxNama.getText(),
            BoxHarga.getText(),
            BoxJumlah.getText()
        });
    }
public double hitungTotal(){
        DefaultTableModel model = (DefaultTableModel) TabelProduk.getModel();
//        int[] selectedRows = TblBarang.getSelectedRows();
        int rowCount = model.getRowCount();
        double total = 0.0;
        
//        double total = 0.0;
//        for(int row : selectedRows){
//            double harga = Double.parseDouble(model.getValueAt(row, 2).toString());
//            int jumlah = Integer.parseInt(model.getValueAt(row, 3).toString());
//            total += harga*jumlah;
//        }

         for(int i = 0; i < rowCount; i++){
            double harga = Double.parseDouble(model.getValueAt(i, 2).toString());
            int jumlah = Integer.parseInt(model.getValueAt(i, 3).toString());
            total += harga*jumlah;
        }
        return total;
    }

    public void Show(){
        MyConfig connect = new MyConfig();
        try{
            Con = connect.getConnect();
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM utils");
            int i = 1;
            while(Rs.next()){
                String[] row = {Integer.toString(i), Rs.getString(2), Rs.getString(3), Rs.getString(4)};
                model.addRow(row);
                i++;
            }
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
    
public Kasirku() {
    initComponents();
    String [] header = {"ID", "NAMA", "HARGA", "STOK"};
    model = new DefaultTableModel (header,0);
    TabelProduk.setModel(model);
    Show();
//  KoneksiDatabase();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LabelHarga = new javax.swing.JLabel();
        LabelNama = new javax.swing.JLabel();
        LabelJumlah = new javax.swing.JLabel();
        BoxNama = new javax.swing.JTextField();
        BoxHarga = new javax.swing.JTextField();
        BoxJumlah = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        LabelTotal = new javax.swing.JLabel();
        LabelUang = new javax.swing.JLabel();
        LabelKembalian = new javax.swing.JLabel();
        BoxTotal = new javax.swing.JTextField();
        BoxUang = new javax.swing.JTextField();
        BoxKembalian = new javax.swing.JTextField();
        btn_bayar = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelProduk = new javax.swing.JTable();
        btn_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KasirIbel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        LabelHarga.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelHarga.setText("Harga Barang");

        LabelNama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelNama.setText("Nama Barang");

        LabelJumlah.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelJumlah.setText("Jumlah Barang");

        BoxNama.setBackground(new java.awt.Color(0, 204, 204));
        BoxNama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BoxNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxNamaActionPerformed(evt);
            }
        });

        BoxHarga.setBackground(new java.awt.Color(0, 204, 204));
        BoxHarga.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        BoxJumlah.setBackground(new java.awt.Color(0, 204, 204));
        BoxJumlah.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );

        btn_tambah.setBackground(new java.awt.Color(102, 255, 255));
        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(102, 255, 255));
        btn_edit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(102, 255, 255));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        LabelTotal.setBackground(new java.awt.Color(0, 204, 204));
        LabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelTotal.setText("Total");

        LabelUang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelUang.setText("Uang");

        LabelKembalian.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelKembalian.setText("Kembalian");

        BoxTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BoxTotal.setText("Rp.");
        BoxTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxTotalActionPerformed(evt);
            }
        });

        BoxUang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BoxUang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxUangActionPerformed(evt);
            }
        });

        BoxKembalian.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BoxKembalian.setText("Rp.");

        btn_bayar.setBackground(new java.awt.Color(102, 255, 255));
        btn_bayar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_bayar.setText("Bayar");
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });

        btn_simpan.setBackground(new java.awt.Color(102, 255, 255));
        btn_simpan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelUang, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                            .addComponent(LabelKembalian))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BoxKembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(BoxTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(BoxUang)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTotal)
                    .addComponent(BoxTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelUang)
                    .addComponent(BoxUang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelKembalian)
                    .addComponent(BoxKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_bayar))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        TabelProduk.setBackground(new java.awt.Color(204, 255, 255));
        TabelProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama ", "Harga ", "Jumlah "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelProduk);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        btn_clear.setBackground(new java.awt.Color(102, 255, 255));
        btn_clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNama)
                                    .addComponent(LabelHarga)
                                    .addComponent(LabelJumlah)
                                    .addComponent(btn_tambah))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BoxNama, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BoxHarga, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BoxJumlah, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNama)
                            .addComponent(BoxNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BoxHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelHarga))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelJumlah)
                            .addComponent(BoxJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah)
                            .addComponent(btn_edit)
                            .addComponent(btn_delete)
                            .addComponent(btn_clear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoxUangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxUangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxUangActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        try{
           Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imeltoko","root","");
           
           int rowCount = TabelProduk.getRowCount();
           for(int i = 0; i < rowCount; i++){
               String Column1 = TabelProduk.getValueAt(i, 1).toString();
               String Column2 = TabelProduk.getValueAt(i, 2).toString();
               String Column3 = TabelProduk.getValueAt(i, 3).toString();
               
               String sql = "INSERT INTO muti_table (NAMMA, HARGA, STOK) VALUES (?,?,?)";
               PreparedStatement statement = Con.prepareStatement(sql);
               
               statement.setString(1, Column1);
               statement.setString(2, Column2);
               statement.setString(3, Column3);
               
               statement.executeUpdate();
           }   
           
           JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke database.");
           Con.close();
           
             }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data ke database.");
        }
           

    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        if(BoxNama.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama Barang Belum di Masukan");
        }else if(BoxHarga.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harga Barang Belum di Masukan");
        }else if(BoxJumlah.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Jumlah Barang Belum di Masukan");
        }else{
            insertData();
            clear();
        }
     
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here
         DefaultTableModel model = (DefaultTableModel) TabelProduk.getModel();
        int rowSelect = TabelProduk.getSelectedRow();
        
        if(btn_edit.getText()== "Edit"){
            btn_tambah.setEnabled(false);
            btn_delete.setEnabled(false);
            btn_edit.setText("Update");
            
            BoxNama.setText(model.getValueAt(rowSelect, 1).toString());
            BoxHarga.setText(model.getValueAt(rowSelect, 2).toString());
            BoxJumlah.setText(model.getValueAt(rowSelect, 3).toString());
            
        }else {
            btn_tambah.setEnabled(true);
            btn_delete.setEnabled(true);
            btn_edit.setText("Edit");
            
            String name = BoxNama.getText();
            String price = BoxHarga.getText();
            String stock = BoxJumlah.getText();
            
            model.setValueAt(name, rowSelect, 1);
            model.setValueAt(price, rowSelect, 2);
            model.setValueAt(stock, rowSelect, 3);
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TabelProduk.getModel();
        int rowSelect = TabelProduk.getSelectedRow();
        
        if(rowSelect == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus data ini?", 
                  "Konfirmasi Pengahapusan Data",JOptionPane.YES_NO_OPTION);
          if(confirm == JOptionPane.YES_OPTION){
              model.removeRow(rowSelect);
          }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void BoxTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxTotalActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        // TODO add your handling code here:
        double total = hitungTotal();
        BoxTotal.setText("Rp." + String.valueOf(total));
        
        try {
            String totalText = BoxTotal.getText().substring(3);
            double total1 = Double.parseDouble(totalText);
            double bayar = Double.parseDouble(BoxUang.getText());
            double kembali = bayar - total1;
            BoxKembalian.setText("Rp." + String.valueOf(kembali));
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Input tidak Valid");
        }
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void BoxNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxNamaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kasirku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Kasirku().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BoxHarga;
    private javax.swing.JTextField BoxJumlah;
    private javax.swing.JTextField BoxKembalian;
    private javax.swing.JTextField BoxNama;
    private javax.swing.JTextField BoxTotal;
    private javax.swing.JTextField BoxUang;
    private javax.swing.JLabel LabelHarga;
    private javax.swing.JLabel LabelJumlah;
    private javax.swing.JLabel LabelKembalian;
    private javax.swing.JLabel LabelNama;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LabelUang;
    private javax.swing.JTable TabelProduk;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
