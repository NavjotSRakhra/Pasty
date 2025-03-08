package io.github.navjotsrakhra.pasty.model.response;

import java.util.UUID;

public class ErrorDto {
    private final UUID errorId;
    private final String message;

    public ErrorDto(String message) {
        this.errorId = UUID.randomUUID();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public UUID getErrorId() {
        return errorId;
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "errorId=" + errorId +
                ", message='" + message + '\'' +
                '}';
    }
}
