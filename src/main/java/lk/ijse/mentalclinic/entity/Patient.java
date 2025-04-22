package lk.ijse.mentalclinic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    private String patientID;
    private String fullName;
    private String age;
    private String phone;

    @OneToMany(mappedBy = "patient" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TherapySession> therapySessions;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;

    public Patient(String patientID, String fullName, String age, String phone) {
        this.patientID = patientID;
        this.fullName = fullName;
        this.age = age;
        this.phone = phone;
    }
}
