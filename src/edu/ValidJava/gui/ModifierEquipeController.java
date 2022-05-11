///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.ValidJava.gui;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import edu.ValidJava.entities.Equipe;
//import edu.ValidJava.entities.donnéeequipe;
//import edu.ValidJava.services.EquipeCRUD;
//import java.util.Optional;
//import javafx.scene.control.ButtonType;
//
//
//
///**
// * FXML Controller class
// *
// * @author MSI
// */
//public class ModifierEquipeController implements Initializable {
//
//    @FXML
//    private TextField tfID;
//    @FXML
//    private TextField tfNom;
//    @FXML
//    private TextField tfNombre;
//    @FXML
//    private TextField tfJoueurs;
//    @FXML
//    private Button valid;
//    Equipe CLmod = donnéeequipe.getEquipe();
//    Equipe newCL = new Equipe();
//
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
//
//    @FXML
//    private void update(ActionEvent event) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//alert.setTitle("Confirmation Dialog");
//alert.setHeaderText("veuillez vous vraiment modifier cette Equipe");
//alert.setContentText("vous étes sure ?");
//               String title =" equipe modifier avec succés";
//              
//            Equipe t = new Equipe();        
//     int id =Integer.parseInt(tfID.getText());
//    int nbr_joueurs=Integer.parseInt(tfNombre.getText());
//    String nom_equipe=tfNom.getText();
//    String nom_joueurs=tfJoueurs.getText();
//
//        
//        EquipeCRUD.(CLmod,t);
//         Optional<ButtonType> result = alert.showAndWait();
//     notif.setAnimationType(Type);    
//        notif.setTitle(title);
//        notif.setNotificationType(NotificationType.SUCCESS);
//        notif.showAndDismiss(javafx.util.Duration.millis(3000)); 
//        try {
//        Parent loader = FXMLLoader.load(getClass().getResource("affichageequipe.fxml"));
//            //  Parent root  = loader.load();
//            Scene  scene = new Scene(loader);
//            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            window.setTitle("Les Equipes");
//            window.setScene(scene);
//            window.show();
//            
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//        }
//    }
//    
//}
