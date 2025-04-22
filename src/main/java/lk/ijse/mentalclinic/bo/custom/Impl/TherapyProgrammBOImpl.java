package lk.ijse.mentalclinic.bo.custom.Impl;

import lk.ijse.mentalclinic.bo.custom.TherapyProgramBO;
import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.TherapyProgramDAO;
import lk.ijse.mentalclinic.dto.TherapyProgramDTO;
import lk.ijse.mentalclinic.entity.TherapyProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/22/2025 1:38 AM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class TherapyProgrammBOImpl implements TherapyProgramBO {
    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.PROGRAM);

    @Override
    public boolean saveProgram(TherapyProgramDTO therapyProgramDTO) {
        return therapyProgramDAO.save(new TherapyProgram(therapyProgramDTO.getProgramID(),therapyProgramDTO.getProgramName(),therapyProgramDTO.getDuration(),therapyProgramDTO.getFee(),therapyProgramDTO.getDescription()));
    }

    @Override
    public List<TherapyProgramDTO> getAllTherapyPrograms() {
        List<TherapyProgram> entities = therapyProgramDAO.getAll(); // Get entity list
        List<TherapyProgramDTO> dtoList = new ArrayList<>();

        for (TherapyProgram program : entities) {
            dtoList.add(new TherapyProgramDTO(
                    program.getProgramID(),
                    program.getProgramName(),
                    program.getDescription(),
                    program.getFee(),
                    program.getDuration()
            ));
        }

        return dtoList;
    }

    @Override
    public boolean deleteProgram(String text) {
        return therapyProgramDAO.delete(text);
    }

    @Override
    public boolean upadateProgremme(TherapyProgramDTO therapyProgramDTO) {
        return therapyProgramDAO.update(new TherapyProgram(therapyProgramDTO.getProgramID(),therapyProgramDTO.getProgramName(),therapyProgramDTO.getDuration(),therapyProgramDTO.getFee(),therapyProgramDTO.getDescription()));
    }
}
