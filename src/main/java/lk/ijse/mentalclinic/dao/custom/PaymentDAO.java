package lk.ijse.mentalclinic.dao.custom;

import lk.ijse.mentalclinic.dao.CrudDAO;
import lk.ijse.mentalclinic.entity.Payment;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 2:29 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface PaymentDAO extends CrudDAO<Payment> {
    String generateNextPaymentId();
    Payment findById(String paymentId);

    String getPaymentIDBySessionID(String id);

    boolean updateStatus(Payment payment);
}
