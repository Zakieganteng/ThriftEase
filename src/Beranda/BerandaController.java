package Beranda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BerandaController implements Initializable{

    @FXML
    private GridPane ShirtGrid;

    @FXML
    private Button buttonshirt00;

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

        datain = barangshirt;




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


    AllBarang barangshirt = new AllBarang();
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
        barangshirt = datatmp;

        
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


    @FXML
    private void handleGridClickothers(MouseEvent event) throws IOException {
        int numCols = ((GridPane) event.getSource()).getColumnCount();
        int numRows = ((GridPane) event.getSource()).getRowCount();

        double cellWidth = ((GridPane) event.getSource()).getWidth() / numCols;
        double cellHeight = ((GridPane) event.getSource()).getHeight() / numRows;

        int clickedCol = (int) (event.getX() / cellWidth);
        int clickedRow = (int) (event.getY() / cellHeight);

        System.out.println("clik " + clickedCol + " " +clickedRow);

        // XStream xstream = new XStream(new StaxDriver());
        // xstream.processAnnotations(Barang.class);
        // xstream.processAnnotations(AllBarang.class);

        // AllBarang datain = new AllBarang();
        // datain.getRefoodBarang().add(datagridothers.get(clickedRow).get(clickedCol));
        

     


        // String xml = xstream.toXML(datain);
        // FileOutputStream myFile = null;
        // try {
        //     String folderPath = "src\\PageSeeProduct";
        //         String fileName = "seeproduct.xml";
        //         String filePath = folderPath + File.separator + fileName;
        //     myFile = new FileOutputStream(filePath);
        //     byte[] bytes = xml.getBytes("UTF-8");
        //     myFile.write(bytes);
        // } catch (Exception e) {
        //     System.err.println("Perhatian: " + e.getMessage());
        // } finally {
        //     if (myFile != null) {
        //         try {
        //             myFile.close();
        //         } catch (IOException e) {
        //             e.printStackTrace();
        //         }
        //     }
        // }

    //   ToSeeprod();



    }





    
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        updatebarang();

         try {
                int roindexnew = 0;
                int coindexnew = 0;
                // datagridnew.add(new ArrayList<>());

                
                HashSet<Integer> generatedNumbers = new LinkedHashSet<>();
                int min = 0;
                int max = barangshirt.getThriftEaseBarang().size()-1;

                // harus di perbaiki ketika barang sudah mencapai angka lebih dari 30 barang yang ada pada getrefood
                int jumlahonothers = 12;
    
                while (generatedNumbers.size() < 12) {
                    int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
                    generatedNumbers.add(randomNumber);
                }
    
                for (int i : generatedNumbers) {

                    if (barangshirt.getThriftEaseBarang().get(i).getKategoriBarang().equals("Shirt")) {

                        final int index = i;
                        
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Display/display.fxml"));
                        AnchorPane item = loader.load();
            
                        // Set different text for each label
                        Label nameLabel = (Label) item.lookup("#NamaShirt");
                        nameLabel.setText(barangshirt.getThriftEaseBarang().get(i).getNamaBarang());
            
                        Label banyakPenjualanLabel = (Label) item.lookup("#KualitasShirt");
                        banyakPenjualanLabel.setText( barangshirt.getThriftEaseBarang().get(i).getKondisiBarang());
                        Label Penjual = (Label) item.lookup("#HargaShirt");
                        Penjual.setText( barangshirt.getThriftEaseBarang().get(i).getHargaBarang());

                        Button keranjang = (Button) item.lookup("#masukKeranjang");

                        keranjang.setOnAction(event -> {
                            System.out.println(nameLabel.getText());;
                            barangshirt.getThriftEaseBarang().get(index).setKeranjang(true);
                            xmlupdate();
                        });
        
                        // ImageView imageView = (ImageView) item.lookup("#imageproduct");
                        // Image image = new Image(getClass().getClassLoader().getResourceAsStream(barangdatashow.getRefoodBarang().get(i).getFotoproduk()));
                        // imageView.setImage(image);
            
                        ShirtGrid.add(item, coindexnew, roindexnew);
    
                    
                        // datagridnew.get(0).add(barangdatashow.getRefoodBarang().get(i));
                        coindexnew++;
    
                        if (coindexnew > 2) {
                            roindexnew++;
                            coindexnew = 0;
                            
                        }
                        // coindex++;
                    }
                    
        
                    
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("salah disini dapa");
            }
        
       
    }    
}
