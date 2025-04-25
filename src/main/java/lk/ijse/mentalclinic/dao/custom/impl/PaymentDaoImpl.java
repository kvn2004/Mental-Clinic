package lk.ijse.mentalclinic.dao.custom.impl;

import lk.ijse.mentalclinic.config.FactoryConfiguration;
import lk.ijse.mentalclinic.dao.custom.PaymentDAO;
import lk.ijse.mentalclinic.entity.Payment;
import lk.ijse.mentalclinic.entity.Therapist;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 2:29 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class PaymentDaoImpl implements PaymentDAO {
    @Override
    public boolean save(Payment payment) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(payment);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String text) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.remove(session.get(Payment.class, text));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Payment> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("SELECT p FROM Payment p LEFT JOIN FETCH p.patient LEFT JOIN FETCH p.therapySession", Payment.class).list();
    }

    @Override
    public boolean update(Payment payment) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.merge(payment);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNextPaymentId() {
       Session session= FactoryConfiguration.getInstance().getSession();

        String lastId = (String) session.createQuery("SELECT p.paymentID FROM Payment p ORDER BY p.paymentID DESC")
                .setMaxResults(1)
                .uniqueResult();

        session.close();

        if (lastId == null) {
            lastId = "PAY000";
        }

        int numericPart = Integer.parseInt(lastId.substring(3)); // extract number after "PAY"
        int nextId = numericPart + 1;

        return String.format("PAY%03d", nextId);
    }

    @Override
    public Payment findById(String paymentId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.get(Payment.class, paymentId);
    }

    @Override
    public String getPaymentIDBySessionID(String sessionID) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String paymentID = session.createQuery(
                        "SELECT p.paymentID FROM Payment p WHERE p.therapySession.sessionID = :sessionID",
                        String.class
                )
                .setParameter("sessionID", sessionID)
                .setMaxResults(1)  // In case multiple match, we take just the first
                .uniqueResult();

        transaction.commit();
        session.close();
        return paymentID;
    }
}
