package Database;

import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("AccountInfo")
public class AllBarang {
    
    @XStreamImplicit
    private ArrayList<Barang> allThriftEaseBarang = new ArrayList<>();

    public ArrayList<Barang> getThriftEaseBarang() {
        return allThriftEaseBarang;
    }

    public void setThriftEaseBarang(ArrayList<Barang> allThriftEaseBarang) {
        this.allThriftEaseBarang = allThriftEaseBarang;
    }
}