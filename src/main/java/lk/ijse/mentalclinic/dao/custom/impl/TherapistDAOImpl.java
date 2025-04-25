package lk.ijse.mentalclinic.dao.custom.impl;

import lk.ijse.mentalclinic.config.FactoryConfiguration;
import lk.ijse.mentalclinic.dao.custom.TherapistDAO;
import lk.ijse.mentalclinic.entity.Therapist;
import lk.ijse.mentalclinic.entity.TherapyProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/22/2025 5:48 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class TherapistDAOImpl implements TherapistDAO {
  @Override
  public boolean save(Therapist therapist) {
    Session session = FactoryConfiguration.getInstance().getSession();
    Transaction tx = session.beginTransaction();
    session.persist(therapist);
    tx.commit();
    session.close();
    return true;
  }

  @Override
  public boolean delete(String text) {
    Session session = FactoryConfiguration.getInstance().getSession();
    Transaction tx = session.beginTransaction();
    session.remove(session.get(Therapist.class, text));
    tx.commit();
    session.close();
    return true;
  }

  @Override
  public List<Therapist> getAll() {
    Session session = FactoryConfiguration.getInstance().getSession();
    return session.createQuery("FROM Therapist").list();
  }

  @Override
  public boolean update(Therapist therapist) {
    Session session = FactoryConfiguration.getInstance().getSession();
    Transaction tx = session.beginTransaction();
    session.merge(therapist);
    tx.commit();
    session.close();
    return true;
  }


  @Override
  public List<String> getAllProgram() {
    Session session = FactoryConfiguration.getInstance().getSession();
    return session.createQuery("SELECT p.programName FROM TherapyProgram p").list();
  }

  @Override
  public List<String> getAllTherapistID() {
    Session session = FactoryConfiguration.getInstance().getSession();
    return session.createQuery("SELECT p.therapistID FROM Therapist p").list();
  }

  @Override
  public Therapist findById(String therapistID) {
    Session session = FactoryConfiguration.getInstance().getSession();
    return session.get(Therapist.class, therapistID);
  }

  @Override
  public String generateNextPaymentId() {
    Session session = FactoryConfiguration.getInstance().getSession();

    String lastId = (String) session.createQuery("SELECT t.therapistID FROM Therapist t ORDER BY t.therapistID DESC")
            .setMaxResults(1)
            .uniqueResult();

    session.close();

    if (lastId == null) {
      return "T001";  // first ID
    }

    int numericPart = Integer.parseInt(lastId.substring(1));
    int nextId = numericPart + 1;

    return String.format("T%03d", nextId);  // T002, T003, etc.

  }
}
