package anys34.com.flirting.domain.place.exception;

import anys34.com.flirting.global.config.error.exception.BusinessException;
import anys34.com.flirting.global.config.error.exception.ErrorCode;

public class PlaceNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new PlaceNotFoundException();

    private PlaceNotFoundException() {super(ErrorCode.BLANK_ID);}
}
