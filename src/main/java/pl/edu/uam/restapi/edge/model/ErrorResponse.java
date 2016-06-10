package pl.edu.uam.restapi.edge.model;

public class ErrorResponse {

    private String message;
    private String userMessage;
    private String info;

    public ErrorResponse(int code, String message) {
        this.message = message;
        this.userMessage = message;
        this.info = "http://docs";
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
}