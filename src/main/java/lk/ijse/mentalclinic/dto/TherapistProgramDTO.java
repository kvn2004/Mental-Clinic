package lk.ijse.mentalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TherapistProgramDTO {
    private String id;
    
    // References to related entities
    private String therapistID;
    private String programID;
}
