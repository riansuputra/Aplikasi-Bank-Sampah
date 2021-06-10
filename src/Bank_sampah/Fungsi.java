/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank_sampah;

import static Bank_sampah.Main.tabel_laporan;
import static Bank_sampah.Main.tabel_laporan_penarikan;
import static Bank_sampah.Main.tabel_laporan_penjualan;
import static Bank_sampah.Main.tabel_laporan_setoran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


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
            ps.setString(1, s.getId_nasabah());
            ps.setString(2, s.getTanggal_penarikan());
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
            ps.close();
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
            
            ps.setString(2, s.getNama_sampah());
            ps.setString(3, s.getHarga());
            ps.setString(4, s.getHarga_pengepul());
            
           
            ps.executeUpdate();
            
            ps.close();
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
        
        String Data[] = new String[4];
        
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
        
    public static void Tabel_Simpanan(String cari) {
        DefaultTableModel model = (DefaultTableModel) Main.tabel_tabungan.getModel();
        
        while (model.getRowCount() > 0){
            model.removeRow(0);
        }
        
        String sql = "";
        if (cari.equals("")) {
            sql = Query.select_saldo;
            
        } else {
            sql = "SELECT * FROM tb_saldo WHERE ("
                    + "id_saldo LIKE'" + cari + "%' OR "
                    + "tgl_simpan LIKE '" + cari + "%' OR "
                    + "id_nasabah LIKE'" + cari + "%' OR "
                    + "id_sampah LIKE '" + cari + "%' OR "
                    + "nama_sampah LIKE'" + cari + "%' OR "
                    + "harga_sampah LIKE '" + cari + "%' OR "
                    + "jumlah_sampah LIKE'" + cari + "%' OR "
                    + "total_sampah LIKE '" + cari + "%' OR "
                    + ")";
        }
        
        String Data[] = new String[6];
        
        try {
            Statement st = Koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Data[0] = rs.getString("tgl_simpan");
                Data[1] = rs.getString("id_nasabah");
                Data[2] = rs.getString("nama_sampah");
                Data[3] = rs.getString("harga_sampah");
                Data[4] = rs.getString("jumlah_sampah");
                Data[5] = rs.getString("total_sampah");
                
                model.addRow(Data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void Tabel_buku_tabungan(String cari) {
        DefaultTableModel model = (DefaultTableModel) Main.tabel_buku_tabungan.getModel();

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        String sql = "";
        if (cari.equals("")) {

            sql = "SELECT * FROM tb_buku_tabungan WHERE id_nasabah = '" + Main.buku_tabungan_id_nasabah.getText() + "'"
                    + "ORDER BY tb_buku_tabungan.tgl_tabungan ASC";
        } else {
            sql = "SELECT * FROM tb_buku_tabungan WHERE ("
                    + "id_nasabah LIKE'" + cari + "%'"
                    + ")" + "ORDER BY tb_buku_tabungan.tgl_tabungan ASC";
        }
        String Data[] = new String[6];

        try {
            Statement st = Koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Data[0] = rs.getString("tgl_tabungan");
                Data[1] = rs.getString("nama_sampah");
                Data[2] = rs.getString("harga_sampah");
                Data[3] = rs.getString("berat_sampah");
                Data[4] = rs.getString("debet");
                Data[5] = rs.getString("kredit");

                model.addRow(Data);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void Tabel_Penjualan(String cari) {
        DefaultTableModel model = (DefaultTableModel) Main.tabel_penjualan.getModel();

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        String sql = "";
        if (cari.equals("")) {
            sql = Query.select_penjualan;

        } else {
            sql = "SELECT * FROM penjualan WHERE ("
                    + "id_jual LIKE'" + cari + "%' OR "
                    + "tanggal_jual LIKE'" + cari + "%' OR "
                    + "nama_pengepul LIKE'" + cari + "%' OR "
                    + "id_sampah LIKE'" + cari + "%' OR "
                    + "nama_sampah LIKE'" + cari + "%' OR "
                    + "harga_sampah LIKE'" + cari + "%' OR "
                    + "berat LIKE'" + cari + "%' OR "
                    + "total_harga LIKE'" + cari + "%'"
                    + ")";
        }
        String Data[] = new String[6];

        try {
            Statement st = Koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Data[0] = rs.getString("tanggal_jual");
                Data[1] = rs.getString("nama_pengepul");
                Data[2] = rs.getString("nama_sampah");
                Data[3] = rs.getString("harga_sampah");
                Data[4] = rs.getString("berat");
                Data[5] = rs.getString("total_harga");

                model.addRow(Data);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void Tabel_laporan_tabungan(String cari) {
        String sql = "";
        if (cari.equals("")) {


            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_DARI = format.format(Main.date_laporan_dari.getDate());
            String tgl_SAMPAI = format.format(Main.date_laporan_sampai.getDate());


            sql = "select * from tb_buku_tabungan where tgl_tabungan>='" + tgl_DARI + "'&& tgl_tabungan<='" + tgl_SAMPAI + "'";
            

        } else {
            sql = "SELECT * FROM tb_buku_tabungan WHERE ("
                    + "id_tabungan LIKE'" + Main.date_laporan_dari + "%'";

        }
        String Data[] = new String[10];

        try {
            Statement st = Koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tabel_laporan.setModel(DbUtils.resultSetToTableModel(rs));
            /*
            while (rs.next()) {

                Data[0] = rs.getString("tgl_tabungan");
                Data[1] = rs.getString("kode");
                Data[2] = rs.getString("id_nasabah");
                Data[3] = rs.getString("nama_sampah");
                Data[4] = rs.getString("id_sampah");
                Data[5] = rs.getString("harga_sampah");
                Data[6] = rs.getString("berat_sampah");
                Data[7] = rs.getString("debet");
                Data[8] = rs.getString("kredit");
                Data[9] = rs.getString("penjualan");

                model.addRow(Data);

            }*/
        } catch (SQLException ex) {            
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void Tabel_laporan_setoran(String cari) {
        String sql = "";
        if (cari.equals("")) {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_DARI = format.format(Main.date_laporan_setoran_dari.getDate());
            String tgl_SAMPAI = format.format(Main.date_laporan_setoran_sampai.getDate());


            sql = "select * from tb_saldo where tgl_simpan>='" + tgl_DARI + "'and tgl_simpan<='" + tgl_SAMPAI + "'";

        } else {

        }
        String Data[] = new String[6];

        try {
            Statement st = Koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            tabel_laporan_setoran.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void Tabel_laporan_penarikan(String cari) {
        String sql = "";
        if (cari.equals("")) {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_DARI = format.format(Main.date_laporan_tarikan_dari.getDate());
            String tgl_SAMPAI = format.format(Main.date_laporan_tarikan_sampai.getDate());


            sql = "select * from tb_penarikan where tanggal_penarikan>='" + tgl_DARI + "'and tanggal_penarikan<='" + tgl_SAMPAI + "'";

        } else {

        }
        String Data[] = new String[6];

        try {
            Statement st = Koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            tabel_laporan_penarikan.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void Tabel_laporan_penjualan(String cari) {
        String sql = "";
        if (cari.equals("")) {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_DARI = format.format(Main.date_laporan_jual_dari.getDate());
            String tgl_SAMPAI = format.format(Main.date_laporan_jual_sampai.getDate());


            sql = "select * from tb_penjualan where tanggal_jual>='" + tgl_DARI + "'and tanggal_jual<='" + tgl_SAMPAI + "'";

        } else {

        }
        String Data[] = new String[6];

        try {
            Statement st = Koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            tabel_laporan_penjualan.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
