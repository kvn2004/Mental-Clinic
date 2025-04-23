package lk.ijse.mentalclinic.bo.custom.Impl;

import lk.ijse.mentalclinic.bo.custom.PatientBO;
import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.PatientDao;
import lk.ijse.mentalclinic.dto.PatientDTO;
import lk.ijse.mentalclinic.entity.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/19/2025 1:34 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class PatientBOImpl implements PatientBO {
    PatientDao patientDao = (PatientDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.PATIENT);

    @Override
    public boolean savePatients(PatientDTO patientDTO) {
        return patientDao.save(new Patient(patientDTO.getPatientID(), patientDTO.getFullName(), patientDTO.getAge(), patientDTO.getPhone()));
    }

    @Override
    public List<PatientDTO> getAllPatiens() {
        List<Patient> all = patientDao.getAll();
        List<PatientDTO> patientsDTOS = new ArrayList<>();
        for (Patient patient : all) {
            patientsDTOS.add(new PatientDTO(patient.getPatientID(), patient.getFullName(), patient.getAge(), patient.getPhone()));
        }

        return patientsDTOS;
    }

    @Override
    public boolean deletePatient(String text) {
        return patientDao.delete(text);
    }

    @Override
    public boolean updatePatients(PatientDTO patientDTO) {
        return patientDao.update(new Patient(patientDTO.getPatientID(), patientDTO.getFullName(), patientDTO.getAge(), patientDTO.getPhone()));
    }

    @Override
    public List<String> getAllpatientsID() {
        return patientDao.getAllPatientID();
    }
}
