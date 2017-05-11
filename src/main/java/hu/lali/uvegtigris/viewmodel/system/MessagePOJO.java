package hu.lali.uvegtigris.viewmodel.system;

public class MessagePOJO {
    protected String message;

    public MessagePOJO() {
    }

    public MessagePOJO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}