module lk.ijse.mentalclinic {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens lk.ijse.mentalclinic.controller to javafx.fxml;
    exports lk.ijse.mentalclinic;
}