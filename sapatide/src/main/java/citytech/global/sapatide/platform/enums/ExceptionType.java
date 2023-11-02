package citytech.global.sapatide.platform.enums;

public enum ExceptionType {
    USER_ALREADY_EXIST("UN-001", "User with this email already exist"),
    USER_NOT_FOUND("FO-101", "User not found"),
    INVALID_CREDENTIAL("INVALID-007", "Invalid Credential"),
    INVALID_EMAIL("EMAIL-009","Invalid email"),
    INCORRECT_MAPPED_FIELD("API-005","Api field are incorrectly mapped"),

    SECURITY_FILTER_MISSING("EX001","Security Token is missing"),
    TOKEN_EXPIRED("TK004","Security Token is expired"),
    INVALID_TOKEN("INV 007","Security Token is invalid"),
    REQUEST_CONTEXT_NOT_SET("RC008","Request Context is not set"),
    INTERCEPTION_EXCEPTION("IE500","Security interceptor Exception");

    private final String code;
    private final String message;

    ExceptionType(String code, String message) {
        this.code = code;
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

