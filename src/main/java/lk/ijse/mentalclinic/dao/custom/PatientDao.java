package lk.ijse.mentalclinic.dao.custom;

import lk.ijse.mentalclinic.dao.CrudDAO;
import lk.ijse.mentalclinic.dao.SuperDao;
import lk.ijse.mentalclinic.entity.Patient;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/19/2025 1:38 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface PatientDao extends CrudDAO<Patient> {
    List<String> getAllPatientID();
    Patient findById(String patientID);
    String generateNextPaymentId();
}
