package lk.ijse.mentalclinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.tm.TherapistTM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TherapistManagementController implements Initializable {
    @FXML
    public JFXComboBox cbSpecialization;
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXComboBox<String> cbStatus;

    @FXML
    private TableColumn<TherapistTM, String> colID;

    @FXML
    private TableColumn<TherapistTM, String> colName;

    @FXML
    private TableColumn<TherapistTM, String> colProgram;

    @FXML
    private TableColumn<TherapistTM, String> colStatus;

    @FXML
    private ImageView imgExit;

    @FXML
    private TableView<?> tblTherapist;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSpecialization;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReportOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbStatus.getItems().addAll("Available", "In Progress");
    }
}
