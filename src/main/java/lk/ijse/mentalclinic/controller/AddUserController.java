package lk.ijse.mentalclinic.controller;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 3/23/2025 11:26 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.Role;
import lk.ijse.mentalclinic.bo.BOFactory;
import lk.ijse.mentalclinic.bo.custom.AddUserBO;
import lk.ijse.mentalclinic.dto.UserDTO;
import lk.ijse.mentalclinic.exception.MyCustomRuntimeException;
import lk.ijse.mentalclinic.util.PasswordUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class
AddUserController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleComboBox.getItems().addAll(Role.values());
        roleComboBox.getSelectionModel().select(Role.ADMIN);
    }

    @FXML
    private Button cancelButton;

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<Role> roleComboBox;

    @FXML
    private Button saveButton;

    @FXML
    private TextField usernameField;

    AddUserBO addUserBO = (AddUserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ADDUSER);

    @FXML
    void handleCancel(ActionEvent event) {
        idField.setText("");
        passwordField.setText("");
        usernameField.setText("");
    }

    @FXML
    void handleSaveUser(ActionEvent event) throws IOException {
        String userIDPattern = "^[A-Za-z0-9]{4,10}$";              // 4-10 alphanumeric characters
        String usernamePattern = "^[A-Za-z]{3,15}$";               // 3-15 alphabet characters
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d).{6,}$"; // at least 1 letter & 1 digit, min 6 chars

        String userID = idField.getText().trim();
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String role = roleComboBox.getValue().toString();

        if (!userID.matches(userIDPattern)) {
            showAlert("Invalid User ID! Must be 4-10 alphanumeric characters.");
        } else if (!username.matches(usernamePattern)) {
            showAlert("Invalid Username! Must be 3-15 letters.");
        } else if (!password.matches(passwordPattern)) {
            showAlert("Invalid Password! Must be at least 6 characters with letters and numbers.");
        } else {
            System.out.println("User ID: " + userID + "\nUsername: " + username + "\nPassword: " + password + "\nRole: " + role);
            String hashpwd= PasswordUtil.hashPassword(password);
            try {
                boolean isSaved = addUserBO.saveUser(new UserDTO(userID, username, hashpwd, role));
                if (isSaved){
                    showAlert("User added successfully!");
                    Stage stage = (Stage) saveButton.getScene().getWindow();
                    stage.close();
                    Parent load = FXMLLoader.load(getClass().getResource("/logingPage.fxml"));
                    Scene scene = new Scene(load);
                    stage.setScene(scene);
                    stage.setTitle("Mental Clinic");
                    stage.show();
                }
            }catch (MyCustomRuntimeException e){
                showAlert(e.getMessage());
            }

        }
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
