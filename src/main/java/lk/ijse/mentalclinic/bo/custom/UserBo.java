package lk.ijse.mentalclinic.bo.custom;

import lk.ijse.mentalclinic.bo.SuperBO;
import lk.ijse.mentalclinic.dto.UserDTO;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 3/24/2025 1:23 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface UserBo extends SuperBO {
    List<UserDTO>checkUser(String username, String password);
}
