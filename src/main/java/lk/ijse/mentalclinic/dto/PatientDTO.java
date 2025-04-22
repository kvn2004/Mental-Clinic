package lk.ijse.mentalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String patientID;
    private String fullName;
    private String age;
    private String phone;
    
    // References to other entities - typically IDs or simplified objects
    private List<String> therapySessionIDs;
    private List<String> paymentIDs;

    public PatientDTO(String id, String name, String age, String tel) {
        this.patientID = id;
        this.fullName = name;
        this.age = age;
        this.phone = tel;
    }
}
