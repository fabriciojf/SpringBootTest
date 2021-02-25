package com.fabriciojf.knowledgetest.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FieldValidatorTest {
    
    @Test
    public void testAsStringValid() {
        String stringValid = "Content Text";
        assertEquals(stringValid, new FieldValidator(stringValid).asString());
    }
    
    @Test
    public void testAsStringEmptyReturningNull() {
        assertNull(new FieldValidator("").asString());
    }
    
    @Test
    public void testAsIntegerValid() {
        assertEquals(5, new FieldValidator("5").asInteger());
    }    
    
    @Test
    public void testAsIntegerInvalid() {
        assertNull(new FieldValidator("ss").asInteger());
    }    
    
    @Test
    public void testAsIntegerWithBlankValue() {
        assertNull(new FieldValidator("").asInteger());
    }    
}
