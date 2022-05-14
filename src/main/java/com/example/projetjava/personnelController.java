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


public class personnelController implements Initializable{
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
    private TextField tempsdutravail;
    @FXML

    private AnchorPane anchorpane;
    @FXML
    private TextField addresseform;
    @FXML
    private DatePicker dateform;
    @FXML
    public  ComboBox<String> docteurform;

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
    private TableView<personnel> tablepatient;
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

    ObservableList<personnel> personnelObservableList= FXCollections.observableArrayList();
    ObservableList<personnel> personnelObservableList1= FXCollections.observableArrayList();


    @FXML
    private TextField keyword1;
    @FXML
    private AnchorPane delete_update;
    @FXML
    private TableView<personnel> tablepatient1;
    @FXML
    private TableColumn<personnel, String> genretab1;
    @FXML
    private TableColumn<personnel, Integer> numtab1;
    @FXML
    private TableColumn<personnel, String> docteurtab1;

    @FXML
    private TableColumn<personnel, String> emailtab1;
    @FXML
    private TableColumn<personnel,Integer> idtab1;
    @FXML
    private TableColumn<personnel, String> rendtab1;
    @FXML
    private TableColumn<personnel, String> nomtab1;

    @FXML
    private TableColumn<personnel, String> prenomtab1;
    @FXML
    private TableColumn<personnel, String> addressetab1;
    @FXML
    private TableColumn<personnel, String> editCol;


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
    private TextField temps;


    @FXML
    private TextField mail;





    @FXML
    private TextField nom;


    @FXML
    private TextField num;


    @FXML
    private TextField prenom;






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
    public void evenenment1() {
      try {
          personnel inf = tablepatient1.getSelectionModel().getSelectedItem();
          idpatient.setText("" + inf.getId());
          nom.setText(inf.getNom());
          prenom.setText(inf.getPrenom());
          docteur.setValue(inf.getDocteur());
          addresse.setText(inf.getAddresse());
          num.setText(inf.getNum());
          mail.setText(inf.getEmail());
          temps.setText(inf.getTemps_travail());
      }
      catch(Exception ex)
      {

      }


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

        String query="SELECT `id_per`, `nom`, `prenom`,`addresse`,`email`, `genre`, `Type`,`temps_travail` ,'num' FROM `personnel`";
        try{
            Statement statement=connection.con.createStatement();
            ResultSet queryoutput= statement.executeQuery(query);
//////affchage
           while(queryoutput.next()){
                Integer queryId=queryoutput.getInt("id_per");
                String queryNum=queryoutput.getString("Num");
                String  queryNom=queryoutput.getString("Nom");
                String  queryPrenom=queryoutput.getString("Prenom");
                String  queryDocteur=queryoutput.getString("Type");
                String  queryAddresse=queryoutput.getString("Addresse");
                String  queryemail=queryoutput.getString("Email");
                String querygenre=queryoutput.getString("genre");
               String queryTemps=queryoutput.getString("temps_travail");

                personnelObservableList.add(new personnel(queryId,queryNum,queryNom,queryPrenom,queryAddresse, queryemail,querygenre,queryDocteur,queryTemps));

            }
            idtab.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomtab.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenomtab.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            addressetab.setCellValueFactory(new PropertyValueFactory<>("addresse"));
            numtab.setCellValueFactory(new PropertyValueFactory<>("num"));
            emailtab.setCellValueFactory(new PropertyValueFactory<>("email"));
            docteurtab.setCellValueFactory(new PropertyValueFactory<>("docteur"));
            genretab.setCellValueFactory(new PropertyValueFactory<>("genre"));
            rendtab.setCellValueFactory(new PropertyValueFactory<>("temps_travail"));

            tablepatient.setItems(personnelObservableList);

///initialise filter
            FilteredList<personnel> filtreData=new FilteredList<>(personnelObservableList,b->true);

            keyword.textProperty().addListener((observable,oldValue,newValue)->{
                filtreData.setPredicate(personnel -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    String searchkeyword = newValue.toLowerCase();
                    if (personnel.getId().toString().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getNom().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getPrenom().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getNum().toString().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getDocteur().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getAddresse().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getEmail().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getGenre().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getTemps_travail().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;//mean returner the match value
                    }else
                        return false;
                });
            });

            SortedList<personnel> sortedData=new SortedList<personnel>(filtreData);

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
                Integer queryId=queryoutput1.getInt("id_per");
                String queryNum=queryoutput1.getString("Num");
                String  queryNom=queryoutput1.getString("Nom");
                String  queryPrenom=queryoutput1.getString("Prenom");
                String  queryDocteur=queryoutput1.getString("Type");
                String  queryAddresse=queryoutput1.getString("Addresse");
                String  queryemail=queryoutput1.getString("Email");
                String querygenre=queryoutput1.getString("genre");
                String queryTemps=queryoutput1.getString("temps_travail");
                personnelObservableList1.add(new personnel(queryId,queryNum,queryNom,queryPrenom,queryAddresse, queryemail,querygenre,queryDocteur,queryTemps));

            }
            idtab1.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomtab1.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenomtab1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            addressetab1.setCellValueFactory(new PropertyValueFactory<>("addresse"));
            numtab1.setCellValueFactory(new PropertyValueFactory<>("num"));
            emailtab1.setCellValueFactory(new PropertyValueFactory<>("email"));
            docteurtab1.setCellValueFactory(new PropertyValueFactory<>("docteur"));
            genretab1.setCellValueFactory(new PropertyValueFactory<>("genre"));
            rendtab1.setCellValueFactory(new PropertyValueFactory<>("temps_travail"));

