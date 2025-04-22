package lk.ijse.mentalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TherapistDTO {
    private String therapistID;
    private String fullName;
    private String specialization;
    private String availabilitySchedule;
    
    // References to related entities
    private List<String> therapySessionIDs;

    public TherapistDTO(String therapistID, String fullName, String availabilitySchedule, String specialization) {
        this.therapistID = therapistID;
        this.fullName = fullName;
        this.availabilitySchedule = availabilitySchedule;
        this.specialization = specialization;
    }

}
