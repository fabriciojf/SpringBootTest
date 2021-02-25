package com.fabriciojf.knowledgetest.schema;

import java.io.FileInputStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TerminalSchemaTest {
    
    @Test
    public void testGetSchemaWithValidFile() {        
        JsonSchema schema = new TerminalSchema();        
        assertNotNull(schema.getSchema());
    }    
}
