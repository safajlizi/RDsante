package com.example.projetjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class proposController {
    @FXML
    protected void onpatientButtonClick(ActionEvent event){
        try {
            createStage(event,"patient.fxml","Espace patient");
        } catch (IOException ex) {

        }

    }
    @FXML
    protected void onpersonnelButtonClick(ActionEvent event){
        try {
            createStage(event,"personnel.fxml","Espace personnel");
        } catch (IOException ex) {

        }

    }
    @FXML
    protected void onproposButtonClick(ActionEvent event)
    {
        try {
            createStage(event,"propos.fxml","A Propos");
        } catch (IOException ex) {

        }
    }

    private void createStage(ActionEvent event,String name,String titre) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(name));

        Parent root =fxmlLoader.load();

        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(titre);
        stage.setScene(new Scene(root));

        stage.show();
    }


    @FXML
    protected void ondeconButtonClick(ActionEvent event){
        try {
            createStage(event,"login.fxml","Login");
        } catch (IOException ex) {

        }
    }
    @FXML
    protected void onfactureButtonClick(ActionEvent event) {
        try {
            createStage(event,"facture.fxml","Factures");
        } catch (IOException ex) {

        }

    }
    @FXML
    protected void onaceuilButtonClick(ActionEvent event)
    {
        try {
            createStage(event,"menu.fxml","menu");
        } catch (IOException ex) {

        }
    }
}
