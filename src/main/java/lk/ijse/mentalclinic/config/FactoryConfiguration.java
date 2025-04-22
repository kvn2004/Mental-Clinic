package lk.ijse.mentalclinic.config;

import lk.ijse.mentalclinic.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 3/24/2025 12:20 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration config = new Configuration()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(TherapyProgram.class)
                .addAnnotatedClass(Therapist.class)
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(TherapySession.class);
        sessionFactory = config.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
