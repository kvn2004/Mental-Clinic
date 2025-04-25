package lk.ijse.mentalclinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.bo.BOFactory;
import lk.ijse.mentalclinic.bo.custom.TherepistBO;
import lk.ijse.mentalclinic.dto.TherapistDTO;
import lk.ijse.mentalclinic.tm.TherapistTM;
import lk.ijse.mentalclinic.util.AlertUtil;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;



public class TherapistManagementController implements Initializable {
    TherepistBO therepistBO = (TherepistBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.THERAPIST);
    @FXML
    public JFXComboBox<String> cbSpecialization;
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
    private TableView<TherapistTM> tblTherapist;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSpecialization;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
       boolean isDeleted =therepistBO.deleteTherapist(txtID.getText());
       if(isDeleted){
           AlertUtil.showSuccess("Deleted Therapist","Therapist deleted successfully");
           refresh();
       }
    }

    @FXML
    void btnReportOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String specialization = cbSpecialization.getValue();
        String status = cbStatus.getValue();
        // Regex patterns
        Pattern idPattern = Pattern.compile("^T\\d{3}$");
        Pattern namePattern = Pattern.compile("^[A-Za-z ]{3,}$");

        if (!idPattern.matcher(id).matches()) {
            AlertUtil.showError("Invalid ID", "ID must start with 'T' followed by 3 digits.");
            return;
        }

        if (!namePattern.matcher(name).matches()) {
            AlertUtil.showError("Invalid Name", "Name must contain only letters and be at least 3 characters.");
            return;
        }

        if (specialization == null || specialization.isEmpty()) {
            AlertUtil.showError("Specialization Required", "Please select a specialization.");
            return;
        }

        if (status == null || status.isEmpty()) {
            AlertUtil.showError("Status Required", "Please select a status.");
            return;
        }
        System.out.println("Valid data. Proceed with saving...");

        TherapistDTO therapist = new TherapistDTO();
        therapist.setTherapistID(id);
        therapist.setFullName(name);
        therapist.setSpecialization(specialization);
        therapist.setAvailabilitySchedule(status);

        boolean isSaved = therepistBO.saveTherapist(therapist);
        if(isSaved){
            AlertUtil.showSuccess("Successful","Successfully saved the therapist.");
            refresh();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        String id = txtID.getText();
        String name = txtName.getText();
        String specialization = cbSpecialization.getValue();
        String status = cbStatus.getValue();
        // Regex patterns
        Pattern idPattern = Pattern.compile("^T\\d{3}$");
        Pattern namePattern = Pattern.compile("^[A-Za-z ]{3,}$");

        if (!idPattern.matcher(id).matches()) {
            AlertUtil.showError("Invalid ID", "ID must start with 'T' followed by 3 digits.");
            return;
        }

        if (!namePattern.matcher(name).matches()) {
            AlertUtil.showError("Invalid Name", "Name must contain only letters and be at least 3 characters.");
            return;
        }

        if (specialization == null || specialization.isEmpty()) {
            AlertUtil.showError("Specialization Required", "Please select a specialization.");
            return;
        }

        if (status == null || status.isEmpty()) {
            AlertUtil.showError("Status Required", "Please select a status.");
            return;
        }
        System.out.println("Valid data. Proceed with saving...");

        TherapistDTO therapist = new TherapistDTO();
        therapist.setTherapistID(id);
        therapist.setFullName(name);
        therapist.setSpecialization(specialization);
        therapist.setAvailabilitySchedule(status);

        boolean isUpdated = therepistBO.updateTherapist(therapist);
        if (isUpdated){
            AlertUtil.showSuccess("Successful","Successfully updated the therapist.");
            refresh();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtID.setText(therepistBO.generateNextPaymentId());
        colID.setCellValueFactory(new PropertyValueFactory<>("therapistID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("availabilitySchedule"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("specialization"));

        cbStatus.getItems().addAll("Available", "In Progress");
        setValues();
        loadTable();

    }
    private void setValues() {
        List<String> allProgram = therepistBO.getAllProgram();
        ObservableList<String> objects = FXCollections.observableArrayList();
        for (String program:allProgram){
            objects.add(program);
        }
        cbSpecialization.setItems(objects);
    }
   private void loadTable(){
        List<TherapistDTO> therapistDTOS = therepistBO.getAllTherapyPrograms();

        ObservableList<TherapistTM> obList = FXCollections.observableArrayList();
       System.out.println(obList);
        for (TherapistDTO therapistDTO:therapistDTOS){
            obList.add(new TherapistTM(
                    therapistDTO.getTherapistID(),
                    therapistDTO.getFullName(),
                    therapistDTO.getAvailabilitySchedule(),
                    therapistDTO.getSpecialization()
            ));
        }
        tblTherapist.setItems(obList);
    }

   private void refresh(){
        loadTable();
       txtID.setText(therepistBO.generateNextPaymentId());

         txtName.setText("");
        cbSpecialization.setValue(null);
        cbStatus.setValue(null);
    }

    public void therapistOnClick(MouseEvent mouseEvent) {
        TherapistTM selectedItem = tblTherapist.getSelectionModel().getSelectedItem();
        txtID.setText(selectedItem.getTherapistID());
        txtName.setText(selectedItem.getFullName());
        cbSpecialization.setValue(selectedItem.getSpecialization());
        cbStatus.setValue(selectedItem.getAvailabilitySchedule());
    }
}
