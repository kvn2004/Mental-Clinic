package lk.ijse.mentalclinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.bo.BOFactory;
import lk.ijse.mentalclinic.bo.custom.TherapyProgramBO;
import lk.ijse.mentalclinic.dto.TherapyProgramDTO;
import lk.ijse.mentalclinic.tm.TherapyProgramTM;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TherapProgramManagementController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtID.setText(therapyProgramBO.generateNextPaymentId());
        colid.setCellValueFactory(new PropertyValueFactory<>("programID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("fee"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("description"));
        loadTables();
    }

    TherapyProgramBO therapyProgramBO = (TherapyProgramBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.THERAPYPROGRAMM);
    @FXML
    public TableColumn<TherapyProgramTM, String> colid;
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<TherapyProgramTM, BigDecimal> colCost;

    @FXML
    private TableColumn<TherapyProgramTM, String> colDes;

    @FXML
    private TableColumn<TherapyProgramTM, String> colDuration;

    @FXML
    private TableColumn<TherapyProgramTM, String> colName;

    @FXML
    private ImageView imgExit;

    @FXML
    private TableView<TherapyProgramTM> tblTherapyprogram;

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

        boolean isDeleted=therapyProgramBO.deleteProgram(txtID.getText());
        if (isDeleted) {
            showAlert("Success", "Therapy program has been deleted!");
            refreshTable();
        }

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

        if (!id.matches("^TP\\d{3}$")) {
            showAlert("Invalid ID", "ID must start with 'TP' followed by 3 digits.");
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
        System.out.println("All are correct");
        // Proceed with your logic...
        BigDecimal fee = new BigDecimal(cost);
        boolean isSaved = therapyProgramBO.saveProgram(new TherapyProgramDTO(id, name, duration, fee, description));
        if (isSaved) {
            showAlert("Success", "Therapy program has been saved!");
            refreshTable();
        }
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String description = txtDes.getText();
        String cost = txtCost.getText();
        String duration = txtDuration.getText();

        if (!id.matches("^TP\\d{3}$")) {
            showAlert("Invalid ID", "ID must start with 'TP' followed by 3 digits.");
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
        System.out.println("All are correct");
        BigDecimal fee = new BigDecimal(cost);
        boolean isUpdated =therapyProgramBO.upadateProgremme(new TherapyProgramDTO(id, name, duration, fee, description));
        if (isUpdated) {
            showAlert("Success", "Therapy program has been updated!");
            refreshTable();
        }

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

    }

    private void loadTables() {

        // Get all programs from business layer
        List<TherapyProgramDTO> allPrograms = therapyProgramBO.getAllTherapyPrograms();

        // Convert to observable list for the table
        ObservableList<TherapyProgramTM> obList = FXCollections.observableArrayList();

        for (TherapyProgramDTO dto : allPrograms) {
            obList.add(new TherapyProgramTM(
                    dto.getProgramID(),
                    dto.getProgramName(),
                    dto.getDescription(),
                    dto.getFee(),
                    dto.getDuration()

            ));
        }

        // Set items to table
        tblTherapyprogram.setItems(obList);

    }
    public void refreshTable() {
        loadTables();
        txtID.setText(therapyProgramBO.generateNextPaymentId());
        txtName.setText("");
        txtCost.setText("");
        txtDuration.setText("");
        txtDes.setText("");
    }

    public void tblTherapyOnClick(MouseEvent mouseEvent) {
        TherapyProgramTM selectedItem = tblTherapyprogram.getSelectionModel().getSelectedItem();
        txtID.setText(selectedItem.getProgramID());
        txtName.setText(selectedItem.getProgramName());
        txtCost.setText(selectedItem.getFee().toString());
        txtDuration.setText(selectedItem.getDuration().toString());
        txtDes.setText(selectedItem.getDescription());
    }

}
