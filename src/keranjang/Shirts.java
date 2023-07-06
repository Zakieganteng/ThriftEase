package keranjang;

public class Shirts {
    private String namaBarang;
    private String kondisiBarang;
    private String hargaBareng;

    public Shirts(String namaBarang, String kondisiBarang, String hargaBareng) {
        this.namaBarang = namaBarang;
        this.kondisiBarang = kondisiBarang;
        this.hargaBareng = hargaBareng;
    }

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

    public String getHargaBareng() {
        return hargaBareng;
    }

    public void setHargaBareng(String hargaBareng) {
        this.hargaBareng = hargaBareng;
    }
}

