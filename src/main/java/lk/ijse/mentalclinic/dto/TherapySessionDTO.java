package lk.ijse.mentalclinic.dto;

import lk.ijse.mentalclinic.entity.Patient;
import lk.ijse.mentalclinic.entity.Therapist;
import lk.ijse.mentalclinic.entity.TherapyProgram;
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
    private String sessionDate;
    private String time;
    private String sessionStatus;
    
    // References to related entities
    private String patientID;
    private String therapistID;
    private String programID;

    public TherapySessionDTO(String sessionID, String sessionDate, String time, String sessionStatus, Patient patient, Therapist therapist, TherapyProgram program) {
        this.sessionID = sessionID;
        this.sessionDate = sessionDate;
        this.time = time;
        this.sessionStatus = sessionStatus;
        this.patientID = patient.getPatientID();
        this.therapistID = therapist.getTherapistID();
        this.programID = program.getProgramID();
    }
}
