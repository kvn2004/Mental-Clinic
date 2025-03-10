module lk.ijse.mentalclinic {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.mentalclinic to javafx.fxml;
    exports lk.ijse.mentalclinic;
}