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
import final_javafx.userentites.SendMail;
import final_javafx.userentites.fos_user;
import final_javafx.userentites.Vars;
import final_javafx.userservices.MailUtils;

import final_javafx.userservices.ServiceUser;
import java.sql.Date;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class Ajouter_UtilisateurController implements Initializable {

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
    private Circle cir;
    @FXML
    private Button affiche;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField telephone;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;
    @FXML
    private Label role;
    @FXML
    private ChoiceBox<String> choix;
    @FXML
    private Button btinscription;
    @FXML
    private ComboBox<String> cbx;
    @FXML
    private ComboBox<String> comboxsexe;
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
         
         comboxsexe.setValue("homme");
         comboxsexe.getItems().add("homme");
        comboxsexe.getItems().add("femme");
          choix.setValue("utilisateur");
         choix.getItems().add("utilisateur");
        choix.getItems().add("administrateur");
       
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

   

    
    
    
    
    
    
    
    
    
    
   
    public boolean verifierchamps () throws SQLException
    {ServiceUser su = new ServiceUser();
         fos_user user = new fos_user();
        String fnom = nom.getText ();
        String fprenom = prenom.getText ();
        String femail = email.getText ();
        String fpass1  = password1.getText ();
        String fpass2  = password2.getText ();
        if (comboxsexe.getValue().equals("homme"))
                {
                    user.setSexe("homme");
                }
          if (comboxsexe.getValue().equals("femme"))
                {
                   user.setSexe("femme"); 
                }   
        String ftelephone = telephone.getText ();
       
          ServiceUser u = new ServiceUser();
            List<fos_user> k = u.getUtilisateurs();
          Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9._]*@[a-zA-Z]+([.][a-zA-Z]+)+") ;  
          Pattern p1 = Pattern.compile("[a-zA-Z]") ;           
          Pattern p3 = Pattern.compile( "[0-9]" );

          
          
          
          Matcher m =p.matcher(femail);
          Matcher m1 =p3.matcher(fnom);
          Matcher m2 =p3.matcher(fprenom);
         
           Matcher m4 =p3.matcher(ftelephone);
           
           
           
            
                // vérifie les champs vides
                if (fnom.trim (). equals ("") || fprenom.trim (). equals ("") || femail.trim ().equals ("")
                   || fpass1.trim (). equals ("") || fpass2.trim (). equals ("")  || ftelephone.trim (). equals (""))
                {
                    
                     Alert alert = new  Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("champs sont vides");
            alert.showAndWait();
            
             return false;
                }
                //controle de saisie de deux mot de passe
               else if (!fpass1.equals(fpass2)) {
            
            Alert alert = new  Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("mot de passe invalide ");
            alert.showAndWait();
                    return false;
                }
               
              
              
                //controle de saisie email
                else if(!(m.find() && m.group().equals(femail)))
                    
                        {
            Alert alert = new  Alert(Alert.AlertType.WARNING);        
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText(" email invalide  ");
            alert.showAndWait();
                    return false;
                        
                        }
                
                 //controle de saisie prenom et nom doit etre de chaine de caractère 
                
                 else if(m1.find() || m2.find())
                    
                        {
            Alert alert = new  Alert(Alert.AlertType.WARNING);        
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText(" prenom or nom doit etre chaine de caractère   ");
            alert.showAndWait();
                    return false;
                        
                        }
                
                
                
                // controle de saisie de l'existance par email
              
                 else if(k.stream().anyMatch(e->e.getEmail().equals(femail)))
                 {
            Alert alert = new  Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText(" email est existe deja  ");
            alert.showAndWait();
                    return false;    
                 }
                   // controle de saisie  téléphone
              
                 else if( !(ftelephone.startsWith("2") || ftelephone.startsWith("5")  || 
                         ftelephone.startsWith("4")|| ftelephone.startsWith("9") || ftelephone.startsWith("7"))
                       || ( ! m4.find() )   ) 
                         
                     
                 {
                 
                    Alert alert = new  Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText(" numero téléphone invalide ");
            alert.showAndWait();
                    return false;    

                 }


                
                
                return true;
                    
               
                
             
        } 
    
    
    
    
    
    @FXML
    private void inscription(ActionEvent event) throws SQLException, IOException, Exception {
        
            ServiceUser su = new ServiceUser();
         fos_user user = new fos_user();
     
         String fnom = nom.getText ();
         String fprenom = prenom.getText ();
         String femail = email.getText();
         String  fpass1= password1.getText ();
         String  fpass2= password2.getText ();
       
       
         String  ftelephone= telephone.getText ();
         
         String p1crypte = Bcrypt.hashpw(fpass1, Bcrypt.gensalt());
         
        
// vérifie si les données sont vides
         if (verifierchamps ())
         {
             
             String str1="1995-10-31";
          Date date1=Date.valueOf(str1);
          String str2="1995-10-31";
          Date date2=Date.valueOf(str2);
          String str3="1995-10-31";
          Date date3=Date.valueOf(str3);
          
             user.setUsername(fnom);
             user.setUsername_canonical(fnom);
             user.setFirst_name(fprenom);
             user.setLast_name(fnom);
             user.setEmail(femail);
             user.setEmail_canonical(femail);
             user.setPassword(p1crypte);
             user.setPhone_numbre(Integer.parseInt(ftelephone));
              if (choix.getValue().equals("utilisateur"))
                {
                    user.setRoles("utilisateur");
                }
          if (choix.getValue().equals("administrateur"))
                {
                   user.setRoles("administrateur"); 
                }  
             user.setSalt("1");
             user.setConfirmation_token(p1crypte);
             user.setEnabled(1);
             user.setIdtrans(0);
             user.setLast_login(date1);
             
             
              if (comboxsexe.getValue().equals("homme"))
                {
                    user.setSexe("homme");
                }
          if (comboxsexe.getValue().equals("femme"))
                {
                   user.setSexe("femme"); 
                }   
             
             
             
          
             user.setBirth_date(date3);
              
            user.setPassword_requested_at(date2);
             
                 System.out.println(user.toString()); 
                 su.addUtilisateur(user);
            
                 
                      
       Stage stage = new Stage();
        Parent home = FXMLLoader.load(getClass().getResource("/final_javafx/gui/Afficher_user.fxml")); 
        Scene hoomescene = new Scene(home);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(hoomescene);
         app_stage.show();
 
                
                 
                 
                 
                
                }
                
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
