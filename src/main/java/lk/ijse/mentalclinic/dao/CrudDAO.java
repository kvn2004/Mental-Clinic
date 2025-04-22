package lk.ijse.mentalclinic.dao;

import lk.ijse.mentalclinic.dto.TherapyProgramDTO;
import lk.ijse.mentalclinic.entity.TherapyProgram;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/21/2025 9:51 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface CrudDAO<T> extends SuperDao {
    boolean save(T t);

    boolean delete(String text);

    List<T> getAll();

    boolean update(T t);
}
