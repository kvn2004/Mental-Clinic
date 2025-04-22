package lk.ijse.mentalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TherapyProgramDTO {
    private String programID;
    private String programName;
    private String duration;
    private BigDecimal fee;
    private String description;

}
