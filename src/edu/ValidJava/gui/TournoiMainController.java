/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.gui;

import com.uttesh.exude.ExudeData;
import com.uttesh.exude.exception.InvalidDataException;
import edu.ValidJava.entities.Equipe;
import edu.ValidJava.entities.Tournois;
import edu.ValidJava.services.EquipeCRUD;
import edu.ValidJava.services.TournoisCRUD;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class TournoiMainController implements Initializable {

    Stage dialogStage;
    @FXML
    private TextField tid;
    @FXML
    private TextField tprize;
    @FXML
    private TextField tmax;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnaffichage;
    @FXML
    private TextField tnom;
    @FXML
    private TextField tlieu;
    @FXML
    private DatePicker tdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void affichage(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageTournoi.fxml"));
            Parent root = loader.load();
            Stage s1=new Stage();
            Scene scene = new Scene(root);
            
            s1.setTitle("Ulticom");
            s1.setScene(scene);
            s1.show();
        } catch (IOException ex) {
            Logger.getLogger(TournoiMainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void ajouterTournoi(ActionEvent event) throws AWTException {
        if (isInputValid()) {
            int id = Integer.parseInt(tid.getText());
            int prize = Integer.parseInt(tprize.getText());
            int max_equipes = Integer.parseInt(tmax.getText());
            String lieu = tlieu.getText();
            String name = tnom.getText();
            Date date = Date.valueOf(tdate.getValue());
            Tournois t = new Tournois(id, prize, max_equipes, lieu, name, date);
            TournoisCRUD tcd = new TournoisCRUD();
            try {
                if (ExudeData.getInstance().getSwearWords(name).length() > 0) {
                    SystemTray tray = SystemTray.getSystemTray();
                    
                    //If the icon is a file
                    Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
                    //Alternative (if the icon is on the classpath):
                    //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));
                    
                    TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
                    //Let the system resize the image if needed
                    trayIcon.setImageAutoSize(true);
                    //Set tooltip text for the tray icon
                    trayIcon.setToolTip("System tray icon demo");
                    tray.add(trayIcon);
                    
                    trayIcon.displayMessage("Notification ajout", "Equipe non ajoutée, vulgarité non permise.", TrayIcon.MessageType.ERROR);
                    
                } else {
                    tcd.CreateTournois(t);
                    SystemTray tray = SystemTray.getSystemTray();
                    
                    //If the icon is a file
                    Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
                    //Alternative (if the icon is on the classpath):
                    //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));
                    
                    TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
                    //Let the system resize the image if needed
                    trayIcon.setImageAutoSize(true);
                    //Set tooltip text for the tray icon
                    trayIcon.setToolTip("System tray icon demo");
                    tray.add(trayIcon);
                    
                    trayIcon.displayMessage("Notification ajout", "Equipe ajoutée avec succès", TrayIcon.MessageType.INFO);
                }
            } catch (InvalidDataException ex) {
                Logger.getLogger(TournoiMainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
        private boolean isInputValid() {
        String errorMessage = "";

        if (tid.getText() == null || tid.getText().length() <= 0 || !tid.getText().matches("[0-9]+")) {
            errorMessage += "invalid id!\n";
        }

        if (tprize.getText() == null || tprize.getText().length() <= 0 || !tprize.getText().matches("[0-9]+")) {
            errorMessage += "invalid nombre!\n";
        }
         if (tlieu.getText() == null || tlieu.getText().length() <= 0) {
            errorMessage += "invalid id!\n";
        }
          if (tnom.getText() == null || tnom.getText().length() <= 0 ) {
            errorMessage += "invalid id!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }

    }
    
}
