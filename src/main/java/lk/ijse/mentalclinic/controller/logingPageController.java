

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 3/11/2025 1:30 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

package lk.ijse.mentalclinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.mentalclinic.bo.BOFactory;
import lk.ijse.mentalclinic.bo.custom.UserBo;
import lk.ijse.mentalclinic.dto.UserDTO;
import lk.ijse.mentalclinic.util.PasswordUtil;

import java.io.IOException;
import java.util.List;

public class logingPageController {
    public Text signupText;
    UserBo userBo = (UserBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER);

    @FXML
    private AnchorPane ancLog;

    @FXML
    private JFXButton btnLoging;

    @FXML
    private ImageView imgshowPwd;

    @FXML
    private TextField pwdtextfield;

    @FXML
    private PasswordField txtPwd;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnLogingOnAction(ActionEvent event) throws IOException {
        String username = txtUsername.getText();
        String password = txtPwd.getText();
        List<UserDTO> userDTOS = userBo.checkUser(username, password);
        System.out.println(userDTOS);

        String role =userDTOS.get(0).getRole();
        boolean haveAccess=false;

        if (PasswordUtil.checkPassword(password,userDTOS.get(0).getPassword())){
            haveAccess=true;
        }else {
            new Alert(Alert.AlertType.ERROR, "Wrong PASSWORD..").show();
        }
        if (haveAccess){
            if (role.equalsIgnoreCase("admin")){
                Stage stage = (Stage) btnLoging.getScene().getWindow();
                stage.close();

                Parent load = FXMLLoader.load(getClass().getResource("/AdminDashboardForm.fxml"));
                Scene scene = new Scene(load);
                stage.setScene(scene);
                stage.setTitle("Mental Clinic");
                stage.show();
            }
            if (role.equalsIgnoreCase("Employee")){
                Stage stage = (Stage) btnLoging.getScene().getWindow();
                stage.close();
                Parent load = FXMLLoader.load(getClass().getResource("/ReceptionistDashboardForm.fxml"));
                Scene scene = new Scene(load);
                stage.setScene(scene);
                stage.setTitle("Mental Clinic");
                stage.show();
            }
        }

    }

    @FXML
    void imgshowPwdonMousePressed(MouseEvent event) {
        txtPwd.setVisible(false);
        txtPwd.setManaged(false);
        pwdtextfield.setVisible(true);
        pwdtextfield.setManaged(true);
        System.out.println(txtPwd.getText());
    }

    @FXML
    void imgshowPwdonMouseRelesed(MouseEvent event) {
        txtPwd.setVisible(true);
        txtPwd.setManaged(true);
        pwdtextfield.setVisible(false);
        pwdtextfield.setManaged(false);
        System.out.println(txtPwd.getText());
    }

    public void signupTextOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) signupText.getScene().getWindow();
        stage.close();

        Parent load = FXMLLoader.load(getClass().getResource("/addUser.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Mental Clinic");
        stage.show();
    }
}
