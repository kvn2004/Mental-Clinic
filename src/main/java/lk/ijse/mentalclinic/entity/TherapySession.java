package lk.ijse.mentalclinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @OneToMany(mappedBy = "therapySession",
            cascade = CascadeType.REMOVE,       // will cascade all ops (persist, remove, etc.)
            orphanRemoval = true)            // will delete orphans automatically
    private List<Payment> payments = new ArrayList<>();

}
