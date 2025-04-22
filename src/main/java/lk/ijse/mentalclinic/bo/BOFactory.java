package lk.ijse.mentalclinic.bo;

import lk.ijse.mentalclinic.bo.custom.Impl.*;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/19/2025 1:28 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class BOFactory implements SuperBO {
    public static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        USER , PATIENT, ADDUSER ,THERAPYPROGRAMM,THERAPIST
    }

    public SuperBO getBO(BOTypes type) {
        switch (type) {
            case USER ->{
                return new UserBoImpl();
            }
            case PATIENT ->{
                return new PatientBOImpl();
            }
            case ADDUSER ->{
                return new AddUserBOImpl();
            }
            case THERAPYPROGRAMM ->{
                return new TherapyProgrammBOImpl();
            }
            case THERAPIST ->{
                return new TherapistBoImpl();
            }
        }
        return null;
    }

}
