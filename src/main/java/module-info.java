module main.atm {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.atm to javafx.fxml;
    exports main.atm;
}