package com.mazum.training.junit;

public class InvalidYearException extends Exception {

    public InvalidYearException() {
        
    }

    public InvalidYearException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public InvalidYearException(String arg0) {
        super(arg0);
    }

    public InvalidYearException(Throwable arg0) {
        super(arg0);
    }
}
