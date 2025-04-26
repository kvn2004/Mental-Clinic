package lk.ijse.mentalclinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.bo.BOFactory;
import lk.ijse.mentalclinic.bo.custom.PatientBO;
import lk.ijse.mentalclinic.bo.custom.PaymentBO;
import lk.ijse.mentalclinic.bo.custom.TherapySessionBO;
import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.PaymentDAO;
import lk.ijse.mentalclinic.dto.PaymentDTO;
import lk.ijse.mentalclinic.dto.TherapySessionDTO;
import lk.ijse.mentalclinic.tm.PaymentTM;
import lk.ijse.mentalclinic.util.AlertUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class PaymentInvoiceManagementController implements Initializable {

    PaymentDAO paymentDAO = (PaymentDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.PAYMENT);
    PaymentBO paymentBO = (PaymentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);
    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PATIENT);
    TherapySessionBO therapySessionBO = (TherapySessionBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.THERAPYSESSION);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblPaymentId.setText(paymentDAO.generateNextPaymentId());
        cbStatus.getItems().addAll("Pending", "Completed");
        cbPatient.getItems().addAll(patientBO.getAllpatientsID());
        colPaymentId.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colPatient.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        colSession.setCellValueFactory(new PropertyValueFactory<>("sessionID"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        loadTables();
    }

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;
    @FXML
    public JFXComboBox<String> cbStatus;

    @FXML
    private JFXComboBox<String> cbPatient;

    @FXML
    private TableColumn<PaymentTM, BigDecimal> colAmount;
    @FXML
    private TableColumn<PaymentTM, String> colStatus;

    @FXML
    private TableColumn<PaymentTM, String> colDate;

    @FXML
    private TableColumn<PaymentTM, String> colPatient;

    @FXML
    private TableColumn<PaymentTM, String> colPaymentId;

    @FXML
    private TableColumn<PaymentTM, String> colSession;

    @FXML
    private ImageView imgExit;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblSession;

    @FXML
    private TableView<PaymentTM> tblPayments;


    @FXML
    void btnReportOnAction(ActionEvent event) {

        String paymentID = lblPaymentId.getText();
        String amountText = lblAmount.getText();
        String date = lblDate.getText();
        String patientID = cbPatient.getValue();
        String sessionID = lblSession.getText();
        String status = cbStatus.getValue();

        if (paymentID == null || paymentID.isEmpty()) {
            System.err.println("Payment ID is required");
            return;
        }
        double amount = 0;
        try {
            amount = amountText == null || amountText.isEmpty()
                    ? 0
                    : Double.parseDouble(amountText);
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid amount: " + amountText);
            return;
        }
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("paymentID", paymentID);
        parameters.put("amount", amount);
        parameters.put("date", date);
        parameters.put("patientID", patientID);
        parameters.put("sessionID", sessionID);
        parameters.put("status", status);
        InputStream reportStream = getClass().getResourceAsStream("/Payment.jrxml");
        if (reportStream == null) {
            System.err.println("Cannot find /reports/Payment.jrxml on classpath");
            return;
        }
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport,
                    parameters,
                    new JREmptyDataSource(1)
            );
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException jrEx) {

            jrEx.printStackTrace();
        }
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        PaymentDTO dto = new PaymentDTO();
        dto.setPaymentID(lblPaymentId.getText());
        dto.setStatus(cbStatus.getValue());
        boolean isStatusUpdated = paymentBO.StatusUpdate(dto);
        TherapySessionDTO sessionDTO = new TherapySessionDTO();
        sessionDTO.setSessionID(lblSession.getText());
        sessionDTO.setSessionStatus(cbStatus.getValue());
        boolean isStatusUpdated2 = therapySessionBO.StatusUpdate(sessionDTO);
        if (isStatusUpdated && isStatusUpdated2) {
            AlertUtil.showSuccess("", "Successfully updated the PAYMENT STATUS");
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
    void paymentSelectOnAction(MouseEvent event) {
        PaymentTM selectedItem = tblPayments.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lblPaymentId.setText(selectedItem.getPaymentID());
            lblDate.setText(selectedItem.getDate());
            lblSession.setText(selectedItem.getSessionID());
            lblAmount.setText(String.valueOf(selectedItem.getAmount()));
            cbStatus.setValue(selectedItem.getStatus());
            cbPatient.setValue(selectedItem.getPatientID());
        }

    }

    void loadTables() {
        List<PaymentDTO> dtos = paymentBO.getAllpayment();
        ObservableList<PaymentTM> obList = FXCollections.observableArrayList();

        for (PaymentDTO dto : dtos) {
            obList.add(new PaymentTM(
                    dto.getPaymentID(),
                    dto.getAmount(),
                    dto.getDate(),
                    dto.getStatus(),
                    dto.getPatientID(),
                    dto.getSessionID()
            ));
        }

        tblPayments.setItems(obList);
    }

    void refresh() {
        loadTables();
    }
}
