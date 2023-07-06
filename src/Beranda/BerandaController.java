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


    
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }    
}
