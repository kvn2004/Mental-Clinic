package lk.ijse.mentalclinic.dao.custom;

import lk.ijse.mentalclinic.dao.CrudDAO;
import lk.ijse.mentalclinic.entity.User;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 3/24/2025 1:24 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface UserDao extends CrudDAO<User> {
    List<User> checkUser(String username, String password);
}
