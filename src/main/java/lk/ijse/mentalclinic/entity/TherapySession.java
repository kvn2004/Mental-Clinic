package lk.ijse.mentalclinic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TherapySession {
    @Id
    private String sessionID;
    private String sessionDate;
    private String Time;
    private String sessionStatus;

    @ManyToOne
    @JoinColumn(name = "patientID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "therapistID")
    private Therapist therapist;

    @ManyToOne
    @JoinColumn(name = "programID")
    private TherapyProgram program;

}
