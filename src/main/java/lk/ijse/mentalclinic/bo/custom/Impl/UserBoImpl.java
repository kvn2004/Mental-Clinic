package lk.ijse.mentalclinic.bo.custom.Impl;

import lk.ijse.mentalclinic.bo.custom.UserBo;
import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.UserDao;
import lk.ijse.mentalclinic.dto.UserDTO;
import lk.ijse.mentalclinic.entity.User;

import java.util.ArrayList;
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

public class UserBoImpl implements UserBo {
    UserDao userDao = (UserDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.USER);

    @Override
    public List<UserDTO> checkUser(String username, String password) {
        List<User> users = userDao.checkUser(username, password);
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(new UserDTO(user.getUserID(),user.getUsername(),user.getPassword(),user.getRole()));
        }
        return userDTOs;
    }
}
