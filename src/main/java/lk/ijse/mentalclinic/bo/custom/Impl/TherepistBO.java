package lk.ijse.mentalclinic.bo.custom.Impl;

import lk.ijse.mentalclinic.bo.SuperBO;
import lk.ijse.mentalclinic.dto.TherapistDTO;
import lk.ijse.mentalclinic.entity.Therapist;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/22/2025 5:42 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface TherepistBO extends SuperBO {
    List<String> getAllProgram();


    boolean saveTherapist(TherapistDTO therapist);

    List<TherapistDTO> getAllTherapyPrograms();

    boolean deleteTherapist(String text);

    boolean updateTherapist(TherapistDTO therapist);
}
