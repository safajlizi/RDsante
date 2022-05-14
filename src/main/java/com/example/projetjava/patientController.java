package com.example.projetjava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class patientController implements Initializable{
    @FXML
    private Button but1;
    @FXML
    private Button but2;
    @FXML
    private Button but3;
    @FXML
    private Button but4;
    @FXML
    private Button but5;
    @FXML
    private Button but6;
    @FXML

    private AnchorPane anchorpane;
    @FXML
    private TextField addresseform;
    @FXML
    private TextField addresseform1;
    @FXML
    private DatePicker dateform;
    @FXML
    public  ComboBox<String> docteurform;
    @FXML
    public  ComboBox<String> docteurform1;

    @FXML
    private ToggleGroup gg;
    @FXML
    private AnchorPane suppmodif;
    @FXML
    private TextField mailform;

    @FXML
    private Button update;

    @FXML
    private AnchorPane update1;

    @FXML
    private Button validerform;



    @FXML
    private TextField nomform;

    @FXML
    private TextField numform;

    @FXML
    private TextField prenomform;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton male;

    private String radiobuttonlabel;

    @FXML
    private TextField keyword;

    @FXML
    private TableView<informationpatient> tablepatient;
    @FXML
    private TableColumn<informationpatient, String> genretab;
    @FXML
    private TableColumn<informationpatient, Integer> numtab;
    @FXML
    private TableColumn<informationpatient, String> docteurtab;

    @FXML
    private TableColumn<informationpatient, String> emailtab;
    @FXML
    private TableColumn<informationpatient,Integer> idtab;
    @FXML
    private TableColumn<informationpatient, Date> rendtab;
    @FXML
    private TableColumn<informationpatient, String> nomtab;

    @FXML
    private TableColumn<informationpatient, String> prenomtab;
    @FXML
    private TableColumn<informationpatient, String> addressetab;

    ObservableList<informationpatient> informationpatientObservableList= FXCollections.observableArrayList();

    @FXML
    private TextField keyword1;
    @FXML
    private AnchorPane delete_update;
    @FXML
    private TableView<informationpatient> tablepatient1;
    @FXML
    private TableColumn<informationpatient, String> genretab1;
    @FXML
    private TableColumn<informationpatient, Integer> numtab1;
    @FXML
    private TableColumn<informationpatient, String> docteurtab1;

    @FXML
    private TableColumn<informationpatient, String> emailtab1;
    @FXML
    private TableColumn<informationpatient,Integer> idtab1;
    @FXML
    private TableColumn<informationpatient, Date> rendtab1;
    @FXML
    private TableColumn<informationpatient, String> nomtab1;

    @FXML
    private TableColumn<informationpatient, String> prenomtab1;
    @FXML
    private TableColumn<informationpatient, String> addressetab1;
    @FXML
    private TableColumn<informationpatient, String> editCol;

    ObservableList<informationpatient> informationpatientObservableList1= FXCollections.observableArrayList();

    /////// ta3 barre num2
    @FXML
    private AnchorPane ajout;
    @FXML
    private AnchorPane recherche;
    @FXML
    private AnchorPane recherche1;



    @FXML
    private Button delete;


    @FXML
    private TextField addresse;




    @FXML
    private TextField idpatient;

    @FXML
    private ComboBox<String> docteur;




    @FXML
    private RadioButton female1;


    @FXML
    private ToggleGroup gg1;




    @FXML
    private TextField mail;



    @FXML
    private TextField mailform1;


    @FXML
    private TextField nom;
    @FXML
    private TextField numform1;
    @FXML
    private TextField prenomform1;
    @FXML
    private TextField num;


    @FXML
    private TextField nomform1;







    @FXML
    public void refrecherbtn()
    {
        delete_update.setVisible(true);
        update1.setVisible(false);
        ajout.setVisible(false);
        //recherche.setVisible(false);
        recherche1.setVisible(false);



    }
    @FXML
    public void updatpatient()
    {
        delete_update.setVisible(false);
        update1.setVisible(true);
        ajout.setVisible(false);
        //recherche.setVisible(false);
        recherche1.setVisible(false);

    }


    @FXML
    public void evenenment() {
        informationpatient inf= tablepatient1.getSelectionModel().getSelectedItem();
        idpatient.setText(""+inf.getId());
        nomform1.setText(inf.getNom());
        prenomform1.setText(inf.getPrenom());
        docteurform1.setValue(inf.getDocteur());
        addresseform1.setText(inf.getAddresse());
        numform1.setText(inf.getNum());
        mailform1.setText(inf.getEmail());



    }

    public void ajout_patient(){
        ajout.setVisible(true);
        //recherche.setVisible(false);
        recherche1.setVisible(false);
        delete_update.setVisible(false);
        update1.setVisible(false);
    }


    public void information_patient(){
        // show();
        ajout.setVisible(false);
        // recherche.setVisible(false);
        recherche1.setVisible(true);
        delete_update.setVisible(false);
        update1.setVisible(false);
    }

    public void suppmodif_patient(){
        ajout.setVisible(false);
        // recherche.setVisible(false);
        recherche1.setVisible(false);
        delete_update.setVisible(true);
        update1.setVisible(false);



    }
    /* public void show() {
         db connection = new db();
         Connection connectDB = connection.getConnection();

         ////ta3 affichage w recherche

         String query = "SELECT `id`, `nom`, `prenom`, `docteur`, `addresse`, `num`, `email`, `genre`, `rend` FROM `patient`";
         try {
             Statement statement = connection.con.createStatement();
             ResultSet queryoutput = statement.executeQuery(query);
 //////affchage
             while (queryoutput.next()) {
                 Integer queryId = queryoutput.getInt("Id");
                 String queryNum = queryoutput.getString("Num");
                 String queryNom = queryoutput.getString("Nom");
                 String queryPrenom = queryoutput.getString("Prenom");
                 String queryDocteur = queryoutput.getString("Docteur");
                 String queryAddresse = queryoutput.getString("Addresse");
                 String queryemail = queryoutput.getString("Email");
                 String querygenre = queryoutput.getString("genre");
                 Date queryDate = queryoutput.getDate("rend");

                 informationpatientObservableList.add(new informationpatient(queryId, queryNum, queryNom, queryPrenom, queryDocteur, queryAddresse, queryemail, querygenre, queryDate));

             }
             idtab.setCellValueFactory(new PropertyValueFactory<>("id"));
             nomtab.setCellValueFactory(new PropertyValueFactory<>("nom"));
             prenomtab.setCellValueFactory(new PropertyValueFactory<>("prenom"));
             addressetab.setCellValueFactory(new PropertyValueFactory<>("addresse"));
             numtab.setCellValueFactory(new PropertyValueFactory<>("num"));
             emailtab.setCellValueFactory(new PropertyValueFactory<>("num"));
             docteurtab.setCellValueFactory(new PropertyValueFactory<>("docteur"));
             genretab.setCellValueFactory(new PropertyValueFactory<>("genre"));
             rendtab.setCellValueFactory(new PropertyValueFactory<>("rend"));

             tablepatient.setItems(informationpatientObservableList);
         } catch (Exception ex) {

         }
     }*/
    @FXML
    public void show ()
    {
        db connection =new db();
        Connection connectDB= connection.getConnection();

        ////ta3 affichage w recherche

        String query="SELECT `id`, `nom`, `prenom`, `docteur`, `addresse`, `num`, `email`, `genre`, `rend` FROM `patient`";
        try{
            Statement statement=connection.con.createStatement();
            ResultSet queryoutput= statement.executeQuery(query);
//////affchage
            while(queryoutput.next()){
                Integer queryId=queryoutput.getInt("Id");
                String queryNum=queryoutput.getString("Num");
                String  queryNom=queryoutput.getString("Nom");
                String  queryPrenom=queryoutput.getString("Prenom");
                String  queryDocteur=queryoutput.getString("Docteur");
                String  queryAddresse=queryoutput.getString("Addresse");
                String  queryemail=queryoutput.getString("Email");
                String querygenre=queryoutput.getString("genre");
                Date queryDate=queryoutput.getDate("rend");

                informationpatientObservableList.add(new informationpatient(queryId,queryNum,queryNom,queryPrenom,queryAddresse, queryemail,querygenre,queryDocteur,queryDate));

            }
            idtab.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomtab.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenomtab.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            addressetab.setCellValueFactory(new PropertyValueFactory<>("addresse"));
            numtab.setCellValueFactory(new PropertyValueFactory<>("num"));
            emailtab.setCellValueFactory(new PropertyValueFactory<>("email"));
            docteurtab.setCellValueFactory(new PropertyValueFactory<>("docteur"));
            genretab.setCellValueFactory(new PropertyValueFactory<>("genre"));
            rendtab.setCellValueFactory(new PropertyValueFactory<>("rend"));

            tablepatient.setItems( informationpatientObservableList);

///initialise filter
            FilteredList<informationpatient> filtreData=new FilteredList<>(informationpatientObservableList,b->true);

            keyword.textProperty().addListener((observable,oldValue,newValue)->{
                filtreData.setPredicate(informationpatient -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    String searchkeyword = newValue.toLowerCase();
                    if (informationpatient.getId().toString().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getNom().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getPrenom().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getNum().toString().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getDocteur().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getAddresse().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getEmail().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getGenre().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getRend().toString().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    }else
                        return false;
                });
            });

            SortedList<informationpatient>sortedData=new SortedList<>(filtreData);

            ///sorted data
            sortedData.comparatorProperty().bind(tablepatient.comparatorProperty());
            // apply filtred data
            tablepatient.setItems(sortedData);
        }catch(SQLException e){
            Logger.getAnonymousLogger(patientController.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }



        ////////////////**********************************delete***********************************/////////////////////////

        ////ta3 affichage w recherche

        try{
            Statement statement=connection.con.createStatement();
            ResultSet queryoutput1= statement.executeQuery(query);
            //////affchage
            while(queryoutput1.next()){
                Integer queryId=queryoutput1.getInt("Id");
                String queryNum=queryoutput1.getString("Num");
                String  queryNom=queryoutput1.getString("Nom");
                String  queryPrenom=queryoutput1.getString("Prenom");
                String  queryDocteur=queryoutput1.getString("Docteur");
                String  queryAddresse=queryoutput1.getString("Addresse");
                String  queryemail=queryoutput1.getString("Email");
                String querygenre=queryoutput1.getString("genre");
                Date queryDate=queryoutput1.getDate("rend");




                informationpatientObservableList1.add(new informationpatient(queryId,queryNum,queryNom,queryPrenom,queryAddresse, queryemail,querygenre,queryDocteur,queryDate));

            }
            idtab1.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomtab1.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenomtab1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            addressetab1.setCellValueFactory(new PropertyValueFactory<>("addresse"));
            numtab1.setCellValueFactory(new PropertyValueFactory<>("num"));
            emailtab1.setCellValueFactory(new PropertyValueFactory<>("email"));
            docteurtab1.setCellValueFactory(new PropertyValueFactory<>("docteur"));
            genretab1.setCellValueFactory(new PropertyValueFactory<>("genre"));

            rendtab1.setCellValueFactory(new PropertyValueFactory<>("rend"));

            tablepatient1.setItems( informationpatientObservableList1);

///initialise filter
            FilteredList<informationpatient> filtreData1=new FilteredList<>(informationpatientObservableList1,b->true);

            keyword1.textProperty().addListener((obseradminvable,oldValue,newValue)->{
                filtreData1.setPredicate(informationpatient -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    String searchkeyword1 = newValue.toLowerCase();
                    if (informationpatient.getId().toString().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getNom().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getPrenom().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getNum().toString().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getDocteur().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getAddresse().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getEmail().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getGenre().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (informationpatient.getRend().toString().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    }else
                        return false;
                });
            });
            SortedList<informationpatient>sortedData1=new SortedList<>(filtreData1);
            ///sorted data
            sortedData1.comparatorProperty().bind(tablepatient1.comparatorProperty());
            // apply filtred data
            tablepatient1.setItems(sortedData1);
        }catch(SQLException ex){
            Logger.getAnonymousLogger(patientController.class.getName()).log(Level.SEVERE,null,ex);
            ex.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url,ResourceBundle rb) {
       show();
    }
    ///////////**************supp patient **********************//////////
    @FXML
    public void suprimepatient() {
        db connection = new db();
        Connection connectDB = connection.getConnection();
        PreparedStatement pst;
        int x = tablepatient1.getSelectionModel().getSelectedItem().getId();
        //  tablepatient1.getItems().removeAll(tablepatient1.getSelectionModel().getSelectedItems());
        //if((x.isEmpty() || x.toString().isBlank() || x.toString() == null) ){}
        String query3="DELETE FROM patient WHERE id ="+ x;
        try {
            pst = connectDB.prepareStatement(query3);

            pst.executeUpdate();
            infoBox("facture supprimée avec succees",null,"success");

            show();

            System.out.println("Patient supprimé");
        } catch (SQLException ex) {

            ex.printStackTrace();
        }

    }
    public void updatepatient(){
        informationpatient info = null;
        System.out.println("modifffffff dkhallllllllll");
        db connection = new db();
        Connection connectDB = connection.getConnection();
        PreparedStatement stat;
        int idup = tablepatient1.getSelectionModel().getSelectedItem().getId();
        String nomup= tablepatient1.getSelectionModel().getSelectedItem().getNom();
        String prenomup= tablepatient1.getSelectionModel().getSelectedItem().getPrenom();
        String docteurup= tablepatient1.getSelectionModel().getSelectedItem().getDocteur();
        String addresseup= tablepatient1.getSelectionModel().getSelectedItem().getAddresse();
        String numup= tablepatient1.getSelectionModel().getSelectedItem().getNum();
        String emailup= tablepatient1.getSelectionModel().getSelectedItem().getEmail();
        String genreup= tablepatient1.getSelectionModel().getSelectedItem().getGenre();
        Date rendup= tablepatient1.getSelectionModel().getSelectedItem().getRend();



        String query4="update patient set nom=?, docteur=?, addresse=?, num=?, email=?, genre=?, rend=? where id=idup";
        try {
            stat = connectDB.prepareStatement(query4);
            stat.setString(1,info.getNom());
            stat.setString(2,info.getPrenom());
            stat.setString(3,info.getDocteur());
            stat.setString(4,info.getAddresse());
            stat.setString(5,info.getNum());
            stat.setString(6,info.getEmail());
            stat.setString(7,info.getGenre());
            stat.setString(8, info.getRend().toString());
            stat.setString(9, info.getId().toString());

            stat.executeUpdate();

            System.out.println("Patient modifier");
        } catch (SQLException ex) {

            ex.printStackTrace();
        }

    }
    //////////////////////////////////////////*************update
/* String nom = nomform.getText();
                    String prenom = prenomform.getText();
                    String num = numform.getText();
                    String addresse = addresseform.getText();
                    String mail = mailform.getText();
                    String docteur = docteurform.getValue();
                    String genre = radiobuttonlabel;
                    String rend = String.valueOf(dateform.getValue());
                    //Date date= String.valueOf(dateform.getValue());*/
    @FXML
    private void  updatebtn(){

       /* db connection =new db();
        Connection connectDB= connection.getConnection();
        PreparedStatement pst;
        String sql= "UPDATE patient SET  docteur = " + docteur.getValue() + " , addresse = " + addresse.getText() + ", num = " + num.getText()+ " , email = " + mail.getText() + " where id = "+ idpatient.getText();

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }*/
        infoBox("patient modifiée avec succees",null,"success");


    }




    /////////////////////ta3 ajouter patient///////////////////////////////////////////////////


    public void ajoutpatient() {
        db connection = new db();
        Connection connectDB = connection.getConnection();
        ToggleGroup gender = new ToggleGroup();


        String nom = nomform.getText();
        String prenom = prenomform.getText();
        String num = numform.getText();
        String addresse = addresseform.getText();
        String mail = mailform.getText();
        String docteur = docteurform.getValue();
        String genre = radiobuttonlabel;
        String rend = String.valueOf(dateform.getValue());
        //Date date= String.valueOf(dateform.getValue());
        String insertfields = "INSERT INTO patient(nom, prenom, docteur, addresse, num, email, genre, rend) VALUES ('";
        String insertvalues = nom + "','" + prenom + "','" + docteur + "','" + addresse + "','" + num + "','" + mail + "','" + genre + "','" + rend + "')";
        String inserttoRegister = insertfields + insertvalues;
        String insertfields2 = "INSERT INTO facture(nom, prenom, num,adresse ,date ,doctor ) VALUES ('";
        String insertvalues2 = nom + "','" + prenom + "','" + num + "','" + addresse + "','" + rend + "','" + docteur + "')";
        String inserttoRegister2 = insertfields2 + insertvalues2;

        try {
            Statement statement = connectDB.createStatement();

            statement.executeUpdate(inserttoRegister);

            statement.executeUpdate(inserttoRegister2);

            infoBox("patient ajouté avec succees",null,"success");



        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void female(ActionEvent event) {
        radiobuttonlabel = "Female";
    }

    public void male(ActionEvent event) {
        radiobuttonlabel = "Male";
    }

    ///ta3 docteur
    public void setData() {

        docteurform.getItems().clear();

        docteurform.getItems().addAll(
                "Medecin",
                "Infermier",
                "ethan.williams@example.com",
                "emma.jones@example.com",
                "michael.brown@example.com");

    }


    //// ta3 barre num1
    @FXML
    protected void onpatientButtonClick(ActionEvent event) {
        try {
            createStage(event, "patient.fxml", "Espace patient");
        } catch (IOException ex) {

        }

    }

    @FXML
    protected void onpersonnelButtonClick(ActionEvent event) {
        try {
            createStage(event, "personnel.fxml", "Espace personnel");
        } catch (IOException ex) {

        }

    }

    @FXML
    protected void onproposButtonClick(ActionEvent event) {
        try {
            createStage(event, "propos.fxml", "A Propos");
        } catch (IOException ex) {

        }
    }

    private void createStage(ActionEvent event, String name, String titre) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(name));

        Parent root = fxmlLoader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setTitle(titre);
        stage.setScene(new Scene(root));

        stage.show();
    }


    @FXML
    protected void ondeconButtonClick(ActionEvent event) {
        try {
            createStage(event, "login.fxml", "Login");
        } catch (IOException ex) {

        }
    }

    @FXML
    protected void onfactureButtonClick(ActionEvent event) {
        try {
            createStage(event, "facture.fxml", "Factures");
        } catch (IOException ex) {

        }

    }

    @FXML
    protected void onaceuilButtonClick(ActionEvent event) {
        try {
            createStage(event, "menu.fxml", "A Propos");
        } catch (IOException ex) {

        }
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
