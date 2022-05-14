package com.example.projetjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class menuController implements Initializable{

    @FXML
    private Button AProp;

    @FXML
    private Button BEP;

    @FXML
    private Button BEPr;

    @FXML
    private ImageView BF;

    @FXML
    private Button BFDP;

    @FXML
    private ImageView BP;

    @FXML
    private ImageView BPr;

    @FXML
    private ImageView Bpros;

    @FXML
    private Button Decon;

    @FXML
    private Button bf;

    @FXML
    private BorderPane borderpa;

    @FXML
    private Button bp;

    @FXML
    private Button bpati;

    @FXML
    private Button bper;
    public void initialize(URL url,ResourceBundle rb)
    {

    }
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

}