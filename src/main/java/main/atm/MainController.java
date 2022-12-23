package main.atm;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    int count = 0;

    @FXML
    void initialize() {
        enter_button.setOnAction(actionEvent -> {
            String cardNumber = cardNumber_field.getText().trim();
            String CVV = cvv_field.getText().trim();
            if (!cardNumber.equals(null) && !CVV.equals(null)){
                loginUser(cardNumber, CVV);
            }
            else {
                count++;
                if((count % 2) == 0) incorrectData_text.setText("");
                else incorrectData_text.setText("Incorrect data");
            }
        });

    }
    public void loginUser(String cardNumber, String CVV) {
        DBHandler dbHandler = new DBHandler();
        User user = new User();
        user.setCardNumber(cardNumber);
        user.setCVV(CVV);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while(true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }

        if (counter >= 1) {
            openNewScene(enter_button,"account-view.fxml");
        }
        else incorrectData_text.setText("Incorrect data");

    }

    public void openNewScene(Button button, String window) {
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
        stage.getIcons().add(new Image("C:\\Users\\Cornel\\IdeaProjects\\AppSkill1\\src\\main\\resources\\images\\app_image.png"));
        stage.setTitle("MordeATM");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();

    }

}
