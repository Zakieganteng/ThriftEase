package Database;

import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("AccountInfo")
public class AllAkun {
    
    @XStreamImplicit
    private ArrayList<Akun> allThriftEaseAccounts = new ArrayList<>();

    public ArrayList<Akun> getThriftEaseAccounts() {
        return allThriftEaseAccounts;
    }

    public void setThriftEaseAccounts(ArrayList<Akun> allThriftEaseAccounts) {
        this.allThriftEaseAccounts = allThriftEaseAccounts;
    }
}