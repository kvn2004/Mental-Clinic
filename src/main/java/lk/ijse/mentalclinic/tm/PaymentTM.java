package lk.ijse.mentalclinic.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 2:41 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTM {
    private String paymentID;
    private BigDecimal amount;
    private String status;

    // Reference to patient
    private String patientID;
    private String sessionID;
}
