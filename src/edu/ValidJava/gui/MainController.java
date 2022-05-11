/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class MainController implements Initializable {

    @FXML
    private Button btnE;
    @FXML
    private Button btnT;
    @FXML
    private Button btnJ;
    @FXML
    private Button btnC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void equipe(ActionEvent event) throws IOException { 
        Parent root=FXMLLoader.load(getClass().getResource("AjoutFXML.fxml"));
        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ulticom");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void tournoi(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("TournoiMain.fxml"));
        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ulticom");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void jeux(ActionEvent event) {
    }

    @FXML
    private void categorie(ActionEvent event) {
    }
    
}
