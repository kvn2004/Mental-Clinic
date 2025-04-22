package lk.ijse.mentalclinic.dao;

import lk.ijse.mentalclinic.dao.custom.UserDao;
import lk.ijse.mentalclinic.dao.custom.impl.PatientDaoImpl;
import lk.ijse.mentalclinic.dao.custom.impl.TherapistDAOImpl;
import lk.ijse.mentalclinic.dao.custom.impl.TherapyProgramDAOImpl;
import lk.ijse.mentalclinic.dao.custom.impl.UserDaoImpl;

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
        USER , PATIENT,PROGRAM,THERAPIST
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
        }
        return null;
    }

}
