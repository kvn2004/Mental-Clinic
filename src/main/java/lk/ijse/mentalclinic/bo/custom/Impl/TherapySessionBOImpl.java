package lk.ijse.mentalclinic.bo.custom.Impl;

import lk.ijse.mentalclinic.bo.custom.TherapySessionBO;
import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.PatientDao;
import lk.ijse.mentalclinic.dao.custom.TherapistDAO;
import lk.ijse.mentalclinic.dao.custom.TherapyProgramDAO;
import lk.ijse.mentalclinic.dao.custom.TherapySessionDAO;
import lk.ijse.mentalclinic.dto.TherapyProgramDTO;
import lk.ijse.mentalclinic.dto.TherapySessionDTO;
import lk.ijse.mentalclinic.entity.TherapyProgram;
import lk.ijse.mentalclinic.entity.TherapySession;

import java.util.ArrayList;
import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 2:09 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class TherapySessionBOImpl implements TherapySessionBO {
    TherapySessionDAO therapySessionDAO = (TherapySessionDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.TherapySession);
    PatientDao patientDao = (PatientDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.PATIENT);
    TherapistDAO therapistDAO = (TherapistDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.THERAPIST);
    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.PROGRAM);


    @Override
    public boolean saveSession(TherapySessionDTO therapySessionDTO) {
        TherapySession therapySession = new TherapySession();
        therapySession.setSessionID(therapySessionDTO.getSessionID());
        therapySession.setSessionDate(therapySessionDTO.getSessionDate());
        therapySession.setTime(therapySessionDTO.getTime());
        therapySession.setSessionStatus(therapySessionDTO.getSessionStatus());
        therapySession.setPatient(patientDao.findById(therapySessionDTO.getPatientID()));
        therapySession.setTherapist(therapistDAO.findById(therapySessionDTO.getTherapistID()));
        therapySession.setProgram(therapyProgramDAO.findById(therapySessionDTO.getProgramID()));
        return therapySessionDAO.save(therapySession);
    }

    @Override
    public List<TherapySessionDTO> getAllTherapyPrograms() {
        List<TherapySession> entities = therapySessionDAO.getAll(); // Get entity list
        List<TherapySessionDTO> dtoList = new ArrayList<>();

        for (TherapySession session : entities) {
            dtoList.add(new TherapySessionDTO(
                    session.getSessionID(),
                    session.getSessionDate(),
                    session.getTime(),
                    session.getSessionStatus(),
                    session.getPatient(),
                    session.getTherapist(),
                    session.getProgram()
            ));
        }

        return dtoList;
    }

    @Override
    public boolean updateSession(TherapySessionDTO therapySessionDTO) {
        TherapySession therapySession = new TherapySession();
        therapySession.setSessionID(therapySessionDTO.getSessionID());
        therapySession.setSessionDate(therapySessionDTO.getSessionDate());
        therapySession.setTime(therapySessionDTO.getTime());
        therapySession.setSessionStatus(therapySessionDTO.getSessionStatus());
        therapySession.setPatient(patientDao.findById(therapySessionDTO.getPatientID()));
        therapySession.setTherapist(therapistDAO.findById(therapySessionDTO.getTherapistID()));
        therapySession.setProgram(therapyProgramDAO.findById(therapySessionDTO.getProgramID()));
        return therapySessionDAO.update(therapySession);
    }

    @Override
    public boolean deleteSession(String id) {
        return therapySessionDAO.delete(id);
    }

    @Override
    public boolean StatusUpdate(TherapySessionDTO sessionDTO) {
        TherapySession therapySession = new TherapySession();
        therapySession.setSessionID(sessionDTO.getSessionID());
        therapySession.setSessionStatus(sessionDTO.getSessionStatus());
        return therapySessionDAO.updateStatus(therapySession);
    }
}
