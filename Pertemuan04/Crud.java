package Pertemuan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud {

    Connection conn;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/PBO";
    String user = "postgres";
    String password = "Ela200705";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public void tambah() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false); // Nonaktifkan otomatis commit

            String sql = "INSERT INTO pesanan (id_pesanan, menu_makanan,harga, qty) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            boolean selesai = false;
            while (!selesai) {

                System.out.println("MASUKKAN DATA PESANAN ");
                System.out.print("Id_pesanan : ");
                String id_pesanan = input.readLine().trim();
                System.out.print("menu_makanan : ");
                String menu_makanan = input.readLine().trim();
                System.out.print("harga : ");
                String harga = input.readLine().trim();
                System.out.print("Qty : ");
                String qty = input.readLine().trim();

                pstmt.setString(1, id_pesanan);
                pstmt.setString(2, menu_makanan);
                pstmt.setString(3, harga);
                pstmt.setString(4, qty);
                pstmt.executeUpdate();

                System.out.print("Apakah Anda ingin memasukkan data pesanan lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true; // Ubah ke true agar loop berhenti jika tidak ingin memasukkan data lagi
                }
            }

            conn.commit(); // Commit transaksi setelah sejumlah operasi-insert berhasil
            System.out.println("Penambahan data telah sukses.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {

            System.out.println("Terjadi kesalahan saat melakukan penambahan data.");
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // Batalkan transaksi jika terjadi kesalahan
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback pemesanan.");
                e.printStackTrace();
            }
        }
    }

    public void tampil() {
        try {
            Class.forName(driver);
            String sql = "SELECT * FROM pesanan";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void hapus() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);

            System.out.print("Masukkan id_pesanan yang akan dihapus : ");
            String id_pesanan = input.readLine().trim();

            String deleteSql = "DELETE FROM pesanan WHERE id_pesanan = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, id_pesanan);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Penghapusan berhasil untuk id pesanan " + id_pesanan + "!");
            } else {
                System.out.println("id pesanan " + id_pesanan + " tidak ada.");
            }

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        try {
            Class.forName(driver);
            String sql = "UPDATE pesanan SET menu_makanan = ?,harga = ?, qty = ? WHERE id_pesanan = ?";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);

            System.out.print("Masukkan id pesanan yang akan diupdate : ");
            String id_pesanan = input.readLine().trim();
            System.out.print("Menu_makanan baru : ");
            String menu_makananBaru = input.readLine().trim();
            System.out.print("Harga baru : ");
            String hargaBaru = input.readLine().trim();
            System.out.print("qty baru : ");
            String qtyBaru = input.readLine().trim();

            pstmt.setString(1, menu_makananBaru);
            pstmt.setString(2, hargaBaru);
            pstmt.setString(3, qtyBaru);
            pstmt.setString(4, id_pesanan);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil diupdate.");
            } else {
                System.out.println("Data tidak ditemukan.");
            }

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n========= MENU UTAMA =========");
            System.out.println("1. Input Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Update Data");
            System.out.println("0. Keluar");
            System.out.print("PILIHAN> ");

            try {
                int pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 0:
                        exit = true; // Set exit menjadi true untuk keluar dari loop
                        break;
                    case 1:
                        tambah();
                        break;
                    case 2:
                        tampil();
                        break;
                    case 3:
                        hapus();
                        break;
                    case 4:
                        update();
                        break;
                    default:
                        System.out.println("Pilihan salah! Silakan pilih antara 0-4.");
                }
            } catch (IOException e) {
                Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, "Kesalahan saat membaca input", e);
                System.out.println("Kesalahan input, silakan coba lagi.");
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
            }
        }
        System.out.println("Program telah selesai."); // Pesan saat keluar dari program
    }

    public static void main(String[] args) {
        new Crud().menu();
    }
}
