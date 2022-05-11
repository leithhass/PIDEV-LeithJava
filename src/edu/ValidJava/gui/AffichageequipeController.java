/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.gui;

import com.itextpdf.text.DocumentException;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
import edu.ValidJava.entities.Equipe;
import edu.ValidJava.entities.donnéeequipe;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import edu.ValidJava.services.EquipeCRUD;
import edu.ValidJava.utils.ServicePdf;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ListView;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AffichageequipeController implements Initializable   {
    EquipeCRUD ecd = new EquipeCRUD();
    @FXML
    private TableView<Equipe> table;
    @FXML
    private TableColumn<Equipe,Integer> idequipe;
    @FXML
    private TableColumn<Equipe,String> nomequipe;
    @FXML
    private TableColumn<Equipe,Integer> nombrejoueurs;
    @FXML
    private TableColumn<Equipe,String > nomjoueurs;
    EquipeCRUD typeCRUD = new EquipeCRUD();
    ObservableList<Equipe> list;
    @FXML
    private TableColumn<?, ?> idevent;
    @FXML
    private TextField modif1;
    @FXML
    private TextField modif2;
    @FXML
    private TextField modif13;
    @FXML
    private TextField modif14;
    @FXML
    private Button delete;
    @FXML
    private Button btnPDF;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            list = (ObservableList<Equipe>) typeCRUD.ReadEquipe(); // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AffichageequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        idequipe.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomequipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        nombrejoueurs.setCellValueFactory(new PropertyValueFactory<>("nbr_joueurs"));
        nomjoueurs.setCellValueFactory(new PropertyValueFactory<>("nom_joueurs"));
        table.setItems(list);
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    Equipe selectedJeu = table.getSelectionModel().getSelectedItem();
//                    System.out.println(selectedProduit);
                    String z = String.valueOf(selectedJeu.getId());
                    modif1.setText(z);
                    modif2.setText(selectedJeu.getNom_equipe());
                    String x = String.valueOf(selectedJeu.getNbr_joueurs());
                    modif13.setText(x);
                    modif14.setText(selectedJeu.getNom_joueurs());

//                    selectedProduit.setImage(selectedProduit.getImage());
//                    (image.getContentDisplay(selectedProduit.getImage());
                } else {
                    table.getSelectionModel().clearSelection();

                }
            }
        }
        );
    }    

    @FXML
    private void sup(ActionEvent event) throws IOException {
         Equipe TypeSelect = (Equipe) table.getSelectionModel().getSelectedItem();
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
            alert.setHeaderText("veuillez vous vraiment supprimer cette équipe");
            alert.setContentText("vous étes sure ?");
            String title = "équipe supprimer avec succés";
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
//        Typesport TypeSelect = (Typesport) tableauType.getSelectionModel().getSelectedItem();
                typeCRUD.suppEquipe(TypeSelect.getId());

                

                Parent loader = FXMLLoader.load(getClass().getResource("affichageequipe.fxml"));
                Scene scene = new Scene(loader);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // AdminPageController apc= loader.getController();
                window.setTitle("Affichage page");
                window.setScene(scene);
                window.show();
            } else {
                Parent loader = FXMLLoader.load(getClass().getResource("affichageequipe.fxml"));
                Scene scene = new Scene(loader);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // AdminPageController apc= loader.getController();
                window.setTitle("Affichage page");
                window.setScene(scene);
                window.show();
            }

          
        }

    }
    public void afficherJeu() throws SQLException {

// Affichge des attributs EQUIPE
        idequipe.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomequipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        nombrejoueurs.setCellValueFactory(new PropertyValueFactory<>("nbr_joueurs"));
        nomjoueurs.setCellValueFactory(new PropertyValueFactory<>("nom_joueurs"));
        table.setItems(list);
        list = (ObservableList<Equipe>) typeCRUD.ReadEquipe();
        list.forEach(
                (p) -> {
                    table.getItems().addAll(
                            new Equipe(p.getId(),p.getNbr_joueurs(), p.getNom_equipe(),
                                     p.getNom_joueurs()
                                    ));

                });

    }

    @FXML
    private void modif(ActionEvent event) throws SQLException {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation de modification");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir modifier cette equipe ? ");
        Optional<ButtonType> action = alert1.showAndWait();

        if (action.get() == ButtonType.OK) {
            ecd.modifJeu(new Equipe(
                    Integer.parseInt(modif1.getText()),
                    Integer.parseInt(modif13.getText()),
                    modif2.getText(),
                    modif14.getText()));
        } else {
            alert1.close();
        }
       
        typeCRUD.ReadEquipe();
         table.getItems().clear();
        afficherJeu();
    }

    @FXML
    private void pdf(ActionEvent event) throws FileNotFoundException, DocumentException, SQLException  {
        ServicePdf sp= new ServicePdf();
        sp.equipePDF();
        
    }
}
  