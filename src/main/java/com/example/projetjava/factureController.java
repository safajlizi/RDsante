package com.example.projetjava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class factureController implements Initializable {
    @FXML
    private AnchorPane tableviewbt;
    @FXML
    private AnchorPane ajout;
    @FXML
    private Button AProp;

    @FXML
    private Button BEP;

    @FXML
    private Button BEPr;

    @FXML
    private ComboBox<String> docteurform;
    @FXML
    private Button BFDP;
    @FXML
    private TextField addresseform;
    @FXML
    private Button Decon;

    @FXML
    private TableColumn<facture, String> adresse;

    @FXML
    private TableColumn<facture, Date> date;

    @FXML
    private TableColumn<facture, String> doctorename;
    @FXML
    private Button refresher;
    @FXML
    private Button delete;

    @FXML
    private Button update;

    @FXML
    private Button validerform;

    @FXML
    private TableColumn<facture,Integer> id;

    @FXML
    private TableColumn<facture,Float > montantpaye;

    @FXML
    private TableColumn<facture, Float> montanttotale;

    @FXML
    private TableColumn<facture, String> nompatient;

    @FXML
    private TableColumn<facture, String> num;

    @FXML
    private TableColumn<facture, String> prenompatient;

    @FXML
    private TextField montant;

    @FXML
    private TextField montantpay;

    @FXML
    private TableView<facture> tv;
    @FXML
    private TextField idfact;

    @FXML
    private TextField numform;

    @FXML
    private TextField prenomform;
    @FXML
    private TextField nomform;


    @FXML
    private ToggleGroup gg;


    @FXML
    private void suprimefacture() {
        db connection = new db();
        Connection connectDB = connection.getConnection();
        PreparedStatement pst;
        int x = tv.getSelectionModel().getSelectedItem().getId();
        //  tablepatient1.getItems().removeAll(tablepatient1.getSelectionModel().getSelectedItems());
        String query3 = "DELETE FROM facture WHERE idfacture =" + x;
        try {
            pst = connectDB.prepareStatement(query3);

            pst.executeUpdate();
            infoBox("facture supprimée avec succees",null,"success");

            System.out.println("facture supprimé");
        } catch (SQLException ex) {
//            Logger.getAnonymousLogger(patientController.class.getName()).log(Level.SEVERE,null,ex);
            ex.printStackTrace();
        }
        showfacture();

    }


    @FXML
    public void updat()
    {
        tableviewbt.setVisible(false);
        ajout.setVisible(true);
    }
    @FXML
    public void Refrech()
    {
        tableviewbt.setVisible(true);
        ajout.setVisible(false);
        showfacture();
    }
@FXML
private void handleMouseAction()
{
    facture fact= tv.getSelectionModel().getSelectedItem();
    idfact.setText(""+fact.getId());
    nomform.setText(fact.getNom());
    prenomform.setText(fact.getPrenom());
    docteurform.setValue(fact.getDoctor());
    addresseform.setText(fact.getAdresse());
    numform.setText(fact.getNum());
   montant.setText(""+fact.getMontant());
   montantpay.setText(""+fact.getMontantpaye());










}
@FXML
    private void  updateRecord(){

        db connection =new db();
        Connection connectDB= connection.getConnection();
        String sql= "UPDATE facture SET montant = " + montant.getText() + ", montant_paye= " + montantpay.getText() + " where idfacture = " + idfact.getText() ;
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);
            infoBox("facture modifiée avec succees",null,"success");
            showfacture();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    infoBox("facture modifiée avec succees",null,"success");


}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showfacture();
    }
    public ObservableList<facture> getfactureList()
    {
        ObservableList<facture> factureList = FXCollections.observableArrayList();

        db connection =new db();
        Connection connectDB= connection.getConnection();
        PreparedStatement stat =null;
        ResultSet rs=null;
        String query="SELECT * FROM facture";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet rs1 = statement.executeQuery(query);
            facture facture;
            while (rs1.next()) {
                facture = new facture(rs1.getInt("idfacture"), rs1.getString("nom"), rs1.getString("prenom"), rs1.getString("num"), rs1.getString("adresse"), rs1.getDate("date"), rs1.getString("doctor"), rs1.getFloat("montant"), rs1.getFloat("montant_paye"));
                factureList.add(facture);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return factureList;
    }

    public void showfacture()  {
        ObservableList<facture> list =getfactureList();
        id.setCellValueFactory( new PropertyValueFactory<facture,Integer>("id"));
        nompatient.setCellValueFactory( new PropertyValueFactory<facture,String>("nom"));
        prenompatient.setCellValueFactory( new PropertyValueFactory<facture,String>("prenom"));
        num.setCellValueFactory(new PropertyValueFactory<facture,String>("num"));
        adresse.setCellValueFactory(new PropertyValueFactory<facture,String>("adresse"));
        date.setCellValueFactory(new PropertyValueFactory<facture,Date>("date"));
        doctorename.setCellValueFactory(new PropertyValueFactory<facture,String>("doctor"));
        montanttotale.setCellValueFactory(new PropertyValueFactory<facture,Float>("montant"));
        montantpaye.setCellValueFactory(new PropertyValueFactory<facture,Float>("montantpaye"));
        tv.setItems(list);

    }
    @FXML
    protected void onpatientButtonClick(ActionEvent event){
        try {
            createStage(event,"patient.fxml","Espace patient");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    @FXML
    protected void onpersonnelButtonClick(ActionEvent event){
        try {
            createStage(event,"personnel.fxml","Espace personnel");
        } catch (IOException ex) {
                 ex.printStackTrace();
        }

    }
    @FXML
    protected void onproposButtonClick(ActionEvent event)
    {
        try {
            createStage(event,"propos.fxml","A Propos");
        } catch (IOException ex) {
      ex.printStackTrace();
        }
    }




    @FXML
    protected void ondeconButtonClick(ActionEvent event){
        try {
            createStage(event,"login.fxml","Login");
        } catch (IOException ex) {
              ex.printStackTrace();
        }
    }
    @FXML
    protected void onfactureButtonClick(ActionEvent event) {
        try {
            createStage(event,"facture.fxml","Factures");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    @FXML
    protected void onaceuilButtonClick(ActionEvent event)
    {
        try {
            createStage(event,"menu.fxml","menu");
        } catch (IOException ex) {
               ex.printStackTrace();
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




    public static void infoBox(String infoMessage,String headerText,String title)
    {
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();

    }
}
