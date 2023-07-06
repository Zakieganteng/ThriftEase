package HalamanSignup;

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
import javafx.stage.Stage;

public class Signuppagecontroller implements Initializable {

    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    private Scene scene;
    
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
    }
}