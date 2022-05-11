/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.services;

import edu.ValidJava.entities.Tournois;
import edu.ValidJava.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class TournoisCRUD {

    Connection cnx = DataSource.getInstance().getCnx();

    public void CreateTournois(Tournois T) {
        try {
            String req = "INSERT INTO Tournois(name,prize,lieu,date,max_equipes) VALUES "
                    + "('" + T.getName() + "'" + ",'" + T.getPrize() + "'" + ",'" + T.getLieu() + "'" + ",'" + T.getDate() + "'" + ",'" + T.getMax_equipes() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Tournois ajouté avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void AjoutTournois(Tournois T) {
        try {
            String req = "INSERT INTO Tournois(nom,prenom) VALUES (?,?)"
                    + "('" + T.getName() + "'" + ",'" + T.getPrize() + "')" + "('" + T.getLieu() + "'" + "('" + T.getDate() + "'" + "('" + T.getMax_equipes() + "'";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, T.getName());
            pst.setInt(2, T.getPrize());
            pst.setString(1, T.getLieu());
            pst.setDate(1, T.getDate());
            pst.setInt(1, T.getMax_equipes());

            pst.executeUpdate(req);
            System.out.println("Tournois ajouté avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Tournois> ReadTournois() {
        List<Tournois> plist = new ArrayList<>();
        try {
            String req = "select * from Tournois";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Tournois T = new Tournois();
                T.setId(rs.getInt("id"));
                T.setName(rs.getString("name"));
                T.setPrize(rs.getInt("prize"));
                T.setMax_equipes(rs.getInt("max_equipes"));
                T.setLieu(rs.getString("lieu"));
                T.setDate(rs.getDate("date"));

                plist.add(T);

            }
        } catch (Exception e) {
        }
        return plist;
    }

    public void suppTournois(int id) {

        try {
            String req = "delete from tournois where id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Tournoi supprimé avec succès");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }

    }

    public void ModifTournoi(Tournois t) {
        String s = "";
        String request = "UPDATE tournois SET prize=" + t.getPrize()
                + ",max_equipes=" + t.getMax_equipes()
                + ",lieu='" + t.getLieu()
                + "',name='" + t.getName()
                + "',date='" + t.getDate()
                + " 'WHERE id=" + t.getId() + " ";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("Tournoi modifié avec succès");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }

    }

}
