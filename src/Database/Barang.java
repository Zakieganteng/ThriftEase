package Database;

public class Barang {

    private String pathpict;

    private Boolean keranjang;
    public Boolean getKeranjang() {
        return keranjang;
    }
    public void setKeranjang(Boolean keranjang) {
        this.keranjang = keranjang;
    }
    public String getPathpict() {
        return pathpict;
    }
    public void setPathpict(String pathpict) {
        this.pathpict = pathpict;
    }
    private String KategoriBarang;
    private String namaBarang;
    public String getKategoriBarang() {
        return KategoriBarang;
    }
    public void setKategoriBarang(String kategoriBarang) {
        KategoriBarang = kategoriBarang;
    }
    private String kondisiBarang;
    private String hargaBarang;
    public String getNamaBarang() {
        return namaBarang;
    }
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    public String getKondisiBarang() {
        return kondisiBarang;
    }
    public void setKondisiBarang(String kondisiBarang) {
        this.kondisiBarang = kondisiBarang;
    }
    public String getHargaBarang() {
        return hargaBarang;
    }
    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
    
}
