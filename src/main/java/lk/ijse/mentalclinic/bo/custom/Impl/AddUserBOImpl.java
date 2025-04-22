package lk.ijse.mentalclinic.bo.custom.Impl;

import lk.ijse.mentalclinic.bo.custom.AddUserBO;
import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.UserDao;
import lk.ijse.mentalclinic.dao.custom.impl.UserDaoImpl;
import lk.ijse.mentalclinic.dto.UserDTO;
import lk.ijse.mentalclinic.entity.User;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/21/2025 2:58 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class AddUserBOImpl implements AddUserBO {
    UserDao userDao = (UserDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.USER);
    @Override
    public boolean saveUser(UserDTO userDTO) {
       return userDao.save(new User(userDTO.getUserID(),userDTO.getUsername(),userDTO.getPassword(),userDTO.getRole()));
    }
}
