package anys34.com.flirting.domain.user.exception;

import anys34.com.flirting.global.config.error.exception.BusinessException;
import anys34.com.flirting.global.config.error.exception.ErrorCode;

public class BlankNameException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new BlankNameException();

    private BlankNameException() {super(ErrorCode.BLANK_NAME);}
}
