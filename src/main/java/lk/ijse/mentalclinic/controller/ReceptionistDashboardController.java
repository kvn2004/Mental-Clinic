package lk.ijse.mentalclinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ReceptionistDashboardController {

    @FXML
    private JFXButton btnPatient;

    @FXML
    private JFXButton btnPatientHistory;

    @FXML
    private JFXButton btnPayment;

    @FXML
    private JFXButton btnTheropySession;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblMenu;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUserName;

    @FXML
    void patientHistoryOnAction(ActionEvent event) {

    }

    @FXML
    void patientOnAction(ActionEvent event) {

    }

    @FXML
    void paymentOnAction(ActionEvent event) {

    }

    @FXML
    void playMouseEnterAnimation(MouseEvent event) {
        Button source = (Button) event.getSource();

        switch (source.getId()) {
            case "btnPatient":
                lblMenu.setText("Manage Patients");
                lblDescription.setText("Click to add, edit, delete, search or view Patient");
                break;
            case "btnTheropySession":
                lblMenu.setText("Manage Theropy Sessions");
                lblDescription.setText("Click to add, edit, delete, search or view Theropy Session");
                break;
            case "btnPayment":
                lblMenu.setText("Manage Payments");
                lblDescription.setText("Click here if you want to See Payments");
                break;
            case "btnPatientHistory":
                lblMenu.setText("Manage Patients History");
                lblDescription.setText("Click here if you want to See patient history");
                break;

        }

        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), source);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();

        DropShadow glow = new DropShadow();
        glow.setColor(Color.web("#1e272e"));
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        source.setEffect(glow);
    }

    @FXML
    void playMouseExitAnimation(MouseEvent event) {
        Button source = (Button) event.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), source);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();

        source.setEffect(null);
        lblMenu.setText("Welcome");
        lblDescription.setText("Please select one of above main operations to proceed");
    }

    @FXML
    void therapySessionOnAction(ActionEvent event) {

    }

    public void imgExitOnMouseClicked(MouseEvent mouseEvent) {

    }
}
