package org.test.example;
import org.example.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class ListManagerTest {
    private ListManager lm;
    private List<Integer> list;
    @BeforeEach
    void setup(){
        lm = new ListManager();
        list = new ArrayList<>();
    }
    @Test
    @DisplayName("Add to List")
    void add(){
        lm.addElement(list, 1);
        assertTrue(list.contains(1));
    }
    @Test
    @DisplayName("Remove from List")
    void rmv(){
        lm.removeElement(list, 2);
        assertFalse(list.contains(2));
    }
    @Test
    @DisplayName("Size of the List")
    void size(){
        lm.addElement(list,10);
        lm.addElement(list,20);
        assertEquals(2, lm.getSize(list));
    }
}

