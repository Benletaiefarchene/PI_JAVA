/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_javafx.Controller;

import final_javafx.userentites.Vars;
import final_javafx.userentites.fos_user;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arche
 */
public class Acceuil_AdminController implements Initializable {

    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private ComboBox<String> cbx;
    @FXML
    private Button affiche;
    @FXML
    private Button bnHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     Image image1 = new Image("/final_javafx/icons/home.png");
       
        img1.setImage(image1);
        
         Image image2 = new Image("/final_javafx/icons/produit.png");
       
        img2.setImage(image2);
        
        Image image3 = new Image("/final_javafx/icons/annonce.png");
       
        img3.setImage(image3);
        
        Image image4 = new Image("/final_javafx/icons/location.png");
       
        img4.setImage(image4);
        
        Image image5 = new Image("/final_javafx/icons/evenement.png");
       
        img5.setImage(image5);
        
        Image image6 = new Image("/final_javafx/icons/circuit.png");
       
        img6.setImage(image6);
        
        Image image7 = new Image("/final_javafx/icons/utilisateur.png");
       
        img7.setImage(image7);
        
        
       
            
            
            
        cbx.setValue(Vars.current_user.getUsername());
         cbx.getItems().add("Mon Profil");
         cbx.getItems().add("déconnexion");
         
         
         
         
        
    }    
    
    

    @FXML
    public void affiche(ActionEvent event) throws IOException {
        
        Parent tableview = FXMLLoader.load(getClass().getResource("/final_javafx/gui/Afficher_user.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
   
     Parent tableview = FXMLLoader.load(getClass().getResource("/final_javafx/gui/Afficher_user.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    
     }
    @FXML
      private void acc(ActionEvent event) throws IOException {
        
         if(cbx.getValue().equals("déconnexion"))
        {
          Stage stage = new Stage();
        Parent home = FXMLLoader.load(getClass().getResource("/final_javafx/gui/Login.fxml")); 
        Scene hoomescene = new Scene(home);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(hoomescene);
         app_stage.show();
        
        }
         
         if(cbx.getValue().equals("Mon Profil"))
             
         {
        fos_user e=Vars.current_user;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/final_javafx/gui/Profil.fxml"));
        Scene scene=new Scene(loader.load());
        ProfilController   mc= loader.getController();
        mc.setEvent(e);
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        
    }
    
}
}
