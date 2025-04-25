package lk.ijse.mentalclinic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TherapyProgram {
    @Id
    private String programID;
    private String programName;
    private String duration;
    private BigDecimal fee;
    private String description;
    // If necessary, you can define the reverse relationship
    @OneToMany(mappedBy = "program", cascade = CascadeType.REMOVE)
    private List<TherapySession> sessions = new ArrayList<>();

}
