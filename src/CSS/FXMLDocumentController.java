package CSS;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField search;
    @FXML
    private Label label;
    @FXML
    private MenuButton menubutshow;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    private Scene scene;
    @FXML
    private AnchorPane MenShow;
    
    @FXML
    private void keHalaman1(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman=object.getPane("Beranda/beranda");
        MenShow.getChildren().setAll(halaman);
    }
    
    @FXML
    private void keHalaman2(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman=object.getPane("keranjang/Shirt");
        MenShow.getChildren().setAll(halaman);
    }
    
    @FXML
    private void keHalaman3(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman=object.getPane("updateproduct/updateproduct");
        MenShow.getChildren().setAll(halaman);
    }

    @FXML
    private void keHalaman4(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman=object.getPane("HalamanLogin/accountpage");
        MenShow.getChildren().setAll(halaman);
    }
    
    
    // @FXML
    // private void keHalamanlogin(ActionEvent event) throws IOException {
    //     System.out.println("kepencet");

    //     root = FXMLLoader.load(getClass().getClassLoader().getResource("Account/FXMLDocument.fxml"));
    //    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //    scene = new Scene(root);
    //    stage.setScene(scene);
    //    stage.show();
    // }

    // @FXML
    // public void pindahkelogin(ActionEvent event) throws IOException {
    //    root = FXMLLoader.load(getClass().getClassLoader().getResource("Account\\FXMLDocumentLogin.fxml"));
    //    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //    scene = new Scene(root);
    //    stage.setScene(scene);
    //    stage.show();
    // }

    // @FXML
    // public void tologin(ActionEvent event) throws IOException {
    //    root = FXMLLoader.load(getClass().getClassLoader().getResource("CSS\\loginpage.fxml"));
    //    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //    scene = new Scene(root);
    //    stage.setScene(scene);
    //    stage.show();
    // }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
