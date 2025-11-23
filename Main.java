import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<ProdukRoti> dataRoti = new ArrayList<>();

    public static void main(String[] args) {
        
        // DATA DEFAULT
        dataRoti.add(new RotiTawar("RT01", "Tawar Kupas", 15000, "Paket Regular"));
        dataRoti.add(new RotiTawar("RT02", "Tawar Gandum", 18000, "Paket Premium"));
        dataRoti.add(new RotiManis("RM01", "Roti Coklat", 12000, "Coklat"));
        dataRoti.add(new RotiManis("RM02", "Roti Keju", 13000, "Keju"));

        int pilih;
        do {
            System.out.println("\n=======================================");
            System.out.println("          APLIKASI TOKO ROTI");
            System.out.println("=======================================");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Ubah Data");
            System.out.println("5. Cek Status (Total Data)");
            System.out.println("6. Simulasi Penjualan");
            System.out.println("7. Hapus Data");
            System.out.println("8. Urutkan Berdasarkan Harga");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1: tambahData(); break;
                case 2: tampilkanData(); break;
                case 3: cariData(); break;
                case 4: ubahData(); break;
                case 5: cekStatus(); break;
                case 6: simulasiPenjualan(); break;
                case 7: hapusData(); break;
                case 8: urutkanHarga(); break;
            }

        } while (pilih != 0);
    }
    //  VALIDASI KODE DUPLIKAT
    static boolean cekKodeDuplikat(String kode) {
        for (ProdukRoti r : dataRoti) {
            if (r.getKode().equalsIgnoreCase(kode)) {
                return true;
            }
        }
        return false;
    }
    // TAMBAH DATA
    static void tambahData() {
    System.out.println("\n1. Roti Tawar\n2. Roti Manis");
    System.out.print("Pilih jenis roti: ");
    int jenis = input.nextInt();
    input.nextLine(); // flush newline

    System.out.print("Kode: ");
    String kode = input.nextLine();

    if (cekKodeDuplikat(kode)) {
        System.out.println("Kode sudah terpakai!");
        return;
    }

    System.out.print("Nama: ");
    String nama = input.nextLine();

    System.out.print("Harga: ");
    double harga = input.nextDouble();
    input.nextLine(); // flush

    if (jenis == 1) {
        System.out.print("Jenis Paket: ");
        String paket = input.nextLine();
        dataRoti.add(new RotiTawar(kode, nama, harga, paket));

    } else if (jenis == 2) {
        System.out.print("Rasa: ");
        String rasa = input.nextLine();
        dataRoti.add(new RotiManis(kode, nama, harga, rasa));
    }

    System.out.println("Data berhasil ditambahkan!");
}
    // TAMPILKAN DATA
    static void tampilkanData() {
    System.out.println("\n=======================================");
    System.out.println("             DATA PRODUK ROTI");
    System.out.println("=======================================");

    if (dataRoti.isEmpty()) {
        System.out.println("Tidak ada data roti.");
        return;
    }

    for (ProdukRoti r : dataRoti) {
        System.out.println("---------------------------------------");
        System.out.println("Kode   : " + r.getKode());
        System.out.println("Nama   : " + r.getNama());
        System.out.println("Harga  : Rp " + r.getHarga());
        System.out.println("Jenis  : " + r.kategori());

        if (r instanceof RotiTawar) {
            System.out.println("Paket  : " + ((RotiTawar) r).getJenisPaket());
        } else if (r instanceof RotiManis) {
            System.out.println("Rasa   : " + ((RotiManis) r).getRasa());
        }
    }

    System.out.println("---------------------------------------");
}
    // CARI DATA
    static void cariData() {
    System.out.print("\nMasukkan kode roti: ");
    String kode = input.next();

    for (ProdukRoti r : dataRoti) {
        if (r.getKode().equalsIgnoreCase(kode)) {

            System.out.println("\n=======================================");
            System.out.println("            DATA DITEMUKAN");
            System.out.println("=======================================");

            r.tampilkanInfo();

            if (r instanceof RotiTawar) {
                ((RotiTawar) r).infoTawar();
            } else if (r instanceof RotiManis) {
                ((RotiManis) r).infoRasa();
            }

            System.out.println("=======================================");
            return;
        }
    }

    System.out.println("Data tidak ditemukan.");
}

    // UBAH DATA
    static void ubahData() {
    System.out.print("Masukkan kode roti yang akan diubah: ");
    String kode = input.next();

    for (ProdukRoti r : dataRoti) {
        if (r.getKode().equalsIgnoreCase(kode)) {

            input.nextLine();  // FIX newline!!!

            System.out.print("Nama baru: ");
            r.setNama(input.nextLine());

            System.out.print("Harga baru: ");
            r.setHarga(Double.parseDouble(input.nextLine()));

            System.out.println("Data berhasil diubah!");
            return;
        }
    }

    System.out.println("Data tidak ditemukan.");
}

    // HAPUS DATA
    static void hapusData() {
        System.out.print("Masukkan kode roti yang akan dihapus: ");
        String kode = input.next();

        for (ProdukRoti r : dataRoti) {
            if (r.getKode().equalsIgnoreCase(kode)) {
                dataRoti.remove(r);
                System.out.println("Data berhasil dihapus!");
                return;
            }
        }

        System.out.println("Data tidak ditemukan.");
    }
    // STATUS DATA (JUMLAH)
    static void cekStatus() {
        System.out.println("Total data roti: " + dataRoti.size());
    }
    // URUTKAN DATA
    static void urutkanHarga() {
        dataRoti.sort((a, b) -> Double.compare(a.getHarga(), b.getHarga()));
        System.out.println("Data berhasil diurutkan berdasarkan harga.");
    }
    // SIMULASI PENJUALAN
    static void simulasiPenjualan() {
        Penjualan p = new Penjualan("TRX001");

        System.out.print("Berapa item roti yang dibeli? ");
        int jml = input.nextInt();

        for (int i = 0; i < jml; i++) {
            System.out.print("Masukkan kode roti: ");
            String kode = input.next();

            for (ProdukRoti r : dataRoti) {
                if (r.getKode().equalsIgnoreCase(kode)) {
                    p.tambahRoti(r);
                }
            }
        }

        p.tampilkanTransaksi();
    }
}
