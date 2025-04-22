package lk.ijse.mentalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    private String registrationID;
    
    // References to related entities
    private String patientID;
    private String programID;
    private String paymentID;
}