            tablepatient1.setItems( personnelObservableList1);

///initialise filter
            FilteredList<personnel> filtreData1=new FilteredList<>(personnelObservableList1,b->true);


            keyword1.textProperty().addListener((obseradminvable,oldValue,newValue)->{
                filtreData1.setPredicate(personnel-> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    String searchkeyword1 = newValue.toLowerCase();
                    if (personnel.getId().toString().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getNom().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getPrenom().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getNum().toString().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getDocteur().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getAddresse().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getEmail().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getGenre().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    } else if (personnel.getTemps_travail().toLowerCase().indexOf(searchkeyword1) > -1) {
                        return true;//mean returner the match value
                    }else
                        return false;
                });
            });
            SortedList<personnel>sortedData1=new SortedList<>(filtreData1);
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
    ///////////**************supp personnel **********************//////////
    @FXML
    public void suprimepatient() {
        db connection = new db();
        Connection connectDB = connection.getConnection();
        PreparedStatement pst;
        int x = tablepatient1.getSelectionModel().getSelectedItem().getId();
        //  tablepatient1.getItems().removeAll(tablepatient1.getSelectionModel().getSelectedItems());
        //if((x.isEmpty() || x.toString().isBlank() || x.toString() == null) ){}
        String query3="DELETE FROM personnel WHERE id_per ="+ x;
        try {
            pst = connectDB.prepareStatement(query3);

            pst.executeUpdate();

            infoBox("personnel supprimé avec succees",null,"success");

            System.out.println("Personnel supprimé");
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        show();

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
        String rendup= tablepatient1.getSelectionModel().getSelectedItem().getTemps_travail();



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
            infoBox("patient modifiée avec succees",null,"success");

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }*/
        infoBox("personnel modifiée avec succees",null,"success");

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
        String temps_travail = tempsdutravail.getText();
        //Date date= String.valueOf(dateform.getValue());
        String insertfields = "INSERT INTO personnel(nom, prenom, addresse,email,genre,Type,temps_travail , num) VALUES ('";
        String insertvalues = nom + "','" + prenom + "','" + addresse + "','" + mail + "','" + genre + "','" + docteur + "','" + temps_travail + "','" + num + "')";
        String inserttoRegister = insertfields + insertvalues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(inserttoRegister);
            infoBox("personnel  ajouté avec succees",null,"success");
          //  show();


        } catch (Exception e) {

        }


        //show();
    }

    public void female(ActionEvent event) {
        radiobuttonlabel = "Female";
    }

    public void male(ActionEvent event) {
        radiobuttonlabel = "Male";
    }

    ///ta3 docteur
    public void setData() {
try {
    docteurform.getItems().clear();

    docteurform.getItems().addAll(
            "Medecin",
            "Infermier"
    );
}
catch(Exception ex)
{

}
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
