package lk.ijse.mentalclinic.bo.custom.Impl;

import lk.ijse.mentalclinic.bo.custom.PaymentBO;
import lk.ijse.mentalclinic.dao.DaoFactory;
import lk.ijse.mentalclinic.dao.custom.PatientDao;
import lk.ijse.mentalclinic.dao.custom.PaymentDAO;
import lk.ijse.mentalclinic.dao.custom.TherapySessionDAO;
import lk.ijse.mentalclinic.dto.PaymentDTO;
import lk.ijse.mentalclinic.entity.Payment;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 2:28 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class PaymentBoImpl implements PaymentBO {
    PaymentDAO paymentDAO = (PaymentDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.PAYMENT);
    PatientDao patientDao = (PatientDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.PATIENT);
    TherapySessionDAO therapySessionDAO = (TherapySessionDAO) DaoFactory.getInstance().getDAO(DaoFactory.DaoType.TherapySession);

    @Override
    public boolean savePayment(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setPaymentID(dto.getPaymentID());
        payment.setAmount(dto.getAmount());
        payment.setDate(dto.getDate());
        payment.setStatus(dto.getStatus());
        payment.setPatient(patientDao.findById(dto.getPatientID()));
        payment.setTherapySession(therapySessionDAO.findById(dto.getSessionID()));
        return paymentDAO.save(payment);
    }
}
