package anys34.com.flirting.domain.user.exception;

import anys34.com.flirting.global.config.error.exception.BusinessException;
import anys34.com.flirting.global.config.error.exception.ErrorCode;

public class SameIdException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new SameIdException();

    private SameIdException() {super(ErrorCode.SAME_ID);}
}
