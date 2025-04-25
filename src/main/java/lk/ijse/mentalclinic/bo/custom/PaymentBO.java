package lk.ijse.mentalclinic.bo.custom;

import lk.ijse.mentalclinic.bo.SuperBO;
import lk.ijse.mentalclinic.dto.PaymentDTO;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/23/2025 2:28 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public interface PaymentBO extends SuperBO {
    boolean savePayment(PaymentDTO dto);

    List<PaymentDTO> getAllpayment();

    boolean updatePayment(PaymentDTO dto);

    String getPaymentIDBySessionID(String id);

    boolean deletePayment(String paymentIDBySessionID);

    boolean StatusUpdate(PaymentDTO dto);

    String generateNextPaymentId();
}
