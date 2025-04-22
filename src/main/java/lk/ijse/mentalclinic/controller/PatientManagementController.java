package lk.ijse.mentalclinic.controller;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 3/11/2025 12:53 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.bo.BOFactory;

import java.io.IOException;

public class PatientManagementController {

    @FXML
    private JFXButton btnDelete;

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
    private TableView<?> tblPatient;

    @FXML
    private JFXTextField txtCost;

    @FXML
    private JFXTextField txtDes;

    @FXML
    private JFXTextField txtDuration;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSearch;
    @FXML
    ImageView imgExit;

    BOFactory factory = (BOFactory) BOFactory.getInstance().getBO(BOFactory.BOTypes.PATIENT);

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
    void txtSearchTextchange(InputMethodEvent event) {

    }

    public void imgExitOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage) imgExit.getScene().getWindow();
        window.close();
        Parent parent = FXMLLoader.load(getClass().getResource("/AdminDashboardForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}

