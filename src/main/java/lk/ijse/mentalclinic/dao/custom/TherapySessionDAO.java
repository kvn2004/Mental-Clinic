package lk.ijse.mentalclinic.dao.custom;

import lk.ijse.mentalclinic.dao.CrudDAO;
import lk.ijse.mentalclinic.dao.SuperDao;
import lk.ijse.mentalclinic.entity.TherapySession;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 2:09 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface TherapySessionDAO extends CrudDAO<TherapySession> {
    String generateNextSessionId();
    TherapySession findById(String therapySessionId);
}
