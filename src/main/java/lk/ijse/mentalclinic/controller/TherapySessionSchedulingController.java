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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.bo.BOFactory;
import lk.ijse.mentalclinic.bo.custom.TherepistBO;
import lk.ijse.mentalclinic.bo.custom.PatientBO;
import lk.ijse.mentalclinic.bo.custom.PaymentBO;
import lk.ijse.mentalclinic.bo.custom.TherapyProgramBO;
import lk.ijse.mentalclinic.bo.custom.TherapySessionBO;
import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.PaymentDAO;
import lk.ijse.mentalclinic.dao.custom.TherapySessionDAO;
import lk.ijse.mentalclinic.dto.PaymentDTO;
import lk.ijse.mentalclinic.dto.TherapySessionDTO;
import lk.ijse.mentalclinic.tm.TherapySessionTM;
import lk.ijse.mentalclinic.util.AlertUtil;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class TherapySessionSchedulingController implements Initializable {
    TherepistBO therepistBO = (TherepistBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.THERAPIST);
    TherapyProgramBO therapyProgramBO = (TherapyProgramBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.THERAPYPROGRAMM);
    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PATIENT);
    PaymentBO paymentBO = (PaymentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);
    TherapySessionBO therapySessionBO = (TherapySessionBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.THERAPYSESSION);
    TherapySessionDAO therapySessionDAO = (TherapySessionDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.TherapySession);
    PaymentDAO paymentDAO = (PaymentDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.PAYMENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<>("sessionID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("sessionDate"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("sessionStatus"));
        ColPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        colTherapist.setCellValueFactory(new PropertyValueFactory<>("therapist"));
        colTherapy.setCellValueFactory(new PropertyValueFactory<>("program"));
        setValues();
        loadTables();
    }

    @FXML
    private TableColumn<TherapySessionTM, String> ColPatient;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXComboBox<String> cbPatient;

    @FXML
    private JFXComboBox<String> cbStatus;

    @FXML
    private JFXComboBox<String> cbTherapy;

    @FXML
    private JFXComboBox<String> cbTheropist;

    @FXML
    private JFXComboBox<String> cbTime;

    @FXML
    private TableColumn<TherapySessionTM, String> colDate;

    @FXML
    private TableColumn<TherapySessionTM, String> colID;

    @FXML
    private TableColumn<TherapySessionTM, String> colStatus;

    @FXML
    private TableColumn<TherapySessionTM, String> colTherapist;

    @FXML
    private TableColumn<TherapySessionTM, String> colTherapy;

    @FXML
    private TableColumn<TherapySessionTM, String> colTime;

    @FXML
    private DatePicker dpSessionDate;

    @FXML
    private ImageView imgExit;

    @FXML
    private TableView<TherapySessionTM> tbtTherapyShedule;

    @FXML
    private JFXTextField txtID;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id= txtID.getText();
        boolean isDeleted = therapySessionBO.deleteSession(id);
       // boolean ispayment = paymentBO.deletePayment(paymentBO.getPaymentIDBySessionID(id));
        if (isDeleted){
            refresh();
            AlertUtil.showSuccess("Successfully deleted the session","Session successfully deleted");
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id= txtID.getText();
        String status= cbStatus.getSelectionModel().getSelectedItem();
        String therapy= cbTherapy.getSelectionModel().getSelectedItem();
        String patient= cbPatient.getSelectionModel().getSelectedItem();
        String therapist=cbTheropist.getSelectionModel().getSelectedItem();
        String time= cbTime.getSelectionModel().getSelectedItem();
        String date= String.valueOf(dpSessionDate.getValue());
        System.out.println(therapy);
        boolean isSheduled=therapySessionBO.saveSession(new TherapySessionDTO(id,date,time,status,patient,therapist,therapy));

        PaymentDTO dto =new PaymentDTO();
        dto.setPaymentID(paymentDAO.generateNextPaymentId());
        dto.setAmount(therapyProgramBO.getProgramPrice(therapy));
        dto.setDate(date);
        dto.setStatus(status);
        dto.setPatientID(patient);
        dto.setSessionID(txtID.getText());
        boolean isPaymentAded=paymentBO.savePayment(dto);

        if (isSheduled && isPaymentAded) {
            AlertUtil.showSuccess("Successfully saved the session","Successfully saved the session");
            refresh();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id= txtID.getText();
        String status= cbStatus.getSelectionModel().getSelectedItem();
        String therapy= cbTherapy.getSelectionModel().getSelectedItem();
        String patient= cbPatient.getSelectionModel().getSelectedItem();
        String therapist=cbTheropist.getSelectionModel().getSelectedItem();
        String time= cbTime.getSelectionModel().getSelectedItem();
        String date= String.valueOf(dpSessionDate.getValue());
        boolean isUpdated=therapySessionBO.updateSession(new TherapySessionDTO(id,date,time,status,patient,therapist,therapy));

        PaymentDTO dto =new PaymentDTO();
        dto.setPaymentID(paymentBO.getPaymentIDBySessionID(id));
        dto.setAmount(therapyProgramBO.getProgramPrice(therapy));
        dto.setDate(date);
        dto.setStatus(status);
        dto.setPatientID(patient);
        dto.setSessionID(txtID.getText());
        boolean isUpdatedPay=paymentBO.updatePayment(dto);

        if (isUpdated && isUpdatedPay) {
            AlertUtil.showSuccess("Successfully updated the session","Successfully updated the session");
            refresh();
        }
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

    @FXML
    void tbtTherapySheduleOnClicked(MouseEvent event) {
        TherapySessionTM selectedItem = tbtTherapyShedule.getSelectionModel().getSelectedItem();

        txtID.setText(selectedItem.getSessionID());
        cbTime.setValue(selectedItem.getTime());
        dpSessionDate.setValue(LocalDate.parse(selectedItem.getSessionDate()));
        cbStatus.setValue(selectedItem.getSessionStatus());
        cbPatient.setValue(selectedItem.getPatient());
        cbTheropist.setValue(selectedItem.getTherapist());
        cbTherapy.setValue(selectedItem.getProgram());

    }

    private void setValues() {
        List<String> allProgramID = therapyProgramBO.getAllProgramID();
        List<String> allTherapistID = therepistBO.getAllTherapistID();
        List<String> allPatientID = patientBO.getAllpatientsID();
        cbTherapy.getItems().addAll(allProgramID);
        cbTheropist.getItems().addAll(allTherapistID);
        cbPatient.getItems().addAll(allPatientID);
        cbStatus.getItems().addAll("Pending", "Completed");

        txtID.setText(therapySessionDAO.generateNextSessionId());
        cbTime.getItems().addAll("08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM");
    }

    void loadTables(){
        List<TherapySessionDTO> therapySessionDTOS = therapySessionBO.getAllTherapyPrograms();

        ObservableList<TherapySessionTM> obList = FXCollections.observableArrayList();
        System.out.println(obList);
        for (TherapySessionDTO dto:therapySessionDTOS){
            obList.add(new TherapySessionTM(
                    dto.getSessionID(),
                    dto.getSessionDate(),
                    dto.getTime(),
                    dto.getSessionStatus(),
                    dto.getPatientID(),
                    dto.getTherapistID(),
                    dto.getProgramID()
            ));
        }
        tbtTherapyShedule.setItems(obList);
    }
    void refresh(){
        txtID.setText(therapySessionDAO.generateNextSessionId());
        cbTime.setValue("");
        dpSessionDate.setValue(null);
        cbStatus.setValue("");
        cbPatient.setValue("");
        cbTheropist.setValue("");
        cbTherapy.setValue("");
        loadTables();
    }
}
