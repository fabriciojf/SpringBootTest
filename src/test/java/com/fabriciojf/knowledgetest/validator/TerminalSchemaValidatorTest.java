package com.fabriciojf.knowledgetest.validator;

import com.fabriciojf.knowledgetest.error.ObjectNotCorrespondingError;
import com.fabriciojf.knowledgetest.error.PostError;
import com.fabriciojf.knowledgetest.util.TerminalUtil;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TerminalSchemaValidatorTest {    
    
    @Test
    public void testProcessWithValidJson() throws Exception {        
//        
//        String terminalData = "44332211;1;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;";
//        JSONObject jsonData = new TerminalUtil(terminalData).adaptCsvLineToJson();
//        System.out.println(jsonData.toString());
//        JSONObject jsonObject = TerminalSchemaValidator.process(jsonData);
//        System.out.println(jsonObject.toString());
    }
    
    @Test
    public void testProcessWithInvalidJson() throws Exception {        
        
//        String terminalData = "44332211;1;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;";
//        JSONObject jsonData = new TerminalUtil(terminalData).adaptCsvLineToJson();
//        System.out.println(jsonData.toString());
//        JSONObject jsonObject = TerminalSchemaValidator.process(jsonData);
//        System.out.println(jsonObject.toString());
    }

    @Test
    public void testProcessWithIncomingDataEmpty() throws Exception {        
             
//        RuntimeException runtimeException = assertThrows(
//                ObjectNotCorrespondingError.class, 
//                () -> TerminalSchemaValidator.process(new JSONObject()));
//        
//        assertTrue(runtimeException.getMessage().contains(
//                "Erro de validação dos dados do objeto json"));
    }    

}
