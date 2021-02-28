package com.fabriciojf.knowledgetest.schema;

import com.fabriciojf.knowledgetest.error.FileError;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @since 25/02/2021
 */
public class TerminalSchema implements JsonBasicSchema {
    
    @Override
    public FileInputStream getSchema() {
    
        String separator = System.getProperty("file.separator");
        String pathFileSchema = "schema" + separator + "TerminalSchema.json";        
        
        try {
            return new FileInputStream(new File(pathFileSchema));
        } catch(FileNotFoundException fileNotFound) {
            throw new FileError("Arquivo schema " + pathFileSchema +
                    " não encontrado");
        }
    }
}
