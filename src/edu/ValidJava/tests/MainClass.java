/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.tests;

import edu.ValidJava.entities.Equipe;
import edu.ValidJava.entities.Tournois;
import edu.ValidJava.services.EquipeCRUD;
import edu.ValidJava.services.TournoisCRUD;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MSI
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
     
        Tournois T= new Tournois(1000,16,"Medina Jadida","Helmi",new Date(0)); 
        TournoisCRUD pcd=new TournoisCRUD();
       //pcd.CreateTournois(T);
       
       
       Equipe E= new Equipe(36,"Jaafer United","Baha Houssem Hazem Leith Helmi"); 
        EquipeCRUD ecd=new EquipeCRUD();
        //ecd.CreateEquipe(E); 
       //List<Tournois> liste = pcd.ReadTournois();
       // for (int i = 0; i < liste.size(); i++) {
            //System.out.println(liste.get(i));
        //ecd.suppEquipe(2);
        //ecd.ModifEquipe(3);
  List<Equipe>p= ecd.ReadEquipe();
        for (int j = 0; j < p.size(); j++) {
            System.out.println(p.get(j));
 //pcd.suppTournois(29);
 //ecd.ModifEquipe(15);
    }
        }
    }

   
    




