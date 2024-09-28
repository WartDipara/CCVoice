package org.elwart.ccvoice.Com.Common.CustomException.usersExceptions;

import org.elwart.ccvoice.Com.Common.CustomException.BaseException;

public class RegErrorException extends BaseException {
    public RegErrorException() {
    }
    public RegErrorException(String msg){
        super(msg);
    }
}
