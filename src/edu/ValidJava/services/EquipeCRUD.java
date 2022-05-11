/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.services;

import edu.ValidJava.entities.Equipe;
import edu.ValidJava.entities.Tournois;
import edu.ValidJava.utils.DataSource;
import edu.ValidJava.utils.sms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MSI
 */
public class EquipeCRUD {
    
    
    Connection cnx = DataSource.getInstance().getCnx();
    
     public void CreateEquipe(Equipe E) {
        try {
            String req = "INSERT INTO Equipe(nbr_joueurs,nom_equipe,nom_joueurs) VALUES "
                    + "('" + E.getNbr_joueurs() + "'" + ",'" + E.getNom_equipe()+ "'" + ",'" + E.getNom_joueurs()+  "')" ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Equipe ajouté avec succès");
            sms.sendSMS("+21629694929", "Bienvenue à ulticom , une équipe a été ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
    public List<Equipe> ReadEquipe() throws SQLException{    
                      String req = "select * from Equipe";
              ObservableList<Equipe> listType = FXCollections.observableArrayList();
            Statement st = cnx.createStatement();
            ResultSet rs= st.executeQuery(req);

        try {
            
            while(rs.next()){
             listType.add(new Equipe(rs.getInt("id"),rs.getInt("nbr_joueurs"),rs.getString("nom_equipe"),rs.getString("nom_joueurs")));

                
            }
        } catch (Exception e) {
        }
        return listType;
        
    }
    
      public void suppEquipe(int id) {

        try {
            String req = "delete from equipe where id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Equipe supprimé avec succès");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }

    }
      public void modifJeu(Equipe j) {
        String s = "";
        String request = "UPDATE equipe SET nom_equipe='" + j.getNom_equipe()
                + "',nbr_joueurs=" + j.getNbr_joueurs()
                + ",nom_joueurs='" + j.getNom_joueurs()
                + " 'WHERE id=" + j.getId() + " ";
        try {
           Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("  Equipe  modifié avec succés  ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
