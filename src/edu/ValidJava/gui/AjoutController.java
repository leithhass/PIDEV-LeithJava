/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.gui;

import com.uttesh.exude.ExudeData;
import com.uttesh.exude.api.ExudeAPI;
import com.uttesh.exude.exception.InvalidDataException;
import edu.ValidJava.entities.Equipe;
import edu.ValidJava.services.EquipeCRUD;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AjoutController implements Initializable {

    Stage dialogStage;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfJoueurs;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button affichage;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> idevent;
    @FXML
    private TableColumn<?, ?> idequipe;
    @FXML
    private TableColumn<?, ?> nomequipe;
    @FXML
    private TableColumn<?, ?> nombrejoueurs;
    @FXML
    private TableColumn<?, ?> nomjoueurs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouterEquipe(ActionEvent event) throws AWTException, InvalidDataException {

        if (isInputValid()) {
            int id = Integer.parseInt(tfID.getText());
            int nbr_joueurs = Integer.parseInt(tfNombre.getText());
            String nom_equipe = tfNom.getText();
            String nom_joueurs = tfJoueurs.getText();
            Equipe E = new Equipe(id, nbr_joueurs, nom_equipe, nom_joueurs);
            EquipeCRUD ecd = new EquipeCRUD();
            if (ExudeData.getInstance().getSwearWords(nom_equipe).length() > 0) {
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

                trayIcon.displayMessage("Notification ajout", "Equipe non ajoutée, vulgarité non permise.", MessageType.ERROR);

            } else {
                ecd.CreateEquipe(E);
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

                trayIcon.displayMessage("Notification ajout", "Equipe ajoutée avec succès", MessageType.INFO);
            }

        }

    }

    @FXML
    private void affichage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("affichageequipe.fxml"));
        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Ulticom");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (tfID.getText() == null || tfID.getText().length() <= 0 || !tfID.getText().matches("[0-9]+")) {
            errorMessage += "invalid id!\n";
        }
        if (tfNom.getText() == null || tfNom.getText().length() <= 0) {
            errorMessage += "invalid nom!\n";
        }

        if (tfNombre.getText() == null || tfNombre.getText().length() <= 0 || !tfNombre.getText().matches("[0-9]+")) {
            errorMessage += "invalid nombre!\n";
        }
        if (tfJoueurs.getText() == null || tfJoueurs.getText().length() <= 0 || tfJoueurs.getText().matches(".*[0-9].*")) {
            errorMessage += "invalid joueurs!\n";
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
