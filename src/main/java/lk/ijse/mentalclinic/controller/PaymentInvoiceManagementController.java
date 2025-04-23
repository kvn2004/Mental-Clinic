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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.bo.BOFactory;
import lk.ijse.mentalclinic.bo.custom.PaymentBO;
import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.PaymentDAO;
import lk.ijse.mentalclinic.dto.PaymentDTO;
import lk.ijse.mentalclinic.dto.TherapySessionDTO;
import lk.ijse.mentalclinic.tm.PaymentTM;
import lk.ijse.mentalclinic.tm.TherapySessionTM;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PaymentInvoiceManagementController implements Initializable {
    PaymentDAO paymentDAO = (PaymentDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.PAYMENT);
    PaymentBO paymentBO = (PaymentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblPaymentId.setText(paymentDAO.generateNextPaymentId());

        colPaymentId.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
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
    private JFXComboBox<String> cbPatient;

    @FXML
    private TableColumn<PaymentTM, String> colAmount;

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

    }

    void loadTables(){
        List<PaymentDTO> dtos = paymentBO.getAllpayment();
        ObservableList<PaymentTM> obList = FXCollections.observableArrayList();
        System.out.println(dtos);
        for (PaymentDTO dto:dtos){
            obList.add(new PaymentTM(
                 dto.getPaymentID(),
                 dto.getAmount()+"",
                 dto.getStatus(),
                 dto.getPatientID(),
                 dto.getSessionID()
            ));
        }
        tblPayments.setItems(obList);
    }
    void refresh(){
        loadTables();
    }
}
