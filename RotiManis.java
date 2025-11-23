public class RotiManis extends ProdukRoti {
    private String rasa;

    public RotiManis(String kode, String nama, double harga, String rasa) {
        super(kode, nama, harga);
        this.rasa = rasa;
    }

    public String getRasa() { return rasa; }
    public void setRasa(String rasa) { this.rasa = rasa; }

    @Override
    public String kategori() {
        return "Roti Manis";
    }

    public void infoRasa() {
        System.out.println("Rasa : " + rasa);
    }
}
