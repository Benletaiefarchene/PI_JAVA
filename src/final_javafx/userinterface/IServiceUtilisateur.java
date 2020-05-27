/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_javafx.userinterface;

import java.sql.SQLException;
import java.util.List;
import final_javafx.userentites.fos_user;

/**
 *
 * @author USER
 */
public interface IServiceUtilisateur {
    
    public void addUtilisateur(fos_user p) throws SQLException;

    public List<fos_user> getUtilisateurs() throws SQLException;

    public fos_user getById(int id) throws SQLException;

    public void deleteUtilisateur(fos_user p) throws SQLException;

    public void deleteUtilisateur(int id) throws SQLException;

    public void updateUtilisateur(fos_user p) throws SQLException;
    
    public List<fos_user> RechercherUtilisateur(String nom) throws SQLException;

}
