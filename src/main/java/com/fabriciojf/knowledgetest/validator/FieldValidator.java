package com.fabriciojf.knowledgetest.validator;

import com.google.common.base.Strings;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @class FieldValidator
 * @since 24/02/2021
 */
public class FieldValidator {
    
    private final String field;
    
    public FieldValidator(String field) {
        this.field = field.trim();
    }
    
    public String asString() {        
        return Strings.isNullOrEmpty(field) ? null : field;
    }
    
    public Integer asInteger() {
        try {
            return Integer.parseInt(field);
        } catch(NumberFormatException ex) {
            return null;
        }
    }    
}
