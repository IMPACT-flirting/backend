package anys34.com.flirting.domain.user.exception;

import anys34.com.flirting.global.config.error.exception.BusinessException;
import anys34.com.flirting.global.config.error.exception.ErrorCode;

public class OverFlowNameException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new OverFlowNameException();

    private OverFlowNameException() {super(ErrorCode.OVERFLOW_NAME);}
}
