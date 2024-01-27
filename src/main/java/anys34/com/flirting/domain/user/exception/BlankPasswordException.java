package anys34.com.flirting.domain.user.exception;

import anys34.com.flirting.global.config.error.exception.BusinessException;
import anys34.com.flirting.global.config.error.exception.ErrorCode;

public class BlankPasswordException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new BlankPasswordException();

    private BlankPasswordException() {super(ErrorCode.BLANK_PASSWORD);}
}
