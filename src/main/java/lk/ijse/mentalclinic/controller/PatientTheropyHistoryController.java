package lk.ijse.mentalclinic.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class PatientTheropyHistoryController {

    public ImageView imgExit;
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
