package com.example.projetjava;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;

import javafx.scene.Node;
import javafx.scene.Parent;

import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.event.ActionEvent;


public class loginController implements Initializable{

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button cnx;

    @FXML
    private PasswordField mdp;

    @FXML
    private TextField nom;



    @FXML
    protected void onHelloButtonClick(ActionEvent event)throws SQLException  {


       db connection =new db();
       Connection connectDB= connection.getConnection();
        PreparedStatement stat =null;
        ResultSet rs=null;
        String sql="SELECT * FROM users WHERE username = ? AND password = ?";
        try {

            stat=connectDB.prepareStatement(sql);
            stat.setString(1,nom.getText().toString());
            stat.setString(2, mdp.getText().toString());

            rs=stat.executeQuery();
            Window owner=nom.getScene().getWindow();
            if (nom.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, owner, "spv entrer votre correct nom", "Error!!");
                return;
            }
            if (mdp.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, owner, "spv entrer votre correct mots de passe ", "Error!!");
                return;
            }
            if (rs.next()) {
                infoBox("connection est validee",null,"success");
                try {
                    createStageEvent(event);
                } catch (IOException ex) {

                }

            } else {
                infoBox("svp entrez votre correct name ou mots de passe", null, "error");

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }
    public void createStageEvent( ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));

        Parent root =fxmlLoader.load();

        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();


        stage.setTitle("Menu");
        stage.setScene(new Scene(root));

        stage.show();
    }


    @Override
    public void initialize(URL location,ResourceBundle resource)
    {

    }
    public static void infoBox(String infoMessage,String headerText,String title)
    {
        Alert alert =new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();

    }
    public static void showAlert(Alert.AlertType alertType ,Window owner,String message,String title)
    {
        Alert alert =new Alert(alertType);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.initOwner(owner);
        alert.show();

    }
}
