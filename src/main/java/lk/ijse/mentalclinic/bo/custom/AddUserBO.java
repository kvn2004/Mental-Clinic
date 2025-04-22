package lk.ijse.mentalclinic.bo.custom;

import lk.ijse.mentalclinic.bo.SuperBO;
import lk.ijse.mentalclinic.dto.UserDTO;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/21/2025 2:57 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface AddUserBO extends SuperBO {
    boolean saveUser(UserDTO userDTO);
}
