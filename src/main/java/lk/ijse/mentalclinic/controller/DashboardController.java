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
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class DashboardController {
    @FXML
    public Label lblMenu;
    @FXML
    public Label lblDescription;
    @FXML
    public AnchorPane root;
    public ImageView imgExit;
    @FXML
    private JFXButton btnTherapist;

    @FXML
    private JFXButton btn_patientHistory;

    @FXML
    private JFXButton btn_theropyProgram;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUserName;

    @FXML
    void patientHistoryOnAction(ActionEvent event) throws IOException {
        Stage window = (Stage) btn_patientHistory.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/PatientTheropyHistoryForm.fxml"));
        navigate(load);


    }

    @FXML
    void therapistOnAction(ActionEvent event) throws IOException {
        Stage window = (Stage) btn_patientHistory.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/TherapistManagementForm.fxml"));
        navigate(load);
    }

    @FXML
    void theropyProgramOnAction(ActionEvent event) throws IOException {
        Stage window = (Stage) btn_patientHistory.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/TherapyProgramManagementForm.fxml"));
        navigate(load);
    }

    void navigate(Parent root) {
        if (root != null) {
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
        Button source = (Button) mouseEvent.getSource();
        switch (source.getId()) {
            case "btnTherapist":
                lblMenu.setText("Manage Therapist");
                lblDescription.setText("Click to add, edit, delete, search or view Therapist");
                break;
            case "btn_theropyProgram":
                lblMenu.setText("Manage Programs");
                lblDescription.setText("Click to add, edit, delete, search or view programs");
                break;
            case "btn_patientHistory":
                lblMenu.setText("Manage Patients");
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

    public void playMouseExitAnimation(MouseEvent mouseEvent) {

        Button source = (Button) mouseEvent.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), source);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();

        source.setEffect(null);
        lblMenu.setText("Welcome");
        lblDescription.setText("Please select one of above main operations to proceed");

    }

    public void imgExitOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) imgExit.getScene().getWindow();
        stage.close();

        Parent load = FXMLLoader.load(getClass().getResource("/logingPage.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Mental Clinic");
        stage.show();
    }
}
