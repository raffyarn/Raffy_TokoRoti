import java.util.ArrayList;

public class Penjualan {
    private final ArrayList<ProdukRoti> daftarRoti = new ArrayList<>();
    private final String kodeTransaksi;

    public Penjualan(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    // Tambah roti ke transaksi
    public void tambahRoti(ProdukRoti roti) {
        daftarRoti.add(roti);
    }

    // Hitung total harga
    public double totalHarga() {
        double total = 0;
        for (ProdukRoti r : daftarRoti) {
            total += r.getHarga();
        }
        return total;
    }

    // Tampilkan isi transaksi
    public void tampilkanTransaksi() {
        System.out.println("\n=== TRANSAKSI " + kodeTransaksi + " ===");
        for (ProdukRoti r : daftarRoti) {
            System.out.println(r.getKode() + " - " + r.getNama() + " (Rp " + r.getHarga() + ")");
        }
        System.out.println("Total Harga: Rp" + totalHarga());
    }
}
