/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank_sampah;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author RianS
 */
public class Fungsi {
    private static Koneksi con = new Koneksi();
    private static PreparedStatement ps = null;
    private static final Connection Koneksi = con.getConnection();
    
    //Create
    public static boolean createNasabah(Query s){
        String sql = Query.daftar_nasabah;
        
        try{
            ps = Koneksi.prepareStatement(sql);
            ps.setString(1, s.getId_nasabah());
            ps.setString(2, s.getNama_nasabah());
            ps.setString(3, s.getAlamat_nasabah());
            ps.setString(4, s.getNomor_Telp_nasabah());
            ps.setString(5, s.getSaldo_nasabah());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean createSampah(Query s){
        String sql = Query.daftar_sampah;
        
        try{
            ps = Koneksi.prepareStatement(sql);
            ps.setString(1, s.getId_sampah());
            ps.setString(2, s.getKategori());
            ps.setString(3, s.getNama_sampah());
            ps.setString(4, s.getHarga());
            ps.setString(5, s.getHarga_pengepul());
            ps.setString(6, s.getStok());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean createPenjualan(Query s){
        String sql = Query.daftar_penjualan;
        
        try{
            ps = Koneksi.prepareStatement(sql);
            ps.setString(1, s.getTanggal_jual());
            ps.setString(2, s.getNama_pengepul());
            ps.setString(3, s.getId_sampah());
            ps.setString(4, s.getNama_sampah());
            ps.setString(5, s.getHarga_sampah());
            ps.setString(6, s.getBerat());
            ps.setString(7, s.getTotal_harga());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean createPenarikan(Query s){
        String sql = Query.daftar_penarikan;
        
        try{
            ps = Koneksi.prepareStatement(sql);
            ps.setString(1, s.getTanggal_penarikan());
            ps.setString(2, s.getId_nasabah());
            ps.setString(3, s.getSaldo_penarikan());
                        
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean createSaldo(Query s){
        String sql = Query.daftar_saldo;
        
        try{
            ps = Koneksi.prepareStatement(sql);
            ps.setString(1, s.getTgl_simpan());
            ps.setString(2, s.getId_nasabah());
            ps.setString(3, s.getId_sampah());
            ps.setString(4, s.getNama_sampah());
            ps.setString(5, s.getHarga_sampah());
            ps.setString(6, s.getJumlah_sampah());
            ps.setString(7, s.getTotal_sampah());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    //Update
    public static boolean updateNasabah(Query s){
        String sql = Query.update_nasabah;
        
        try{
            ps = Koneksi.prepareStatement(sql);
            ps.setString(1, s.getId_nasabah());
            ps.setString(2, s.getNama_nasabah());
            ps.setString(3, s.getAlamat_nasabah());
            ps.setString(4, s.getNomor_Telp_nasabah());
                                 
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean updateSampah(Query s){
        String sql = Query.update_sampah;
        
        try{
            ps = Koneksi.prepareStatement(sql);
            ps.setString(1, s.getId_sampah());
            ps.setString(2, s.getKategori());
            ps.setString(3, s.getNama_sampah());
            ps.setString(4, s.getHarga());
            ps.setString(5, s.getHarga_pengepul());
            ps.setString(6, s.getStok());
           
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean updateUser(Query s){
        String sql = Query.update_user;
        
        try{
            ps = Koneksi.prepareStatement(sql);
            ps.setString(3, s.getUsername());
            ps.setString(4, s.getPassword());
            
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static void Tabel_nasabah(String cari) {
        DefaultTableModel model = (DefaultTableModel) Main.tabel_nasabah.getModel();
        
        while (model.getRowCount() > 0){
            model.removeRow(0);
        }
        
        String sql = "";
        if (cari.equals("")) {
            sql = Query.select_nasabah;
            
        } else {
            sql = "SELECT * FROM tb_nasabah WHERE ("
                    + "id_nasabah LIKE'" + cari + "%' OR "
                    + "nama_nasabah LIKE '" + cari + "%' OR "
                    + "alamat LIKE'" + cari + "%' OR "
                    + "nomor_telp LIKE '" + cari + "%' OR "
                    + "saldo_nasabah LIKE '" + cari + "%' OR "
                    + ")";
        }
        
        String Data[] = new String[3];
        
        try {
            Statement st = Koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Data[0] = rs.getString("id_nasabah");
                Data[1] = rs.getString("nama_nasabah");
                Data[2] = rs.getString("alamat");
                
                model.addRow(Data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    
    public static void Tabel_sampah(String cari) {
        DefaultTableModel model = (DefaultTableModel) Main.tabel_sampah.getModel();
        
        while (model.getRowCount() > 0){
            model.removeRow(0);
        }
        
        String sql = "";
        if (cari.equals("")) {
            sql = Query.select_sampah;
            
        } else {
            sql = "SELECT * FROM tb_sampah WHERE ("
                    + "id_sampah LIKE'" + cari + "%' OR "
                    + "kategori LIKE '" + cari + "%' OR "
                    + "nama_sampah LIKE'" + cari + "%' OR "
                    + "harga LIKE '" + cari + "%' OR "
                    + "harga_pengepul LIKE '" + cari + "%' OR "
                    + "stok LIKE '" + cari + "%' OR "
                    + ")";
        }
        
        String Data[] = new String[3];
        
        try {
            Statement st = Koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Data[0] = rs.getString("id_sampah");
                Data[1] = rs.getString("nama_sampah");
                Data[2] = rs.getString("stok");
                                
                model.addRow(Data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    
    public static void Tabel_penarikan(String cari) {
        DefaultTableModel model = (DefaultTableModel) Main.tabel_penarikan.getModel();
        
        while (model.getRowCount() > 0){
            model.removeRow(0);
        }
        
        String sql = "";
        if (cari.equals("")) {
            sql = Query.select_penarikan;
            
        } else {
            sql = "SELECT * FROM tb_penarikan WHERE ("
                    + "id_penarikan LIKE'" + cari + "%' OR "
                    + "id_nasabah LIKE '" + cari + "%' OR "
                    + "tanggal_penarikan LIKE'" + cari + "%' OR "
                    + "saldo_nasabah LIKE '" + cari + "%' OR "
                    + ")";
        }
        
        String Data[] = new String[3];
        
        try {
            Statement st = Koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Data[0] = rs.getString("id_penarikan");
                Data[1] = rs.getString("id_nasabah");
                Data[2] = rs.getString("tanggal_penarikan");
                Data[3] = rs.getString("saldo_penarikan");
                
                model.addRow(Data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
