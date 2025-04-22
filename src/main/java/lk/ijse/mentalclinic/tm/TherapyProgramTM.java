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
 * Created: 4/22/2025 1:53 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TherapyProgramTM {
    private String programID;
    private String programName;
    private String duration;
    private BigDecimal fee;
    private String description;
}
