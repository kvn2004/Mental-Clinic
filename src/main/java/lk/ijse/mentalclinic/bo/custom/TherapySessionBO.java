package lk.ijse.mentalclinic.bo.custom;

import lk.ijse.mentalclinic.bo.SuperBO;
import lk.ijse.mentalclinic.dto.TherapySessionDTO;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 2:09 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface TherapySessionBO extends SuperBO {
    boolean saveSession(TherapySessionDTO therapySessionDTO);

    List<TherapySessionDTO> getAllTherapyPrograms();

    boolean updateSession(TherapySessionDTO therapySessionDTO);

    boolean deleteSession(String id);

    boolean StatusUpdate(TherapySessionDTO sessionDTO);
}
