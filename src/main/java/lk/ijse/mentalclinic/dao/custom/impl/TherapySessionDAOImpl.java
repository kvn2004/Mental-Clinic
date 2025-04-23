package lk.ijse.mentalclinic.dao.custom.impl;

import lk.ijse.mentalclinic.config.FactoryConfiguration;
import lk.ijse.mentalclinic.dao.custom.TherapySessionDAO;
import lk.ijse.mentalclinic.entity.TherapySession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 2:10 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class TherapySessionDAOImpl implements TherapySessionDAO {
    @Override
    public boolean save(TherapySession therapySession) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.persist(therapySession);
        tx.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String text) {
        return false;
    }

    @Override
    public List<TherapySession> getAll() {
        return List.of();
    }

    @Override
    public boolean update(TherapySession therapySession) {
        return false;
    }

    @Override
    public String generateNextSessionId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String lastId = (String) session.createQuery("SELECT t.sessionID FROM TherapySession t ORDER BY t.sessionID DESC")
                .setMaxResults(1)
                .uniqueResult();
        session.close();

        if (lastId == null) {
            lastId = "TS000";
        }

        int num = Integer.parseInt(lastId.substring(2));
        return String.format("TS%03d", num + 1);
    }

    @Override
    public TherapySession findById(String therapySessionId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.get(TherapySession.class, therapySessionId);
    }
}
