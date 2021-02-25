package com.fabriciojf.knowledgetest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @class PostError
 * @version 1.0
 * @since 25/02/2021
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileError extends RuntimeException {
    
    public FileError() {}
    
    public FileError(String message) {
        super(message);
    }
}
