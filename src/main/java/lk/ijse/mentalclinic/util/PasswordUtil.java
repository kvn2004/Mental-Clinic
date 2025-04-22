package lk.ijse.mentalclinic.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 4/21/2025 6:16 PM
 * Project: Mental Clinic
 * --------------------------------------------
 **/

public class PasswordUtil {
    // Hash a plain text password
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12)); // 12 is the work factor
    }

    // Verify if the plain password matches the hashed password
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        if (hashedPassword == null || !hashedPassword.startsWith("$2a$")) {
            throw new IllegalArgumentException("Invalid hashed password format.");
        }
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
