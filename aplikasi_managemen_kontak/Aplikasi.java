import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Aplikasi {
    private static final String NAMA_FILE = "kontak.csv";
    private static ArrayList<Kontak> daftarKontak = new ArrayList<>(); // Pindahkan deklarasi di sini

    private static void simpanKontakKeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NAMA_FILE))) {
            for (Kontak kontak : daftarKontak) {
                writer.write(kontak.getNama() + "," + kontak.getNomorTelepon() + "," + kontak.getEmail());
                writer.newLine();
            }
            System.out.println("Kontak berhasil disimpan ke dalam file.");
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menyimpan kontak ke dalam file.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("Menu Aplikasi Manajemen Kontak:");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Hapus Kontak berdasarkan Nama");
            System.out.println("3. Hapus Kontak berdasarkan Nomor Telepon");
            System.out.println("4. Tampilkan Daftar Kontak");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membuang newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Nomor Telepon: ");
                    String nomorTelepon = scanner.nextLine();
                    System.out.print("Masukkan Email: ");
                    String email = scanner.nextLine();
                    Kontak kontakBaru = new Kontak(nama, nomorTelepon, email);
                    daftarKontak.add(kontakBaru);
                    System.out.println("====== Kontak berhasil ditambahkan! =====");
                     simpanKontakKeFile(); // Menyimpan kontak ke dalam file sebelum keluar
                    break;
                case 2:
                    System.out.print("Masukkan Nama Kontak yang akan dihapus: ");
                    String namaHapus = scanner.nextLine();
                    for (Kontak kontak : daftarKontak) {
                        if (kontak.getNama().equalsIgnoreCase(namaHapus)) {
                            daftarKontak.remove(kontak);
                            System.out.println("===== Kontak berhasil dihapus! =====");
                            break;
                        }
                    }
                     simpanKontakKeFile(); // Menyimpan kontak ke dalam file sebelum keluar
                    break;
                case 3:
                    System.out.print("Masukkan Nomor Telepon Kontak yang akan dihapus: ");
                    String nomorTeleponHapus = scanner.nextLine();
                    daftarKontak.removeIf(kontak -> kontak.getNomorTelepon().equals(nomorTeleponHapus));
                    System.out.println("Kontak berhasil dihapus!");
                    break;
                case 4:
                    System.out.println("==============");
                    System.out.println("Daftar Kontak:");
                    System.out.println("==============");
                    for (Kontak kontak : daftarKontak) {
                        System.out.println(kontak);
                        System.out.println("===========");
                    }
                    break;
                case 5:
                    simpanKontakKeFile(); // Menyimpan kontak ke dalam file sebelum keluar
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}

class Kontak {
    private String nama;
    private String nomorTelepon;
    private String email;

    public Kontak(String nama, String nomorTelepon, String email) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + "\nNomor Telepon: " + nomorTelepon + "\nEmail: " + email;
    }
}
