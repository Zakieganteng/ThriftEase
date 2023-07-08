package updateproduct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import Database.Akun;
import Database.AllBarang;
import Database.Barang;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class updatecontroller implements Initializable {


    @FXML
    private void tambahdata(ActionEvent event){
        Barang tambahnew = new Barang();
        tambahnew.setNamaBarang();

        tambahnew.setKondisiBarang();
        tambahnew.setKategoriBarang();
        tambahnew.setKeranjang(false);
        tambahnew.setHargaBarang("Rp. " +);

        barang.getThriftEaseBarang().add(tambahnew);

        xmlupdate();
    }

    
    @FXML
    private void xmlupdate() {

        XStream xstream = new XStream(new StaxDriver());
       xstream.processAnnotations(Barang.class);
        xstream.processAnnotations(AllBarang.class);

       
        AllBarang datain = new AllBarang();

        datain = barang;




        String xml = xstream.toXML(datain);
        FileOutputStream myFile = null;
        try {
            String folderPath = "src\\Database";
                String fileName = "BaseBarang.xml";
                String filePath = folderPath + File.separator + fileName;
            myFile = new FileOutputStream(filePath);
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


    AllBarang barang = new AllBarang();
    @FXML
    private void updatebarang() {

        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(Akun.class);
        xstream.processAnnotations(AllBarang.class);
        xstream.ignoreUnknownElements();
        FileInputStream getFile = null;
        String readXML = "";
        try {
            getFile = new FileInputStream("src\\Database\\BaseBarang.xml");
            readXML = xmlToString(getFile);
        } catch (Exception e) {
            System.err.println("Perhatian:"  + e.getMessage());
        } finally {
            if (getFile != null) {
                try {
                    getFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        AllBarang datatmp = (AllBarang) xstream.fromXML(readXML);
        barang = datatmp;

        
    }

    public static String xmlToString(FileInputStream xmlFile) {
       int isiFile;
       char myChar;
       String myString = "";
       try {
          while ((isiFile = xmlFile.read()) != -1) {
               myChar = (char) isiFile;
               myString = myString + myChar;
          }
       } catch (IOException e) {
          e.printStackTrace();
       }
       return myString;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updatebarang();
    }
}
