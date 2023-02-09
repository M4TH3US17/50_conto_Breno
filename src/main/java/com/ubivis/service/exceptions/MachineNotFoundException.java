package com.ubivis.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MachineNotFoundException extends Exception {

    public MachineNotFoundException(String msg) {
        super(msg);
    }

}
