module main.atm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens main.atm to javafx.fxml;
    exports main.atm;
}