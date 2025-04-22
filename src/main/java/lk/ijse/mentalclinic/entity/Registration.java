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
public class Registration {
    @Id
    private String registrationID;

    @ManyToOne
    @JoinColumn(name = "patientID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "programID")
    private TherapyProgram program;

    @OneToOne
    @JoinColumn(name = "paymentID")
    private Payment payment;


}
