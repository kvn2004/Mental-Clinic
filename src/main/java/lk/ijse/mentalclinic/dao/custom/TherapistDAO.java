package lk.ijse.mentalclinic.dao.custom;

import lk.ijse.mentalclinic.dao.CrudDAO;
import lk.ijse.mentalclinic.entity.Therapist;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/22/2025 5:48 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface TherapistDAO extends CrudDAO<Therapist> {
    List<String> getAllProgram();
}
