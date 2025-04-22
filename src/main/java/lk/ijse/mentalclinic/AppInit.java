package lk.ijse.mentalclinic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.mentalclinic.config.FactoryConfiguration;
import lk.ijse.mentalclinic.entity.User;
import org.hibernate.Session;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 3/11/2025 1:18 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class AppInit extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSession();
        List<User> users = session.createQuery("FROM User", User.class).list();
        boolean checker = false;
        for (User user : users) {
            if (user.getRole().equalsIgnoreCase("admin")) {
                checker = true;
                break;
            }
        }
        if (checker) {
            Parent load = FXMLLoader.load(getClass().getResource("/logingPage.fxml"));
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.setTitle("Mental Clinic");
            stage.show();
        }else {
            Parent load = FXMLLoader.load(getClass().getResource("/addUser.fxml"));
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.setTitle("Mental Clinic");
            stage.show();
        }
    }
}
//public class AppInit extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage stage) {
//        boolean isAdminPresent = checkAdminUser();
//
//        String fxmlPath = isAdminPresent ? "/logingPage.fxml" : "/addUser.fxml";
//        loadScene(stage, fxmlPath, "Mental Clinic");
//    }
//
//    private boolean checkAdminUser() {
//        boolean adminExists = false;
//        try (Session session = FactoryConfiguration.getInstance().getSession()) {
//            List<User> users = session.createQuery("FROM User", User.class).list();
//            for (User user : users) {
//                if ("admin".equalsIgnoreCase(user.getRole())) {
//                    adminExists = true;
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();  // Replace with proper logging
//        }
//        return adminExists;
//    }
//
//    private void loadScene(Stage stage, String fxmlPath, String title) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setTitle(title);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();  // Replace with proper logging
//        }
//    }
//}

