/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utile.MyConnection;
import userentites.fos_user;
import userservices.ServiceUser;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class main {
    public static void main(String[] args) throws SQLException {
        MyConnection cnx1= MyConnection.getInstance();  
        MyConnection cnx2= MyConnection.getInstance();
      
      ServiceUser u = new ServiceUser();
        List<fos_user> listuu = new ArrayList<>();
     List<fos_user> listrech = new ArrayList<>();
     
   /*
         System.out.println("*********methode ajouter:************");
      String str1="1995-10-31";
       String str2="1996-10-31";
       String str3="1996-10-31";
      Date date1=Date.valueOf(str1);
      
      Date date2=Date.valueOf(str2);
      Date date3=Date.valueOf(str3);
      fos_user p1= new fos_user("archene1919","archene1919","archene1995@gmail.com","archene1995@gmail.com",0,"ajout","987654321",date1,"b",date2,"a:0:{}","archene19","benletaief19","male",21654987,date3);
      u.addUtilisateur(p1);
        System.out.println(p1);
  
       listuu=u.getUtilisateurs();
       
       for(fos_user ui:listuu){
           System.out.println(ui.toString());
       }
       */
   fos_user op= u.getById(54);
        System.out.println("by id ");
       System.out.println(op);   

      
     
     
        
 /*
       System.out.println("*********methode recherche:************");
    listrech=u.RechercherUtilisateur("archene");
     for(fos_user ui:listrech){
           System.out.println(ui.toString());
            
       }
     
  */

    System.out.println("********modifié Utilisateur:***********");
      //op.toString();
      op.setPhone_numbre(23866408);
      op.setUsername("archene_31");
      u.updateUtilisateur(op);
      //  System.out.println(op); 
      
       
        System.out.println("l'Utilisateur est modifié  "+ op);
     
    /*  System.out.println("********supprimer  Utilisateur:***********");      
        
      u.deleteUtilisateur(op);
*/
    }
}
