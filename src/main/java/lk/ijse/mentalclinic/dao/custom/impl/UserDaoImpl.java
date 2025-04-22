package lk.ijse.mentalclinic.dao.custom.impl;

import lk.ijse.mentalclinic.config.FactoryConfiguration;
import lk.ijse.mentalclinic.dao.custom.UserDao;
import lk.ijse.mentalclinic.entity.TherapyProgram;
import lk.ijse.mentalclinic.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 3/24/2025 1:25 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class UserDaoImpl implements UserDao {


    @Override
    public List<User> checkUser(String username, String password) {
        Session session = FactoryConfiguration.getInstance().getSession();

        List<User> list = session.createQuery("FROM User WHERE username = :username", User.class).setParameter("username", username).list();
        System.out.println(list);
        return list;
    }

    @Override
    public boolean save(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String text) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public boolean update(User user) {
        return false;
    }


}
