// Superclass ProdukRoti
public class ProdukRoti {
    private String kode;
    private String nama;
    private double harga;

    // Constructor berparameter
    public ProdukRoti(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    // Getter Setter (Encapsulation)
    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    // Method tambahan
    public void tampilkanInfo() {
        System.out.println("Kode  : " + kode);
        System.out.println("Nama  : " + nama);
        System.out.println("Harga : Rp" + harga);
    }

    public String kategori() {
        return "Umum";
    }
}
