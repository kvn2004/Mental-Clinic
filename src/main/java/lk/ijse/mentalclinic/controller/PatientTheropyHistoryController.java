package lk.ijse.mentalclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class PatientTheropyHistoryController {

    @FXML
    private TableColumn<?, ?> colPatient;

    @FXML
    private TableColumn<?, ?> colPayment;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTheropy;

    @FXML
    private TableView<?> tblPatientTheropyHistory;

    public void imgExitOnMouseClicked(MouseEvent mouseEvent) {

    }
}
