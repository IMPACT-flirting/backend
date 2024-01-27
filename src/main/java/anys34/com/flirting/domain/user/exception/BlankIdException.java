package anys34.com.flirting.domain.user.exception;

import anys34.com.flirting.global.config.error.exception.BusinessException;
import anys34.com.flirting.global.config.error.exception.ErrorCode;

public class BlankIdException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new BlankIdException();

    private BlankIdException() {super(ErrorCode.BLANK_ID);}
}
