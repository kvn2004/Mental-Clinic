package lk.ijse.mentalclinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.bo.BOFactory;
import lk.ijse.mentalclinic.bo.custom.Impl.TherapyProgrammBOImpl;
import lk.ijse.mentalclinic.bo.custom.TherapyProgramBO;
import lk.ijse.mentalclinic.dto.TherapyProgramDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TherapProgramManagementController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    TherapyProgramBO therapyProgramBO= (TherapyProgramBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.THERAPYPROGRAMM);
    @FXML
    public TableColumn<?, ?> colid;
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colCost;

    @FXML
    private TableColumn<?, ?> colDes;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private ImageView imgExit;

    @FXML
    private TableView<?> tblTherapyprogram;

    @FXML
    public JFXTextField txtID;

    @FXML
    private JFXTextField txtCost;

    @FXML
    private JFXTextField txtDes;

    @FXML
    private JFXTextField txtDuration;

    @FXML
    private JFXTextField txtName;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReportOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String description = txtDes.getText();
        String cost = txtCost.getText();
        String duration = txtDuration.getText();

        if (!id.matches("\\d+")) {
            showAlert("Invalid ID", "ID must be numeric.");
            return;
        }

        if (!name.matches("[A-Za-z ]+")) {
            showAlert("Invalid Name", "Name must contain only letters and spaces.");
            return;
        }

        if (!description.matches(".{1,100}")) {
            showAlert("Invalid Description", "Description is required (max 100 characters).");
            return;
        }

        if (!cost.matches("\\d+(\\.\\d{1,2})?")) {
            showAlert("Invalid Cost", "Cost must be a valid number. (e.g., 100 or 99.99)");
            return;
        }

        if (!duration.matches("\\d+")) {
            showAlert("Invalid Duration", "Duration must be numeric.");
            return;
        }

        // All valid
        showAlert("Success", "All inputs are valid!");
        // Proceed with your logic...

        boolean isSaved=therapyProgramBO.saveProgram(new TherapyProgramDTO(id,name,duration,cost,description));
        if (isSaved){
            showAlert("Success", "Therapy program has been saved!");
        }
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void imgExitOnMouseClicked(MouseEvent event) throws IOException {
        Stage window = (Stage) imgExit.getScene().getWindow();
        window.close();
        Parent parent = FXMLLoader.load(getClass().getResource("/AdminDashboardForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

}}
