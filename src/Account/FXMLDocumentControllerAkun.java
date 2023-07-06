package Account;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;



public class FXMLDocumentControllerAkun implements Initializable {

@FXML
private Button LoginButton;  
@FXML
private Label wrongUN;
@FXML
private Label wrongPass;
@FXML
private TextField username;
@FXML
private PasswordField password;
@FXML
private Stage stage;
@FXML
private Parent root;
private Scene scene;
@FXML
public ImageView potologo;

@FXML
public void LoginButton(ActionEvent event) throws Exception {
 root = FXMLLoader.load(getClass().getClassLoader().getResource("CSS/FXMLDocument.fxml"));
       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
}
@FXML
public void SignupButton(ActionEvent event) throws Exception {
 root = FXMLLoader.load(getClass().getClassLoader().getResource("HalamanSignup/signuppage.fxml"));
       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();

}
@FXML
public void wrongButton(ActionEvent event){
}

 @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }    
}


