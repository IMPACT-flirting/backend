package anys34.com.flirting.domain.user.exception;

import anys34.com.flirting.global.config.error.exception.BusinessException;
import anys34.com.flirting.global.config.error.exception.ErrorCode;

public class OverFlowIdException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new OverFlowIdException();

    private OverFlowIdException() {super(ErrorCode.OVERFLOW_ID);}
}
