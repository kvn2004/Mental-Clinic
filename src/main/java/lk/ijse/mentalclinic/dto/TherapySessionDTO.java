package lk.ijse.mentalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TherapySessionDTO {
    private String sessionID;
    private LocalDate sessionDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String sessionStatus;
    
    // References to related entities
    private String patientID;
    private String therapistID;
    private String programID;
}
