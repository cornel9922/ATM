package main.atm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    void initialize() {
    }

}
