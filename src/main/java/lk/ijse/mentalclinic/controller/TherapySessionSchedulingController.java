package lk.ijse.mentalclinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class TherapySessionSchedulingController {

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXComboBox<?> cbPatient;

    @FXML
    private JFXComboBox<?> cbTheropy;

    @FXML
    private TableColumn<?, ?> colCost;

    @FXML
    private TableColumn<?, ?> colDes;

    @FXML
    private TableColumn<?, ?> colDueration;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private DatePicker dpSessionDate;

    @FXML
    private ImageView imgExit;

    @FXML
    private TableView<?> tbtTherapyShedule;

    @FXML
    private JFXTextField txtDes;

    @FXML
    private JFXTextField txtcost;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void imgExitOnMouseClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) imgExit.getScene().getWindow();
        stage.close();
        Parent load = FXMLLoader.load(getClass().getResource("/ReceptionistDashboardForm.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Mental Clinic");
        stage.show();
    }

}
