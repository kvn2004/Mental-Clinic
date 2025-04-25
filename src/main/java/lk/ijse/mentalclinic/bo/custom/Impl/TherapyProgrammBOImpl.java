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
        TherapyProgram therapyProgram = new TherapyProgram();
        therapyProgram.setDescription(therapyProgramDTO.getDescription());
        therapyProgram.setProgramID(therapyProgramDTO.getProgramID());
        therapyProgram.setProgramName(therapyProgramDTO.getProgramName());
        therapyProgram.setDuration(therapyProgramDTO.getDuration());
        therapyProgram.setFee(therapyProgramDTO.getFee());
        therapyProgram.setDescription(therapyProgramDTO.getDescription());


        return therapyProgramDAO.save(therapyProgram);
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
        TherapyProgram therapyProgram = new TherapyProgram();
        therapyProgram.setDescription(therapyProgramDTO.getDescription());
        therapyProgram.setProgramID(therapyProgramDTO.getProgramID());
        therapyProgram.setProgramName(therapyProgramDTO.getProgramName());
        therapyProgram.setDuration(therapyProgramDTO.getDuration());
        therapyProgram.setFee(therapyProgramDTO.getFee());
        therapyProgram.setDescription(therapyProgramDTO.getDescription());
        return therapyProgramDAO.update(therapyProgram);
    }

    @Override
    public List<String> getAllProgramID() {
        return therapyProgramDAO.getAllProgrammID();
    }

    @Override
    public double getProgramPrice(String therapy) {
        return therapyProgramDAO.getProgramPrice(therapy);
    }

    @Override
    public String generateNextPaymentId() {
        return therapyProgramDAO.generateNextPaymentId();
    }
}
