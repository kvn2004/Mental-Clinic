package lk.ijse.mentalclinic.dao;

import lk.ijse.mentalclinic.dao.custom.impl.*;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/19/2025 1:37 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class DaoFactory {
    public static DaoFactory daoFactory;
    private DaoFactory() {}
    public static DaoFactory getInstance() {
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }
    public enum DaoType {
        USER , PATIENT,PROGRAM,THERAPIST,TherapySession,PAYMENT
    }

    public SuperDao getDAO(DaoType daoType) {
        switch (daoType) {
            case USER->{
                return new UserDaoImpl();
            }
            case PATIENT->{
                return new PatientDaoImpl();
            }
            case PROGRAM->{
                return new TherapyProgramDAOImpl();
            }
            case THERAPIST->{
                return new TherapistDAOImpl();
            }
            case TherapySession->{
                return new TherapySessionDAOImpl();
            }
            case PAYMENT->{
                return new PaymentDaoImpl();
            }
        }
        return null;
    }

}
