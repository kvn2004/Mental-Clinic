package lk.ijse.mentalclinic.util;

import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/22/2025 6:00 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/


public class AlertUtil {

  public static void showError(String title, String message) {
    Platform.runLater(() ->showAlert(title, message));
  }

  public static void showInfo(String title, String message) {
    Platform.runLater(() -> showAlert(title, message));
  }

  public static void showWarning(String title, String message) {
    Platform.runLater(() -> showAlert(title, message));
  }

  public static void showSuccess(String title, String message) {
    Platform.runLater(() -> showAlert(title, message));
  }

  private static void showAlert(String title, String message) {
    Platform.runLater(() -> {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle(title);
      alert.setHeaderText(null);
      alert.setContentText(message);
      //alert.initOwner(owner);
      alert.showAndWait();
    });
  }
}