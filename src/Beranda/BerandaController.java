package Beranda;

import java.net.URL;
import java.util.ResourceBundle;

import CSS.OpenScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class BerandaController implements Initializable{

    @FXML
    private ScrollPane beranda;

    @FXML
    private ScrollPane halpromo;

     @FXML
    private void keHalamanberanda(ActionEvent event) {
        halpromo.setVisible(false);
        beranda.setVisible(true);
    }

    @FXML
    private void keHalamanpromo(ActionEvent event) {
        halpromo.setVisible(true);
        beranda.setVisible(false);
    }

    
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }    
}
