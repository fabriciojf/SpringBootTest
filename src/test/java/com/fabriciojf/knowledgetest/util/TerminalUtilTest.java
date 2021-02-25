package com.fabriciojf.knowledgetest.util;

import com.fabriciojf.knowledgetest.error.PostError;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TerminalUtilTest {
    
    @Test
    public void testAdaptCsvLineToJsonWithValidField()  {
        
        TerminalUtil terminalUtil = new TerminalUtil(
                "44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN");       

        try {
            JSONObject terminalJson = terminalUtil.adaptCsvLineToJson();
            assertEquals("PWWIN", terminalJson.get("model"));
        } catch (JSONException ex) {
            fail("O Objeto JSON não pode ser criado");
        }
    }    
    
    @Test
    public void testAdaptCsvLineToJsonWithNoValidLine()  {
        TerminalUtil terminalUtil = new TerminalUtil(
                "44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0");

        RuntimeException runtimeException = assertThrows(
                PostError.class, () -> terminalUtil.adaptCsvLineToJson());
        
        assertTrue(runtimeException.getMessage().contains(
                "Line not contains all fields to the Terminal Model"));
    }

}
