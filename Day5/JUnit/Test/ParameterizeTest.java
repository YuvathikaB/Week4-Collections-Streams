package org.test.example;
import org.example.Parameterize;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
public class ParameterizeTest {
    Parameterize parameter = new Parameterize();
    @ParameterizedTest
    @ValueSource(ints = {12, 14, 16})
    void testEvenNumbers(int number) {
        assertTrue(parameter.isEven(number));
    }
    @ParameterizedTest
    @ValueSource(ints = {11, 13})
    void testOddNumbers(int number) {
        assertFalse(parameter.isEven(number));
    }
}
