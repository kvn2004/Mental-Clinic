package lk.ijse.mentalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private String paymentID;
    private BigDecimal amount;
    private String status;
    
    // Reference to patient
    private String patientID;
}
