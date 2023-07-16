package kr.co.webmill.webfluxintro.exception;

public class InputValidationException extends RuntimeException {
    private static final String MSG = "Allowed range is 10 - 20";
    private static final int errorCode = 100;
    private final int input;

    public int getInput() {
        return input;
    }
    public int getErrorCode(){
        return errorCode;
    }

    public InputValidationException(int input) {
        super(MSG);
        this.input = input;
    }
}
