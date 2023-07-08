package keranjang;

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
import Database.AllAkun;
import Database.AllBarang;
import Database.Barang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class shirt implements Initializable {

    @FXML
    private TableView<Shirts> keranjanglist;

    @FXML
    private TableColumn<Shirts, String> HargaBareng;

    @FXML
    private TableColumn<Shirts, String> KondisiBarang;

    @FXML
    private TableColumn<Shirts, String> NamaBarang;

    private ObservableList<Shirts> data = FXCollections.observableArrayList(
    );

    @FXML
    private void deleteRow() {
        Shirts selectedShirt = keranjanglist.getSelectionModel().getSelectedItem();

        if (selectedShirt != null) {
            data.remove(selectedShirt);

            for (int i = 0; i < productifseller.getThriftEaseBarang().size(); i++) {

            if (productifseller.getThriftEaseBarang().get(i).getNamaBarang().equals(selectedShirt.getNamaBarang())) {
                
                productifseller.getThriftEaseBarang().get(i).setKeranjang(false);
                xmlupdate();
            }
            
        }

            

            
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updatebarang();

        for (int i = 0; i < productifseller.getThriftEaseBarang().size(); i++) {

            if (productifseller.getThriftEaseBarang().get(i).getKeranjang()) {
                
                data.add(new Shirts(productifseller.getThriftEaseBarang().get(i).getNamaBarang(), productifseller.getThriftEaseBarang().get(i).getKondisiBarang(), productifseller.getThriftEaseBarang().get(i).getHargaBarang()));
            }
            
        }
        // Set up the cell value factories for each column
        NamaBarang.setCellValueFactory(new PropertyValueFactory<>("namaBarang"));
        KondisiBarang.setCellValueFactory(new PropertyValueFactory<>("kondisiBarang"));
        HargaBareng.setCellValueFactory(new PropertyValueFactory<>("hargaBareng"));

        

        keranjanglist.setItems(data);

        // Set the data to the table
        // keranjangList.setItems(data);
    }

     @FXML
    private void xmlupdate() {

        XStream xstream = new XStream(new StaxDriver());
       xstream.processAnnotations(Barang.class);
        xstream.processAnnotations(AllBarang.class);

       
        AllBarang datain = new AllBarang();

        datain = productifseller;




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


    AllBarang productifseller = new AllBarang();
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
        productifseller = datatmp;

        
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
    

    // Add other methods and event handlers as needed
}
