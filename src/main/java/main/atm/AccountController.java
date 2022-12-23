package main.atm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deposit_button;

    @FXML
    private Button exit_button;

    @FXML
    private Text totalMoney_field;

    @FXML
    private Button withdraw_button;
    @FXML
    private TextField withdraw_field;

    @FXML
    private TextField deposit_field;

    @FXML
    void initialize() {
        if(withdraw_field.getText().matches("[0-9]*")) {
            withdraw_button.setOnAction(actionEvent -> {
            });
        }
        else withdraw_field.setText("");
    }

}
