package com.fabriciojf.knowledgetest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @class ObjectNotFoundError
 * @since 25/02/2021
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundError extends RuntimeException {    
    public ObjectNotFoundError(String message) {
        super(message);
    }
}