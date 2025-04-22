package lk.ijse.mentalclinic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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

//    @OneToMany(mappedBy = "program")
//    private List<Registration> registrations;
//
//    @OneToMany(mappedBy = "program")
//    private List<TherapySession> therapySessions;
//
//    @OneToMany(mappedBy = "program")
//    private List<TherapistProgram> therapistPrograms;
}
