package anys34.com.flirting.global.config.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_MATCH(400, "User Not Match"),
    UNEXPECTED_TOKEN(400, "Unexpected token"),
    SAME_ID(400, "Same Id"),
    BLANK_ID(400, "Blank Id"),
    OVERFLOW_ID(400, "Over Flow Id"),
    BLANK_NAME(400, "Blank NAME"),
    OVERFLOW_NAME(400, "Over Flow NAME"),
    BLANK_PASSWORD(400, "Blank Password"),
    PLACE_NOT_FOUND(400, "Place Not Found"),
    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),

    USER_NOT_FOUND(404, "User Not Found"),
    POST_NOT_FOUND(404, "Post Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),
    CONTENT_TYPE_NOT_FOUND(404, "Content Type Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}
