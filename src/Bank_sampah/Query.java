/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank_sampah;

/**
 *
 * @author RianS
 */
public class Query {
    
    //Query Create
    public static String daftar_nasabah = "INSERT INTO tb_nasabah("
            + "id_nasabah,"
            + "nama_nasabah,"
            + "alamat,"
            + "nomor_telp,"
            + "saldo_nasabah)"
            + "VALUES(?,?,?,?,?)";
    public static String daftar_sampah = "INSERT INTO tb_sampah("
            + "id_sampah,"
            + "kategori,"
            + "nama_sampah,"
            + "harga,"
            + "harga_pengepul,"
            + "stok)"
            + "VALUES(?,?,?,?,?,?)";
    public static String daftar_penjualan = "INSERT INTO tb_penjualan("
            + "tanggal_jual,"
            + "nama_pengepul,"
            + "id_sampah,"
            + "nama_sampah,"
            + "harga_sampah,"
            + "berat,"
            + "total_harga)"
            + "VALUES(?,?,?,?,?,?,?)";
    public static String daftar_penarikan = "INSERT INTO tb_penarikan("
            + "id_nasabah,"
            + "tanggal_penarikan,"
            + "saldo_penarikan)"
            + "VALUES(?,?,?)";
    public static String daftar_saldo = "INSERT INTO tb_saldo("
            + "tgl_simpan,"
            + "id_nasabah,"
            + "id_sampah,"
            + "nama_sampah,"
            + "harga_sampah,"
            + "jumlah_sampah,"
            + "total_sampah)"
            + "VALUES(?,?,?,?,?,?,?)";
        
    //Query Update
    public static String update_nasabah = "CALL UpdateNasabah(?,?,?,?)";
    public static String update_sampah = "CALL UpdateSampah(?,?,?,?)";
    public static String update_user = "UPDATE tb_user SET("
            + "username,"
            + "password)"
            + "WHERE id_user = ?";
    
    //Query Select
    public static String select_nasabah = "SELECT * FROM tb_nasabah";
    public static String select_sampah = "SELECT * FROM tb_sampah";
    public static String select_sampah2 = "SELECT * FROM tb_sampah";
    public static String select_saldo = "SELECT * FROM tb_saldo";
    public static String select_penarikan = "SELECT * FROM tb_penarikan";
    public static String select_penjualan = "SELECT * FROM tb_penjualan";
    public static String select_laporan_tabungan = "SELECT * FROM tb_laporan_tabungan";
    public static String jumlah_nasabah = "SELECT COUNT(id_nasabah) FROM tb_nasabah";
    
    //Get Set 
    //Nasabah
    private String id_nasabah;
    private String nama_nasabah;
    private String alamat;
    private String nomor_telp;
    private String saldo_nasabah;
    public String getId_nasabah(){
        return id_nasabah;
    }
    public void setId_nasabah(String id_nasabah){
        this.id_nasabah = id_nasabah;
    }
    public String getNama_nasabah(){
        return nama_nasabah;
    }
    public void setNama_nasabah(String nama_nasabah){
        this.nama_nasabah = nama_nasabah;
    }
    public String getAlamat_nasabah(){
        return alamat;
    }
    public void setAlamat_nasabah(String alamat){
        this.alamat = alamat;
    }
    public String getNomor_Telp_nasabah(){
        return nomor_telp;
    }
    public void setNomor_Telp_nasabah(String nomor_telp){
        this.nomor_telp = nomor_telp;
    }
    public String getSaldo_nasabah(){
        return saldo_nasabah;
    }
    public void setSaldo_nasabah(String saldo_nasabah){
        this.saldo_nasabah = saldo_nasabah;
    }
    
    //User
    private String username;
    private String password;
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    //Sampah
    private String id_sampah;
    private String kategori;
    private String nama_sampah;
    private String harga;
    private String harga_pengepul;
    private String stok;
    public String getId_sampah(){
        return id_sampah;
    }
    public void setId_sampah(String id_sampah){
        this.id_sampah = id_sampah;
    }
    public String getKategori(){
        return kategori;
    }
    public void setKategori(String kategori){
        this.kategori = kategori;
    }
    public String getNama_sampah(){
        return nama_sampah;
    }
    public void setNama_sampah(String nama_sampah){
        this.nama_sampah = nama_sampah;
    }
    public String getHarga(){
        return harga;
    }
    public void setHarga(String harga){
        this.harga = harga;
    }
    public String getHarga_pengepul(){
        return harga_pengepul;
    }
    public void setHarga_Pengepul(String harga_pengepul){
        this.harga_pengepul = harga_pengepul;
    }
    public String getStok(){
        return stok;
    }
    public void setStok(String stok){
        this.stok = stok;
    }
    
    //Penjualan
    private String id_penjualan;
    private String tanggal_jual;
    private String nama_pengepul;
    private String berat;
    private String harga_sampah;
    private String total_harga;
    public String getId_penjualan(){
        return id_penjualan;
    }
    public void setId_penjualan(String id_penjualan){
        this.id_penjualan = id_penjualan;
    }
    public String getTanggal_jual(){
        return tanggal_jual;
    }
    public void setTanggal_jual(String tanggal_jual){
        this.tanggal_jual = tanggal_jual;
    }
    public String getNama_pengepul(){
        return nama_pengepul;
    }
    public void setNama_pengepul(String nama_pengepul){
        this.nama_pengepul = nama_pengepul;
    }
    public String getBerat(){
        return berat;
    }
    public void setBerat(String berat){
        this.berat = berat;
    }
    public String getTotal_harga(){
        return total_harga;
    }
    public void setTotal_harga(String total_harga){
        this.total_harga = total_harga;
    }
    public String getHarga_sampah(){
        return harga_sampah;
    }
    public void setHarga_sampah(String harga_sampah){
        this.harga_sampah = harga_sampah;
    }
    //Penarikan
    private String id_penarikan;
    private String tanggal_penarikan;
    private String saldo_penarikan;
    public String getId_penarikan(){
        return id_penarikan;
    }
    public void setId_penarikan(String id_penarikan){
        this.id_penarikan = id_penarikan;
    }
    public String getTanggal_penarikan(){
        return tanggal_penarikan;
    }
    public void setTanggal_penarikan(String tanggal_penarikan){
        this.tanggal_penarikan = tanggal_penarikan;
    }
    public String getSaldo_penarikan(){
        return saldo_penarikan;
    }
    public void setSaldo_penarikan(String saldo_penarikan){
        this.saldo_penarikan = saldo_penarikan;
    }
    
    //Saldo
    private String id_saldo;
    private String tgl_simpan;
    private String jumlah_sampah;
    private String total_sampah;
    public String getId_saldo(){
        return id_saldo;
    }
    public void setId_saldo(String id_saldo){
        this.id_saldo = id_saldo;
    }
    public String getTgl_simpan(){
        return tgl_simpan;
    }
    public void setTgl_simpan(String tgl_simpan){
        this.tgl_simpan = tgl_simpan;
    }
    public String getJumlah_sampah(){
        return jumlah_sampah;
    }
    public void setJumlah_sampah(String jumlah_sampah){
        this.jumlah_sampah = jumlah_sampah;
    }
    public String getTotal_sampah(){
        return total_sampah;
    }
    public void setTotal_sampah(String total_sampah){
        this.total_sampah = total_sampah;
    }
}
