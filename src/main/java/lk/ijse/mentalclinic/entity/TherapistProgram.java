package lk.ijse.mentalclinic.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TherapistProgram {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "therapistID")
    private Therapist therapist;

    @ManyToOne
    @JoinColumn(name = "programID")
    private TherapyProgram program;
}
