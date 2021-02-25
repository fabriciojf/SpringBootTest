package com.fabriciojf.knowledgetest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @class PostError
 * @version 1.0
 * @since 25/02/2021
 */
@ResponseStatus(HttpStatus.LENGTH_REQUIRED)
public class PostError extends RuntimeException {
    
    public PostError() {}
    
    public PostError(String message) {
        super(message);
    }
}
