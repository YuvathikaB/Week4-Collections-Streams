package org.test.example;
import org.example.DateFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DateFormatterTest {
    DateFormatter formatter = new DateFormatter();
    @Test
    void testValidDate() {
        assertEquals("05-05-2025", formatter.formatDate("2025-05-05"));
    }
    @Test
    void testInvalidDay() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("2025-05-32"));
    }
    @Test
    void testInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("05-05-2025"));
    }
    @Test
    void testEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate(""));
    }
}
