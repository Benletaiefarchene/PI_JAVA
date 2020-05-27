/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_javafx.Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import final_javafx.userentites.Bcrypt;
import final_javafx.userentites.fos_user;
import final_javafx.userentites.Vars;
import final_javafx.userservices.ServiceUser;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class Modifier_UtilisateurController implements Initializable {

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
    

    private Label role;
    @FXML
    private ChoiceBox<String> choix;
    @FXML
    private Button btinscription;
    
    fos_user e;
    private ComboBox<String> comboxsexe;
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
         
         
         
         choix.getItems().add("utilisateur");
        choix.getItems().add("administrateur");
         ServiceUser su = new ServiceUser();
         fos_user user = new fos_user();
        
         Platform.runLater(()->{
            System.out.println(e);
              
             
               
               choix.setValue(e.getRoles());
               

       
    });    
         }    

    @FXML
    private void affiche(ActionEvent event) throws IOException {
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
    private void modifier_utilisateur(ActionEvent event) throws SQLException, IOException {

        
         ServiceUser su = new ServiceUser();
         fos_user user = new fos_user();
     
        
       
       
        
// vérifie si les données sont vides
       
            
             user.setId(e.getId());
             user.setUsername(e.getUsername());
             user.setUsername_canonical(e.getUsername_canonical());
             user.setEmail(e.getEmail());
             user.setEmail_canonical(e.getEmail_canonical());
             user.setSalt(e.getSalt());
             user.setPassword(e.getPassword());
             user.setLast_login(e.getLast_login());
             user.setConfirmation_token(e.getConfirmation_token());
             user.setPassword_requested_at(e.getPassword_requested_at());
             user.setLast_name(e.getLast_name());
             user.setFirst_name(e.getFirst_name());
             user.setSexe(e.getSexe());
             user.setPhone_numbre(e.getPhone_numbre());
             user.setBirth_date(e.getBirth_date());
             user.setIdtrans(e.getIdtrans());
             
           if (choix.getValue().equals("utilisateur"))
                {
                    user.setRoles("utilisateur");
                }
          if (choix.getValue().equals("administrateur"))
                {
                   user.setRoles("administrateur"); 
                }   
          
             System.out.println(user);
             
          
         su.updateUtilisateur(user);
         
         
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succés!");
            alert.setHeaderText(null);
            alert.setContentText("Modification de l'utilisateur réalisée!");
            alert.showAndWait();
            
            
            
             Stage stage = new Stage();
        Parent home = FXMLLoader.load(getClass().getResource("/final_javafx/gui/Afficher_user.fxml")); 
        Scene hoomescene = new Scene(home);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(hoomescene);
         app_stage.show();
 
    }
    
    
    
    public void setEvent(fos_user e1){
        this.e=e1;
    }
    
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
