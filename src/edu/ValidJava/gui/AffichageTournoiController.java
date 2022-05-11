/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.gui;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import edu.ValidJava.entities.Tournois;
import edu.ValidJava.services.TournoisCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import static java.util.Collections.list;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AffichageTournoiController implements Initializable {
TournoisCRUD tcd = new TournoisCRUD();
    @FXML
    private TableView<Tournois> tabletournoi;
    @FXML
    private TableColumn<?, ?> idtournoi;
    @FXML
    private TableColumn<?, ?> nomtournoi;
    @FXML
    private TableColumn<?, ?> prizetournoi;
    @FXML
    private Button btnsupp;
    @FXML
    private Button btnmodif;
    @FXML
    private TextField taid;
    @FXML
    private TextField taprize;
    @FXML
    private TextField tamax;
    @FXML
    private TextField talieu;
    @FXML
    private Button btnpdf;
    @FXML
    private TextField tanom;
    @FXML
    private DatePicker tadate;
    @FXML
    private TableColumn<?, ?> nbequipes;
    @FXML
    private TableColumn<?, ?> lieut;
    @FXML
    private TableColumn<?, ?> maxt;
    @FXML
    private TableColumn<?, ?> datet;
    ObservableList<Tournois> list;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = FXCollections.observableArrayList(tcd.ReadTournois()); // TODO
        idtournoi.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomtournoi.setCellValueFactory(new PropertyValueFactory<>("name"));
        prizetournoi.setCellValueFactory(new PropertyValueFactory<>("prize"));
        lieut.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        maxt.setCellValueFactory(new PropertyValueFactory<>("max_equipes"));
        datet.setCellValueFactory(new PropertyValueFactory<>("date"));
        tabletournoi.setItems(list);
        tabletournoi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (tabletournoi.getSelectionModel().getSelectedItem() != null) {
                    Tournois selectedtournoi = (Tournois) tabletournoi.getSelectionModel().getSelectedItem();
                    String z = String.valueOf(selectedtournoi.getId());
                    taid.setText(z);
                    String t = String.valueOf(selectedtournoi.getPrize());
                    taprize.setText(t);
                    String x = String.valueOf(selectedtournoi.getMax_equipes());
                    tamax.setText(x);
                    talieu.setText(selectedtournoi.getLieu());
                    tanom.setText(selectedtournoi.getName());
                    LocalDate d=selectedtournoi.getDate().toLocalDate();
                    tadate.setValue(d);
                    
                } else {
                    tabletournoi.getSelectionModel().clearSelection();

                }
            }
        }
        );
    }    

    @FXML
    private void sup(ActionEvent event) throws IOException {
         Tournois TypeSelect = (Tournois) tabletournoi.getSelectionModel().getSelectedItem();
        if ((TypeSelect == null)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vérifier les champs");
            alert.setHeaderText("Look, verifier les chapms");
            alert.setContentText("Ooops, ");

            alert.showAndWait();
            String title = "verifier les champs ";
                   } else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("veuillez vous vraiment supprimer ce tournoi");
            alert.setContentText("vous étes sure ?");
            String title = "Tournoi supprimer avec succés";
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
//        Typesport TypeSelect = (Typesport) tableauType.getSelectionModel().getSelectedItem();
                tcd.suppTournois(TypeSelect.getId());

                

                Parent loader = FXMLLoader.load(getClass().getResource("AffichageTournoi.fxml"));
                Scene scene = new Scene(loader);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // AdminPageController apc= loader.getController();
                window.setTitle("Affichage page");
                window.setScene(scene);
                window.show();
            } else {
                Parent loader = FXMLLoader.load(getClass().getResource("AffichageTournoi.fxml"));
                Scene scene = new Scene(loader);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // AdminPageController apc= loader.getController();
                window.setTitle("Affichage page");
                window.setScene(scene);
                window.show();
            }

          
        }
    }
        public void afficherTournoi() throws SQLException {

// Affichge des attributs EQUIPE
        idtournoi.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomtournoi.setCellValueFactory(new PropertyValueFactory<>("name"));
        prizetournoi.setCellValueFactory(new PropertyValueFactory<>("prize"));
        lieut.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        maxt.setCellValueFactory(new PropertyValueFactory<>("max_equipes"));
        datet.setCellValueFactory(new PropertyValueFactory<>("date"));
        tabletournoi.setItems(list);
        list = (ObservableList<Tournois>) tcd.ReadTournois();
        list.forEach(
                (p) -> {
                    tabletournoi.getItems().addAll(
                            new Tournois(p.getId(), p.getName(), p.getPrize(), p.getLieu(), p.getMax_equipes(), p.getDate()
                                    ));

                });

    }

   @FXML
    private void modif(ActionEvent event) throws SQLException {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation de modification");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir modifier ce tournoi ? ");
        Optional<ButtonType> action = alert1.showAndWait();
        Date d=java.sql.Date.valueOf(tadate.getValue());
        if (action.get() == ButtonType.OK) {
            tcd.ModifTournoi(new Tournois(
                    Integer.parseInt(taid.getText()),
                    tanom.getText(),
                    Integer.parseInt(taprize.getText()),
                    talieu.getText(),
                    Integer.parseInt(tamax.getText()),
                    
                    d));
        } else {
            alert1.close();
        }
       
        tcd.ReadTournois();
        tabletournoi.getItems().clear();
        afficherTournoi();
    }

    @FXML
    private void pdf(ActionEvent event) {
    }
    
}
