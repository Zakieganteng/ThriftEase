package HalamanLogin;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginpagecontroller implements Initializable {

    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    private Scene scene;
    @FXML
    public void  keHalamanLogin(ActionEvent event) throws IOException {
       root = FXMLLoader.load(getClass().getClassLoader().getResource("Account/loginpage.fxml"));
       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }
    @FXML
    public void  keHalamanSignup(ActionEvent event) throws IOException {
       root = FXMLLoader.load(getClass().getClassLoader().getResource("HalamanSignup/signuppage.fxml"));
       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }
    @FXML
    public void  keHalamanProfile(ActionEvent event) throws IOException {
       root = FXMLLoader.load(getClass().getClassLoader().getResource(""));
       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}