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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.bo.BOFactory;
import lk.ijse.mentalclinic.bo.custom.PatientBO;
import lk.ijse.mentalclinic.dto.PatientDTO;
import lk.ijse.mentalclinic.dto.TherapistDTO;
import lk.ijse.mentalclinic.tm.PatientTM;
import lk.ijse.mentalclinic.tm.TherapistTM;
import lk.ijse.mentalclinic.util.AlertUtil;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PatientManagementController implements Initializable {
    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PATIENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("phone"));
        loadTable();
    }

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<PatientTM, String> colAge;

    @FXML
    private TableColumn<PatientTM, String> colID;

    @FXML
    private TableColumn<PatientTM, String> colName;

    @FXML
    private TableColumn<PatientTM, String> colTel;

    @FXML
    private ImageView imgExit;

    @FXML
    private TableView<PatientTM> tblPatient;

    @FXML
    private JFXTextField txtAge;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPatientID;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXTextField txtTel;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        boolean isDeleted = patientBO.deletePatient(txtPatientID.getText());
        if (isDeleted) {
            refresh();
            AlertUtil.showSuccess("Successful","Delete Patient Successfully");
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtPatientID.getText();
        String name = txtName.getText();
        String age = txtAge.getText();
        String tel = txtTel.getText();

        // Regex patterns
        String idPattern = "P\\d{3}";                    // Example: P001, P123
        String namePattern = "[A-Za-z ]{3,}";            // Letters and spaces, min 3 characters
        String agePattern = "1[0-9]{1,2}|[2-9][0-9]?";   // 10–199, or 2–99
        String telPattern = "0\\d{9}";                   // Sri Lankan format: 10 digits starting with 0

        // Validations
        if (!id.matches(idPattern)) {
            AlertUtil.showError("Invalid ID", "Patient ID should be in the format P001.");
            return;
        }

        if (!name.matches(namePattern)) {
            AlertUtil.showError("Invalid Name", "Name should contain only letters and spaces (min 3 characters).");
            return;
        }

        if (!age.matches(agePattern)) {
            AlertUtil.showError("Invalid Age", "Age must be a number between 10 and 199.");
            return;
        }

        if (!tel.matches(telPattern)) {
            AlertUtil.showError("Invalid Phone Number", "Phone number should contain exactly 10 digits starting with 0 (e.g., 0771234567).");
            return;
        }
        boolean isSaved = patientBO.savePatients(new PatientDTO(id,name,age,tel));
        if (isSaved) {
            AlertUtil.showSuccess("Patient Saved", "Patient Saved");
            refresh();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtPatientID.getText();
        String name = txtName.getText();
        String age = txtAge.getText();
        String tel = txtTel.getText();

        // Regex patterns
        String idPattern = "P\\d{3}";                    // Example: P001, P123
        String namePattern = "[A-Za-z ]{3,}";            // Letters and spaces, min 3 characters
        String agePattern = "1[0-9]{1,2}|[2-9][0-9]?";   // 10–199, or 2–99
        String telPattern = "0\\d{9}";                   // Sri Lankan format: 10 digits starting with 0

        // Validations
        if (!id.matches(idPattern)) {
            AlertUtil.showError("Invalid ID", "Patient ID should be in the format P001.");
            return;
        }

        if (!name.matches(namePattern)) {
            AlertUtil.showError("Invalid Name", "Name should contain only letters and spaces (min 3 characters).");
            return;
        }

        if (!age.matches(agePattern)) {
            AlertUtil.showError("Invalid Age", "Age must be a number between 10 and 199.");
            return;
        }

        if (!tel.matches(telPattern)) {
            AlertUtil.showError("Invalid Phone Number", "Phone number should contain exactly 10 digits starting with 0 (e.g., 0771234567).");
            return;
        }
        boolean isUpdated = patientBO.updatePatients(new PatientDTO(id,name,age,tel));
        if (isUpdated) {
            AlertUtil.showSuccess("Updated", "Patient Updated");
            refresh();
        }
    }

    @FXML
    public void imgExitOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage) imgExit.getScene().getWindow();
        window.close();
        Parent parent = FXMLLoader.load(getClass().getResource("/ReceptionistDashboardForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void tblPatientClicked(MouseEvent event) {
        PatientTM selectedItem = tblPatient.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            txtPatientID.setText(selectedItem.getPatientID());
            txtName.setText(selectedItem.getFullName());
            txtAge.setText(selectedItem.getAge());
            txtTel.setText(selectedItem.getPhone());
        }

    }

    @FXML
    void txtSearchTextchange(InputMethodEvent event) {

    }

    void loadTable(){
        List<PatientDTO> patientDTOS = patientBO.getAllPatiens();

        ObservableList<PatientTM> obList = FXCollections.observableArrayList();
        System.out.println(obList);
        for (PatientDTO DTO:patientDTOS){
            obList.add(new PatientTM(
                    DTO.getPatientID(),
                    DTO.getFullName(),
                    DTO.getAge(),
                    DTO.getPhone()
            ));
        }
        tblPatient.setItems(obList);
    }
    void refresh(){
        loadTable();
        txtPatientID.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtTel.setText("");
    }

}
