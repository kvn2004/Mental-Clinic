package lk.ijse.mentalclinic.bo.custom;

import lk.ijse.mentalclinic.bo.SuperBO;
import lk.ijse.mentalclinic.dto.PatientDTO;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/19/2025 1:27 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface PatientBO extends SuperBO {
    boolean savePatients(PatientDTO patientDTO);

    List<PatientDTO> getAllPatiens();

    boolean deletePatient(String text);

    boolean updatePatients(PatientDTO patientDTO);

    List<String> getAllpatientsID();
}
