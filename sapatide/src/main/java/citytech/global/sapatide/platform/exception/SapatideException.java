package citytech.global.sapatide.platform.exception;

import citytech.global.sapatide.platform.enums.ExceptionType;

public class SapatideException extends RuntimeException{
    private final ExceptionType exceptionType;

    public SapatideException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType =exceptionType;
        }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }
    }


