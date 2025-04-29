package org.test.example;
import org.example.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringUtilsTest {
        private StringUtils su;
        @BeforeEach
        void setup(){
            su = new StringUtils();
        }
        @Test
        @DisplayName("Reverse the String")
        void rev(){
            assertEquals("elppa",su.reverse("apple"));
        }
        @Test
        @DisplayName("Palindrome True")
        void PalinTrue(){
            assertTrue(su.isPalindrome("wow"));
        }
        @Test
        @DisplayName("Palindrome False")
        void PalinFalse(){
            assertFalse(su.isPalindrome("hello"));
        }
        @Test
        @DisplayName("Upper Case")
        void Upper(){
            assertEquals("JAVA",su.toUpper("java"));
        }
}

