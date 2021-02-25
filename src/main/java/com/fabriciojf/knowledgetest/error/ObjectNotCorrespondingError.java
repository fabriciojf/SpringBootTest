package com.fabriciojf.knowledgetest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @class ObjectNotCorrespondingError
 * @since 25/02/2021
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ObjectNotCorrespondingError extends RuntimeException {    
    public ObjectNotCorrespondingError(String message) {
        super(message);
    }
}

