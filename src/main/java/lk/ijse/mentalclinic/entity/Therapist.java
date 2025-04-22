package lk.ijse.mentalclinic.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Therapist {
    @Id
    private String therapistID;

    private String fullName;
    private String specialization;
    private String availabilitySchedule;


    @OneToMany(mappedBy = "therapist" ,cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<TherapySession> therapySessions;

}
