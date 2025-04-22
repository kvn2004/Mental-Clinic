package lk.ijse.mentalclinic.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 1:02 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientTM {
    private String patientID;
    private String fullName;
    private String age;
    private String phone;
}
