package com.fabriciojf.knowledgetest.util;

import com.fabriciojf.knowledgetest.error.PostError;
import com.fabriciojf.knowledgetest.validator.FieldValidator;
import org.json.JSONObject;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @since 25/02/2021
 */
public class TerminalUtil {

    private String line;
    
    public TerminalUtil(String line) {        
        this.line = line;
    } 
    
    public JSONObject adaptCsvLineToJson() {
        
        if (line.chars().filter(ch -> ch == ';').count() != 9) {
            throw new PostError("Line not contains all fields to the Terminal Model");
        }         

        String[] fields = line.split(";");
        JSONObject json = new JSONObject();

        json.put("logic", new FieldValidator(fields[0]).asInteger());
        json.put("serial", new FieldValidator(fields[1]).asString());
        json.put("model", new FieldValidator(fields[2]).asString());
        json.put("sam", new FieldValidator(fields[3]).asInteger());
        json.put("ptid", new FieldValidator(fields[4]).asString());
        json.put("plat", new FieldValidator(fields[5]).asInteger());
        json.put("version", new FieldValidator(fields[6]).asString());
        json.put("mxr", new FieldValidator(fields[7]).asInteger());
        json.put("mxf", new FieldValidator(fields[8]).asString());
        
        if (fields.length == 10) {
            json.put("VERFM", new FieldValidator(fields[9]).asString());
        }        
        return json;
    }        
}
