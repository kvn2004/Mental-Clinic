package lk.ijse.mentalclinic.bo.custom;

import lk.ijse.mentalclinic.bo.SuperBO;
import lk.ijse.mentalclinic.dto.TherapyProgramDTO;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/22/2025 1:36 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface TherapyProgramBO extends SuperBO {
    boolean saveProgram(TherapyProgramDTO therapyProgramDTO);

    List<TherapyProgramDTO> getAllTherapyPrograms();

    boolean deleteProgram(String text);

    boolean upadateProgremme(TherapyProgramDTO therapyProgramDTO);

    List<String> getAllProgramID();

    double getProgramPrice(String therapy);
}
