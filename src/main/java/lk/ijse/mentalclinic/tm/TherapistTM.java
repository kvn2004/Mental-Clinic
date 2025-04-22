package lk.ijse.mentalclinic.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/22/2025 1:11 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TherapistTM {
    private String therapistID;
    private String fullName;
    private String specialization;
    private String availabilitySchedule;
}
