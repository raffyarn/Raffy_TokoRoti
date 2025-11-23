public class RotiTawar extends ProdukRoti {
    private String jenisPaket;

    public RotiTawar(String kode, String nama, double harga, String jenisPaket) {
        super(kode, nama, harga);
        this.jenisPaket = jenisPaket;
    }

    public String getJenisPaket() { return jenisPaket; }
    public void setJenisPaket(String jenisPaket) { this.jenisPaket = jenisPaket; }

    @Override
    public String kategori() {
        return "Roti Tawar";
    }

    public void infoTawar() {
        System.out.println("Jenis Paket : " + jenisPaket);
    }
}
