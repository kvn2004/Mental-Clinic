package lk.ijse.mentalclinic.dao.custom.impl;

import lk.ijse.mentalclinic.config.FactoryConfiguration;
import lk.ijse.mentalclinic.dao.custom.PatientDao;
import lk.ijse.mentalclinic.entity.Patient;
import lk.ijse.mentalclinic.entity.TherapyProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/19/2025 1:38 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class PatientDaoImpl implements PatientDao {

    @Override
    public boolean save(Patient patient) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.save(patient);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String text) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.remove(session.get(Patient.class, text));
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public List<Patient> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM Patient ").list();
    }

    @Override
    public boolean update(Patient patient) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.merge(patient);
        tx.commit();
        session.close();
        return true;
    }


    @Override
    public List<String> getAllPatientID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("SELECT p.patientID FROM Patient p").list();
    }

    @Override
    public Patient findById(String patientID) {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.get(Patient.class, patientID);
    }

    @Override
    public String generateNextPaymentId() {
        Session session = FactoryConfiguration.getInstance().getSession();

        String lastId = (String) session.createQuery("SELECT p.patientID FROM Patient p ORDER BY p.patientID DESC")
                .setMaxResults(1)
                .uniqueResult();

        session.close();

        if (lastId == null) {
            return "P001";
        }

        int numericPart = Integer.parseInt(lastId.substring(1));
        int nextId = numericPart + 1;

        return String.format("P%03d", nextId);

    }
}
