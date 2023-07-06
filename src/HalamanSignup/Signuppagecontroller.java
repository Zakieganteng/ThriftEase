package HalamanSignup;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Signuppagecontroller implements Initializable {

    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    private Scene scene;

    @FXML
    private TextField email;

    @FXML
    private PasswordField finalpassword;

    @FXML
    private PasswordField newpassword;

    @FXML
    private TextField newuserrname;

    @FXML
    private Label showwarnnotcomp;



    @FXML
    private void signup(ActionEvent event) throws IOException{
        Akun mosignup = new Akun();

        if (newuserrname.getText().equals ("") || newpassword.getText().equals("")) {
            showwarnnotcomp.setVisible(true);
            
        } else {
            
            showwarnnotcomp.setVisible(false);
            mosignup.setNama(newuserrname.getText());
            mosignup.setPassword(newpassword.getText());
            mosignup.setEmail(email.getText());
            productifseller.getThriftEaseAccounts().add(mosignup);
    
            xmlupdate();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("CSS/FXMLDocument.fxml"));
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
        }

    }

    @FXML
    private void xmlupdate() {

        XStream xstream = new XStream(new StaxDriver());
       xstream.processAnnotations(Akun.class);
        xstream.processAnnotations(AllAkun.class);

       
        AllAkun datain = new AllAkun();

        datain = productifseller;




        String xml = xstream.toXML(datain);
        FileOutputStream myFile = null;
        try {
            String folderPath = "src\\Database";
                String fileName = "Accountbase.xml";
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


    AllAkun productifseller = new AllAkun();
    @FXML
    private void updatebarang() {

        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(Akun.class);
        xstream.processAnnotations(AllAkun.class);
        xstream.ignoreUnknownElements();
        FileInputStream getFile = null;
        String readXML = "";
        try {
            getFile = new FileInputStream("src\\Database\\Accountbase.xml");
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
        AllAkun datatmp = (AllAkun) xstream.fromXML(readXML);
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
    
    @FXML
    public void  keHalamanUtama(ActionEvent event) throws Exception {
       root = FXMLLoader.load(getClass().getClassLoader().getResource("CSS/FXMLDocument.fxml"));
       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updatebarang();
    }
}