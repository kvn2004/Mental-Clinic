package lk.ijse.mentalclinic.dao.custom.impl;

import lk.ijse.mentalclinic.config.FactoryConfiguration;
import lk.ijse.mentalclinic.dao.custom.TherapyProgramDAO;
import lk.ijse.mentalclinic.entity.TherapyProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public List<String> getAllProgrammID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("SELECT p.programID FROM TherapyProgram p").list();
    }

    @Override
    public TherapyProgram findById(String therapyProgramID) {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.get(TherapyProgram.class, therapyProgramID);
    }

    @Override
    public double getProgramPrice(String therapyId) {
        if (therapyId == null || therapyId.isEmpty()) {
            return 0;
        }

        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();

            // Option 1: Use BigDecimal in query and convert to double
            Query<BigDecimal> query = session.createQuery(
                    "SELECT p.fee FROM TherapyProgram p WHERE p.programID = :therapyId",
                    BigDecimal.class);
            query.setParameter("therapyId", therapyId);

            BigDecimal result = query.uniqueResult();
            return result != null ? result.doubleValue() : 0;

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "Error fetching program price for therapyId: " + therapyId, e);
            return 0;
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (Exception e) {
                    Logger.getLogger(getClass().getName()).log(Level.WARNING,
                            "Error closing session", e);
                }
            }
        }
    }

    @Override
    public String generateNextPaymentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String lastId = (String) session
                .createQuery("SELECT tp.programID FROM TherapyProgram tp ORDER BY tp.programID DESC")
                .setMaxResults(1)
                .uniqueResult();

        transaction.commit();
        session.close();

        if (lastId == null) {
            return "TP001";
        }

        // Extract the numeric part and increment
        int numericPart = Integer.parseInt(lastId.substring(2));
        int nextId = numericPart + 1;

        return String.format("TP%03d", nextId);

    }
}
