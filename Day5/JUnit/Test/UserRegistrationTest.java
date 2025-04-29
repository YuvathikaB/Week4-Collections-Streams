package org.test.example;
import org.example.UserRegistration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UserRegistrationTest {
    UserRegistration userRegistration = new UserRegistration();
    @Test
    void testValidUserRegistration() {
        userRegistration.registerUser("yuvathika_boopathi", "yuvathika.boopathi@example.com", "password123");
    }
    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("", "yuvathika.boopathi@example.com", "password123");
        });
    }
    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("yuvathika_boopathi", "yuvathika.boopathiexample.com", "password123");
        });
    }
    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("yuvathika_boopathi", "yuvathika.boopathi@example.com", "pass");  });  }    }

