package Database;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class MakeBarangBase {
    public static void main(String[] args) {
        XStream xstream = new XStream(new StaxDriver());
        
        
        xstream.processAnnotations(Barang.class);
        xstream.processAnnotations(AllBarang.class);

        AllBarang dataAll = new AllBarang();

        Barang test1 = new Barang();


       test1.setNamaBarang("TOPIBUNDAR");
       test1.setKondisiBarang("Bagus");
       test1.setHargaBarang("200.000");


        dataAll.getThriftEaseBarang().add(test1);
        


    
    
        String xml = xstream.toXML(dataAll);
        FileOutputStream myFile = null;
        try {
            myFile = new FileOutputStream("src/Database/BaseBarang.xml");
            byte[] bytes = xml.getBytes("UTF-8");
            myFile.write(bytes);
        } catch (Exception e) {
            System.err.println("Perhatian: " + e.getMessage());
        } finally {
            if (myFile != null) {
                try {
                    myFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
}