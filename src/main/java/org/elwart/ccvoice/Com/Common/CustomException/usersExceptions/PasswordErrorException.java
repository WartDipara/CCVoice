package org.elwart.ccvoice.Com.Common.CustomException.usersExceptions;

import org.elwart.ccvoice.Com.Common.CustomException.BaseException;

public class PasswordErrorException extends BaseException {
    public PasswordErrorException() {
    }

    public PasswordErrorException(String message) {
        super(message);
    }
}
