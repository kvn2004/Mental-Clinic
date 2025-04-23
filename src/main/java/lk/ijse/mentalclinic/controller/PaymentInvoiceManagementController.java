package lk.ijse.mentalclinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.PaymentDAO;
import lk.ijse.mentalclinic.tm.PaymentTM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentInvoiceManagementController implements Initializable {
    PaymentDAO paymentDAO = (PaymentDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.PAYMENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblPaymentId.setText(paymentDAO.generateNextPaymentId());
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
    private TableColumn<PaymentTM, PaymentTM> colAmount;

    @FXML
    private TableColumn<PaymentTM, PaymentTM> colDate;

    @FXML
    private TableColumn<PaymentTM, PaymentTM> colPatient;

    @FXML
    private TableColumn<PaymentTM, PaymentTM> colPaymentId;

    @FXML
    private TableColumn<PaymentTM, PaymentTM> colSession;

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

}
