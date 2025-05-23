package lk.ijse.mentalclinic.dao.custom;

import lk.ijse.mentalclinic.dao.CrudDAO;
import lk.ijse.mentalclinic.entity.TherapyProgram;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/22/2025 1:54 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface TherapyProgramDAO extends CrudDAO<TherapyProgram> {
    List<String> getAllProgrammID();
    TherapyProgram findById(String therapyProgramID);

    double getProgramPrice(String therapy);
    String generateNextPaymentId();
}
