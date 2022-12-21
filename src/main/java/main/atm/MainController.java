package main.atm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cardNumber_field;

    @FXML
    private PasswordField cvv_field;

    @FXML
    private Button enter_button;

    @FXML
    private Text incorrectData_text;


    int money = 15000;
    int cardNumber = 84652321;
    int CVV = 464;
    int count = 0;

    @FXML
    void initialize() {
        enter_button.setOnAction(actionEvent -> {
            if(cardNumber_field.getText().equals("84652321") && cvv_field.getText().equals("464"))
        {
                showNewScene(enter_button, "account-view.fxml");
            }
            else {
                count++;
                if((count % 2) == 0) incorrectData_text.setText("");
                else incorrectData_text.setText("Incorrect data");
            }
        });

    }

    public void showNewScene(Button button, String window) {
        button.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainPage.class.getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.getIcons().add(new Image("C:\\Users\\Cornel\\IdeaProjects\\ATM\\src\\main\\resources\\images\\share.png"));
        stage.setTitle("MordeATM");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

}
