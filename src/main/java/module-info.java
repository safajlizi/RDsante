module com.example.projetjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;

    requires java.sql;
    requires mysql.connector.java;

    opens com.example.projetjava to javafx.fxml;
    exports com.example.projetjava;
}