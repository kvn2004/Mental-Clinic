module lk.ijse.mentalclinic {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires static lombok;
    requires java.naming;
    requires jbcrypt;
    requires mysql.connector.j;
    requires net.sf.jasperreports.core;


    opens lk.ijse.mentalclinic.controller to javafx.fxml;
    opens lk.ijse.mentalclinic.entity to org.hibernate.orm.core;
    opens lk.ijse.mentalclinic.tm to javafx.base;

    exports lk.ijse.mentalclinic;

}