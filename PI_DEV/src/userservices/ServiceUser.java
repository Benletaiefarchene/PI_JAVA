/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import userentites.fos_user;
import userinterface.IServiceUtilisateur;
import utile.MyConnection;


/**
 *
 * @author USER
 */
public class ServiceUser implements IServiceUtilisateur {


   
       private Connection cnx;

    public ServiceUser() {
        cnx = MyConnection.getInstance().getCnx();
    }
     @Override
    public List<fos_user> getUtilisateurs()  throws SQLException {
  
        List<fos_user> listu = new ArrayList<>();
       // UserServices uu=new UserServices();
       
        try {
            String req="SELECT * FROM fos_user";
            Statement st =cnx.createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next())
            {    
            fos_user a = new fos_user();
            a.setId(rs.getInt("id"));
            a.setUsername(rs.getString("username"));
            a.setUsername_canonical(rs.getString("username_canonical"));
            a.setFirst_name(rs.getString("first_name"));
            a.setLast_name(rs.getString("last_name"));
            a.setSexe(rs.getString("sexe"));
            a.setEmail(rs.getString("email_canonical"));
            a.setEmail_canonical(rs.getString("email_canonical"));
            a.setRoles(rs.getString("roles"));
            a.setConfirmation_token(rs.getString("confirmation_token"));
            a.setPhone_numbre(rs.getInt("phone_number"));
            a.setBirth_date(rs.getDate("birth_date"));
            a.setIdtrans(rs.getInt("idtrans"));
            a.setPassword(rs.getString("password"));         
                listu.add(a);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listu;
    }

  
   
   public fos_user getById(int id) throws SQLException{
        fos_user a=new fos_user();
        try {
            String req="SELECT * FROM fos_user where id="+id;
            Statement st =cnx.createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next())
            {
 
            a.setId(rs.getInt("id"));
            a.setUsername(rs.getString("username"));
            a.setUsername_canonical(rs.getString("username_canonical"));
            a.setFirst_name(rs.getString("first_name"));
            a.setLast_name(rs.getString("last_name"));
            a.setSexe(rs.getString("sexe"));
            a.setEmail(rs.getString("email"));
            a.setEmail_canonical(rs.getString("email_canonical"));
            a.setRoles(rs.getString("roles"));
            a.setConfirmation_token(rs.getString("confirmation_token"));
            
            a.setPhone_numbre(rs.getInt("phone_number"));
            a.setBirth_date(rs.getDate("birth_date"));
            a.setIdtrans(rs.getInt("idtrans"));
            a.setPassword(rs.getString("password"));                      
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
   public void deleteUtilisateur(fos_user p) throws SQLException{
        try {
            String req="DELETE FROM fos_user WHERE id=?";
            PreparedStatement pre = cnx.prepareStatement(req);
            pre.setInt(1,p.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteUtilisateur(int id) throws SQLException {
             try {
            String req="DELETE FROM fos_user WHERE id=?";
            PreparedStatement pre = cnx.prepareStatement(req);
            pre.setInt(1,id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    

    @Override
      public void updateUtilisateur(fos_user p) throws SQLException{

         try {

         /*   String req="UPDATE fos_user SET username=? username_canonical=?, email=? email_canonical=? enable=? password=? last_login=? confirmation_token=? password_requested_at=? roles=? first_name=?  last_name=?  sexe=?  phone_number=? birth_date=?  WHERE id=?";
          PreparedStatement pre = cnx.prepareStatement(req);     
           pre.setString(1,p.getUsername());
            pre.setString(2,p.getUsername_canonical());
            pre.setString(3,p.getEmail());
            pre.setString(4,p.getEmail_canonical());
            pre.setInt(5,p.getEnabled());
            pre.setString(6,p.getPassword());
            pre.setDate(7,p.getLast_login());
            pre.setString(8,p.getConfirmation_token());
            pre.setDate(9,p.getPassword_requested_at());
            pre.setString(10,p.getRoles());
            pre.setString(11,p.getFirst_name());
            pre.setString(12,p.getLast_name());
            pre.setString(13,p.getSexe());
            pre.setInt(14,p.getPhone_numbre());
            pre.setDate(15,p.getBirth_date());
            pre.setInt(16,p.getId());
             System.err.println(req);
            pre.executeUpdate();*/   
          String req="UPDATE fos_user SET username='"+p.getUsername()+"', username_canonical='"+p.getUsername_canonical()+"' ,email='"+p.getEmail()+"', email_canonical='"+p.getEmail_canonical()+"', enabled="+p.getEnabled()+", password='"+p.getPassword()+"', confirmation_token='"+p.getConfirmation_token()+"', roles='"+p.getRoles()+"' ,first_name='"+p.getFirst_name()+"',  last_name='"+p.getLast_name()+"', sexe='"+p.getSexe()+"',  phone_number="+p.getPhone_numbre()+" WHERE id="+p.getId();
       
   Statement st=cnx.createStatement();
         st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    @Override
    public void addUtilisateur(fos_user p) throws SQLException {       
        try {
            
            
            String req="INSERT INTO fos_user (username,username_canonical,email,email_canonical,enabled,password,last_login,confirmation_token,password_requested_at,roles,first_name, last_name, sexe, phone_number,birth_date ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
              PreparedStatement pre = cnx.prepareStatement(req);
   
            pre.setString(1,p.getUsername());
            pre.setString(2,p.getUsername_canonical());
            pre.setString(3,p.getEmail());
            pre.setString(4,p.getEmail_canonical());
            pre.setInt(5,p.getEnabled());
            pre.setString(6,p.getPassword());
            pre.setDate(7,p.getLast_login());
            pre.setString(8,p.getConfirmation_token());
            pre.setDate(9,p.getPassword_requested_at());
            pre.setString(10,p.getRoles());
            pre.setString(11,p.getFirst_name());
            pre.setString(12,p.getLast_name());
            pre.setString(13,p.getSexe());
            pre.setInt(14,p.getPhone_numbre());
            pre.setDate(15,p.getBirth_date());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
     public List<fos_user> RechercherUtilisateur(String username) throws SQLException{
       
      
         
     List<fos_user> listrecherche = new ArrayList<>();
       // UserServices uu=new UserServices();
       
        try {
            String req="SELECT * FROM fos_user WHERE username='"+username+"'";
            Statement st =cnx.createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next())
            {    
            fos_user a = new fos_user();
            a.setId(rs.getInt("id"));
            a.setUsername(rs.getString("username"));
            a.setFirst_name(rs.getString("first_name"));
            a.setLast_name(rs.getString("last_name"));
            a.setEmail(rs.getString("email"));
            a.setSexe(rs.getString("sexe"));
            a.setRoles(rs.getString("roles"));
            a.setPhone_numbre(rs.getInt("phone_number"));
            a.setPassword(rs.getString("password"));         
                listrecherche.add(a);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listrecherche;
    }

    
     
     
     
     }


         
 
