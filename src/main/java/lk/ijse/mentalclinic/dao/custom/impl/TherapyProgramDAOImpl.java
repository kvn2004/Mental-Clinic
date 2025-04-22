package lk.ijse.mentalclinic.dao.custom.impl;

import lk.ijse.mentalclinic.config.FactoryConfiguration;
import lk.ijse.mentalclinic.dao.custom.TherapyProgramDAO;
import lk.ijse.mentalclinic.entity.TherapyProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/22/2025 1:55 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class TherapyProgramDAOImpl implements TherapyProgramDAO {

    @Override
    public boolean save(TherapyProgram therapyProgram) {
        System.out.println(therapyProgram);
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.persist(therapyProgram);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String text) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.remove(session.get(TherapyProgram.class, Integer.parseInt(text)));
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public List<TherapyProgram> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("From TherapyProgram").list();

    }

    @Override
    public boolean update(TherapyProgram therapyProgram) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.merge(therapyProgram);
        tx.commit();
        session.close();
        return true;

    }
}
