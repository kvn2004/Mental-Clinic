package lk.ijse.mentalclinic.bo.custom.Impl;

import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.TherapistDAO;
import lk.ijse.mentalclinic.dto.TherapistDTO;
import lk.ijse.mentalclinic.entity.Therapist;

import java.util.ArrayList;
import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/22/2025 5:43 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class TherapistBoImpl implements TherepistBO {
    TherapistDAO therapistDAO = (TherapistDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.THERAPIST);

    @Override
    public List<String> getAllProgram() {
        return therapistDAO.getAllProgram();
    }

    @Override
    public boolean saveTherapist(TherapistDTO therapistDto) {
        Therapist therapists = new Therapist();
        therapists.setTherapistID(therapistDto.getTherapistID());
        therapists.setFullName(therapistDto.getFullName());
        therapists.setSpecialization(therapistDto.getSpecialization());
        therapists.setAvailabilitySchedule(therapistDto.getAvailabilitySchedule());

        return therapistDAO.save(therapists);
    }

    @Override
    public List<TherapistDTO> getAllTherapyPrograms() {
        List<Therapist> entities = therapistDAO.getAll();// Get entity list
        // System.out.println("Entity"+entities.get(0).getTherapistID()+entities.get(0).getFullName()+entities.get(0).getSpecialization()+entities.get(0).getAvailabilitySchedule());
        List<TherapistDTO> dtoList = new ArrayList<>();
        for (Therapist entity : entities) {
            dtoList.add(new TherapistDTO(
                    entity.getTherapistID(),
                    entity.getFullName(),
                    entity.getSpecialization(),
                    entity.getAvailabilitySchedule()


            ));
        }
        return dtoList;
    }

    @Override
    public boolean deleteTherapist(String text) {
        return therapistDAO.delete(text);
    }

    @Override
    public boolean updateTherapist(TherapistDTO therapistDto) {
        Therapist therapists = new Therapist();
        therapists.setTherapistID(therapistDto.getTherapistID());
        therapists.setFullName(therapistDto.getFullName());
        therapists.setSpecialization(therapistDto.getSpecialization());
        therapists.setAvailabilitySchedule(therapistDto.getAvailabilitySchedule());
        return therapistDAO.update(therapists);
    }

    @Override
    public List<String> getAllTherapistID() {
        return therapistDAO.getAllTherapistID();
    }


}
