package lk.ijse.mentalclinic.tm;

import lk.ijse.mentalclinic.entity.Patient;
import lk.ijse.mentalclinic.entity.Therapist;
import lk.ijse.mentalclinic.entity.TherapyProgram;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 3:20 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TherapySessionTM {
    private String sessionID;
    private String sessionDate;
    private String time;
    private String sessionStatus;
    private String patient;
    private String therapist;
    private String program;


}
