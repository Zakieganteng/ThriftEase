package Beranda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import CSS.OpenScene;
import Database.Akun;
import Database.AllBarang;
import Database.Barang;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class BerandaController implements Initializable{

    @FXML
    private Button buttonshirt00;

    @FXML
    private void buttonshirt00(){
        Barang newlist = new Barang();

        newlist.setNamaBarang("Backhit Holy Land");
        newlist.setKondisiBarang("Very Good Condition");

        newlist.setHargaBarang("Rp 130.000");

        productifseller.getThriftEaseBarang().add(newlist);

        xmlupdate();

    }
    @FXML
    private void buttonshirt10(){
        Barang newlist = new Barang();

        newlist.setNamaBarang("Backhit Tshirts");
        newlist.setKondisiBarang("Very Good Condition");

        newlist.setHargaBarang("Rp 145.000");

        productifseller.getThriftEaseBarang().add(newlist);
        xmlupdate();

    }
    @FXML
    private void buttonshirt20(){
        Barang newlist = new Barang();

        newlist.setNamaBarang("Backhit Nasa");
        newlist.setKondisiBarang("Good Condition");

        newlist.setHargaBarang("Rp 100.000");

        productifseller.getThriftEaseBarang().add(newlist);
        xmlupdate();

    }

    @FXML
    private Button buttonshirt10;

    @FXML
    private Button buttonshirt20;

    @FXML
    private ScrollPane beranda;

    @FXML
    private ScrollPane halpromo;

    @FXML
    private ScrollPane halshirt;

     @FXML
    private ScrollPane halsweater;

    @FXML
    private ScrollPane haljacket;

    @FXML
    private ScrollPane halshort;

    @FXML
    private ScrollPane hallong;

     @FXML
    private ScrollPane halskirt;

     @FXML
    private void keHalamanberanda(ActionEvent event) {
        halpromo.setVisible(false);
        beranda.setVisible(true);
        halshirt.setVisible(false);
        halsweater.setVisible(false);
        haljacket.setVisible(false);
        halshort.setVisible(false);
        hallong.setVisible(false);
        halskirt.setVisible(false);
    }

    @FXML
    private void keHalamanpromo(ActionEvent event) {
        halpromo.setVisible(true);
        beranda.setVisible(false);
        halshirt.setVisible(false);
        halsweater.setVisible(false);
        haljacket.setVisible(false);
        halshort.setVisible(false);
        hallong.setVisible(false);
        halskirt.setVisible(false);
    }

     @FXML
    private void keHalamanshirt(ActionEvent event) {
        halpromo.setVisible(false);
        beranda.setVisible(false);
        halshirt.setVisible(true);
        halsweater.setVisible(false);
        haljacket.setVisible(false);
        halshort.setVisible(false);
        hallong.setVisible(false);
        halskirt.setVisible(false);
    }

    @FXML
    private void keHalamansweater(ActionEvent event) {
        halpromo.setVisible(false);
        beranda.setVisible(false);
        halshirt.setVisible(false);
        halsweater.setVisible(true);
        haljacket.setVisible(false);
        halshort.setVisible(false);
        hallong.setVisible(false);
        halskirt.setVisible(false);
    }

    @FXML
    private void keHalamanjacket(ActionEvent event) {
        halpromo.setVisible(false);
        beranda.setVisible(false);
        halshirt.setVisible(false);
        halsweater.setVisible(false);
        haljacket.setVisible(true);
        halshort.setVisible(false);
        hallong.setVisible(false);
        halskirt.setVisible(false);
    }

     @FXML
    private void keHalamanshort(ActionEvent event) {
        halpromo.setVisible(false);
        beranda.setVisible(false);
        halshirt.setVisible(false);
        halsweater.setVisible(false);
        haljacket.setVisible(false);
        halshort.setVisible(true);
        hallong.setVisible(false);
        halskirt.setVisible(false);
    }

    @FXML
    private void keHalamanlong(ActionEvent event) {
        halpromo.setVisible(false);
        beranda.setVisible(false);
        halshirt.setVisible(false);
        halsweater.setVisible(false);
        haljacket.setVisible(false);
        halshort.setVisible(false);
        hallong.setVisible(true);
        halskirt.setVisible(false);
    }

     @FXML
    private void keHalamanskirt(ActionEvent event) {
        halpromo.setVisible(false);
        beranda.setVisible(false);
        halshirt.setVisible(false);
        halsweater.setVisible(false);
        haljacket.setVisible(false);
        halshort.setVisible(false);
        hallong.setVisible(false);
        halskirt.setVisible(true);
    }

    @FXML
    private void shirt1(ActionEvent event) {



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
    // @FXML
    // private void updatebarang() {

    //     XStream xstream = new XStream(new StaxDriver());
    //     xstream.addPermission(AnyTypePermission.ANY);
    //     xstream.processAnnotations(Akun.class);
    //     xstream.processAnnotations(AllBarang.class);
    //     xstream.ignoreUnknownElements();
    //     FileInputStream getFile = null;
    //     String readXML = "";
    //     try {
    //         getFile = new FileInputStream("src\\Database\\BaseBarang.xml");
    //         readXML = xmlToString(getFile);
    //     } catch (Exception e) {
    //         System.err.println("Perhatian:"  + e.getMessage());
    //     } finally {
    //         if (getFile != null) {
    //             try {
    //                 getFile.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    //     AllBarang datatmp = (AllBarang) xstream.fromXML(readXML);
    //     productifseller = datatmp;

        
    // }

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
        
       
    }    
}
