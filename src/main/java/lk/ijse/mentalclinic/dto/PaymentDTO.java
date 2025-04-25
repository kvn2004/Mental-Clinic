package lk.ijse.mentalclinic.dto;

import lk.ijse.mentalclinic.entity.Patient;
import lk.ijse.mentalclinic.entity.TherapySession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private String paymentID;
    private double amount;
    private String date;
    private String status;

    // Reference to patient
    private String patientID;
    private String sessionID;

    public PaymentDTO(String paymentID, double amount, String date, String status, Patient patient, TherapySession therapySession) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.patientID = (patient != null) ? patient.getPatientID() : "N/A";
        this.sessionID = (therapySession != null) ? therapySession.getSessionID() : "N/A";
    }

}

