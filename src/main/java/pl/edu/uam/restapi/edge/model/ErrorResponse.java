package pl.edu.uam.restapi.edge.model;

public class ErrorResponse {

    private String message;
    private String userMessage;
    private String info;
    private int code;

    public ErrorResponse(int code, String message) {
        this.message = message;
        this.userMessage = message;
        this.info = "http://docs";
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getInfo() {
        return info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}