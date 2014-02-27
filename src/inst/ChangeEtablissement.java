/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inst;

import DAO.EtablissementDAO;
import Entities.Etablissement;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
 
public class ChangeEtablissement extends Application {
//    final JFXPanel fxPanel = new JFXPanel();
    public static void main(String[] args) {
        SwingInterop si = new SwingInterop();
        
        launch(args);
    }
            
            

        
    @Override public void start(Stage stage) {
        final Button button = new Button ("Afficher");
        final Label notification = new Label ();
        stage.setTitle("Selection d'un Etablissement");
        Scene scene = new Scene(new Group(), 600, 250);
        
        final ComboBox emailComboBox = new ComboBox();
        EtablissementDAO et = new EtablissementDAO();
        List<Etablissement> lt = new ArrayList<Etablissement>();
        lt=et.getAllEtab();
        for(Etablissement e:lt)
        {
        emailComboBox.getItems().addAll(e.getName());
        }
         
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (emailComboBox.getValue() != null && 
                    !emailComboBox.getValue().toString().isEmpty()){
                        notification.setText("Statistiques rafraichies\nLes statistiques relatives à "+ emailComboBox.getValue().toString()+ " sont maintenant affichées" );   
                        emailComboBox.setValue(null);
                        

                }
                else {
                    notification.setText("Aucun établissement sélectionné"); 
                }
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Etablissement"), 0, 0);
        grid.add(emailComboBox, 1, 0);


        grid.add(button, 3, 5,5,2);
        grid.add (notification, 1, 3, 3, 1);
        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }    
}
