package me.teenyda.nCoV.base.exception;

public class NetException extends Exception {

    public String code;
    public String errorMsg;

    public NetException(String message) {
        super(message);
    }

    public NetException(String message, String code) {
        super(message);
        this.errorMsg = message;
        this.code = code;
    }
}
